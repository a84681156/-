//공백 유효성검사
function joinCheck(){
    let userJoinId = document.querySelector("#userId");
    let userJoinPw = document.querySelector("#userPw");
    let userJoinPw2 = document.querySelector("#userPw2");
    let userJoinName = document.querySelector("#userName");
    let userJoinTel = document.querySelector("#userTel");
    let userJoinMail = document.querySelector("#userEmail");
    let userJoinNick = document.querySelector("#userNickName");
    let userStyle = document.querySelector(".join_chkBoxControl_user");

    let regJoinId = /^[A-Za-z]{1}[A-Za-z0-9]{6,12}$/;
    let regJoinPw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;
    let regJoinPw2 = /^(?=.*[a-zA-Z])(?=.*[!@#$%^&*+=-])(?=.*[0-9]).{8,16}$/;
    let regJoinTel = /^01[016789]{1}-([0-9]{4})-([0-9]{4})$/;
    let regJoinMail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{1,3}$/;
    let regJoinNick = /^[\wㄱ-ㅎㅏ-ㅣ가-힣A-Za-z0-9]{2,20}$/;


    //id 공백검사
    if(userJoinId.value == ""){
        alert("아이디를 입력해주세요");
        userJoinId.focus();
        return false;
    }
    //id 유효성검사
    if(regJoinId.test(userJoinId.value) == false){
        alert("아이디는 영문대소문자, 숫자를 포함하는 6~12자리로 입력해주세요.");
        userJoinId.value="";
        userJoinId.focus();
        return false;
    }

    //nickName 공백검사
    if(userJoinNick.value == ""){
        alert("닉네임을 입력해주세요");
        userJoinNick.focus();
        return false;
    }
    //nickName 유효성검사
    if(regJoinNick.test(userJoinNick.value) == false){
        alert("닉네임은 숫자, 영어, 한국어, _ 를 허용하며 최소 2글자 이상으로 작성해주세요.");
        userJoinNick.value="";
        userJoinNick.focus();
        return false;
    }

    //pw 공백검사
    if(userJoinPw.value == ""){
        alert("비밀번호를 입력해주세요");
        userJoinPw.focus();
        return false;
    }
    //pw 유효성검사
    if(regJoinPw.test(userJoinPw.value) == false){
        alert("비밀번호는 영문대소문자, 숫자, 특수문자를 포함하여 8~16자리로 입력해주세요.");
        userJoinPw.value="";
        userJoinPw.focus();
        return false;
    }
    
    //pw일치확인 공백검사
    if(userJoinPw2.value == ""){
        alert("비밀번호확인을 입력해주세요");
        userPw.focus();
        return false;
    }

    //pw일치확인 유효성검사1
    if(regJoinPw2.test(userJoinPw2.value) == false){
        alert("비밀번호는 영문대소문자, 숫자, 특수문자를 포함하여 8~16자리로 입력해주세요.");
        userJoinPw2.value="";
        userJoinPw2.focus();
        return false;
    }
    //pw일치확인 유효성검사2   
    if(userJoinPw2.value != userJoinPw.value){
        alert("비밀번호가 일치하지 않습니다.");
        userJoinPw2.value="";
        userJoinPw2.focus();
        return false;
    }

    //name 공백검사
    if(userJoinName.value == ""){
        alert("이름을 입력해주세요");
        userTel.focus();
        return false;
    }

    //tel 공백검사
    if(userJoinTel.value == ""){
        alert("전화번호를 입력해주세요");
        userTel.focus();
        return false;
    }
    //tel 유효성검사
    if(regJoinTel.test(userJoinTel.value) == false){
        alert("전화번호는 01x-xxxx-xxxx형식에 맞게 작성해주세요.");
        userJoinTel.value="";
        userJoinTel.focus();
        return false;
    }

    //email 공백검사
    if(userJoinMail.value == ""){
        alert("이메일를 입력해주세요");
        userJoinMail.focus();
        return false;
    }
    //email 유효성검사
    if(regJoinMail.test(userJoinMail.value) == false){
        alert("이메일 형식을 지켜서 작성해주세요. ex)xxxx@xxxx.com");
        userJoinMail.value="";
        userJoinMail.focus();
        return false;
    }

    //기업회원 일반회원
    if(userStyle.value == false){
        alert("이메일를 입력해주세요");
        return false;
    }

    if($(".join_chkBoxControl_user").is(":checked") == false){
        alert("회원유형을 선택해주세요.");
        return false;
    }else{
        return true;
    }
}

	//기업회원 개인회원 동시선택 불가
	function checkOnlyOne(mem) {
	
	    const checkboxes 
	        = document.getElementsByName("membertype");
	    
	    checkboxes.forEach((cb) => {
	        cb.checked = false;
	    })
	    
	    mem.checked = true;
	    }
	
	//이메일 sms수신 동시선택 불가
	function checkOnlyOne1(recep) {
	
	    const checkboxes 
	        = document.getElementsByName("reception");
	
	    checkboxes.forEach((cb) => {
	        cb.checked = false;
	    })
	
	    recep.checked = true;
	}