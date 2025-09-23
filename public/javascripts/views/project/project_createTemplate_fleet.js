/**
 * Created by vtk-anhlt166 on 6/15/22.
 */
function addProjectFleet() {
    var nameProject = $("#nameFleetAdd").val();
    var contentProject = $("#contentFleetAdd").val();
    if(nameProject.length <= 0 || contentProject.length <= 0){
        showNotification('danger', Messages("Bạn cần điền đủ thông tin"));
        return;
    }

    $("#addFleetConfirm").modal('hide');

    $("#buttonAddProjectFleet").attr("disabled", true);

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

                addTemplateAttributeFleet(projectId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectFleet").attr("disabled", false);
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

function addTemplateAttributeFleet(projectId) {
    console.log(projectId);
    var body = new FormData;
    body.url = "/api/templates";
    var attrArray = [
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "accuracy",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "battery",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "config",
            "logged": false,
            "value": "{\"M\":1,\"N\":1,\"P\":30}",
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
            "attribute_key": "geofence",
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
            "attribute_key": "latitude",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "logging",
            "logged": true,
            "value": "",
            "value_t": "JSON"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "longtitude",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "message",
            "logged": true,
            "value": "",
            "value_t": "JSON"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "name",
            "logged": false,
            "value": "Tracking",
            "value_t": "STR"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "owner",
            "logged": false,
            "value": "",
            "value_t": "STR"
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
                addDeviceFleet(projectId, templateId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectFleet").attr("disabled", false);
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

function addDeviceFleet(projectid, templateId) {
    var body = new FormData;
    body.url = "/api/devices";
    body.json = {
        "name":"Fleet 01",
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
                addFlowEngineFleet(projectid, templateId, deviceId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectFleet").attr("disabled", false);
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

function addFlowEngineFleet(project, templateId, deviceId) {
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
                importFlowDeviceIdFleet(idFlow, templateId, deviceId, project);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectFleet").attr("disabled", false);
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

function importFlowDeviceIdFleet(idFlow, templateId, deviceId, projectId) {
    console.log(idFlow);
    var body = new FormData;
    body.url = "/api/ruleChain/metadata";
    body.json = {
        "ruleChainId": {
            "entityType": "RULE_CHAIN",
            "id": idFlow
        },
        "firstNodeIndex": 6,
        "nodes": [
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1430,
                    "layoutY": 655
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "FCM",
                "debugMode": true,
                "configuration": {
                    "jsScript": "var {deviceID, ss_name: name, ss_owner: owner} = metadata;\nlet {action, msg: message, title} = msg.gfcm;\nlet data = {\n    click_action: \"FLUTTER_NOTIFICATION_CLICK\",\n    device_name: name,\n    device_id: deviceID,\n    action,\n    message,\n    ts: new Date().getTime()\n};\nmsg = {\n    to: \"/topics/\" + owner,\n    notification: {\n        title,\n        body: message,\n        android_channel_id: \"\",\n        sound: \"alert2.mp3\"\n    },\n    priority: \"high\",\n    data\n};\nmetadata['sts'] = new Date().getTime();\nreturn {msg, metadata, msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1704,
                    "layoutY": 653
                },
                "type": "org.iot.rule.engine.rest.TbRestApiCallNode",
                "name": "Firebase Cloud Messaging",
                "debugMode": true,
                "configuration": {
                    "restEndpointUrlPattern": "https://fcm.googleapis.com/fcm/send",
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
                        "Content-Type": "application/json",
                        "Authorization": "key="
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
                    "layoutX": 1430,
                    "layoutY": 753
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "SMS",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let {content, recipient: owner} = msg.gsms;\nif (owner.length == 9) owner = \"84\" + owner;\nelse if (owner.length == 10 && owner.substr(0,1) == \"0\") owner = \"84\" + owner.substr(1);\nmetadata['soap_request'] = '<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:impl=\"http://impl.bulkSms.ws/\">\\\n\t\t<soapenv:Header/>\\\n\t\t<soapenv:Body>\\\n            <impl:wsCpMt>\\\n                <User></User>\\\n                <Password></Password>\\\n                <CPCode></CPCode>\\\n                <RequestID>1</RequestID>\\\n                <UserID>' + owner + '</UserID>\\\n                <ReceiverID>' + owner + '</ReceiverID>\\\n                <ServiceID></ServiceID>\\\n                <CommandCode>bulksms</CommandCode>\\\n                <Content>' + content + '</Content>\\\n                <ContentType>1</ContentType>\\\n            </impl:wsCpMt>\\\n        </soapenv:Body>\\\n    </soapenv:Envelope>';\nreturn {msg, metadata, msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1702,
                    "layoutY": 754
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
                    "layoutX": 51,
                    "layoutY": 53
                },
                "type": "org.iot.rule.engine.debug.TbMsgGeneratorNode",
                "name": "Timed Message Transmitter",
                "debugMode": true,
                "configuration": {
                    "msgCount": 0,
                    "periodInSeconds": 1800,
                    "jsScript": "let msg = {\n    ss: random(-110, -70, 1),\n    type: \"DPOS\",\n    r: random(-15, -7, 1),\n    p: 30,\n    m: 1,\n    t: parseInt(new Date().getTime()/1000) - 5,\n    v: \"A1.0.0z\",\n    b: random(20, 100, 1),\n    cn: \"LTE\",\n    lon: random(105.772166, 105.840732),\n    lat: random(20.998574, 21.073752),\n    a: random(10, 50, 1)\n};\nlet metadata = {deviceID: \""+deviceId+"\"};\nvar msgType = \"POST_TELEMETRY_REQUEST\";\n\nreturn {msg, metadata, msgType};\n\nfunction random(min, max, int) {\n    if (int) return Math.floor((Math.random() * (max - min)) + min);\n    else return roundToSix((Math.random() * (max - min)) + min);\n}\n\nfunction roundToSix(num) {\n    return +(Math.round(num + \"e+6\")  + \"e-6\");\n}",
                    "originatorId": null,
                    "originatorType": null
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 326,
                    "layoutY": 53
                },
                "type": "org.iot.rule.engine.mqtt.PublishMqttToDeviceNode",
                "name": "Send Message",
                "debugMode": true,
                "configuration": {
                    "topicPattern": "messages/${deviceID}/gps",
                    "retain": false
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 329,
                    "layoutY": 152
                },
                "type": "org.iot.rule.engine.filter.TbJsSwitchNode",
                "name": "Topic Filter",
                "debugMode": true,
                "configuration": {
                    "jsScript": "var deviceID = metadata.deviceID;\nif (msgType == \"POST_VARIABLES\") return [metadata.topic, \"log\"];\nelse return [\"others\"];"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 601,
                    "layoutY": 150
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Raw Message Logger",
                "debugMode": true,
                "configuration": {
                    "jsScript": "return {msg: {logging: {message: msg, topic: metadata.topic}}, metadata, msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1704,
                    "layoutY": 151
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
                    "layoutX": 604,
                    "layoutY": 252
                },
                "type": "org.iot.rule.engine.metadata.TbGetAttributesNode",
                "name": "Get Device's Data",
                "debugMode": true,
                "configuration": {
                    "tellFailureIfAbsent": true,
                    "clientAttributeNames": [],
                    "sharedAttributeNames": [],
                    "serverAttributeNames": [
                        "config",
                        "owner",
                        "geofence",
                        "name"
                    ]
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 876,
                    "layoutY": 252
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "GPS Processing",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let codename = {\n    \"DPOS\": \"000\",\n    \"DASP\": \"001\",\n    \"DAST\": \"002\",\n    \"DSOS\": \"003\"\n};\nlet {ss, r, type, m , p, t, v, b, cn, lat, lon, a} = msg;\nlet {ss_name: name, ss_owner: owner} = metadata;\nlet {M, P, N} = JSON.parse(metadata.ss_config);\nlet {glat, glon, radius} = JSON.parse(metadata.ss_geofence);\n\n// Timestamp must be saved in milisecond format\nif (t < 1640995200) t = parseInt(new Date().getTime()/1000);    // 1640995200 ~ Saturday, January 1, 2022\nlet ts = t * 1000 + Number.parseInt(codename[type]);            // Avoid saving duplicated messages\n\nlet fcm = {};\nlet sms = {};\nlet gfcm = {};\nlet gsms = {};\n\n// Data to save\nlet data = {\n    battery: b, connection: cn, firmware_version: v,                                                    // Basic information \n    ts,                                                                                                 // For timeseries attributes\n    last_update: new Date().getTime(),                                                                  // The moment this device sent message to cloud\n    latitude: lat,                                                                                      // The location of the device\n    longtitude: lon,\n    accuracy: a,\n    message: {type, b, t, v, cn, lat, lon, a, ss, r, m, p, ts: parseInt(new Date().getTime()/1000)}           // The message to show on the FrontEnd\n};  \n\n// Notification\n// Change timestamp to readable datetime\nlet time = convert(ts);\nif (type == \"DSOS\") {\n    let sos = \"Thiết bị \" + name + \" vừa nhấn cảnh báo lúc \" + time + \"!\";\n    fcm = {title: \"Khẩn cấp\", msg: sos, action: \"ACTION_SOS\"};\n    sms = {recipient: owner, content: sos};\n}\nelse if (type == \"DAST\") {\n    let start = \"Thiết bị \" + name + \" đã chuyển động lúc \" + time + \"!\";\n    fcm = {title: \"Chuyển động\", msg: start, action: \"ACTION_UPDATE_LOCATION\"};\n    sms = {recipient: owner, content: start};\n} \nelse if (type == \"DASP\") {\n    let stop = \"Thiết bị \" + name + \" đã ngừng chuyển động lúc \" + time + \"!\";\n    fcm = {title: \"Dừng lại\", msg: stop, action: \"ACTION_UPDATE_LOCATION\"};\n    sms = {recipient: owner, content: stop};\n}\n\n// Geofencing\nif (glat && distance(glat, glon, lat, lon) > radius) {\n    let geo = \"Thiết bị \" + name + \" đang nằm ngoài vùng an toàn lúc \" + time + \"!\";\n    gfcm = {title: \"Cảng báo\", msg: start, action: \"ACTION_UPDATE_LOCATION\"};\n    gsms = {recipient: owner, content: geo};\n}\n\n// Return the config to device and the server timestamp for synchronization\nlet control = {M, P, N, T: parseInt(new Date().getTime()/1000)};\n\nmsg = {data, fcm, control, sms, gfcm, gsms};\nreturn {msg, metadata, msgType};\n\nfunction convert(_time){\n    let time = _time + 25200000;\n    let year = new Date(time).getFullYear();\n    let month = new Date(time).getMonth() + 1;\n    if (month < 3) month = \"0\" + month;\n    let day = new Date(time).getDate();\n    if (day < 10) day = \"0\" + day;\n    let hour = new Date(time).getHours();\n    if (hour < 10) hour = \"0\" + hour;\n    let minute = new Date(time).getMinutes();\n    if (minute < 10) minute = \"0\" + minute;\n    let second = new Date(time).getSeconds();\n    if (second < 10) second = \"0\" + second;\n    return \"\" + hour + \":\" + minute + \":\" + second + \" ngày \" + day + \"/\" + month + \"/\" + year;\n}\n\nfunction distance(lat1, lon1, lat2, lon2) {\n    let radian = Math.PI / 180;\n    let phi1 = lat1 * radian;\n    let phi2 = lat2 * radian;\n    let deltaPhi = (lat2 - lat1) * radian / 2;\n    let deltaLambda = (lon2 - lon1) * radian / 2;\n    let sinPhi = Math.sin(deltaPhi);\n    let sinLambda = Math.sin(deltaLambda);\n    let a = sinPhi * sinPhi + Math.cos(phi1) * Math.cos(phi2) * sinLambda * sinLambda;\n    return 12742000 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));\n}"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 603,
                    "layoutY": 354
                },
                "type": "org.iot.rule.engine.metadata.TbGetAttributesNode",
                "name": "Get Device's Data",
                "debugMode": true,
                "configuration": {
                    "tellFailureIfAbsent": true,
                    "clientAttributeNames": [],
                    "sharedAttributeNames": [],
                    "serverAttributeNames": [
                        "config",
                        "owner",
                        "name"
                    ]
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 875,
                    "layoutY": 353
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Status Processing",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let codename = {\n    \"DON\": \"000\",\n    \"DBL\": \"001\",\n    \"DBF\": \"002\",\n    \"DCF\": \"003\",\n    \"GET\": \"004\"\n};\nlet {type, v, t, b, m, p, cn, ss, r} = msg;\nlet {M, P, N} = JSON.parse(metadata.ss_config);\nvar name = metadata.ss_name;\n\nlet fcm = {};\nlet sms = {};\n\n// Timestamp must be saved in milisecond format\nif (T < 1640995200) T = parseInt(new Date().getTime()/1000);    // 1640995200 ~ Saturday, January 1, 2022\nlet ts = T * 1000 + Number.parseInt(codename[type]);            // Avoid saving duplicated messages\nlet data = {\n    battery: b, connection: cn, firmware_version: v,                                    // Basic information \n    ts,                                                                                 // For timeseries attributes\n    message: {type, v, t, b, cn, m, p, ss, r, ts: parseInt(new Date().getTime()/1000)}, // The message to show on the FrontEnd\n    last_update: new Date().getTime()                                                   // The moment this device sent message to cloud\n};\n\n// Notification\n// Change timestamp to readable datetime\nlet time = convert(ts);\nif (Type == \"DBL\") {\n    let low =  \"Thiết bị \" + _name + \" chỉ còn lại \" + B + \"% pin!\";\n    fcm = {title: \"Pin yếu\", msg: low, action: \"ACTION_NOTIFICATION\"};\n    sms = {recipient: owner, content: low};\n} else if (Type == \"DBF\") {\n    let full = \"Thiết bị \" + _name + \" đã sạc đầy pin!\";\n    fcm = {title: \"Pin đầy\", msg: full, action: \"ACTION_NOTIFICATION\"};\n    sms = {recipient: owner, content: full};\n}\n\n// Return the config to device and the server timestamp for synchronization\nlet control = {M, P, N, T: parseInt(new Date().getTime()/1000)};\n\nmsg = {data, fcm, sms, control};\nreturn {msg, metadata, msgType};\n\nfunction convert(_time){\n    let time = _time + 25200000;\n    let year = new Date(time).getFullYear();\n    let month = new Date(time).getMonth() + 1;\n    if (month < 3) month = \"0\" + month;\n    let day = new Date(time).getDate();\n    if (day < 10) day = \"0\" + day;\n    let hour = new Date(time).getHours();\n    if (hour < 10) hour = \"0\" + hour;\n    let minute = new Date(time).getMinutes();\n    if (minute < 10) minute = \"0\" + minute;\n    let second = new Date(time).getSeconds();\n    if (second < 10) second = \"0\" + second;\n    return \"\" + hour + \":\" + minute + \":\" + second + \" ngày \" + day + \"/\" + month + \"/\" + year;\n}\n"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1153,
                    "layoutY": 254
                },
                "type": "org.iot.rule.engine.filter.TbJsSwitchNode",
                "name": "Action(s)",
                "debugMode": true,
                "configuration": {
                    "jsScript": "var ret = [\"SaveData\", \"Response\"];\nif (metadata.ss_owner != \"\") {\n    if (msg.fcm.msg) ret.push(\"FCM\");\n    if (msg.sms.content) ret.push(\"SMS\");\n    if (msg.gfcm.msg) ret.push(\"GeoFCM\");\n    if (msg.gsms.content) ret.push(\"GeoSMS\");\n}\nreturn ret;"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1428,
                    "layoutY": 254
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Save Data",
                "debugMode": true,
                "configuration": {
                    "jsScript": "return {msg: msg.data, metadata, msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1430,
                    "layoutY": 352
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "MQTT Response",
                "debugMode": true,
                "configuration": {
                    "jsScript": "return {msg: msg.control, metadata, msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1428,
                    "layoutY": 454
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "FCM",
                "debugMode": true,
                "configuration": {
                    "jsScript": "var {deviceID, ss_name: name, ss_owner: owner} = metadata;\nlet {action, msg: message, title} = msg.fcm;\nlet data = {\n    click_action: \"FLUTTER_NOTIFICATION_CLICK\",\n    device_name: name,\n    device_id: deviceID,\n    action,\n    message,\n    ts: new Date().getTime()\n};\nmsg = {\n    to: \"/topics/\" + owner,\n    notification: {\n        title,\n        body: message,\n        android_channel_id: \"\",\n        sound: \"alert2.mp3\"\n    },\n    priority: \"high\",\n    data\n};\nmetadata['sts'] = new Date().getTime();\nreturn {msg, metadata, msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1703,
                    "layoutY": 353
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
                    "layoutX": 1705,
                    "layoutY": 452
                },
                "type": "org.iot.rule.engine.rest.TbRestApiCallNode",
                "name": "Firebase Cloud Messaging",
                "debugMode": true,
                "configuration": {
                    "restEndpointUrlPattern": "https://fcm.googleapis.com/fcm/send",
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
                        "Content-Type": "application/json",
                        "Authorization": "key="
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
                    "layoutX": 1428,
                    "layoutY": 552
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "SMS",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let {content, recipient: owner} = msg.sms;\nif (owner.length == 9) owner = \"84\" + owner;\nelse if (owner.length == 10 && owner.substr(0,1) == \"0\") owner = \"84\" + owner.substr(1);\nmetadata['soap_request'] = '<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:impl=\"http://impl.bulkSms.ws/\">\\\n\t\t<soapenv:Header/>\\\n\t\t<soapenv:Body>\\\n            <impl:wsCpMt>\\\n                <User></User>\\\n                <Password></Password>\\\n                <CPCode></CPCode>\\\n                <RequestID>1</RequestID>\\\n                <UserID>' + owner + '</UserID>\\\n                <ReceiverID>' + owner + '</ReceiverID>\\\n                <ServiceID></ServiceID>\\\n                <CommandCode>bulksms</CommandCode>\\\n                <Content>' + content + '</Content>\\\n                <ContentType>1</ContentType>\\\n            </impl:wsCpMt>\\\n        </soapenv:Body>\\\n    </soapenv:Envelope>';\nreturn {msg, metadata, msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1700,
                    "layoutY": 553
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
            }
        ],
        "connections": [
            {
                "fromIndex": 0,
                "toIndex": 1,
                "type": "Success"
            },
            {
                "fromIndex": 2,
                "toIndex": 3,
                "type": "Success"
            },
            {
                "fromIndex": 4,
                "toIndex": 5,
                "type": "Success"
            },
            {
                "fromIndex": 6,
                "toIndex": 9,
                "type": "gps"
            },
            {
                "fromIndex": 6,
                "toIndex": 7,
                "type": "log"
            },
            {
                "fromIndex": 6,
                "toIndex": 11,
                "type": "status"
            },
            {
                "fromIndex": 7,
                "toIndex": 8,
                "type": "Success"
            },
            {
                "fromIndex": 9,
                "toIndex": 10,
                "type": "Success"
            },
            {
                "fromIndex": 10,
                "toIndex": 13,
                "type": "Success"
            },
            {
                "fromIndex": 11,
                "toIndex": 12,
                "type": "Success"
            },
            {
                "fromIndex": 12,
                "toIndex": 13,
                "type": "Success"
            },
            {
                "fromIndex": 13,
                "toIndex": 16,
                "type": "FCM"
            },
            {
                "fromIndex": 13,
                "toIndex": 0,
                "type": "GeoFCM"
            },
            {
                "fromIndex": 13,
                "toIndex": 2,
                "type": "GeoSMS"
            },
            {
                "fromIndex": 13,
                "toIndex": 15,
                "type": "Response"
            },
            {
                "fromIndex": 13,
                "toIndex": 14,
                "type": "SaveData"
            },
            {
                "fromIndex": 13,
                "toIndex": 19,
                "type": "SMS"
            },
            {
                "fromIndex": 14,
                "toIndex": 8,
                "type": "Success"
            },
            {
                "fromIndex": 15,
                "toIndex": 17,
                "type": "Success"
            },
            {
                "fromIndex": 16,
                "toIndex": 18,
                "type": "Success"
            },
            {
                "fromIndex": 19,
                "toIndex": 20,
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
                addFlowIdToTemplateDeviceFleet(idFlow, templateId, deviceId, projectId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectFleet").attr("disabled", false);
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

function addFlowIdToTemplateDeviceFleet(idFlow, templateId, deviceId, projectId) {
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
                addDashboardNewToFleet(deviceId, projectId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectFleet").attr("disabled", false);
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

function addDashboardNewToFleet(deviceId, projectId) {
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
                saveWigetDashboardFleet(dashboardId, deviceId, projectId)
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectFleet").attr("disabled", false);
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

function saveWigetDashboardFleet(dashboardId, deviceId, projectId) {
    console.log(dashboardId, deviceId, projectId);
    var body = new FormData;
    body.id = dashboardId;
    var widgetList = [];

    var data1 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"Fleet 01\",\"var\":\"" + deviceId +
            "\",\"varName\":\"Fleet\",\"attribute_key\":\"accuracy\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
    widgetList.push({
        "x": "9",
        "y": "4",
        "w": "3",
        "h": "3",
        "id": "data-11",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data1,
        "title": "ĐỘ CHÍNH XÁC",
        "unit": "",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data2 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"Fleet 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"Fleet\",\"attribute_key\":\"battery\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
    widgetList.push({
        "x": "6",
        "y": "4",
        "w": "3",
        "h": "3",
        "id": "data-10",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data2,
        "title": "PIN",
        "unit": "%",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data3 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"Fleet 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"Fleet\",\"attribute_key\":\"connection\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"STR\"}]";
    widgetList.push({
        "x": "3",
        "y": "4",
        "w": "3",
        "h": "3",
        "id": "data-9",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data3,
        "title": "KẾT NỐI",
        "unit": "",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data4 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"Fleet 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"Fleet\",\"attribute_key\":\"firmware_version\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"STR\"}]";
    widgetList.push({
        "x": "0",
        "y": "4",
        "w": "3",
        "h": "3",
        "id": "data-8",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data4,
        "title": "FIRMWARE VERSION",
        "unit": "",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data5 = "[{\"device\":\"" + deviceId + "\",\"deviceName\":\"Fleet 01\",\"var\":\"" + deviceId +
        "\",\"varName\":\"Fleet\",\"attribute_key\":\"battery\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
    widgetList.push({
        "x": "6",
        "y": "0",
        "w": "6",
        "h": "4",
        "id": "chart-line-7",
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

    var data6 = "[{\"device\":\"" + deviceId +
        "\",\"lat\":\"latitude\",\"long\":\"longtitude\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
    widgetList.push({
        "x": "0",
        "y": "0",
        "w": "6",
        "h": "4",
        "id": "map-canvas-6",
        "type": "1",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data6,
        "title": "BẢN ĐỒ",
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
            $("#buttonAddProjectFleet").attr("disabled", false);
        }
    });
}