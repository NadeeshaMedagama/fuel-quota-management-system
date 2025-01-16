import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const LoginForm = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  async function login(event) {
    event.preventDefault();
    try {
      await axios
        .post("http://localhost:8080/api/v1/VehicleOwner/login", {
          email: email,
          password: password,
        })
        .then(
          (res) => {
            console.log(res.data);

            if (res.data.message === "Email not exists") {
              alert("Email not exists");
            } else if (res.data.message === "Login Success") {
              navigate("/home");
            } else {
              alert("Incorrect Email and Password do not match");
            }
          },
          (fail) => {
            console.error(fail); // Error!
          }
        );
    } catch (err) {
      alert(err);
    }
  }

  return (
    <div className="login-container">
      <div className="form-container">
        {/* Title */}
        <h2 className="form-title">
          Welcome Back
        </h2>

        <form onSubmit={login} className="login-form">
          {/* Email Input */}
          <div className="input-group">
            <label htmlFor="email" className="input-label">
              Username
            </label>
            <input
              type="email"
              id="email"
              name="email"
              placeholder="Enter your email"
              className="input-field"
              value={email}
              onChange={(event) => {
                setEmail(event.target.value);
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
        </form>
      </div>
    </div>
  );
};

export default LoginForm;

