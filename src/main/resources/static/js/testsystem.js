function paperdeletepost(){
	var paperId = $("#paperid").val();
    var status = $("#paperstatus").val();
    $.ajax({
        type: "POST",
        url: "/manage/modifypaper/deletepaper",
        contentType: 'application/json',
        data: JSON.stringify({
            "paperId": paperId,
            "status": status,
        }),
        success: function (response){
        	if (response.code == 200) {
                window.location.href = response.redirect;
            } else {
            	alert(response.message);
            }
        },
        dataType: "json"
    });
}

function papermodifysubmit(){
	var paperId = $("#paperid").val();
    var status = $("#paperstatus").val();
    $.ajax({
        type: "POST",
        url: "/manage/modifypaper/papermodifysubmit",
        contentType: 'application/json',
        data: JSON.stringify({
            "paperId": paperId,
            "status": status,
        }),
        success: function (response){
        	if (response.code == 200) {
                window.location.href = response.redirect;
            } else {
            	alert(response.message);
            }
        },
        dataType: "json"
    });
}

function paperquestionadd(){
	var paperId = $("#paperid").val();
    var status = $("#paperstatus").val();
    $.ajax({
        type: "POST",
        url: "/manage/modifypaper/paperquestionadd",
        contentType: 'application/json',
        data: JSON.stringify({
            "id": paperId,
            "status": status,
        }),
        success: function (response){
        	if (response.code == 200) {
                window.location.href = response.redirect;
            } else {
            	alert(response.message);
            }
        },
        dataType: "json"
    });
}

function paperAddQuestion(paperId,questionID){
	alert(paperId+"  "+questionID);
    $.ajax({
        type: "POST",
        url: "/manage/modifypaper/paperQuestionAddSubmit",
        contentType: 'application/json',
        data: JSON.stringify({
            "id": paperId,
            "questionId": questionID
        }),
        success: function (response){
        	if (response.code == 200) {
                window.location.href = response.redirect;
            } else {
            	alert(response.message);
            }
        },
        dataType: "json"
    });
}