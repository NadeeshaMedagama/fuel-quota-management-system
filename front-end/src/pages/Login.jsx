import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import '../Styles/Login.css'; // Adjust if it's a CSS file

const LoginForm = () => {
  const [contactNumber, setContactNumber] = useState(""); // Change to contactNumber
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const navigate = useNavigate();

  const login = async (event) => {
    event.preventDefault();
    setError("");
    setLoading(true);

    try {
      const response = await axios.post(
        "http://localhost:8080/api/v1/auth/userAuth", // Backend endpoint
        {
          contactNumber,  // Sending contactNumber and password as per backend
          password,
        }
      );
      console.log("Contact Number:", contactNumber);
      console.log("Password:", password);
      
      if (response.status === 200) {
          setError("login successfully");
        navigate("/VehicleRegistrationForm");
      } else {
        setError(response.data.message || "An error occurred.");
      }
    } catch (error) {
      if (error.response) {
        const { status, data } = error.response;
        if (status === 400 || status === 401) {
          setError(data.message);
        } else {
          setError("An unexpected error occurred. Please try again.");
        }
      } else {
        setError("Unable to connect to the server. Please check your connection.");
      }
    } finally {
      setLoading(false);
    }
  };

  const handleForgotPassword = () => {
    alert("Forgot Password feature will send a reset link to your registered email.");
  };

  return (
    <div className="login-container">
      <div className="form-container">
        <h2 className="form-title">Welcome Back</h2>
        <form onSubmit={login} className="login-form">
          <div className="input-group">
            <label htmlFor="contactNumber" className="input-label">
              Contact Number
            </label>
            <input
              type="text"
              id="contactNumber"
              placeholder="Enter your contact number"
              className="input-field"
              value={contactNumber}
              onChange={(e) => setContactNumber(e.target.value)}  // Bind contactNumber
              required
            />
          </div>
          <div className="input-group">
            <label htmlFor="password" className="input-label">
              Password
            </label>
            <input
              type="password"
              id="password"
              placeholder="Enter your password"
              className="input-field"
              value={password}
              onChange={(e) => setPassword(e.target.value)} // Bind password
              required
            />
          </div>
          {error && <div className="error-message">{error}</div>}
          <button type="submit" className="submit-button" disabled={loading}>
            {loading ? "Logging in..." : "Login"}
          </button>
          <div className="register-link">
            Don’t have an account?{" "}
            <a href="/SignUp" className="register-link-text">
              Register
            </a>
          </div>
          <div className="forgot-password-link">
            <a href="#" onClick={handleForgotPassword} className="forgot-password-link-text">
              Forgot Password?
            </a>
          </div>
        </form>
      </div>
    </div>
  );
};

export default LoginForm;
