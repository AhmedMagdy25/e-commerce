import { useEffect } from "react"
import { Link, useNavigate } from "react-router-dom";

export default function Login(){
    const navigate = useNavigate();
    
    useEffect(()=>{
        document.querySelector(".login").onsubmit= e =>{
            e.preventDefault();
            let data = new URLSearchParams(new FormData(e.target));
            fetch("http://localhost:8080/e-commerce/Login",{
                method:"post",
                credentials: "include",
                body: data
            }).then(res=>res.json()).then(res=>{
                if(res.success){
                    navigate("/");
                }else{
                    for (const key in res) {
                        alert(`${key}\n${res[key]}`)
                    }
                }
            })
        }
    })
    return(
        <div className="container">
            <h1>Login Page</h1>
            <form className="login">
                <input type="text" name="email" placeholder="Enter your email"/>
                <input type="password" name="password" placeholder="Enter your password"/>
                <input type="submit" value="login"/>
            </form>
            <Link to="/signup">don't have account?</Link>
        </div>
    )
}