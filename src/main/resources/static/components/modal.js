class MyModal extends HTMLElement{
    constructor(){
        super();

        this.classList.add("hidden");

        const modal_back = document.createElement('div');
        modal_back.classList.add("modal_back");
        this.appendChild(modal_back);

        const modal_body = document.createElement('div');
        modal_body.classList.add("modal_body");
        modal_back.appendChild(modal_body);

        modal_back.addEventListener("click", (e)=>{
            e.preventDefault();
            let attr = e.target.parentElement.getAttribute("loading")
            if(attr == null || attr.toString() != "true"){
                this.classList.add('hidden')
            }
        })
    }
    static get observedAttributes(){ 
        return ["loading"]
    }
    attributeChangedCallback(name, oldValue, newValue){
        if(name === "loading"){
            const modal_body = this.querySelector('.modal_body');
            if(newValue){
                const loading_text = document.createElement("div")
                loading_text.classList.add("loading_text")
                loading_text.innerText = "loading..."
                modal_body.appendChild(loading_text)

                const loading = document.createElement("div")
                loading.classList.add("loading")
                modal_body.appendChild(loading)
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
        this.show()
    }
    message(text){
        this.setAttribute("loading", false)
        this.show()
        const modal_body = this.querySelector('.modal_body');
        modal_body.innerText = text.toString();
    }
}
customElements.define("my-modal", MyModal);