package org.zstack.network.service.vip;

import org.zstack.header.identity.Action;
import org.zstack.header.message.APIDeleteMessage;
import org.zstack.header.message.APIMessage;
import org.zstack.header.message.APIParam;
import org.zstack.header.network.l3.L3NetworkMessage;
import org.zstack.header.rest.APINoSee;

/**
 * @api
 * delete vip
 *
 * @category vip
 *
 * @since 0.1.0
 *
 * @cli
 *
 * @httpMsg
 * {
"org.zstack.network.service.vip.APIDeleteVipMsg": {
"uuid": "89ee09a90682331e978806e3c58f7a8a",
"session": {
"uuid": "cae423a42fd740e8bd1677f3a9f789b9"
}
}
}
 *
 * @msg
 * {
"org.zstack.network.service.vip.APIDeleteVipMsg": {
"uuid": "89ee09a90682331e978806e3c58f7a8a",
"session": {
"uuid": "cae423a42fd740e8bd1677f3a9f789b9"
},
"timeout": 1800000,
"id": "30e2e366e186498db68d8025d3cd8e25",
"serviceId": "api.portal"
}
}
 *
 * @result
 */
@Action(category = VipConstant.ACTION_CATEGORY)
public class APIDeleteVipMsg extends APIDeleteMessage implements L3NetworkMessage {
    /**
     * @ignore
     */
    @APINoSee
    private String l3NetworkUuid;
    /**
     * @desc vip uuid
     */
    @APIParam(checkAccount = true)
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getL3NetworkUuid() {
        return l3NetworkUuid;
    }

    public void setL3NetworkUuid(String l3NetworkUuid) {
        this.l3NetworkUuid = l3NetworkUuid;
    }
}
