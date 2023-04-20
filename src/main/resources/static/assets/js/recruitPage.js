(function () {
    const url = new URL(location.href);
    const urlParams = url.searchParams;

    fetch("", {
        method: "POST",
        headers: {
            "Content-Type": "application.json"
        },
        body: JSON.stringify({
            "career": urlParams.get("career")
        })
    })
        .then(response => response.json())
        .then(data => {
            const contentsList = document.querySelector("contents-list");
            contentsList.setList(data)
        })
})();