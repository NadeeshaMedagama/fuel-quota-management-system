import React, { useState } from "react";
import { useNavigate } from "react-router-dom"; // Import useNavigate
import "./SignUpForm.css";

const SignUpForm = () => {
    const navigate = useNavigate(); // Initialize the navigate function
  
    const handleUserdashboardClick = () => {
      navigate("/Userdashboard"); // Navigate to the Register route
    };
  const [formData, setFormData] = useState({
    fullName: "",
    email: "",
    address: "",
    contactNumber: "",
    username: "",
    password: "",
    userType: "",
    image: null,
  });

  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleFileChange = (e) => {
    const file = e.target.files[0];
    if (file && !file.type.startsWith("image/")) {
      setErrors((prevErrors) => ({
        ...prevErrors,
        image: "Please upload a valid image file.",
      }));
    } else {
      setFormData((prevData) => ({
        ...prevData,
        image: file,
      }));
      setErrors((prevErrors) => ({ ...prevErrors, image: null }));
    }
  };

  const validateForm = () => {
    const newErrors = {};
    if (!formData.fullName) newErrors.fullName = "Full Name is required.";
    if (!formData.email) {
      newErrors.email = "Email is required.";
    } else if (!/\S+@\S+\.\S+/.test(formData.email)) {
      newErrors.email = "Email format is invalid.";
    }
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
    if (!formData.image) {
      newErrors.image = "Please upload your profile image.";
    }
    return newErrors;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const validationErrors = validateForm();
    if (Object.keys(validationErrors).length > 0) {
      setErrors(validationErrors);
    } else {
      console.log("Form submitted successfully:", formData);
      setErrors({});
      alert("Registration successful!");

      // After successful registration, navigate to User Dashboard
      navigate("/Userdashboard"); // Navigate to the Userdashboard route

      // Reset form
      setFormData({
        fullName: "",
        email: "",
        address: "",
        contactNumber: "",
        username: "",
        password: "",
        userType: "",
        image: null,
      });
    }
  };

  return (
    <div className="container">
      <div className="top-left">
        <img src="/logo.png" alt="FuelPulse Logo" className="logo" />
      </div>

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
            Email Address
            <input
              type="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              placeholder="Enter your email"
              className={errors.email ? "error-input" : ""}
            />
            {errors.email && <span className="error">{errors.email}</span>}
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
            {errors.password && (
              <span className="error">{errors.password}</span>
            )}
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
              <option value="Admin">Admin</option>
              <option value="Customer">Customer</option>
            </select>
            {errors.userType && <span className="error">{errors.userType}</span>}
          </label>

          <label>
            Upload Your Image
            <input type="file" onChange={handleFileChange} />
            {errors.image && <span className="error">{errors.image}</span>}
          </label>

          <button type="submit"
          onClick={handleUserdashboardClick}>Register</button>
        </form>
      </div>
    </div>
  );
};

export default SignUpForm;




