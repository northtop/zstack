package org.zstack.network.service.eip;

import org.zstack.header.identity.Action;
import org.zstack.header.message.APIDeleteMessage;
import org.zstack.header.message.APIMessage;
import org.zstack.header.message.APIParam;

/**
 * @api
 * delete eip
 *
 * @category eip
 *
 * @since 0.1.0
 *
 * @cli
 *
 * @httpMsg
 * {
"org.zstack.network.service.eip.APIDeleteEipMsg": {
"uuid": "7c1fa7260409432cb8d9880697a3407c",
"deleteMode": "Permissive",
"session": {
"uuid": "f0c39ad956124bf19994bd8fafaf9004"
}
}
}
 *
 * @msg
 * {
"org.zstack.network.service.eip.APIDeleteEipMsg": {
"uuid": "7c1fa7260409432cb8d9880697a3407c",
"deleteMode": "Permissive",
"session": {
"uuid": "f0c39ad956124bf19994bd8fafaf9004"
},
"timeout": 1800000,
"id": "ff0e3313c2514fd09a1407202d7ac243",
"serviceId": "api.portal"
}
}
 *
 * @result
 * see :ref:`APIDetachEipEvent`
 */
@Action(category = EipConstant.ACTION_CATEGORY)
public class APIDeleteEipMsg extends APIDeleteMessage implements EipMessage {
    /**
     * @desc eip uuid
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
    public String getEipUuid() {
        return uuid;
    }
}
