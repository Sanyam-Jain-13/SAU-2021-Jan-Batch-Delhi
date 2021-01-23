import React from 'react';
import LogoImg from "../../Assets/Images/logo.svg";
//import logo from "../../Assets/Images/logo512.png";
const Logo = function()
{
 return (
    //<img src= "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/React-icon.svg/1200px-React-icon.svg.png" className="App-logo"  alt="logo"/>
    <img src={LogoImg} className="App-logo"  alt="logo"/>
   
   );
};

export default Logo;