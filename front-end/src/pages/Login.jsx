import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "../Styles/Login.css";
import Footer from "../user/common/Footer";

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
        navigate("/home"); // Navigate to the home page
      } else {
        setError(response.data.message || "An error occurred.");
      }
    } catch (error) {
      if (error.response) {
        // Handle backend errors
        const { status, data } = error.response;
        if (status === 400 || status === 401) {
          setError(data.message); // Show backend-provided error message
        } else {
          setError("An unexpected error occurred. Please try again.");
        }
      } else {
        // Handle network errors or other issues
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
              onChange={(e) => setVehicleRegistrationNumber(e.target.value)}
              required
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
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>

          {/* Error Message */}
          {error && <div className="error-message">{error}</div>}

          {/* Login Button */}
          <button type="submit" className="submit-button" disabled={loading}>
            {loading ? "Logging in..." : "Login"}
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
      <Footer />
    </div>
  );
};

export default LoginForm;
