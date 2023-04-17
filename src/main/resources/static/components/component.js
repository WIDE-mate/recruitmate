
function insertComponent(components){
    let head = document.querySelector("head");
    for(let component of components){
        const script = document.createElement("script");
        script.setAttribute("type", "text/javascript");
        script.setAttribute("src", "../static/components/" + component);
        console.log(script)
        head.appendChild(script)
    }
};

(function(){
    let components = []
    components.push("modal.js")
    components.push("header.js")

    insertComponent(components);
})();
