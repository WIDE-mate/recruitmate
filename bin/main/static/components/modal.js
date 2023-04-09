class MyModal extends HTMLElement{
    constructor(){
        super();

        const modal_back = document.createElement('div');
        modal_back.classList.add("modal_back", "hidden");
        this.appendChild(modal_back);

        const modal_body = document.createElement('div');
        modal_body.classList.add("modal_body");
        modal_back.appendChild(modal_body);
    }
    static get observedAttributes(){ 
        return ["loding"]
    }
    attributeChangedCallback(name, oldValue, newValue){
        if(name === "loading"){
            const modal_body = this.querySelector('.modal_body');
            if(newValue){
                //로딩모양 구현해야함 귀찮음 나중에 하기
            }else{
                while(modal_body.hasChildNodes()){
                    modal_body.removeChild(modal_body.childNodes[0])
                }
            }
        }
    }

    show(){
        this.classList.remove('hidden')
    }
    hide(){
        this.classList.add('hidden')
    }
    loading(){
        this.setAttribute("loading", true)
    }
    message(text){
        this.setAttribute("loading", false)
        this.show()
        const modal_body = this.querySelector('.modal_body');
        modal_body.innerText = text.toString();
    }
}
customElements.define("my-modal", MyModal);
(()=>{
    document.body.appendChild(document.createElement('my-modal'));
})();