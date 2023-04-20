class ContentsList extends HTMLElement{
    constructor() {
        super();

        this.classList.add("contents_list")

        const div = document.createElement("div");
        this.appendChild(div);

        const header = document.createElement("div");
        div.appendChild(header);
        const header_title = document.createElement("div");
        header_title.style.width = "100%";
        header_title.style.display = "flex";
        header.appendChild(header_title);
        const title = document.createElement("div")
        title.style.fontSize = "24px";
        title.style.display = "inline-block"
        title.innerText="채용 정보"
        header_title.appendChild(title)
        const title_cnt = document.createElement("div")
        title_cnt.style.display = "inline-flex"
        title_cnt.style.flexGrow = "1"
        title_cnt.style.alignItems = "center"
        title_cnt.style.marginTop = "5px"
        title_cnt.style.marginLeft = "15px"
        title_cnt.style.color = "#777777"
        title_cnt.innerText = "총 3건"
        header_title.appendChild(title_cnt);

    }

    setList(json){
        /**
         * data는
         * {
         *     title: 제목,
         *     contents: 내용,
         *     period: 기간,
         *     require: 조건,(대졸, 고졸, 경력n년 ...)
         *     task: 직무(sw, 회계, 인사...)
         * }
         * json은 얘네를 리스트로 만든 것
         */
        const list = this.querySelector("div")
        for(let data of json){
            const div = document.createElement("div");

        }
    }
}
customElements.define("contents-list", ContentsList);