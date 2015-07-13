package org.zstack.network.service.portforwarding;

import org.zstack.header.identity.Action;
import org.zstack.header.message.APIMessage;
import org.zstack.header.message.APIParam;
import org.zstack.header.vm.VmNicVO;

/**
 * @api
 *
 * @category port forwarding
 *
 * @since 0.1.0
 *
 * @cli
 *
 * @httpMsg
 * {
"org.zstack.network.service.portforwarding.APIAttachPortForwardingRuleMsg": {
"ruleUuid": "bc82d5c4f9394c24b7fa19ee611c0857",
"vmNicUuid": "5dfef29a376a49de9e1a887ea9bfe683",
"session": {
"uuid": "7e4e7b4a7b7641c4beef2a4e7c4b5fa2"
}
}
}
 *
 * @msg
 * {
"org.zstack.network.service.portforwarding.APIAttachPortForwardingRuleMsg": {
"ruleUuid": "bc82d5c4f9394c24b7fa19ee611c0857",
"vmNicUuid": "5dfef29a376a49de9e1a887ea9bfe683",
"session": {
"uuid": "7e4e7b4a7b7641c4beef2a4e7c4b5fa2"
},
"timeout": 1800000,
"id": "1e5fc7da29734c6c86249ff6b9190844",
"serviceId": "api.portal"
}
}
 *
 * @result
 *
 * see :ref:`APIAttachPortForwardingRuleEvent`
 */
@Action(category = PortForwardingConstant.ACTION_CATEGORY)
public class APIAttachPortForwardingRuleMsg extends APIMessage {
    /**
     * @desc rule uuid
     */
    @APIParam(resourceType = PortForwardingRuleVO.class, checkAccount = true)
    private String ruleUuid;
    /**
     * @desc vm nic uuid the rule attaches to. see :ref:`VmNicInventory`
     */
    @APIParam(resourceType = VmNicVO.class, checkAccount = true)
    private String vmNicUuid;

    public String getRuleUuid() {
        return ruleUuid;
    }

    public void setRuleUuid(String ruleUuid) {
        this.ruleUuid = ruleUuid;
    }

    public String getVmNicUuid() {
        return vmNicUuid;
    }

    public void setVmNicUuid(String vmNicUuid) {
        this.vmNicUuid = vmNicUuid;
    }
}
