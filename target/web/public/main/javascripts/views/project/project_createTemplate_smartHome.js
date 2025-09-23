/**
 * Created by vtk-anhlt166 on 6/24/22.
 */
function addProjectSmartHome() {
    var nameProject = $("#nameSmartHomeAdd").val();
    var contentProject = $("#contentSmartHomeAdd").val();
    if(nameProject.length <= 0 || contentProject.length <= 0){
        showNotification('danger', Messages("Bạn cần điền đủ thông tin"));
        return;
    }

    $("#addSmartHomeConfirm").modal('hide');

    $("#buttonAddProjectSmartHome").attr("disabled", true);

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

                addTemplateAttributeGatewaySmartHome(projectId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartHome").attr("disabled", false);
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

//TODO : tao template, attribute cho humidify va pump
function addTemplateAttributeGatewaySmartHome(projectId) {
    console.log(projectId);
    var body = new FormData;
    body.url = "/api/templates";
    var attrArray = [
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "id_hub",
            "logged": false,
            "value": "",
            "value_t": "STR"
        }
    ];
    body.json = {
        "name":"Gateway",
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
                var templateIdGate = data.content.id;
                addTemplateAttributeSensorSmartHome(projectId, templateIdGate);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartHome").attr("disabled", false);
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

function addTemplateAttributeSensorSmartHome(projectId, templateIdGate) {
    console.log(projectId);
    var body = new FormData;
    body.url = "/api/templates";
    var attrArray = [
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "id_switch",
            "logged": false,
            "value": "",
            "value_t": "STR"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "status_motion",
            "logged": false,
            "value": "",
            "value_t": "DBL"
        }
    ];
    body.json = {
        "name":"Sensor",
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
                var templateIdSensor = data.content.id;
                addTemplateAttributeSwitchSmartHome(projectId, templateIdGate, templateIdSensor);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartHome").attr("disabled", false);
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

function addTemplateAttributeSwitchSmartHome(projectId, templateIdGate, templateIdSensor) {
    console.log(projectId);
    var body = new FormData;
    body.url = "/api/templates";
    var attrArray = [
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "endpoint",
            "logged": false,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "power",
            "logged": false,
            "value": "",
            "value_t": "STR"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "power-01",
            "logged": false,
            "value": "",
            "value_t": "STR"
        }
    ];
    body.json = {
        "name":"Switch",
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
                var templateIdSwitch = data.content.id;
                addDeviceSmartHomeSensor(projectId, templateIdGate, templateIdSensor, templateIdSwitch);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartHome").attr("disabled", false);
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

//TODO : tao thiet bi sensor, hub va switch
function addDeviceSmartHomeSensor(projectId, templateIdGate, templateIdSensor, templateIdSwitch) {
    var body = new FormData;
    body.url = "/api/devices";
    body.json = {
        "name":"sensor-01",
        "project_id":projectId,
        "template_id":templateIdSensor
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
                var deviceIdSensor = data.content.id;
                addDeviceSmartHomeHub(projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartHome").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Tạo thiết bị sensor không thành công"));
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

function addDeviceSmartHomeHub(projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor) {
    var body = new FormData;
    body.url = "/api/devices";
    body.json = {
        "name":"hub-01",
        "project_id":projectId,
        "template_id":templateIdGate
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
                var deviceIdHub = data.content.id;
                addDeviceSmartHomeSwitch(projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor, deviceIdHub);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartHome").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Tạo thiết bị hub không thành công"));
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

function addDeviceSmartHomeSwitch(projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor, deviceIdHub) {
    var body = new FormData;
    body.url = "/api/devices";
    body.json = {
        "name":"switch-01",
        "project_id":projectId,
        "template_id":templateIdSwitch
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
                var deviceIdSwitch = data.content.id;
                updateAtributeHubDeviceSmartHome(projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor, deviceIdHub, deviceIdSwitch);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartHome").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Tạo thiết bị switch không thành công"));
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


function updateAtributeHubDeviceSmartHome(projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor, deviceIdHub, deviceIdSwitch) {
    var body = new FormData;
    body.url = "/api/attributes/DEVICE/"+deviceIdHub+"/values";
    body.json = {
        "attributes":[
            {
                "attribute_type":"SCOPE_SERVER",
                "attribute_key":"id_sensor",
                "value": deviceIdSensor,
                "value_t":"STR"
            }
        ]
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

                updateAtributeSwitchDeviceSmartHome(projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor, deviceIdHub, deviceIdSwitch);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartHome").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Cập nhật thuộc tính thiết bị hub không thành công"));
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

function updateAtributeSwitchDeviceSmartHome(projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor, deviceIdHub, deviceIdSwitch) {
    var body = new FormData;
    body.url = "/api/attributes/DEVICE/"+deviceIdSensor+"/values";
    body.json = {
        "attributes":[
            {
                "attribute_type":"SCOPE_SERVER",
                "attribute_key":"id_switch",
                "value": deviceIdSwitch,
                "value_t":"STR"
            }
        ]
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

                addFlowEngineSmartHome(projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor, deviceIdHub, deviceIdSwitch);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartHome").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Cập nhật thuộc tính thiết bị Pump không thành công"));
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

function addFlowEngineSmartHome(projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor, deviceIdHub, deviceIdSwitch) {
    var body = new FormData;
    body.url = "/api/ruleChain";
    body.json = {
        "additionalInfo": {
            "description": ""
        },
        "name": "Flow",
        "projectId": projectId,
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
                importFlowDeviceIdSmartHome(idFlow, projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor, deviceIdHub, deviceIdSwitch);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartHome").attr("disabled", false);
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

function importFlowDeviceIdSmartHome(idFlow, projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor, deviceIdHub, deviceIdSwitch) {
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
                    "layoutX": 1354,
                    "layoutY": 283
                },
                "type": "org.iot.rule.engine.telemetry.TbMsgAttributesNode",
                "name": "SaveData",
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
                    "layoutX": 1629,
                    "layoutY": 280
                },
                "type": "org.iot.rule.engine.mqtt.PublishMqttToDeviceNode",
                "name": "SendMessage",
                "debugMode": true,
                "configuration": {
                    "topicPattern": "messages/${ss_id_switch}/switch",
                    "retain": true
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 49,
                    "layoutY": 53
                },
                "type": "org.iot.rule.engine.debug.TbMsgGeneratorNode",
                "name": "Timed Message Transmitter",
                "debugMode": true,
                "configuration": {
                    "msgCount": 0,
                    "periodInSeconds": 30,
                    "jsScript": "let msg = {\n   motion:1\n};\nlet metadata = {deviceID: \""+deviceIdHub+"\"};\nvar msgType = \"POST_TELEMETRY_REQUEST\";\n\nreturn {msg, metadata, msgType};\n",
                    "originatorId": null,
                    "originatorType": null
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 384,
                    "layoutY": 52
                },
                "type": "org.iot.rule.engine.mqtt.PublishMqttToDeviceNode",
                "name": "Send Message",
                "debugMode": true,
                "configuration": {
                    "topicPattern": "messages/${deviceID}/gateway",
                    "retain": true
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 715,
                    "layoutY": 287
                },
                "type": "org.iot.rule.engine.metadata.TbGetAttributesNode",
                "name": "GetAtt",
                "debugMode": true,
                "configuration": {
                    "tellFailureIfAbsent": true,
                    "clientAttributeNames": [],
                    "sharedAttributeNames": [],
                    "serverAttributeNames": [
                        "id_switch",
                        "ts"
                    ]
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 391,
                    "layoutY": 149
                },
                "type": "org.iot.rule.engine.filter.TbJsSwitchNode",
                "name": "Filter",
                "debugMode": true,
                "configuration": {
                    "jsScript": "var ret = [];\nif(metadata.topic == \"gateway\") ret.push('gateway')\nif(metadata.topic == \"sensor\") ret.push('sensor')\nif(metadata.topic == \"switch\") ret.push('switch')\nreturn ret\n"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1001,
                    "layoutY": 151
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Data Processing",
                "debugMode": true,
                "configuration": {
                    "jsScript": "return {msg: msg, metadata: metadata, msgType: msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1355,
                    "layoutY": 148
                },
                "type": "org.iot.rule.engine.mqtt.PublishMqttToDeviceNode",
                "name": "SendMessage",
                "debugMode": true,
                "configuration": {
                    "topicPattern": "messages/${ss_id_sensor}/sensor",
                    "retain": true
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 713,
                    "layoutY": 152
                },
                "type": "org.iot.rule.engine.metadata.TbGetAttributesNode",
                "name": "GetAtt",
                "debugMode": true,
                "configuration": {
                    "tellFailureIfAbsent": true,
                    "clientAttributeNames": [],
                    "sharedAttributeNames": [],
                    "serverAttributeNames": [
                        "id_sensor"
                    ]
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1003,
                    "layoutY": 283
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Data Processing",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let {motion} = msg;\nlet ts = new Data.getTime();\nlet last_motion = JSON.stringify(metadata.ss_ts);\nlet status_motion = false;\nlet delay = new Date().getTime() - last_motion\nif (motion == 1) {\n    status_motion = true\n    msg = {status_motion: status_motion, ts:ts}\n} else if (motion == 0 || delay >= 600000) {\n    msg = {status_motion: status_motion}\n}\nreturn {\n    msg: msg,\n    metadata: metadata,\n    msgType: msgType\n};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 728,
                    "layoutY": 403
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Data Processing",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let {status_motion} = msg;\nlet power = \"\";\nlet power_1 = \"\";\nlet endpoint = 0;\nif( status_motion == true){\n    power = \"ON\";\n    power_1 = \"ON\";\n    endpoint = 1;\n    msg = {power:power, endpoint:endpoint, power_1:power_1}\n}\nelse if (status_motion == false){\n    power_1 = \"OFF\";\n    power = \"OFF\";\n    endpoint = 0;\n    msg = {power_1:power_1, endpoint:endpoint, power:power}\n    \n}\n\nreturn {msg: msg, metadata: metadata, msgType: msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1002,
                    "layoutY": 402
                },
                "type": "org.iot.rule.engine.telemetry.TbMsgAttributesNode",
                "name": "SaveData",
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
                    "layoutX": 1360,
                    "layoutY": 401
                },
                "type": "org.iot.rule.engine.mqtt.PublishMqttToDeviceNode",
                "name": "Message Response",
                "debugMode": true,
                "configuration": {
                    "topicPattern": "messages/${deviceID}/control",
                    "retain": true
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
                "toIndex": 9,
                "type": "Success"
            },
            {
                "fromIndex": 5,
                "toIndex": 8,
                "type": "gateway"
            },
            {
                "fromIndex": 5,
                "toIndex": 4,
                "type": "sensor"
            },
            {
                "fromIndex": 5,
                "toIndex": 10,
                "type": "switch"
            },
            {
                "fromIndex": 6,
                "toIndex": 7,
                "type": "Success"
            },
            {
                "fromIndex": 8,
                "toIndex": 6,
                "type": "Success"
            },
            {
                "fromIndex": 9,
                "toIndex": 0,
                "type": "Success"
            },
            {
                "fromIndex": 10,
                "toIndex": 11,
                "type": "Success"
            },
            {
                "fromIndex": 11,
                "toIndex": 12,
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
                addFlowIdToTemplateGateway(idFlow, projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor, deviceIdHub, deviceIdSwitch);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartHome").attr("disabled", false);
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

function addFlowIdToTemplateGateway(idFlow, projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor, deviceIdHub, deviceIdSwitch) {
    var body = new FormData;
    body.url = "/api/templates/"+templateIdGate;
    body.json = {
        "name": "Gateway",
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
                addFlowIdToTemplateSensor(idFlow, projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor, deviceIdHub, deviceIdSwitch);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartHome").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Gán Flow ID cho mẫu thiết bị Gateway không thành công"));
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

function addFlowIdToTemplateSensor(idFlow, projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor, deviceIdHub, deviceIdSwitch) {
    var body = new FormData;
    body.url = "/api/templates/"+templateIdSensor;
    body.json = {
        "name": "Sensor",
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
                addFlowIdToTemplateSwitch(idFlow, projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor, deviceIdHub, deviceIdSwitch);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartHome").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Gán Flow ID cho mẫu thiết bị Sensor không thành công"));
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

function addFlowIdToTemplateSwitch(idFlow, projectId, templateIdGate, templateIdSensor, templateIdSwitch, deviceIdSensor, deviceIdHub, deviceIdSwitch) {
    var body = new FormData;
    body.url = "/api/templates/"+templateIdSwitch;
    body.json = {
        "name": "Switch",
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
                addDashboardNewToSmartHome(projectId, deviceIdSensor, deviceIdHub, deviceIdSwitch);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartHome").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Gán Flow ID cho mẫu thiết bị Switch không thành công"));
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

function addDashboardNewToSmartHome(projectId, deviceIdSensor, deviceIdHub, deviceIdSwitch) {
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
                console.log(dashboardId);
                saveWigetDashboardSmartHome(dashboardId, projectId, deviceIdSensor, deviceIdHub, deviceIdSwitch);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartHome").attr("disabled", false);
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

function saveWigetDashboardSmartHome(dashboardId, projectId, deviceIdSensor, deviceIdHub, deviceIdSwitch) {
    console.log(dashboardId, projectId, deviceIdSensor, deviceIdHub, deviceIdSwitch);
    var body = new FormData;
    body.id = dashboardId;
    var widgetList = [];

    var data1 = "[{\"device\":\"" + deviceIdSensor + "\",\"deviceName\":\"sensor-01\",\"var\":\"" + deviceIdSensor +
        "\",\"varName\":\"sensor-01\",\"attribute_key\":\"status_motion\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
    widgetList.push({
        "x": "4",
        "y": "0",
        "w": "4",
        "h": "4",
        "id": "data-1",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data1,
        "title": "Trạng thái chuyển động",
        "unit": "",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data2 = "[{\"device\":\"" + deviceIdSwitch + "\",\"deviceName\":\"switch-01\",\"var\":\"" + deviceIdSwitch +
        "\",\"varName\":\"switch-01\",\"attribute_key\":\"power-01\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"STR\"}]";
    widgetList.push({
        "x": "0",
        "y": "0",
        "w": "4",
        "h": "4",
        "id": "data-0",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data2,
        "title": "Công tắc đang bật",
        "unit": "",
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
            $("#buttonAddProjectSmartHome").attr("disabled", false);
        }
    });
}