/**
 * Created by vtk-anhlt166 on 6/15/22.
 */
function addProjectSmartWater() {
    var nameProject = $("#nameSmartWaterAdd").val();
    var contentProject = $("#contentSmartWaterAdd").val();
    if(nameProject.length <= 0 || contentProject.length <= 0){
        showNotification('danger', Messages("Bạn cần điền đủ thông tin"));
        return;
    }

    $("#addSmartWaterConfirm").modal('hide');

    $("#buttonAddProjectSmartWater").attr("disabled", true);

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

                addTemplateAttributeSmartWater(projectId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartWater").attr("disabled", false);
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

function addTemplateAttributeSmartWater(projectId) {
    console.log(projectId);
    var body = new FormData;
    body.url = "/api/templates";
    var attrArray = [
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "flow_rate",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "delta_volume",
            "logged": true,
            "value": "",
            "value_t": "JSON"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "config",
            "logged": false,
            "value": "{\"M\":1,\"P\":60}",
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
            "attribute_key": "negative_volume",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "name",
            "logged": false,
            "value": "",
            "value_t": "STR"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "temperature",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "status",
            "logged": true,
            "value": "",
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
            "attribute_key": "positive_volume",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "total_volume",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "error",
            "logged": true,
            "value": "",
            "value_t": "STR"
        }
    ];
    body.json = {
        "name":"SmartWaterMeter",
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
                addDeviceSmartWater(projectId, templateId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartWater").attr("disabled", false);
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

function addDeviceSmartWater(projectid, templateId) {
    var body = new FormData;
    body.url = "/api/devices";
    body.json = {
        "name":"SmartWater 01",
        "project_id":projectid,
        "template_id":templateId
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
                addFlowEngineSmartWater(projectid, templateId, deviceId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartWater").attr("disabled", false);
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

function addFlowEngineSmartWater(project, templateId, deviceId) {
    var body = new FormData;
    body.url = "/api/ruleChain";
    body.json = {
        "additionalInfo": {
            "description": ""
        },
        "name": "Flow",
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
                importFlowDeviceIdSmartWater(idFlow, templateId, deviceId, project);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartWater").attr("disabled", false);
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

function importFlowDeviceIdSmartWater(idFlow, templateId, deviceId, projectId) {
    console.log(idFlow);
    var body = new FormData;
    body.url = "/api/ruleChain/metadata";
    body.json = {
        "ruleChainId": {
            "entityType": "RULE_CHAIN",
            "id": idFlow
        },
        "firstNodeIndex": 5,
        "nodes": [
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 53,
                    "layoutY": 53
                },
                "type": "org.iot.rule.engine.debug.TbMsgGeneratorNode",
                "name": "Timed Message Transmitter",
                "debugMode": true,
                "configuration": {
                    "msgCount": 0,
                    "periodInSeconds": 3600,
                    "jsScript": "let msgType = \"POST_TELEMETRY_REQUEST\";\nlet msg = {}\nlet metadata = {deviceID: \""+deviceId+"\", entity_type: \"DEVICE\", entity_id: \""+deviceId+"\"}\nreturn {msg, metadata, msgType};\n",
                    "originatorId": null,
                    "originatorType": null
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 328,
                    "layoutY": 53
                },
                "type": "org.iot.rule.engine.metadata.TbGetAttributesNode",
                "name": "Get Device's Data",
                "debugMode": true,
                "configuration": {
                    "tellFailureIfAbsent": true,
                    "clientAttributeNames": [],
                    "sharedAttributeNames": [],
                    "serverAttributeNames": [
                        "total_volume",
                        "negative_volume",
                        "positive_volume",
                        "status"
                    ]
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 602,
                    "layoutY": 54
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Send Message",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let {ss_positive_volume: positive_volume, ss_negative_volume: negative_volume, ss_total_volume: total_volume, ss_status: status} = metadata;\nlet neg = randomNumber(0, 2);\nlet pos = randomNumber(2, 10);\nlet st = 0;\nif (status == \"BÌNH THƯỜNG\") {\n    chance = randomNumber(0, 25);\n    if (chance < 1) st = randomNumber(1, 5, 1);\n}\nmsg = {\n    st,\n    vol: Number(total_volume) + pos - neg,\n    vpos: Number(positive_volume) + pos,\n    vneg: Number(negative_volume) + neg,\n    q: parseInt(pos - neg),\n    temp: randomNumber(12, 30),\n    e: \"OK\",\n    dlt: {d: 48, v: 240},\n    ss: randomNumber(-110, -70, 1),\n    r: randomNumber(-15, 7, 1),\n    m: 1,\n    t: parseInt(new Date().getTime() / 1000),\n    p: 60,\n    fwv: \"A1.0.0Z\",\n    cn: \"NB-IOT\"\n}\nreturn {msg, metadata, msgType};\n\nfunction randomNumber(min, max, int) {\n    if (int) return Math.floor(Math.random() * (max - min) + min);\n    else return roundToTwo((Math.random() * (max - min) + min));\n}\n\nfunction roundToTwo(num) {\n    return +(Math.round(num + \"e+2\")  + \"e-2\");\n}"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 876,
                    "layoutY": 52
                },
                "type": "org.iot.rule.engine.mqtt.PublishMqttToDeviceNode",
                "name": "Response",
                "debugMode": true,
                "configuration": {
                    "topicPattern": "messages/${deviceID}/info",
                    "retain": false
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 881,
                    "layoutY": 257
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Save Data",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let codename = {\n    \"0\": \"BÌNH THƯỜNG\",\n    \"1\": \"RÒ RỈ\",\n    \"2\": \"NHIỄM TỪ TÍNH\",\n    \"3\": \"VỠ ỐNG NƯỚC\",\n    \"4\": \"KHÔNG CÓ NƯỚC\",\n    \"5\": \"DÒNG CHẢY NGƯỢC\"\n};\nvar {ss_owner: owner, ss_name: name} = metadata;\nlet {st, vol, vpos, vneg, q, temp, e, dlt: {d, v}, ss, r, m, t, p, dur, fwv, cn} = msg;\nif (t < 1640970000) t = parseInt(new Date().getTime()/1000);\nlet ts = t * 1000;\n\nmsg = {\n    status: codename[st], firmware_version: fwv, total_volume: roundToTwo(vol), positive_volume: roundToTwo(vpos), negative_volume: roundToTwo(vneg), temperature: temp, flow_rate: q, error: e, delta_volume: {duration: d, volume: v}, connection: cn,\n    message: {...msg, ts: new Date().getTime()},\n    last_update: new Date().getTime(),\n    ts\n}\n\nif (st != 0 && owner != \"\") {\n    let content = \"Innoway \" + convert(t * 1000) + \": Thiết bị \" + name + \" đã gửi cảnh báo \" + status[st] + \"!\";\n    metadata[\"soap_request\"] = '<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:impl=\"http://impl.bulkSms.ws/\">\\\n\t\t<soapenv:Header/>\\\n\t\t<soapenv:Body>\\\n            <impl:wsCpMt>\\\n                <User></User>\\\n                <Password></Password>\\\n                <CPCode></CPCode>\\\n                <RequestID>1</RequestID>\\\n                <UserID>' + owner + '</UserID>\\\n                <ReceiverID>' + owner + '</ReceiverID>\\\n                <ServiceID></ServiceID>\\\n                <CommandCode>bulksms</CommandCode>\\\n                <Content>' + content + '</Content>\\\n                <ContentType>1</ContentType>\\\n            </impl:wsCpMt>\\\n        </soapenv:Body>\\\n    </soapenv:Envelope>';\n    \n}\n\nreturn {msg, metadata, msgType};\n\nfunction convert(_time){\n    let time = _time + 25200000;\n    let year = new Date(time).getFullYear();\n    let month = new Date(time).getMonth() + 1;\n    if (month < 3) month = \"0\" + month;\n    let day = new Date(time).getDate();\n    if (day < 10) day = \"0\" + day;\n    let hour = new Date(time).getHours();\n    if (hour < 10) hour = \"0\" + hour;\n    let minute = new Date(time).getMinutes();\n    if (minute < 10) minute = \"0\" + minute;\n    let second = new Date(time).getSeconds();\n    if (second < 10) second = \"0\" + second;\n    return \"\" + hour + \":\" + minute + \":\" + second + \" ngày \" + day + \"/\" + month + \"/\" + year;\n}\n\n\nfunction roundToTwo(num) {\n    return +(Math.round(num + \"e+2\")  + \"e-2\");\n}"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 327,
                    "layoutY": 154
                },
                "type": "org.iot.rule.engine.filter.TbJsSwitchNode",
                "name": "Action(s)",
                "debugMode": true,
                "configuration": {
                    "jsScript": "if(msgType === 'POST_VARIABLES' && metadata.topic == \"info\") return ['Response', 'SaveData'];\nelse return [];"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 603,
                    "layoutY": 257
                },
                "type": "org.iot.rule.engine.metadata.TbGetAttributesNode",
                "name": "Get Device's Data",
                "debugMode": true,
                "configuration": {
                    "tellFailureIfAbsent": true,
                    "clientAttributeNames": [],
                    "sharedAttributeNames": [],
                    "serverAttributeNames": [
                        "name",
                        "owner"
                    ]
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1155,
                    "layoutY": 255
                },
                "type": "org.iot.rule.engine.telemetry.TbMsgAttributesNode",
                "name": "Save Data",
                "debugMode": true,
                "configuration": {
                    "scope": "SERVER_SCOPE",
                    "notifyDevice": null,
                    "loggedHistory": false
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 882,
                    "layoutY": 156
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Response",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let {P, M} = JSON.parse(metadata.ss_config);\nreturn {msg: {M, P, T: parseInt(new Date().getTime() / 1000)}, metadata, msgType};\n"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 604,
                    "layoutY": 156
                },
                "type": "org.iot.rule.engine.metadata.TbGetAttributesNode",
                "name": "Get Device's Data",
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
                    "layoutX": 1154,
                    "layoutY": 155
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
                    "layoutX": 1429,
                    "layoutY": 353
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
                    "layoutX": 1154,
                    "layoutY": 351
                },
                "type": "org.iot.rule.engine.filter.TbJsFilterNode",
                "name": "Check SMS",
                "debugMode": true,
                "configuration": {
                    "jsScript": "return metadata.soap_request != \"\";"
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
                "toIndex": 2,
                "type": "Success"
            },
            {
                "fromIndex": 2,
                "toIndex": 3,
                "type": "Success"
            },
            {
                "fromIndex": 4,
                "toIndex": 7,
                "type": "Success"
            },
            {
                "fromIndex": 4,
                "toIndex": 12,
                "type": "Success"
            },
            {
                "fromIndex": 5,
                "toIndex": 9,
                "type": "Response"
            },
            {
                "fromIndex": 5,
                "toIndex": 6,
                "type": "SaveData"
            },
            {
                "fromIndex": 6,
                "toIndex": 4,
                "type": "Success"
            },
            {
                "fromIndex": 8,
                "toIndex": 10,
                "type": "Success"
            },
            {
                "fromIndex": 9,
                "toIndex": 8,
                "type": "Success"
            },
            {
                "fromIndex": 12,
                "toIndex": 11,
                "type": "True"
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
                addFlowIdToTemplateDeviceSmartWater(idFlow, templateId, deviceId, projectId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartWater").attr("disabled", false);
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

function addFlowIdToTemplateDeviceSmartWater(idFlow, templateId, deviceId, projectId) {
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
                addDashboardNewToSmartWater(deviceId, projectId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartWater").attr("disabled", false);
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

function addDashboardNewToSmartWater(deviceId, projectId) {
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
                saveWigetDashboardSmartWater(dashboardId, deviceId, projectId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartWater").attr("disabled", false);
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

function saveWigetDashboardSmartWater(dashboardId, deviceId, projectId) {
    console.log(dashboardId, deviceId, projectId);
    var body = new FormData;
    body.id = dashboardId;
    var widgetList = [];

    var data1 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"SmartWater 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"SmartWater\",\"attribute_key\":\"connection\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"STR\"}]";
    widgetList.push({
        "x": "10",
        "y": "4",
        "w": "2",
        "h": "2",
        "id": "data-7",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data1,
        "title": "KẾT NỐI",
        "unit": "",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data2 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"SmartWater 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"SmartWater\",\"attribute_key\":\"total_volume\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
    widgetList.push({
        "x": "8",
        "y": "4",
        "w": "2",
        "h": "2",
        "id": "data-6",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data2,
        "title": "TỔNG KHỐI LƯỢNG",
        "unit": "",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data3 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"SmartWater 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"SmartWater\",\"attribute_key\":\"positive_volume\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
    widgetList.push({
        "x": "6",
        "y": "4",
        "w": "2",
        "h": "2",
        "id": "data-5",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data3,
        "title": "KHỐI LƯỢNG CHẢY THUẬN",
        "unit": "",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data4 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"SmartWater 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"SmartWater\",\"attribute_key\":\"negative_volume\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
    widgetList.push({
        "x": "4",
        "y": "4",
        "w": "2",
        "h": "2",
        "id": "data-4",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data4,
        "title": "KHỐI LƯỢNG CHẢY NGƯỢC",
        "unit": "",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data5 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"SmartWater 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"SmartWater\",\"attribute_key\":\"temperature\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
    widgetList.push({
        "x": "2",
        "y": "4",
        "w": "2",
        "h": "2",
        "id": "data-3",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data5,
        "title": "NHIỆT ĐỘ",
        "unit": "Độ C",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data6 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"SmartWater 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"SmartWater\",\"attribute_key\":\"flow_rate\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
    widgetList.push({
        "x": "0",
        "y": "4",
        "w": "2",
        "h": "2",
        "id": "data-2",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data6,
        "title": "TỐC ĐỘ DÒNG CHẢY",
        "unit": "",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data7 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"SmartWater 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"SmartWater\",\"attribute_key\":\"temperature\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
    widgetList.push({
        "x": "6",
        "y": "0",
        "w": "6",
        "h": "4",
        "id": "chart-line-1",
        "type": "4",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data7,
        "title": "BIỂU ĐỒ NHIỆT ĐỘ",
        "unit": null,
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data8 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"SmartWater 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"SmartWater\",\"attribute_key\":\"delta_volume\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"JSON\"},{\"device\":\"4f6730b8-931b-47b1-9b73-df2f7968c35e\",\"deviceName\":\"SmartWater 01\",\"var\":\"4f6730b8-931b-47b1-9b73-df2f7968c35e\",\"varName\":\"SmartWater\",\"attribute_key\":\"negative_volume\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"},{\"device\":\"4f6730b8-931b-47b1-9b73-df2f7968c35e\",\"deviceName\":\"SmartWater 01\",\"var\":\"4f6730b8-931b-47b1-9b73-df2f7968c35e\",\"varName\":\"SmartWater\",\"attribute_key\":\"total_volume\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
    widgetList.push({
        "x": "0",
        "y": "0",
        "w": "6",
        "h": "4",
        "id": "chart-line-0",
        "type": "4",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data8,
        "title": "BIỂU ĐỒ KHỐI LƯỢNG",
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
            $("#buttonAddProjectSmartWater").attr("disabled", false);
        }
    });
}