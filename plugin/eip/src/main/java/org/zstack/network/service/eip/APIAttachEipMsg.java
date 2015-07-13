package org.zstack.network.service.eip;

import org.zstack.header.identity.Action;
import org.zstack.header.message.APIMessage;
import org.zstack.header.message.APIParam;
import org.zstack.header.vm.VmNicVO;

/**
 * @api
 * attach eip to a vm nic
 *
 * @category eip
 *
 * @since 0.1.0
 *
 * @cli
 *
 * @httpMsg
 * {
"org.zstack.network.service.eip.APIAttachEipMsg": {
"eipUuid": "69198105fd7a40778fba1759b923545c",
"vmNicUuid": "0bdb4fb64baa4c4d85d39c9f43773342",
"session": {
"uuid": "b8a93f786c474493b34e560b49a8da1f"
}
}
}
 *
 * @msg
 * {
"org.zstack.network.service.eip.APIAttachEipMsg": {
"eipUuid": "69198105fd7a40778fba1759b923545c",
"vmNicUuid": "0bdb4fb64baa4c4d85d39c9f43773342",
"session": {
"uuid": "b8a93f786c474493b34e560b49a8da1f"
},
"timeout": 1800000,
"id": "3df75c42d240472d8fc1e7edecd83149",
"serviceId": "api.portal"
}
}
 *
 * @result
 *
 * see :ref:`APIAttachEipEvent`
 */
@Action(category = EipConstant.ACTION_CATEGORY)
public class APIAttachEipMsg extends APIMessage implements EipMessage {
    /**
     * @desc eip uuid
     */
    @APIParam(resourceType = EipVO.class, checkAccount = true)
    private String eipUuid;
    /**
     * @desc vm nic uuid. See :ref:`VmNicInventory`
     */
    @APIParam(resourceType = VmNicVO.class, checkAccount = true)
    private String vmNicUuid;

    public String getEipUuid() {
        return eipUuid;
    }

    public void setEipUuid(String eipUuid) {
        this.eipUuid = eipUuid;
    }

    public String getVmNicUuid() {
        return vmNicUuid;
    }

    public void setVmNicUuid(String vmNicUuid) {
        this.vmNicUuid = vmNicUuid;
    }
}
