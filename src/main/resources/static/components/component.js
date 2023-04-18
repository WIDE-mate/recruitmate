
function insertComponent(components){
    let head = document.querySelector("head");
    for(let component of components){
        const script = document.createElement("script");
        script.setAttribute("type", "text/javascript");
        script.setAttribute("src", "../static/components/" + component);
        head.appendChild(script)
    }
}

(function(){
    let components = []
    components.push("modal.js")
    components.push("header.js")
    components.push("flexitem.js")

    insertComponent(components);
})();

