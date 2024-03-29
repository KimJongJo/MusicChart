console.log("sss");

const checkObj = {
    "inputId" : false, // 아이디
    "inputPw" : false, // 비밀번호
    "inputPwConfirm" : false, // 비밀번호 확인
    "inputName" : false, // 닉네임
}

// 아이디 유효성 검사
const inputId = document.getElementById("inputId");

inputId.addEventListener("keyup", function () {
    
    const regExp = /^[A-Za-z0-9!@#^]{4,13}$/;

    if(regExp.test(this.value)){
        this.style.color = "green";
        checkObj.inputId = true;
    }else{
        this.style.color = "red";
        checkObj.inputId = false;
    }

});


// 비밀번호 유효성 검사
const inputPw = document.getElementById("inputPw");
const inputPwConfirm = document.getElementById("inputPw2");

inputPwConfirm.addEventListener("keyup", function(){
    
    if(inputPw.value.length == 0) {
        this.value = "";
        alert("비밀번호를 먼저 입력해주세요");
        inputPw.focus();
        checkObj.inputPw = false;
    }
});


const pwMessage = document.getElementById("pwMessage");

inputPw.addEventListener("keyup", function() {

    if((inputPw.value == inputPwConfirm.value) && inputPw.value.length != 0){
        pwMessage.innerText = "일치"
        checkObj.inputPw = true;
        checkObj.inputPwConfirm = true;
    } else {
        pwMessage.innerText = "불일치"
        checkObj.inputPwConfirm = false;
    }
});


inputPwConfirm.addEventListener("keyup", function() {

    if( (inputPw.value == inputPwConfirm.value) && inputPw.value.length != 0 ){

        pwMessage.style.opacity = 1;

        pwMessage.innerText = "일치";
        checkObj.inputPw = true;
        checkObj.inputPwConfirm = true;
    } else {
        pwMessage.style.opacity = 1;
        pwMessage.innerText = "불일치";
        checkObj.inputPwConfirm = false;
    }
});


// 닉네임 검사
// 3 ~ 11 글자

const inputName = document.getElementById("inputName");

inputName.addEventListener("change", function() {
    const regExp = /^[가-힣A-Za-z0-9]{2,11}$/;

    if(regExp.test(this.value)){
        this.style.color = "green";
        checkObj.inputName = true;
    } else {
        this.style.color = "red";
        checkObj.inputName = false;
    }
});


// 최종
function validate() {

    for(let key in checkObj){
        if( !checkObj[key] ){
            alert("유효성검사가 완료되지 않았습니다.")
            return false;
        }
    }

    return true;
 }