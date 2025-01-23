import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "./SignUpForm.css";

const SignUpForm = () => {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    fullName: "",
    address: "",
    contactNumber: "",
    username: "",
    password: "",
    userType: "",
  });

  const [errors, setErrors] = useState({});
  const [submissionError, setSubmissionError] = useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const validateForm = () => {
    const newErrors = {};
    if (!formData.fullName) newErrors.fullName = "Full Name is required.";
    if (!formData.contactNumber) {
      newErrors.contactNumber = "Contact Number is required.";
    } else if (!/^\d{10}$/.test(formData.contactNumber)) {
      newErrors.contactNumber = "Contact Number must be 10 digits.";
    }
    if (!formData.password) {
      newErrors.password = "Password is required.";
    } else if (formData.password.length < 6) {
      newErrors.password = "Password must be at least 6 characters.";
    }
    if (!formData.userType) {
      newErrors.userType = "User Type is required.";
    }
    return newErrors;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const validationErrors = validateForm();
    if (Object.keys(validationErrors).length > 0) {
      setErrors(validationErrors);
    } else {
      setErrors({});
      try {
        // Send POST request to Spring Boot backend
        const response = await axios.post("http://localhost:8080/api/v1/users/register", formData);
        console.log(response.data);

        if (response.status === 200) {
          alert("Registration successful!");
          // Navigate to Vehicle Registration Form
          navigate("/VehicleRegistrationForm");
        }
      } catch (error) {
        console.error("Error submitting form:", error);
        setSubmissionError("Registration failed. Please try again.");
      }
    }
  };

  return (
    <div className="container">
      <div className="sign-up-form">
        <h2>Sign Up</h2>
        <form onSubmit={handleSubmit}>
          <label>
            Full Name
            <input
              type="text"
              name="fullName"
              value={formData.fullName}
              onChange={handleChange}
              placeholder="Enter your full name"
              className={errors.fullName ? "error-input" : ""}
            />
            {errors.fullName && <span className="error">{errors.fullName}</span>}
          </label>

          <label>
            Address
            <input
              type="text"
              name="address"
              value={formData.address}
              onChange={handleChange}
              placeholder="Enter your address"
            />
          </label>

          <label>
            Contact Number
            <input
              type="text"
              name="contactNumber"
              value={formData.contactNumber}
              onChange={handleChange}
              placeholder="Enter your contact number"
              className={errors.contactNumber ? "error-input" : ""}
            />
            {errors.contactNumber && (
              <span className="error">{errors.contactNumber}</span>
            )}
          </label>

          <label>
            Username
            <input
              type="text"
              name="username"
              value={formData.username}
              onChange={handleChange}
              placeholder="Choose a username"
            />
          </label>

          <label>
            Password
            <input
              type="password"
              name="password"
              value={formData.password}
              onChange={handleChange}
              placeholder="Create a password"
              className={errors.password ? "error-input" : ""}
            />
            {errors.password && <span className="error">{errors.password}</span>}
          </label>

          <label>
            User Type
            <select
              name="userType"
              value={formData.userType}
              onChange={handleChange}
              className={errors.userType ? "error-input" : ""}
            >
              <option value="">Select user type</option>
              <option value="Customer">Customer</option>
            </select>
            {errors.userType && <span className="error">{errors.userType}</span>}
          </label>

          <button type="submit">Register</button>
          {submissionError && <p className="error">{submissionError}</p>}
        </form>
      </div>
    </div>
  );
};

export default SignUpForm;
