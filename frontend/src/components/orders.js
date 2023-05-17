import { useEffect } from "react"

export default function Orders(){
    useEffect(()=>{
        fetch("http://localhost:8080/e-commerce/Orders",{
            credentials: "include",
        }).then(orders=>orders.json()).then(orders=>{
            if(orders.forbidden){
                document.querySelector(".container").innerHTML=`<h1 class="forbidden">Login frist</h1>`
            }else{
                document.querySelector(".container").innerHTML="";
                if(orders.length === 0) document.querySelector(".container").innerHTML="you didn't make any order";
                else orders.forEach(order => {
                    document.querySelector(".container").innerHTML+=`
                        <div class="order">
                            <img src="/images/${order.productImg}"></img>
                            <h4>${order.productName}</h4>
                            <p>${order.timestamp}</p>
                            <p>${order.productPrice}$</p>
                            <button onclick="deleteOrder(this)" value="${order.productID}"
                            data-timestamp="${order.timestamp}">Delete</button>
                        </div>
                        <hr>
                    `
                });
            }
        })
    })
    return (
        <div className="container"><p className="loading">Loading...</p></div>
    )
}
