function logout(loginKey) {
    fetch("?loginKey=" + loginKey)
        .then(response =>  {
            if (response.status.toString() == "200"){
                let saved_login_id = window.localStorage.getItem("saved_login_id")
                window.localStorage.clear();
                window.localStorage.setItem("saved_login_id", saved_login_id)
            }else{
                //로그아웃 실패로직
            }
        })
}

class NavBox extends HTMLElement{
    constructor() {
        super();

        const ul = document.createElement("ul")
        this.appendChild(ul)
    }

    clear(){
        const ul = this.querySelector("ul")
        while(ul.hasChildNodes()){
            ul.removeChild(ul.childNodes[0])
        }
    }
    set(data){
        //data 구조는 name: location
        this.clear()
        const ul = this.querySelector("ul")
        for(let name in data){
            let location = data[name];
            const li = document.createElement("li")
            li.classList.add("nav_item")
            li.innerText = name;
            li.addEventListener("click", function (e) {
                e.preventDefault()
                location.replace(location);
            })
            ul.appendChild(li)
        }
    }
}
customElements.define("nav-box", NavBox);

class MyProfile extends HTMLElement{
    constructor() {
        super();

        const sign_up = document.createElement("div")
        sign_up.innerText = "회원가입"
        sign_up.addEventListener("click", function (e) {
            //회원가입 사이트로 이동
            e.preventDefault()
            location.href = "/sign"
        })
        this.appendChild(sign_up)

        const sign_in = document.createElement("div")
        if(window.localStorage.getItem("loginKey").length != null){
            sign_in.innerText = "로그아웃"
            sign_in.addEventListener("click", function (e) {
                //로그아웃
                e.preventDefault()
                logout(window.localStorage.getItem("loginKey"));
                location.reload();
            })
        }else{
            sign_in.innerText = "로그인"
            sign_in.addEventListener("click", function (e) {
                //로그인 사이트로 이동
                e.preventDefault()
                location.href = "/login"
            })
        }

        this.appendChild(sign_in)

        const div = document.createElement("div")
        div.classList.add("profile_div")
        const img = document.createElement("img")
        img.classList.add("profile_img")
        div.addEventListener("click", function (e) {
            e.preventDefault()
            location.href = "/myPage"
        })
        div.appendChild(img)
        this.appendChild(div)
    }

    setImg(src){
        const img = this.querySelector(".profile_img")
        img.setAttribute("src", src)
        img.setAttribute("rel", "profile_img")
    }
}
customElements.define("my-profile", MyProfile);

class TopHeader extends HTMLElement {
    constructor() {
        super();

        const logo = document.createElement("img")
        logo.classList.add("main_logo_min")
        logo.setAttribute("src", "../static/img/main_logo.png")
        logo.addEventListener("click", function (e) {
            e.preventDefault()
            location.href = "/"
        })
        this.appendChild(logo)

        let nav_box = '<nav-box class="nav_box"></nav-box>'
        this.insertAdjacentHTML("beforeend", nav_box)

        let profile = '<my-profile class="nav_profile"></my-profile>'
        this.insertAdjacentHTML("beforeend", profile)

    }

    connectedCallback(){
        //네비박스 세팅
        fetch()
            .then(response => response.json())
            .then(data => {
                this.setNavBox(data)
            })
            .catch(error => {
                //에러면 모달에 에러뜸
                document.querySelector("my-modal").message("\n\n화면 설정 중 에러가 발생했습니다.\n" + error.toString())
            })

        //프로필 사진 세팅
        const img_src = window.localStorage.getItem("profile_img")
        if (img_src == null || img_src == undefined){
            this.querySelector("my-profile").setImg("../static/img/default_profile.jpg")
        }else{
            this.querySelector("my-profile").setImg(img_src)
        }
    }

    setNavBox(data){
        const navBox = this.querySelector("nav-box")
        navBox.set(data)
    }
}
customElements.define("top-header", TopHeader);