function loginCheck(){
    let userLoginId = document.querySelector("#userId");
    let userLoginPw = document.querySelector("#userPw");
    
    let regLoginId = /^[A-Za-z]{1}[A-Za-z0-9]{6,12}$/;
    let regLoginPw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;

    //id 공백검사
    if(userLoginId.value == ""){
        alert("아이디를 입력해주세요");
        userId.focus();
        return false;
    }
    //id 유효성검사
    if(regLoginId.test(userLoginId.value) == false){
        alert("아이디는 영문대소문자, 숫자를 포함하는 6~12자리로 입력해주세요.");
        userLoginId.value="";
        userLoginId.focus();
        return false;
    }

    //pw 공백검사
    if(userLoginPw.value == ""){
        alert("비밀번호를 입력해주세요");
        userLoginPw.focus();
        return false;
    }
    //pw 유효성검사
    if(regLoginPw.test(userLoginPw.value) == false){
        alert("비밀번호는 영문대소문자, 숫자, 특수문자를 포함하여 8~16자리로 입력해주세요.");
        userLoginPw.value="";
        userLoginPw.focus();
        return false;
    }
}