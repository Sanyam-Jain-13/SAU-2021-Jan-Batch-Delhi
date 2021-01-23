import React from 'react';
import Logo from './Components/HeaderComponents/Logo';
import './Assets/Styles/App.css';
import Header from "./Components/HeaderComponents/Header";
import Body from "./Components/Body.js";


function App() {
  return (
    <div className="App">
      <Header/>
      <Logo/>
      <header className="App-header">
        <Body/>
      </header>
    </div>
  );
}

export default App;
