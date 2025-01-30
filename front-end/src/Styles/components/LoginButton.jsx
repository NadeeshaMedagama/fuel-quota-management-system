import React from "react";
import { useNavigate } from "react-router-dom";

function LoginButton() {
  const navigate = useNavigate();

  const handleClick = () => {
    navigate("/login");
  };

  return <button className="login-button" onClick={handleClick}>Log In</button>;
}

export default LoginButton;