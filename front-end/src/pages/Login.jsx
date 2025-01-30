import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import '../Styles/Login.css'; // Adjust if it's a CSS file

const LoginForm = () => {
  const [vehicleRegistrationNumber, setVehicleRegistrationNumber] = useState("");
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
        "http://localhost:8080/api/v1/VehicleOwner/login",
        {
          vehicleRegistrationNumber,
          password,
        }
      );

      if (response.data.message === "Login Success") {
        // Redirect to the Vehicle Registration Form upon successful login
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
            <label htmlFor="vehicleRegistrationNumber" className="input-label">
              Vehicle Registration Number
            </label>
            <input
              type="text"
              id="vehicleRegistrationNumber"
              placeholder="Enter your vehicle registration number"
              className="input-field"
              value={vehicleRegistrationNumber}
              onChange={(e) => setVehicleRegistrationNumber(e.target.value)}
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
              onChange={(e) => setPassword(e.target.value)}
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
