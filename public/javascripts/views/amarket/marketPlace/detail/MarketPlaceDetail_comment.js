/**
 * Created by vtk-anhlt166 on 8/16/22.
 */
var treeNodeArrayComment = [];
var parentId = [];
function getListCommentProduct(){
    var body = {
        "id" : productId
    };
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.MarketPlaceCommentController.getListCommentProduct();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                $("#tabListComment").html('<div id="treeComment"></div>');
                treeNodeArrayComment = [];
                parentId = [];
                $("#countComment").html(data.content.length + Messages(" bình luận"));
                if(data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        var text = '<div class="chat-content-leftside">'+
                            '<div class="d-flex">'+
                            '<img src="'+avtDefault+'" width="48" height="48" class="rounded-circle" alt="">'+
                            '<div class="flex-grow-1 ms-2">'+
                            '<p class="mb-0 chat-time text-default" style="font-weight: 700;">'+ data.content[i].name +'</p>'+
                            '<p class="mb-0 chat-time text-default" style="font-weight: 500;">'+ moment.unix(data.content[i].createDate/1000).format("HH:mm, DD/MM/YYYY") +'</p>'+
                            '<p class="chat-left-msg text-default">'+data.content[i].content+'</p>'+
                            '<div class="like-answer">'+
                            '<a><i class="bx bx-like"></i>'+ Messages("Hữu ích") +'</a>'+
                            '<a style="padding-left: 20px;" onclick="showInputAnswer(\''+data.content[i].id+'\', \''+data.content[i].content+'\')" data-bs-toggle="modal" data-bs-target="#answerFormModal"><i class="bx bx-comment"></i>'+Messages("Trả lời")+'</a>'+
                            '<a id="countChildCmt_'+data.content[i].id+'"></a>'+
                            '</div>'+
                            '</div>'+
                            '</div>'+
                            '</div>'+
                            '</div>';
                        // var text = '<span style="padding: 15px; font-size: 16px;">'+data.content[i].content+'</span>';
                        var node = {
                            id: data.content[i].id,
                            parent: data.content[i].parent,
                            text: text,
                            date: moment.unix(data.content[i].createDate/1000).format("YYYY/MM/DD HH:mm")
                        };
                        treeNodeArrayComment.push(node);
                        if(data.content[i].parent == "#"){
                            parentId.push(data.content[i].id);
                        }
                    }

                    console.log(treeNodeArrayComment);
                    console.log(parentId);
                    $('#treeComment').jstree({
                        core: {
                            data: treeNodeArrayComment,
                            check_callback: true  // don't forget to set this param to true
                        },
                        "plugins": ["sort"],
                        "sort" : function(a, b) {
                            //What is the function of sorting
                            a1 = this.get_node(a);
                            b1 = this.get_node(b);
                            if (a1.icon == b1.icon){
                                if(a1.parent == "#"){
                                    return (a1.date > b1.date) ? 1 : -1;
                                }
                            }
                        }
                    });
                    $('#treeComment').jstree();
                    $('#treeComment').on('loaded.jstree', function(e, data) {
                        //open tat ca cac node
                        $('#treeComment').jstree('open_all');
                        // console.log(data);
                        // console.log(data.instance._model.data);
                        for(var i=0; i<parentId.length; i++){
                            var count = $("#" + parentId[i] + " .jstree-anchor").children().length;
                            // console.log(count);
                            if(count > 1){
                                $("#countChildCmt_"+parentId[i]).html(" ("+(count-1)+" phản hồi bình luận)");
                                $('#treeComment').jstree().close_node({"id":parentId[i]});
                            }
                        }
                    });
                    $('.jstree-anchor').on('click', function () {
                        $('#treeComment').jstree(true).select_node('child_node_1');
                        $('#treeComment').jstree('select_node', 'child_node_1');
                        $.jstree.reference('#treeComment').select_node('child_node_1');
                    });
                }

            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function proccessCommentProduct(){
    var body = {
        "id" : productId,
        "name" : $("#nameQuestioner").val(),
        "email" : $("#emailQuestioner").val(),
        "content" : $("#questionText").val(),
        "parent" : "#"
    };
    console.log(body);

    var isEmpty = !Object.values(body).some(x => (x !== null && x !== ''));
    if(isEmpty){
        showNotification('danger',Messages("Bạn vui lòng điền đầy đủ thông tin"));
        return;
    }

    localStorage.nameCmt = $("#nameQuestioner").val();
    localStorage.emailCmt = $("#emailQuestioner").val();

    StartProcess();
    var r = jsRoutes.controllers.MarketPlaceCommentController.commentWithProductId();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                $("#questionText").val("");
                FinishProcess();
                //add node parent
                var text = '<div class="chat-content-leftside">'+
                    '<div class="d-flex">'+
                    '<img src="'+avtDefault+'" width="48" height="48" class="rounded-circle" alt="">'+
                    '<div class="flex-grow-1 ms-2">'+
                    '<p class="mb-0 chat-time text-default" style="font-weight: 700;">'+ data.content.name +'</p>'+
                    '<p class="mb-0 chat-time text-default" style="font-weight: 500;">'+ moment.unix(data.content.createDate/1000).format("HH:mm, DD/MM/YYYY") +'</p>'+
                    '<p class="chat-left-msg text-default">'+data.content.content+'</p>'+
                    '<div class="like-answer">'+
                    '<a><i class="bx bx-like"></i>'+ Messages("Hữu ích") +'</a>'+
                    '<a style="padding-left: 20px;" onclick="showInputAnswer(\''+data.content.id+'\', \''+data.content.content+'\')" data-bs-toggle="modal" data-bs-target="#answerFormModal"><i class="bx bx-comment"></i>'+Messages("Trả lời")+'</a>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>';
                $('#treeComment').jstree().create_node('#', {
                    "id": data.content.id,
                    "text": text,
                    "date": moment.unix(data.content.createDate/1000).format("YYYY/MM/DD HH:mm")
                }, "last");
            } else {
                showNotification('danger',Messages("Gửi không thành công"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function showInputAnswer(id, content) {
    console.log("showInputAnswer" + id);
    $("#parentId").val(id);
    $("#questionContent").html(content);
    $("#answerContent").val("");
    $("#answerName").val((localStorage.nameCmt != null && localStorage.nameCmt != undefined) ? localStorage.nameCmt : "");
    $("#answerEmail").val((localStorage.emailCmt != null && localStorage.emailCmt != undefined) ? localStorage.emailCmt : "")
}

function proccessAnswer() {
    console.log("proccessAnswer");
    var body = {
        "id" : productId,
        "name" : $("#answerName").val(),
        "email" : $("#answerEmail").val(),
        "content" : $("#answerContent").val(),
        "parent" : $("#parentId").val()
    };
    console.log(body);

    var isEmpty = !Object.values(body).some(x => (x !== null && x !== ''));
    if(isEmpty){
        showNotification('danger',Messages("Bạn vui lòng điền đầy đủ thông tin"));
        return;
    }

    localStorage.nameCmt = $("#answerName").val();
    localStorage.emailCmt = $("#answerEmail").val();

    StartProcess();
    var r = jsRoutes.controllers.MarketPlaceCommentController.commentWithProductId();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                FinishProcess();
                //add node parent
                var text = '<div class="chat-content-leftside">'+
                    '<div class="d-flex">'+
                    '<img src="'+avtDefault+'" width="48" height="48" class="rounded-circle" alt="">'+
                    '<div class="flex-grow-1 ms-2">'+
                    '<p class="mb-0 chat-time text-default" style="font-weight: 700;">'+ data.content.name +'</p>'+
                    '<p class="mb-0 chat-time text-default" style="font-weight: 500;">'+ moment.unix(data.content.createDate/1000).format("HH:mm, DD/MM/YYYY") +'</p>'+
                    '<p class="chat-left-msg text-default">'+data.content.content+'</p>'+
                    '<div class="like-answer">'+
                    '<a><i class="bx bx-like"></i>'+ Messages("Hữu ích") +'</a>'+
                    '<a style="padding-left: 20px;" onclick="showInputAnswer(\''+data.content.id+'\', \''+data.content.content+'\')" data-bs-toggle="modal" data-bs-target="#answerFormModal"><i class="bx bx-comment"></i>'+Messages("Trả lời")+'</a>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>';
                $('#treeComment').jstree().create_node(body.parent, {
                    "id": data.content.id,
                    "text": text,
                    "date": moment.unix(data.content.createDate/1000).format("YYYY/MM/DD HH:mm")
                }, "last");
                $('#treeComment').jstree('select_node', '#'+data.content.id);
            } else {
                showNotification('danger', data.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}