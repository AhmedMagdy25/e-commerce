let makeOrder = ele=>{
    let data = new URLSearchParams();
    data.append("productID", ele.value);
    data.append("type", "add");

    fetch("http://localhost:8080/e-commerce/Orders",{
        method:"post",
        credentials: "include",
        body: data
    }).then(res=>res.json()).then(res=>{
        for (const key in res) {
            if(key === "forbidden") location.href = "/login"
            else
                alert(`${key} \n ${res[key]}`)
        }
    })
}
let deleteOrder = ele=>{
    let data = new URLSearchParams();
    data.append("productID", ele.value);
    data.append("timestamp", ele.dataset.timestamp);
    data.append("type", "delete");

    fetch("http://localhost:8080/e-commerce/Orders",{
        method:"post",
        credentials: "include",
        body: data
    }).then(res=>res.json()).then(res=>{
        if(res.success) location.reload();
        else{
            for (const key in res) {
                alert(`${key} \n ${res[key]}`)
            }
        }
    })
}