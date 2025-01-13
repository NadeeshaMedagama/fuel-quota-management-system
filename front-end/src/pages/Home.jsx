import React from 'react';
import "./Home.css";
import Header from "../user/common/Header.jsx"
import Footer from "../user/common/Footer.jsx";

const App = () => {
    return (
      <div className="container">
        <div className="header">
          <a href="#" className="login-link">Log In</a>
        </div>
        <div className="content">
          <h1 className="title">what sie you oul fuel?</h1>
          <p className="subtitle">
            Managing Fuel, Simplifying Lives: Your Digital Fuel Management Solution
          </p>
          <button className="register-button">REGISTER NOW</button>
        </div>
      </div>
    );
  };
  
  export default App;
