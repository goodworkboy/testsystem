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

function testPublish(){
	var name = $("#testname").val();
	var startTime= $("#startTime").val();
	var duration = $("#duration").val();
	var paperId = $("#paperId").val();
	if ( name == null || name ==""){
		alert("考试名称不能为空！");
		return
	}
	if(startTime == null || startTime ==""){
		alert("考试开始时间不能为空！");
		return
	}
	if(duration == null || duration ==""){
		alert("考试结束时间不能为空！");
		return
	}
    $.ajax({
        type: "POST",
        url: "/manage/publish/submit",
        contentType: 'application/json',
        data: JSON.stringify({
            "name": name,
            "startTime": startTime,
            "duration": duration,
            "paperId": paperId,
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

function modifytestsubmit(){
	var name = $("#testname").val();
	var startTime= $("#startTime").val();
	var duration = $("#duration").val();
	var paperId = $("#paperId").val();
	var testId = $("#testId").val();
	if ( name == null || name ==""){
		alert("考试名称不能为空！");
		return
	}
	if(startTime == null || startTime ==""){
		alert("考试开始时间不能为空！");
		return
	}
	if(duration == null || duration ==""){
		alert("考试结束时间不能为空！");
		return
	}
    $.ajax({
        type: "POST",
        url: "/manage/modifytest/submit",
        contentType: 'application/json',
        data: JSON.stringify({
            "name": name,
            "startTime": startTime,
            "duration": duration,
            "paperId": paperId,
            "id": testId,
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

function signUp(testId){
	$.ajax({
        type: "POST",
        url: "/user/test/signup",
        contentType: 'application/json',
        data: JSON.stringify({
            "testId": testId
        }),
        success: function (response){
        	if (response.code == 200) {
        		alert("报名成功!");
            } else {
            	alert(response.message);
            }
        	window.location.reload();
        },
        dataType: "json"
    });
}

function signOut(testId){
	$.ajax({
        type: "POST",
        url: "/user/test/signOut",
        contentType: 'application/json',
        data: JSON.stringify({
            "testId": testId
        }),
        success: function (response){
        	if (response.code == 200) {
        		alert("取消报名成功!");
        		window.location.reload();
            } else {
            	alert(response.message);
            }
        },
        dataType: "json"
    });
}

function startTest(testId){
	$.ajax({
        type: "POST",
        url: "/user/startingTest/startTest",
        contentType: 'application/json',
        data: JSON.stringify({
            "testId": testId
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

function changeQuestion(testId,page,questionId){
	var radios = document.getElementsByName("answer");
    var answer = null;
    for(var i=0;i<radios.length;i++){
        if(radios[i].checked == true){
            answer = radios[i].value;
        }
    }
	$.ajax({
        type: "POST",
        url: "/user/startingTest/doTest/submit",
        contentType: 'application/json',
        data: JSON.stringify({
            "testId": testId,
            "answer":answer,
            "questionId":questionId
        }),
       
        success: function (response){
        	if (response.code == 200) {
        		window.location.href = "/user/startingTest/doTest/"+testId+"?page="+page;
            } else {
            	alert(response.message+"即将返回主页");
            	window.location.href = response.redirect;
            }
        },
        dataType: "json"
    });
}

function submitall(testId,questionId){
	var radios = document.getElementsByName("answer");
    var answer = null;
    for(var i=0;i<radios.length;i++){
        if(radios[i].checked == true){
            answer = radios[i].value;
        }
    }
	$.ajax({
        type: "POST",
        url: "/user/startingTest/doTest/submit",
        contentType: 'application/json',
        data: JSON.stringify({
            "testId": testId,
            "answer":answer,
            "questionId":questionId
        }),
        success: function (response){
        	if (response.code == 200) {
        		$.ajax({
        	        type: "POST",
        	        url: "/user/startingTest/doTest/submitAll",
        	        contentType: 'application/json',
        	        data: JSON.stringify({
        	            "testId": testId,
        	        }),
        	        success: function (){
        	        	alert("提交成功！即将返回主页！");
    	        		window.location.href = "/user/home";
        	        },
        	        dataType: "json"
        	    });
            } else {
            	alert(response.message+"即将返回主页");
            	window.location.href = response.redirect;
            }
        },
        dataType: "json"
    });
}