import { useEffect } from "react"

export default function Home(){
    useEffect(()=>{
        
        fetch("http://localhost:8080/e-commerce/Products").then(products=>products.json()).then(products=>{
            document.querySelector(".cards-container").innerHTML ="";
            products.forEach(product => {
                document.querySelector(".cards-container").innerHTML +=`
                    <div class="card" >
                        <img src="/images/${product.image}"></img>
                        <div class="info">
                            <h3>${product.name}</h3>
                            <p>${product.details}</p>
                            <p>${product.price}$</p>
                        </div>
                        <button type="button" onclick="makeOrder(this)" value="${product.id}"> Order </button>
                    </form>
                `
            });
        })

    })
    return (
        <div className="cards-container"><p className="loading">Loading...</p></div>
    )
}
