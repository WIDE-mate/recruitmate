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
}

window.onload = (e) =>{
    getNewcomer();
    getCareer();
}