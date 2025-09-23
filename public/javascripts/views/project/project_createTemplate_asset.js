/**
 * Created by vtk-anhlt166 on 6/16/22.
 */
function addProjectAsset() {
    var nameProject = $("#nameAssetAdd").val();
    var contentProject = $("#contentAssetAdd").val();
    if(nameProject.length <= 0 || contentProject.length <= 0){
        showNotification('danger', Messages("Bạn cần điền đủ thông tin"));
        return;
    }

    $("#addAssetConfirm").modal('hide');

    $("#buttonAddProjectAsset").attr("disabled", true);

    var body = new FormData;
    body.url = "/api/projects";
    body.json = {
        "name":nameProject,
        "description":contentProject
    };
    console.log(body);
    var r = jsRoutes.controllers.ProjectController.sendPostJsonProjectTemplate();
    StartProcess();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                var projectId = data.content.id;

                addTemplateAttributeAsset(projectId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectAsset").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Tạo dự án không thành công"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}

function addTemplateAttributeAsset(projectId) {
    console.log(projectId);
    var body = new FormData;
    body.url = "/api/templates";
    var attrArray = [
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "current",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "current_rf",
            "logged": true,
            "value": "{\"count\":0,\"list\":[]}",
            "value_t": "JSON"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "config",
            "logged": false,
            "value": "{\"M\":0,\"P\":30}",
            "value_t": "JSON"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "connection",
            "logged": false,
            "value": "",
            "value_t": "STR"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "firmware_version",
            "logged": false,
            "value": "",
            "value_t": "STR"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "message",
            "logged": false,
            "value": "",
            "value_t": "JSON"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "last_update",
            "logged": false,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "missing",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "missing_rf",
            "logged": true,
            "value": "{\"count\":0,\"list\":[]}",
            "value_t": "JSON"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "name",
            "logged": false,
            "value": "Master",
            "value_t": "STR"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "owner",
            "logged": false,
            "value": "",
            "value_t": "STR"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "set",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "set_rf",
            "logged": true,
            "value": "{\"count\":0,\"list\":[]}",
            "value_t": "JSON"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "unknown",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "unknown_rf",
            "logged": true,
            "value": "{\"count\":0,\"list\":[]}",
            "value_t": "JSON"
        }
    ];
    body.json = {
        "name":"Sample",
        "project_id":projectId,
        "attributes":attrArray
    };
    console.log(body);
    var r = jsRoutes.controllers.ProjectController.sendPostJsonProjectTemplate();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                var templateId = data.content.id;
                addGroupAsset(projectId, templateId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectAsset").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Tạo mẫu thiết bị và thuộc tính không thành công"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}

function addGroupAsset(projectId, templateId) {
    var body = new FormData;
    body.url = "/api/groups";
    body.json = {
        "name":"Asset 01",
        "project_id":projectId,
        "entity_type":"DEVICE",
        "org_id": "",
        "metadata": {}
    };
    console.log(body);
    var r = jsRoutes.controllers.ProjectController.sendPostJsonProjectTemplate();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                var groupId = data.content.id;
                addDeviceAsset(projectId, templateId, groupId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectAsset").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Tạo nhóm không thành công"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}

function addDeviceAsset(projectid, templateId, groupId) {
    var body = new FormData;
    body.url = "/api/devices";
    body.json = {
        "name":"Asset 01",
        "project_id":projectid,
        "template_id":templateId,
        "group_id":groupId
    };
    console.log(body);
    var r = jsRoutes.controllers.ProjectController.sendPostJsonProjectTemplate();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                var deviceId = data.content.id;
                addFlowEngineAsset(projectid, templateId, deviceId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectAsset").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Tạo thiết bị không thành công"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}

function addFlowEngineAsset(project, templateId, deviceId) {
    var body = new FormData;
    body.url = "/api/ruleChain";
    body.json = {
        "additionalInfo": {
            "description": ""
        },
        "name": "Master",
        "projectId": project,
        "firstRuleNodeId": null,
        "root": false,
        "debugMode": true,
        "configuration": null
    };
    console.log(body);
    var r = jsRoutes.controllers.ProjectController.sendPostJsonProjectTemplate();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                var idFlow = data.content.id.id;
                importFlowDeviceIdAsset(idFlow, templateId, deviceId, project);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectAsset").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Tạo Flow Engine không thành công"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}

function importFlowDeviceIdAsset(idFlow, templateId, deviceId, projectId) {
    console.log(idFlow);
    var body = new FormData;
    body.url = "/api/ruleChain/metadata";
    body.json = {
        "ruleChainId": {
            "entityType": "RULE_CHAIN",
            "id": idFlow
        },
        "firstNodeIndex": 12,
        "nodes": [
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 54,
                    "layoutY": 251
                },
                "type": "org.iot.rule.engine.debug.TbMsgGeneratorNode",
                "name": "Timed Messages Transmitter",
                "debugMode": true,
                "configuration": {
                    "msgCount": 0,
                    "periodInSeconds": 1800,
                    "jsScript": "\nlet total = randomNumber(450, 600, 1);\nlet string = \"\";\n\nfor (let i = 0; i < total; i++) {\n    string = string + \"RF\" + randomNumber(0, 250, 1) + \",\";\n}\n\nlet part_length = parseInt((string.length + 30) / 3);\nlet msg = \"*001,<\" + string.substr(0, part_length) + \"#\";\nlet metadata = {deviceID: \""+deviceId+"\"};\nmetadata['part2'] = \"*002,\" + string.substr(part_length, part_length * 2) + \"#\";\nmetadata['part3'] = \"*003,\" + string.substr(part_length * 2) + \",>#\";\nlet msgType = \"POST_TELEMETRY_REQUEST\";\n\nreturn {msg, metadata, msgType};\n\nfunction randomNumber(min, max, int) {\n    if (int) return Math.floor(Math.random() * (max - min) + min);\n    else return Math.random() * (max - min) + min;\n}",
                    "originatorId": null,
                    "originatorType": null
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 55,
                    "layoutY": 352
                },
                "type": "org.iot.rule.engine.mqtt.PublishMqttToDeviceNode",
                "name": "Send Part 1",
                "debugMode": true,
                "configuration": {
                    "topicPattern": "messages/${deviceID}/rf",
                    "retain": false
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 53,
                    "layoutY": 551
                },
                "type": "org.iot.rule.engine.mqtt.PublishMqttToDeviceNode",
                "name": "Send Part 2",
                "debugMode": true,
                "configuration": {
                    "topicPattern": "messages/${deviceID}/rf",
                    "retain": false
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 52,
                    "layoutY": 752
                },
                "type": "org.iot.rule.engine.mqtt.PublishMqttToDeviceNode",
                "name": "Send Part 3",
                "debugMode": true,
                "configuration": {
                    "topicPattern": "messages/${deviceID}/rf",
                    "retain": false
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 52,
                    "layoutY": 452
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Send Part 2",
                "debugMode": true,
                "configuration": {
                    "jsScript": "msg = metadata['part2'];\ndelete metadata['part2'];\nreturn {msg, metadata, msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 51,
                    "layoutY": 652
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Send Part 3",
                "debugMode": true,
                "configuration": {
                    "jsScript": "msg = metadata['part3'];\ndelete metadata['part3'];\nreturn {msg, metadata, msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 878,
                    "layoutY": 351
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Save Status",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let codename = {\n    \"DPD\": \"000\",\n    \"DCF\": \"001\",\n    \"GET\": \"002\",\n    \"DSOS\": \"003\"\n};\nvar {ss_owner: owner, ss_name: name} = metadata;\nlet {cn, ss, r, t, v, m, p, type} = msg;\nif (t < 1640970000) t = parseInt(new Date().getTime()/1000);\nlet ts = t * 1000 + Number.parseInt(codename[Type]);\n\nmsg = {\n    connection: cn, firmware_version: v,\n    message: {...msg, ts: new Date().getTime()},\n    last_update: new Date().getTime(),\n    ts\n}\n\nif (type == \"DSOS\" && owner != \"\") {\n    let content = \"Innoway \" + convert(t * 1000) + \": Thiết bị \" + name + \" đã gửi cảnh báo khẩn cấp!\";\n    metadata[\"soap_request\"] = '<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:impl=\"http://impl.bulkSms.ws/\">\\\n\t\t<soapenv:Header/>\\\n\t\t<soapenv:Body>\\\n            <impl:wsCpMt>\\\n                <User></User>\\\n                <Password></Password>\\\n                <CPCode></CPCode>\\\n                <RequestID>1</RequestID>\\\n                <UserID>' + owner + '</UserID>\\\n                <ReceiverID>' + owner + '</ReceiverID>\\\n                <ServiceID></ServiceID>\\\n                <CommandCode>bulksms</CommandCode>\\\n                <Content>' + content + '</Content>\\\n                <ContentType>1</ContentType>\\\n            </impl:wsCpMt>\\\n        </soapenv:Body>\\\n    </soapenv:Envelope>';\n    \n}\n\nreturn {msg, metadata, msgType};\n\nfunction convert(_time){\n    let time = _time + 25200000;\n    let year = new Date(time).getFullYear();\n    let month = new Date(time).getMonth() + 1;\n    if (month < 3) month = \"0\" + month;\n    let day = new Date(time).getDate();\n    if (day < 10) day = \"0\" + day;\n    let hour = new Date(time).getHours();\n    if (hour < 10) hour = \"0\" + hour;\n    let minute = new Date(time).getMinutes();\n    if (minute < 10) minute = \"0\" + minute;\n    let second = new Date(time).getSeconds();\n    if (second < 10) second = \"0\" + second;\n    return \"\" + hour + \":\" + minute + \":\" + second + \" ngày \" + day + \"/\" + month + \"/\" + year;\n}"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 601,
                    "layoutY": 353
                },
                "type": "org.iot.rule.engine.metadata.TbGetAttributesNode",
                "name": "Get Device's Data",
                "debugMode": false,
                "configuration": {
                    "tellFailureIfAbsent": true,
                    "clientAttributeNames": [],
                    "sharedAttributeNames": [],
                    "serverAttributeNames": [
                        "owner",
                        "name"
                    ]
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 602,
                    "layoutY": 250
                },
                "type": "org.iot.rule.engine.metadata.TbGetAttributesNode",
                "name": "Get Config",
                "debugMode": true,
                "configuration": {
                    "tellFailureIfAbsent": true,
                    "clientAttributeNames": [],
                    "sharedAttributeNames": [],
                    "serverAttributeNames": [
                        "config"
                    ]
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 2526,
                    "layoutY": 352
                },
                "type": "org.iot.rule.engine.rest.SoapApiCallNode",
                "name": "Automated SMS Service",
                "debugMode": true,
                "configuration": {
                    "restEndpointUrlPattern": "http://ams.tinnhanthuonghieu.vn:8009/bulkapi?wsdl",
                    "requestMethod": "POST",
                    "useSimpleClientHttpFactory": false,
                    "enableProxy": false,
                    "useSystemProxyProperties": false,
                    "proxyScheme": null,
                    "proxyHost": null,
                    "proxyPort": 0,
                    "proxyUser": null,
                    "proxyPassword": null,
                    "readTimeoutMs": 0,
                    "maxParallelRequestsCount": 0,
                    "headers": {
                        "Content-Type": "text/xml",
                        "Accept": "text/xml"
                    },
                    "useRedisQueueForMsgPersistence": false,
                    "trimQueue": false,
                    "maxQueueSize": 0,
                    "credentials": {
                        "type": "anonymous"
                    }
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1699,
                    "layoutY": 554
                },
                "type": "org.iot.rule.engine.filter.TbJsSwitchNode",
                "name": "Check Mode",
                "debugMode": true,
                "configuration": {
                    "jsScript": "if (JSON.parse(metadata.ss_config).M == 0) return [\"Scan\"];\nelse return [\"Register\"];"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1977,
                    "layoutY": 652
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Save Set RFID",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let data = msg.rfid;\nlet rfid = JSON.parse(metadata.ss_set_rf).list;\ndata.forEach((element) => {\n    if (!rfid.includes(element)) rfid.push(element);\n});\nreturn {msg: {set_rf: {list: rfid, count: rfid.length}, \"set\": rfid.length, ts: new Date().getTime()}, metadata, msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 329,
                    "layoutY": 154
                },
                "type": "org.iot.rule.engine.filter.TbJsSwitchNode",
                "name": "Action(s)",
                "debugMode": true,
                "configuration": {
                    "jsScript": "if (msgType == \"POST_VARIABLES\") {\n    let ret = [];\n    switch (metadata.topic) {\n        case \"rf\": {\n            ret = [\"SaveData\"];\n            if (msg[msg.length - 2] == \">\") ret.push(\"Combine\", \"Response\");\n            break;\n        }\n        case \"config\": {\n            ret = [\"SaveStatus\", \"Response\"];\n        }\n    }\n    return ret;\n}\nelse return [];"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 876,
                    "layoutY": 252
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Response",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let {M, P} = JSON.parse(metadata.ss_config);\nreturn {msg: {code: 0, M, P, T: parseInt(new Date().getTime() / 1000)}, metadata, msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 601,
                    "layoutY": 555
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Get Former Parts",
                "debugMode": true,
                "configuration": {
                    "jsScript": "metadata[\"req_multiple_entity\"] = JSON.stringify({\n    entity_type: \"GROUP\",\n\tentity_ids: [metadata.group_id],\n});\nreturn {msg, metadata, msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 602,
                    "layoutY": 154
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Trim Message and Save",
                "debugMode": true,
                "configuration": {
                    "jsScript": "var order = \"id\" + msg.toString().substring(1, 5);\nvar str = msg.toString().substring(6, msg.length - 1);\nvar msg = {};\nmsg[order] = str;\nreturn {msg, metadata, msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 876,
                    "layoutY": 554
                },
                "type": "org.iot.rule.engine.metadata.TbGetAttributesListEntityNode",
                "name": "Get Former Parts",
                "debugMode": true,
                "configuration": {
                    "version": 0
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 873,
                    "layoutY": 157
                },
                "type": "org.iot.rule.engine.telemetry.TbMsgSaveGroupAttributesNode",
                "name": "Save Data",
                "debugMode": true,
                "configuration": {
                    "version": 0
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1151,
                    "layoutY": 253
                },
                "type": "org.iot.rule.engine.mqtt.PublishMqttToDeviceNode",
                "name": "Response",
                "debugMode": true,
                "configuration": {
                    "topicPattern": "messages/${deviceID}/control",
                    "retain": false
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1151,
                    "layoutY": 552
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Combine RFID",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let largest = parseInt(msg.toString().substring(1, 5));\nlet str = msg.toString().substring(6, msg.length-1);\nlet string = \"\";\nlet array = JSON.parse(metadata.res_attributes).attributes; //get all attributes\nlet data = {};\nfor (let i = 0, l = array.length; i < l; i++) {\n    let key = array[i].key;\n    let index = parseInt(key.toString().substring(2,6));\n    if (index > largest) continue;\n    data[index] = array[i].strV;\n}\nfor (let k = 1; k < largest; k++) {\n    string = string + data[k];\n}\nstring = (string + str).substring(string.indexOf(\"<\") + 1, (string + str).indexOf(\">\"));\nsplit = string.split(',');\nlet rfid = [];\nfor (let i = 0, len = split.length; i < len; i++) {\n    if (split[i] !== \"\") rfid.push(split[i]);\n}\nreturn {msg: {rfid} , metadata, msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 2251,
                    "layoutY": 355
                },
                "type": "org.iot.rule.engine.filter.TbJsFilterNode",
                "name": "Check SMS",
                "debugMode": true,
                "configuration": {
                    "jsScript": "return metadata.soap_request != \"\";"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1423,
                    "layoutY": 555
                },
                "type": "org.iot.rule.engine.metadata.TbGetAttributesNode",
                "name": "Get SetRF and Mode",
                "debugMode": true,
                "configuration": {
                    "tellFailureIfAbsent": true,
                    "clientAttributeNames": [],
                    "sharedAttributeNames": [],
                    "serverAttributeNames": [
                        "set_rf",
                        "config"
                    ]
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 2525,
                    "layoutY": 451
                },
                "type": "org.iot.rule.engine.telemetry.TbMsgAttributesNode",
                "name": "Save Data",
                "debugMode": true,
                "configuration": {
                    "scope": "SERVER_SCOPE",
                    "notifyDevice": null,
                    "loggedHistory": null
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1978,
                    "layoutY": 553
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Save Current RFID",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let owner = metadata.ss_owner;\nlet data = msg.rfid;\nlet rfid = [];\nlet set_rf = JSON.parse(metadata.ss_set_rf).list;\nlet current_rf = [];\nlet missing_rf = [];\n\ndata.forEach((element) => {\n    if (!rfid.includes(element)) rfid.push(element);\n});\n\nfor (let i = 0, l = set_rf.length; i < l; i++) {\n    if (rfid.indexOf(set_rf[i]) > -1) {\n        current_rf.push(set_rf[i]);\n        rfid.splice(rfid.indexOf(set_rf[i]), 1);\n    }\n    else if (rfid.indexOf(set_rf[i]) == -1) {\n        missing_rf.push(set_rf[i]);\n    }\n}\n\nmsg = {\n    current_rf: {list: current_rf, count: current_rf.length},\n    current: current_rf.length,\n    missing_rf: {list: missing_rf, count: missing_rf.length},\n    missing: missing_rf.length,\n    unknown_rf: {list: rfid, count: rfid.length},\n    unknown: rfid.length,\n    \"set\": set_rf.length,\n    ts: new Date().getTime()\n};\n\nif (rfid.length > 0 || missing_rf.length > 0 && owner != \"\") {\n    let content = \"Innoway: \" + fmt(Date.now()) + \": \\nHàng hóa bị thiếu:\\n\" + list(missing_rf) + \"\\nHàng hóa không rõ nguồn gốc:\\n\" + list(rfid);\n    metadata[\"soap_request\"] = '<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:impl=\"http://impl.bulkSms.ws/\">\\\n\t\t<soapenv:Header/>\\\n\t\t<soapenv:Body>\\\n            <impl:wsCpMt>\\\n                <User></User>\\\n                <Password></Password>\\\n                <CPCode></CPCode>\\\n                <RequestID>1</RequestID>\\\n                <UserID>' + owner + '</UserID>\\\n                <ReceiverID>' + owner + '</ReceiverID>\\\n                <ServiceID></ServiceID>\\\n                <CommandCode>bulksms</CommandCode>\\\n                <Content>' + content + '</Content>\\\n                <ContentType>1</ContentType>\\\n            </impl:wsCpMt>\\\n        </soapenv:Body>\\\n    </soapenv:Envelope>';\n    \n}\n    \nreturn {msg, metadata, msgType};\n\nfunction fmt(_time) {\n    let time = new Date(_time + 25200000);\n    let year = new Date(time).getFullYear();\n    let month = new Date(time).getMonth() + 1;\n    if (month < 3) month = \"0\" + month;\n    let day = new Date(time).getDate();\n    if (day < 10) day = \"0\" + day;\n    let hour = new Date(time).getHours();\n    if (hour < 10) hour = \"0\" + hour;\n    let minute = new Date(time).getMinutes();\n    if (minute < 10) minute = \"0\" + minute;\n    let second = new Date(time).getSeconds();\n    if (second < 10) second = \"0\" + second;\n    return \"\" + hour + \":\" + minute + \":\" + second + \" ngày \" + day + \"/\" + month + \"/\" + year;\n}\n\nfunction list(array) {\n    let data = \"\";\n    for (let i = 0, l = array.length; i < l; i++) {\n        data = data + (i+1) + \". \" + array[i] + \"\\n\";\n    }\n    return data;\n}\n\n"
                }
            }
        ],
        "connections": [
            {
                "fromIndex": 0,
                "toIndex": 1,
                "type": "Success"
            },
            {
                "fromIndex": 1,
                "toIndex": 4,
                "type": "Success"
            },
            {
                "fromIndex": 2,
                "toIndex": 5,
                "type": "Success"
            },
            {
                "fromIndex": 4,
                "toIndex": 2,
                "type": "Success"
            },
            {
                "fromIndex": 5,
                "toIndex": 3,
                "type": "Success"
            },
            {
                "fromIndex": 6,
                "toIndex": 20,
                "type": "Success"
            },
            {
                "fromIndex": 6,
                "toIndex": 22,
                "type": "Success"
            },
            {
                "fromIndex": 7,
                "toIndex": 6,
                "type": "Success"
            },
            {
                "fromIndex": 8,
                "toIndex": 13,
                "type": "Success"
            },
            {
                "fromIndex": 10,
                "toIndex": 11,
                "type": "Register"
            },
            {
                "fromIndex": 10,
                "toIndex": 23,
                "type": "Scan"
            },
            {
                "fromIndex": 11,
                "toIndex": 22,
                "type": "Success"
            },
            {
                "fromIndex": 12,
                "toIndex": 14,
                "type": "Combine"
            },
            {
                "fromIndex": 12,
                "toIndex": 8,
                "type": "Response"
            },
            {
                "fromIndex": 12,
                "toIndex": 15,
                "type": "SaveData"
            },
            {
                "fromIndex": 12,
                "toIndex": 7,
                "type": "SaveStatus"
            },
            {
                "fromIndex": 13,
                "toIndex": 18,
                "type": "Success"
            },
            {
                "fromIndex": 14,
                "toIndex": 16,
                "type": "Success"
            },
            {
                "fromIndex": 15,
                "toIndex": 17,
                "type": "Success"
            },
            {
                "fromIndex": 16,
                "toIndex": 19,
                "type": "Success"
            },
            {
                "fromIndex": 19,
                "toIndex": 21,
                "type": "Success"
            },
            {
                "fromIndex": 20,
                "toIndex": 9,
                "type": "True"
            },
            {
                "fromIndex": 21,
                "toIndex": 10,
                "type": "Success"
            },
            {
                "fromIndex": 23,
                "toIndex": 20,
                "type": "Success"
            },
            {
                "fromIndex": 23,
                "toIndex": 22,
                "type": "Success"
            }
        ],
        "ruleChainConnections": null
    };
    console.log(body);
    var r = jsRoutes.controllers.ProjectController.sendPostJsonProjectTemplate();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                addFlowIdToTemplateDeviceAsset(idFlow, templateId, deviceId, projectId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectAsset").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Import Flow Engine chứa id thiết bị không thành công"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}

function addFlowIdToTemplateDeviceAsset(idFlow, templateId, deviceId, projectId) {
    var body = new FormData;
    body.url = "/api/templates/"+templateId;
    body.json = {
        "name": "test",
        "rule_chain_id": idFlow
    };
    console.log(body);
    var r = jsRoutes.controllers.ProjectController.sendPutJsonProjectTemplate();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                addDashboardNewToAsset(deviceId, projectId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectAsset").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Gán Flow ID cho mẫu thiết bị không thành công"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}

function addDashboardNewToAsset(deviceId, projectId) {
    var body = new FormData;
    body.projectId = projectId;
    console.log(body);
    var r = jsRoutes.controllers.ProjectController.createDashboardTemplate();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                var dashboardId = data.content.id;
                saveWigetDashboardAsset(dashboardId, deviceId, projectId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectAsset").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Tạo dashboard không thành công"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}

function saveWigetDashboardAsset(dashboardId, deviceId, projectId) {
    console.log(dashboardId, deviceId, projectId);
    var body = new FormData;
    body.id = dashboardId;
    var widgetList = [];

    var data1 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"Asset 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"Asset\",\"attribute_key\":\"set_rf\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"JSON\"}]";
    widgetList.push({
        "x": "9",
        "y": "3",
        "w": "3",
        "h": "3",
        "id": "data-4",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data1,
        "title": "RFID BAN ĐẦU",
        "unit": "",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data2 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"Asset 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"Asset\",\"attribute_key\":\"unknow_rf\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"JSON\"}]";
    widgetList.push({
        "x": "6",
        "y": "3",
        "w": "3",
        "h": "3",
        "id": "data-3",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data2,
        "title": "RFID LẠ",
        "unit": "",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data3 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"Asset 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"Asset\",\"attribute_key\":\"current_rf\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"JSON\"}]";
    widgetList.push({
        "x": "9",
        "y": "0",
        "w": "3",
        "h": "3",
        "id": "data-2",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data3,
        "title": "RFID HIỆN TẠI",
        "unit": "",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data4 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"Asset 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"Asset\",\"attribute_key\":\"missing_rf\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"JSON\"}]";
    widgetList.push({
        "x": "6",
        "y": "0",
        "w": "3",
        "h": "3",
        "id": "data-1",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data4,
        "title": "RFID BỊ MẤT",
        "unit": "",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data5 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"Asset 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"Asset\",\"attribute_key\":\"missing_rf\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"JSON\"}"+
        ",{\"device\":\""+deviceId+"\",\"deviceName\":\"Asset 01\",\"var\":\""+deviceId+"\",\"varName\":\"Asset\",\"attribute_key\":\"set_rf\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"JSON\"}"+
        ",{\"device\":\""+deviceId+"\",\"deviceName\":\"Asset 01\",\"var\":\""+deviceId+"\",\"varName\":\"Asset\",\"attribute_key\":\"unknow_rf\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"JSON\"}]";
    widgetList.push({
        "x": "0",
        "y": "0",
        "w": "6",
        "h": "5",
        "id": "chart-line-0",
        "type": "4",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data5,
        "title": "BIỂU ĐỒ ĐƯỜNG",
        "unit": null,
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    body.widgetList = widgetList;
    console.log(body);

    var r = jsRoutes.controllers.DashboardV3Controller.saveDashboard();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                getListProject();

                showNotification('success', Messages("Tạo dự án mẫu thành công"));
            } else {
                FinishProcess();
                showNotification('danger', Messages("Tạo dashboard không thành công"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
            $("#createTemplateProjectModal").modal('hide');
            $("#buttonAddProjectAsset").attr("disabled", false);
        }
    });
}