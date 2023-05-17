import { useEffect } from "react";
import {Link,useNavigate} from "react-router-dom";

export default function Signup(){
    const navigate = useNavigate();

    useEffect(()=>{
        document.querySelector(".signup").onsubmit= e =>{
            e.preventDefault();
            let data = new URLSearchParams(new FormData(e.target));
            
            fetch("http://localhost:8080/e-commerce/Signup",{
                method:"post",
                body:data
            }).then(res=>res.json()).then(res=>{
                if(res.success) navigate("/login");
                else {
                    for (const key in res) {
                        alert(`${key}\n${res[key]}`)
                    }
                }
            })
        }
    })
    return (
        <div className="container">
            <h1>Sign Up Page</h1>
            <form className="signup" action="" method="post">
                <input type="text" name="name" placeholder="Enter your name"/>
                <input type="text" name="email" placeholder="Enter your email"/>
                <input type="password" name="password" placeholder="Enter your password"/>
                <input type="submit" value="signup"/>
            </form>
            <Link to="/login">already have account?</Link>
        </div>
    )
}
