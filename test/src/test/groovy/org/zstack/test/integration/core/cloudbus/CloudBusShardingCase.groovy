package org.zstack.test.integration.core.cloudbus

import org.zstack.core.Platform
import org.zstack.core.cloudbus.CloudBusIN
import org.zstack.core.thread.AsyncThread
import org.zstack.header.AbstractService
import org.zstack.header.managementnode.ManagementNodeExitMsg
import org.zstack.header.managementnode.ManagementNodeVO
import org.zstack.header.message.Message
import org.zstack.testlib.SubCase

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Created by AlanJager on 2017/3/25.
 */
class CloudBusShardingCase extends SubCase {

    CloudBusIN bus
    CountDownLatch latch = new CountDownLatch(1)
    boolean isSuccess = false
    String servId = "FakeService"
    CountDownLatch startLatch = new CountDownLatch(1)

    class FakeService extends AbstractService {
        @Override
        boolean start() {
            bus.registerService(this)
            bus.activeService(this)
            return true
        }

        @Override
        boolean stop() {
            bus.deActiveService(this)
            bus.unregisterService(this)
            return true
        }

        @Override
        void handleMessage(Message msg) {
            if (msg.getClass() == HelloWorldMsgForCloudBusCase.class) {
                isSuccess = true
            }
            latch.countDown()
        }

        @Override
        String getId() {
            return bus.makeLocalServiceId(servId)
        }

    }

    @AsyncThread
    private void startFakeService() {
        def fs = new FakeService()
        fs.start()
    }


    @Override
    void clean() {

    }

    @Override
    void setup() {
    }

    @Override
    void environment() {
    }

    @Override
    void test() {
        bus = bean(CloudBusIN.class)
        testCloudBusSharding()
    }

    void testCloudBusSharding() {
        startFakeService()
        HelloWorldMsgForCloudBusCase msg = new HelloWorldMsgForCloudBusCase()
        bus.makeTargetServiceIdByResourceUuid(msg, servId, Platform.getUuid())
        bus.send(msg)
        latch.await(10, TimeUnit.SECONDS)
        assert isSuccess

        ManagementNodeExitMsg msg1 = new ManagementNodeExitMsg()
        msg1.setServiceId(bus.makeLocalServiceId(Platform.getManagementServerId()))
        bus.send(msg1)

        ManagementNodeVO vo
        retryInSecs(5) {
            vo = dbFindByUuid(Platform.getManagementServerId(), ManagementNodeVO.class)
            return vo == null
        }

        TimeUnit.SECONDS.sleep(5)
        bus.makeTargetServiceIdByResourceUuid(msg, servId, Platform.getUuid())
    }
}
