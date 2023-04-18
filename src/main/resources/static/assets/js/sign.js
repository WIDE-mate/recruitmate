function idValidation() {
    const id = document.getElementById("id")
    if (document.getElementById("id").getAttribute("dbcheck").toString() != "false") return;
    fetch()
        .then(response => response.text())
        .then(data => {
            if(data == "1"){
                id.dbcheck = true
                id.setAttribute("disabled",true)
            }else{
                id.dbcheck = false
            }
        })
}

function passwordCheck(){
    const password = document.getElementById("password")
    const password_check = document.getElementById("password_check")
    const pass_check = document.getElementById("pass_check")

    const check = (password.value == password_check.value)
    if (check){
        password.style.color="black";
        password_check.style.color="black";
        pass_check.innerHTML = "";
    }else{
        password.style.color="red";
        password_check.style.color="red";
        pass_check.innerHTML = "비밀번호와 비밀번호 확인이 상이합니다.";
        document.getElementById("sign_up").disabled = true
    }
    return check
}
function passwordValidation(){
    const password = document.getElementById("password")
    const pass_check = document.getElementById("pass_check")
    let regExp = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;
    let check = regExp.test(password.value)
    if(!check){
        document.getElementById("sign_up").disabled = true
        pass_check.innerText = "소문자, 숫자, 특수문자를 포함하여 8-20자리로 입력해주세요."
    }else{
        pass_check.innerText = ""
    }
    return check
}

document.getElementById("password").addEventListener("input", function (e) {
    e.preventDefault()
    if (document.getElementById("id").getAttribute("dbcheck").toString() != "false" && passwordCheck() && passwordValidation()){
        document.getElementById("sign_up").disabled = false
    }
})
document.getElementById("password_check").addEventListener("input", function (e) {
    e.preventDefault()
    if (document.getElementById("id").getAttribute("dbcheck").toString() != "false" && passwordCheck() && passwordValidation()){
        document.getElementById("sign_up").disabled = false
    }
})
document.getElementById("sign_form").addEventListener("submit", function (e) {
    e.preventDefault()
    const formData = new FormData(document.getElementById("sign_form"));
    const modal = document.querySelector("my-modal");
    modal.loading();

    const datas = {};
    formData.forEach((value, key) => {
        if(key != "addr_datail" && value.length == 0){
            const text = document.getElementById(key).getAttribute("placeholder")
            modal.message("\n\n" + text + "는 필수 입력입니다.")
            return
        }
        if(key == "tel"){
            //휴대폰번호 체크
            let regPhone = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/
            if(!regPhone.test(value)){
                modal.message("\n\n휴대전화 번호를 확인해 주세요.")
                return
            }else{
                value = value.split("-")
                if(value.length == 3){
                    value = value.join("-")
                }else if(value[0].length == 11){
                    let num = []
                    num.push(phone.substring(0,3))
                    num.push(phone.substring(3,7))
                    num.push(phone.substring(7))
                    value = num.join("-")
                }else if (value[0].length == 10){
                    let num = []
                    num.push(phone.substring(0,3))
                    num.push(phone.substring(3,6))
                    num.push(phone.substring(6))
                    value = num.join("-")
                }else{
                    modal.message("\n\n휴대전화 번호를 확인해 주세요.")
                    return
                }
            }
        }
        if(key == "email"){
            let regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/
            if(!regEmail.test(value)){
                modal.message("\n\n유효하지 않은 이메일 패턴입니다.")
                return
            }
        }
        datas[key] = value;

        fetch("", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(datas)
        })
            .then(response => {
                if(response.status == "200"){
                    return response.json();
                }else{
                    modal.message("\n\n네트워크 오류 입니다.\n잠시 후 다시 시도해주세요. ")
                    return "error"
                }
            })
            .then(data => {
                if(data != "error"){
                    //회원가입 성공인듯? 로그인 페이지로 이동
                    location.href = "/login"
                }
            })
    });
})
