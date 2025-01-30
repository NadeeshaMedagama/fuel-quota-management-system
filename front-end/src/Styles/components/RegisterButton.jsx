// src/components/RegisterButton.jsx
import React from "react";
import { useNavigate } from "react-router-dom";

const RegisterButton = () => {
  const navigate = useNavigate();  // Use navigate hook from react-router-dom

  const handleRegisterClick = () => {
    navigate("/signUp");  // Redirect to the signup page
  };

  return (
    <button className="register-button" onClick={handleRegisterClick}>
      Register Now
    </button>
  );
};

export default RegisterButton;