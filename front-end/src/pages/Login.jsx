import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "./Login.css";

const LoginForm = () => {
  const [password, setPassword] = useState("");
  const [vehicleRegistrationNumber, setVehicleRegistrationNumber] = useState("");
  const [error, setError] = useState("");

  const navigate = useNavigate();

  async function login(event) {
    event.preventDefault();
    try {
      const res = await axios.post("http://localhost:8080/api/v1/VehicleOwner/login", {
        vehicleRegistrationNumber: vehicleRegistrationNumber,
        password: password,
      });

      if (res.data.message === "Vehicle Registration Number not exists") {
        setError("Vehicle Registration Number not exists");
      } else if (res.data.message === "Login Success") {
        navigate("/home");
      } else {
        setError("Incorrect Password");
      }
    } catch (err) {
      console.error(err);
      setError("An error occurred. Please try again.");
    }
  }

  const handleForgotPassword = () => {
    alert("Forgot Password feature will send a reset link to your registered email.");
  };

  return (
    <div className="login-container">
      <div className="form-container">
        {/* Title */}
        <h2 className="form-title">Welcome Back</h2>

        <form onSubmit={login} className="login-form">
          {/* Vehicle Registration Number Input */}
          <div className="input-group">
            <label htmlFor="vehicleRegistrationNumber" className="input-label">
              Vehicle Registration Number
            </label>
            <input
              type="text"
              id="vehicleRegistrationNumber"
              name="vehicleRegistrationNumber"
              placeholder="Enter your vehicle registration number"
              className="input-field"
              value={vehicleRegistrationNumber}
              onChange={(event) => {
                setVehicleRegistrationNumber(event.target.value);
              }}
            />
          </div>

          {/* Password Input */}
          <div className="input-group">
            <label htmlFor="password" className="input-label">
              Password
            </label>
            <input
              type="password"
              id="password"
              name="password"
              placeholder="Enter your password"
              className="input-field"
              value={password}
              onChange={(event) => {
                setPassword(event.target.value);
              }}
            />
          </div>

          {/* Error Message */}
          {error && <div className="error-message">{error}</div>}

          {/* Login Button */}
          <button type="submit" className="submit-button">
            Login
          </button>

          {/* Register Link */}
          <div className="register-link">
            Don’t have an account?{" "}
            <a href="/register" className="register-link-text">
              Register
            </a>
          </div>

          {/* Forgot Password Link */}
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
