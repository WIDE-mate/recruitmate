class NavBox extends HTMLElement{
    constructor() {
        super();

        const ul = document.createElement("ul")
        ul.classList.add("nav_box")
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
            li.addEventListener("click", function () {
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
        sign_up.addEventListener("click", function () {
            //회원가입 사이트로 이동
            location.href = "/sign"
        })
        this.appendChild(sign_up)

        const sign_in = document.createElement("div")
        sign_in.innerText = "로그인"
        sign_in.addEventListener("click", function () {
            //로그인 사이트로 이동
            location.href = "/login"
        })
        this.appendChild(sign_in)

        const div = document.createElement("div")
        const img = document.createElement("img")
        img.classList.add("profile_img")
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