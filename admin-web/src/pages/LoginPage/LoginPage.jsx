import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';  
import './LoginPage.css';
import logo1 from '../../assets/logo1.png'; 

const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();


    const loginData = {
      email: email,
      password: password,
    };

    try {

      const response = await axios.post('http://localhost:8080/api/v1/auth/administratorAuth', loginData);

      if (response.data.success) {
        console.log('Login successful');
        navigate('/Dashboard'); // Navigate to the dashboard 
      } else {
        setErrorMessage('Invalid email or password');
      }
    } catch (error) {
      console.error('Error logging in:', error);
      setErrorMessage('An error occurred. Please try again later.');
    }
  };

  return (
    <div className="login-container">
      {/* Logo */}
      <img src={logo1} alt="Logo" className="logo" style={{ width: '190px', height: '60px', marginLeft: '50px', marginTop: '-10px', marginBottom: '15px' }} />

      <form onSubmit={handleSubmit} className="login-form">
        <h2>Login</h2>

        {errorMessage && <div className="error-message">{errorMessage}</div>} {/* Display error message */}

        <div className="input-group">
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>

        <div className="input-group">
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>

        <button type="submit" className="login-btn">Login</button>
      </form>
    </div>
  );
};

export default LoginPage;
