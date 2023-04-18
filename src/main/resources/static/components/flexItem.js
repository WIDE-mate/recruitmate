class FlexItem extends HTMLElement{
    constructor() {
        super();

        this.classList.add("flex_item");
    }
    set(element){
        while(this.hasChildNodes()){
            this.removeChild(this.childNodes[0])
        }
        this.appendChild(element)
    }
}
customElements.define("flex-item", FlexItem);