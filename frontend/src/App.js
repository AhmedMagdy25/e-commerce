import { Route, Routes, Link, useNavigate } from "react-router-dom";
import Home from "./components/home";
import Login from "./components/login";
import Signup from "./components/signup";
import Orders from "./components/orders";
import './App.css';
import { useEffect } from "react";

function App() {
  const navigate = useNavigate();

  let logout = ()=>{
    fetch("http://localhost:8080/e-commerce/Logout",{
      credentials:"include",
    }).then(res=>res.json()).then(res=>{
      if(res.success) navigate('/login')
      else{
        for (const key in res) {
          alert(`${key}\n${res[key]}`)
        }
      }
    }).catch(err=>{
       console.log(err)
    })
  }
  
  useEffect(()=>{
    if(document.body.lastChild.tagName === 'SCRIPT')
        document.body.lastChild.src = "/js/script.js";
    else{
        const script = document.createElement('script');
        script.src = "/js/script.js";
        document.body.appendChild(script)
    } 
  })
  return (
    <div className="App">
      <nav>
        <h4>E-commerce</h4>
        <ul>
          <li><Link to={"/"}>Home</Link></li>
          <li><Link to={"/login"}>Login</Link></li>
          <li><Link to={"/signup"}>Sign Up</Link></li>
          <li><Link to={"/orders"}>Orders</Link></li>
          <li><button tybe="button" onClick={logout}>Logout</button></li>
        </ul>
      </nav>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/login' element={<Login/>}/>
        <Route path='/signup' element={<Signup/>}/>
        <Route path='/orders' element={<Orders/>}/>
      </Routes>
    </div>
  );
}

export default App;
