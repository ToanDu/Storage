/**
 * Created by vtk-anhlt166 on 6/24/22.
 */
function addProjectSmartFarm() {
    var nameProject = $("#nameSmartFarmAdd").val();
    var contentProject = $("#contentSmartFarmAdd").val();
    if(nameProject.length <= 0 || contentProject.length <= 0){
        showNotification('danger', Messages("Bạn cần điền đủ thông tin"));
        return;
    }

    $("#addSmartFarmConfirm").modal('hide');

    $("#buttonAddProjectSmartFarm").attr("disabled", true);

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

                addTemplateAttributeHumidifySmartFarm(projectId);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartFarm").attr("disabled", false);
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
function addTemplateAttributeHumidifySmartFarm(projectId) {
    console.log(projectId);
    var body = new FormData;
    body.url = "/api/templates";
    var attrArray = [
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "battery",
            "logged": false,
            "value": "",
            "value_t": "DBL"
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
            "attribute_key": "current_humidity",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "error",
            "logged": true,
            "value": "",
            "value_t": "JSON"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "id_pump",
            "logged": false,
            "value": "",
            "value_t": "STR"
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
            "attribute_key": "_name",
            "logged": false,
            "value": "Sensor",
            "value_t": "STR"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "set_humidity",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        }
    ];
    body.json = {
        "name":"Humidity",
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
                var templateIdHumidify = data.content.id;
                addTemplateAttributePumpSmartFarm(projectId, templateIdHumidify);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartFarm").attr("disabled", false);
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

function addTemplateAttributePumpSmartFarm(projectId, templateIdHumidify) {
    console.log(projectId);
    var body = new FormData;
    body.url = "/api/templates";
    var attrArray = [
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "status",
            "logged": false,
            "value": "",
            "value_t": "BOOL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "total_water_consumption",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        },
        {
            "attribute_type": "SCOPE_SERVER",
            "attribute_key": "water_consumption",
            "logged": true,
            "value": "",
            "value_t": "DBL"
        }
    ];
    body.json = {
        "name":"Pump",
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
                var templateIdPump = data.content.id;
                addDeviceSmartFarmHumidify(projectId, templateIdHumidify, templateIdPump);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartFarm").attr("disabled", false);
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

//TODO : tao thiet bi humidify va pump
function addDeviceSmartFarmHumidify(projectId, templateIdHumidify, templateIdPump) {
    var body = new FormData;
    body.url = "/api/devices";
    body.json = {
        "name":"humidity-01",
        "project_id":projectId,
        "template_id":templateIdHumidify
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
                var deviceIdHumidify = data.content.id;
                addDeviceSmartFarmPump(projectId, templateIdHumidify, templateIdPump, deviceIdHumidify);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartFarm").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Tạo thiết bị humidity không thành công"));
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

function addDeviceSmartFarmPump(projectId, templateIdHumidify, templateIdPump, deviceIdHumidify) {
    var body = new FormData;
    body.url = "/api/devices";
    body.json = {
        "name":"pump-01",
        "project_id":projectId,
        "template_id":templateIdPump
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
                var deviceIdPump = data.content.id;
                updateAtributeDeviceSmartFarm(projectId, templateIdHumidify, templateIdPump, deviceIdHumidify, deviceIdPump);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartFarm").attr("disabled", false);
                FinishProcess();
                showNotification('danger', Messages("Tạo thiết bị pump không thành công"));
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


function updateAtributeDeviceSmartFarm(projectId, templateIdHumidify, templateIdPump, deviceIdHumidify, deviceIdPump) {
    var body = new FormData;
    body.url = "/api/attributes/DEVICE/"+deviceIdHumidify+"/values";
    body.json = {
        "attributes":[
            {
                "attribute_type":"SCOPE_SERVER",
                "attribute_key":"id_pump",
                "value": deviceIdPump,
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

                addFlowEngineSmartFarm(projectId, deviceIdHumidify, deviceIdPump, templateIdHumidify, templateIdPump);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartFarm").attr("disabled", false);
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

function addFlowEngineSmartFarm(projectId, deviceIdHumidify, deviceIdPump, templateIdHumidify, templateIdPump) {
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
                importFlowDeviceIdSmartFarm(idFlow, projectId, deviceIdHumidify, deviceIdPump, templateIdHumidify, templateIdPump);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartFarm").attr("disabled", false);
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

function importFlowDeviceIdSmartFarm(idFlow, projectId, deviceIdHumidify, deviceIdPump, templateIdHumidify, templateIdPump) {
    console.log(idFlow);
    var body = new FormData;
    body.url = "/api/ruleChain/metadata";
    body.json = {
        "ruleChainId": {
            "entityType": "RULE_CHAIN",
            "id": idFlow
        },
        "firstNodeIndex": 2,
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
                    "periodInSeconds": 30,
                    "jsScript": "let msg = {\n   batt: random(50,100,1),\n   curr_hum: random(20,100,1),\n   cn: \"LTE\"\n};\nlet metadata = {deviceID: \""+deviceIdHumidify+"\"};\nvar msgType = \"POST_TELEMETRY_REQUEST\";\n\nreturn {msg, metadata, msgType};\n\nfunction random(min, max, int) {\n    if (int) return Math.floor((Math.random() * (max - min)) + min);\n    else return roundToTwo((Math.random() * (max - min)) + min);\n}\n\nfunction roundToTwo(num) {\n    return +(Math.round(num + \"e+2\")  + \"e-2\");\n}",
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
                    "topicPattern": "messages/${deviceID}/humidity",
                    "retain": false
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 326,
                    "layoutY": 152
                },
                "type": "org.iot.rule.engine.filter.TbJsSwitchNode",
                "name": "Filter",
                "debugMode": true,
                "configuration": {
                    "jsScript": "var deviceID = metadata.deviceID;\nvar ret = []\nif (msgType == \"POST_VARIABLES\") ret.push(metadata.topic, \"log\") \nif (metadata.topic == 'humidity') ret.push('humidity') \nif (metadata.topic == 'control_pump') ret.push('fake');\nif (metadata.topic == 'pump') ret.push('pump');\nreturn ret;\n"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1008,
                    "layoutY": 303
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Data",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let {batt, curr_hum, cn} = msg\nlet data = {\n    battery : batt,\n    current_humidity : curr_hum,\n    connection : cn,\n    message: {batt, curr_hum, cn}\n}\nmsg = {data}\nreturn {msg: msg, metadata: metadata, msgType: msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1026,
                    "layoutY": 435
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "pump",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let lwc = JSON.parse(metadata.ss_total_water_consumption);\nlet {water_consumption, status, _switch} = msg; \nlet total = lwc + water_consumption;\nmsg = {water_consumption:water_consumption, total_water_consumption:total, status, _switch}\nreturn {msg: msg, metadata: metadata, msgType: msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1043,
                    "layoutY": 648
                },
                "type": "org.iot.rule.engine.mqtt.PublishMqttToDeviceNode",
                "name": "SendMessageToPump",
                "debugMode": true,
                "configuration": {
                    "topicPattern": "messages/${deviceID}/pump",
                    "retain": true
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 712,
                    "layoutY": 437
                },
                "type": "org.iot.rule.engine.metadata.TbGetAttributesNode",
                "name": "GetAtt",
                "debugMode": true,
                "configuration": {
                    "tellFailureIfAbsent": true,
                    "clientAttributeNames": [],
                    "sharedAttributeNames": [],
                    "serverAttributeNames": [
                        "total_water_consumption"
                    ]
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 704,
                    "layoutY": 300
                },
                "type": "org.iot.rule.engine.metadata.TbGetAttributesNode",
                "name": "GetAtt",
                "debugMode": true,
                "configuration": {
                    "tellFailureIfAbsent": true,
                    "clientAttributeNames": [],
                    "sharedAttributeNames": [],
                    "serverAttributeNames": [
                        "id_pump",
                        "set_humidity"
                    ]
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1386,
                    "layoutY": 301
                },
                "type": "org.iot.rule.engine.filter.TbJsSwitchNode",
                "name": "Action",
                "debugMode": true,
                "configuration": {
                    "jsScript": "var ret = [\"SaveData\", \"Response\"];\nreturn ret"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1726,
                    "layoutY": 303
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "SaveData",
                "debugMode": true,
                "configuration": {
                    "jsScript": "return {msg: msg.data, metadata: metadata, msgType: msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 719,
                    "layoutY": 648
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "FakePump",
                "debugMode": true,
                "configuration": {
                    "jsScript": "// FAKE DEVICE: send msg from device to cloud\nlet water_consumption = random(20, 100, 1)\nlet _switch = \"OFF\";\nlet {status} = msg.data\nif (status == true){\n    _switch = \"ON\"\n    msg = {status, _switch:_switch}\n}else{\n    msg = {status, water_consumption: water_consumption, _switch:_switch}\n}\n\nreturn {msg: msg, metadata: metadata, msgType: msgType};\n\nfunction random(min, max, int) {\n    if (int) return Math.floor((Math.random() * (max - min)) + min);\n    else return roundToTwo((Math.random() * (max - min)) + min);\n}\n\nfunction roundToTwo(num) {\n    return +(Math.round(num + \"e+2\")  + \"e-2\");\n}"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1727,
                    "layoutY": 430
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Response Pump",
                "debugMode": true,
                "configuration": {
                    "jsScript": "let {current_humidity} = msg.data;\nlet set_humidity = JSON.parse(metadata.ss_set_humidity);\nlet status = false;\nif(set_humidity - current_humidity >= 0){\n    status = true;\n}\nlet data = {\n    status:status\n}\nreturn {msg: {data}, metadata: metadata, msgType: msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 2030,
                    "layoutY": 430
                },
                "type": "org.iot.rule.engine.mqtt.PublishMqttToDeviceNode",
                "name": "SendMessageToPump",
                "debugMode": true,
                "configuration": {
                    "topicPattern": "messages/${ss_id_pump}/control_pump",
                    "retain": true
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 747,
                    "layoutY": 155
                },
                "type": "org.iot.rule.engine.transform.TbTransformMsgNode",
                "name": "Log",
                "debugMode": true,
                "configuration": {
                    "jsScript": "return {msg: {logging: {message: msg, topic: metadata.topic}}, metadata, msgType};"
                }
            },
            {
                "additionalInfo": {
                    "description": "",
                    "layoutX": 1916,
                    "layoutY": 154
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
                    "layoutX": 1343,
                    "layoutY": 438
                },
                "type": "org.iot.rule.engine.telemetry.TbMsgAttributesNode",
                "name": "SaveData",
                "debugMode": true,
                "configuration": {
                    "scope": "SERVER_SCOPE",
                    "notifyDevice": null,
                    "loggedHistory": null
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
                "toIndex": 10,
                "type": "fake"
            },
            {
                "fromIndex": 2,
                "toIndex": 7,
                "type": "humidity"
            },
            {
                "fromIndex": 2,
                "toIndex": 13,
                "type": "log"
            },
            {
                "fromIndex": 2,
                "toIndex": 6,
                "type": "pump"
            },
            {
                "fromIndex": 3,
                "toIndex": 8,
                "type": "Success"
            },
            {
                "fromIndex": 4,
                "toIndex": 15,
                "type": "Success"
            },
            {
                "fromIndex": 6,
                "toIndex": 4,
                "type": "Success"
            },
            {
                "fromIndex": 7,
                "toIndex": 3,
                "type": "Success"
            },
            {
                "fromIndex": 8,
                "toIndex": 11,
                "type": "Response"
            },
            {
                "fromIndex": 8,
                "toIndex": 9,
                "type": "SaveData"
            },
            {
                "fromIndex": 9,
                "toIndex": 14,
                "type": "Success"
            },
            {
                "fromIndex": 10,
                "toIndex": 5,
                "type": "Success"
            },
            {
                "fromIndex": 11,
                "toIndex": 12,
                "type": "Success"
            },
            {
                "fromIndex": 13,
                "toIndex": 14,
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
                addFlowIdToTemplateHumidifySmartFarm(idFlow, projectId, templateIdHumidify, templateIdPump, deviceIdHumidify, deviceIdPump);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartFarm").attr("disabled", false);
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

function addFlowIdToTemplateHumidifySmartFarm(idFlow, projectId, templateIdHumidify, templateIdPump, deviceIdHumidify, deviceIdPump) {
    var body = new FormData;
    body.url = "/api/templates/"+templateIdHumidify;
    body.json = {
        "name": "Humidity",
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
                addFlowIdToTemplatePumpSmartFarm(idFlow, projectId, templateIdPump, deviceIdHumidify, deviceIdPump);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartFarm").attr("disabled", false);
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

function addFlowIdToTemplatePumpSmartFarm(idFlow, projectId, templateIdPump, deviceIdHumidify, deviceIdPump) {
    var body = new FormData;
    body.url = "/api/templates/"+templateIdPump;
    body.json = {
        "name": "Pump",
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
                addDashboardNewToSmartFarm(projectId, deviceIdHumidify, deviceIdPump);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartFarm").attr("disabled", false);
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

function addDashboardNewToSmartFarm(projectId, deviceIdHumidify, deviceIdPump) {
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
                saveWigetDashboardSmartFarm(dashboardId, projectId, deviceIdHumidify, deviceIdPump);
            } else {
                $("#createTemplateProjectModal").modal('hide');
                $("#buttonAddProjectSmartFarm").attr("disabled", false);
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

function saveWigetDashboardSmartFarm(dashboardId, projectId, deviceIdHumidify, deviceIdPump) {
    console.log(dashboardId, projectId, deviceIdHumidify, deviceIdPump);
    var body = new FormData;
    body.id = dashboardId;
    var widgetList = [];

    var data1 = "[{\"device\":\"" + deviceIdPump + "\",\"deviceName\":\"pump-01\",\"var\":\"" + deviceIdPump +
        "\",\"varName\":\"pump-01\",\"attribute_key\":\"water_consumption\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
    widgetList.push({
        "x": "10",
        "y": "4",
        "w": "2",
        "h": "2",
        "id": "data-5",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data1,
        "title": "Khối lượng nước",
        "unit": "M3",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data2 = "[{\"device\":\"" + deviceIdHumidify + "\",\"deviceName\":\"humidity-01\",\"var\":\"" + deviceIdHumidify +
        "\",\"varName\":\"humidity-01\",\"attribute_key\":\"battery\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
    widgetList.push({
        "x": "8",
        "y": "4",
        "w": "2",
        "h": "2",
        "id": "data-4",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data2,
        "title": "Pin",
        "unit": "%",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data3 = "[{\"device\":\"" + deviceIdHumidify + "\",\"deviceName\":\"humidity-01\",\"var\":\"" + deviceIdHumidify +
        "\",\"varName\":\"humidity-01\",\"attribute_key\":\"current_humidity\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"STR\"}]";
    widgetList.push({
        "x": "6",
        "y": "4",
        "w": "2",
        "h": "2",
        "id": "data-3",
        "type": "7",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data3,
        "title": "Độ ẩm hiện tại",
        "unit": "%",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data4 = "[{\"device\":\"" + deviceIdHumidify + "\",\"deviceName\":\"humidify-01\",\"var\":\"" + deviceIdHumidify +
        "\",\"varName\":\"humidity-01\",\"attribute_key\":\"battery\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
    widgetList.push({
        "x": "0",
        "y": "4",
        "w": "6",
        "h": "4",
        "id": "chart-line-2",
        "type": "4",
        "org": null,
        "filter": "org",
        "filterValue": projectId,
        "data": data4,
        "title": "Pin",
        "unit": "%",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data5 = "[{\"device\":\"" + deviceIdHumidify + "\",\"deviceName\":\"humidity-01\",\"var\":\"" + deviceIdHumidify +
        "\",\"varName\":\"humidity-01\",\"attribute_key\":\"current_humidity\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
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
        "data": data5,
        "title": "Độ ẩm",
        "unit": "%",
        "maxValue": null,
        "cmdon": null,
        "cmdoff": null
    });

    var data6 = "[{\"device\":\"" + deviceIdPump + "\",\"deviceName\":\"pump-01\",\"var\":\"" + deviceIdPump +
        "\",\"varName\":\"pump-01\",\"attribute_key\":\"total_water_consumption\",\"attribute_type\":\"SCOPE_SERVER\",\"value_type\":\"DBL\"}]";
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
        "data": data6,
        "title": "Tổng lượng nước tiêu thụ",
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
            $("#buttonAddProjectSmartFarm").attr("disabled", false);
        }
    });
}