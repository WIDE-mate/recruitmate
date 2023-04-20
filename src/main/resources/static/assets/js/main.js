function getSession(loginKey) {
    fetch("/api/auth/get-session?loginKey=" + loginKey)
        .then(response => response.json())
        .then(data => {
            console.log(data)
            for(let item of data){
                window.localStorage.setItem(item[0], item[1]);
            }
        })
}
//신입채용
function getNewcomer(){
    const newcomer = document.getElementById("newcomer_figure")
    //신입 채용 공고 수 가져오는 API
    fetch()
        .then(response => response.json())
        .then(data => {
            const div = newcomer.querySelector(".recruit_cnt")
            div.innerHTML = data;
        })
    //클릭시 이벤트 추가
    newcomer.addEventListener("click", function () {
        //신입 채용 화면으로
        location.href = "/recruitPage?career=newcomer";
    })
}
//경력채용
function getCareer() {
    const career = document.getElementById("career_figure")
    //경력 채용 공고 수 가져오는 API
    fetch()
        .then(response => response.json())
        .then(data => {
            const div = career.querySelector(".recruit_cnt")
            div.innerHTML = data;
        })
    career.addEventListener("click", function () {
        //경력 채용 화면으로
        location.href = "/recruitPage?career=career";
    })
}

window.onload = (e) =>{
    getSession(window.localStorage.getItem("loginKey").toString());
    getNewcomer();
    getCareer();
}