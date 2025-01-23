import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios"; // import axios
import "./SignUpForm.css";

const SignUpForm = () => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    contactNumber: "",
    registrationNumber: "",
    chassisNumber: "",
    manufactureYear: "",
    vehicle: "",
    password: "",
    vehicleType: "",
  });

  const [errors, setErrors] = useState({});

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const validateForm = () => {
    let formErrors = {};
    if (!formData.contactNumber.match(/^\d{10}$/)) {
      formErrors.contactNumber = "Contact number must be 10 digits.";
    }
    if (formData.registrationNumber.trim() === "") {
      formErrors.registrationNumber = "Registration number is required.";
    }
    if (formData.chassisNumber.trim() === "") {
      formErrors.chassisNumber = "Chassis number is required.";
    }
    if (!formData.manufactureYear.match(/^(19|20)\d{2}$/)) {
      formErrors.manufactureYear = "Manufacture year must be a valid year.";
    }
    if (formData.vehicle.trim() === "") {
      formErrors.vehicle = "Vehicle name is required.";
    }
    if (formData.password.length < 6) {
      formErrors.password = "Password must be at least 6 characters long.";
    }
    if (formData.vehicleType.trim() === "") {
      formErrors.vehicleType = "Vehicle type is required.";
    }

    setErrors(formErrors);
    return Object.keys(formErrors).length === 0;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (validateForm()) {
      try {
        // Send form data to Spring Boot backend
        const response = await axios.post("http://localhost:8080/api/signup", formData);
        console.log(response.data); // Handle the response from the backend (e.g., success message)
        navigate("/RegistrationSuccessfullPage"); // Redirect upon successful registration
      } catch (error) {
        console.error("There was an error during registration", error);
        // You can handle error responses here if needed (e.g., show a message to the user)
      }
    }
  };

  return (
    <div className="signup-form-container">
      <h2>Sign Up</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Contact Number:</label>
          <input
            type="text"
            name="contactNumber"
            value={formData.contactNumber}
            onChange={handleInputChange}
            placeholder="Enter your contact number"
          />
          {errors.contactNumber && <p className="error">{errors.contactNumber}</p>}
        </div>

        <div className="form-group">
          <label>Registration Number:</label>
          <input
            type="text"
            name="registrationNumber"
            value={formData.registrationNumber}
            onChange={handleInputChange}
            placeholder="Enter your registration number"
          />
          {errors.registrationNumber && <p className="error">{errors.registrationNumber}</p>}
        </div>

        <div className="form-group">
          <label>Chassis Number:</label>
          <input
            type="text"
            name="chassisNumber"
            value={formData.chassisNumber}
            onChange={handleInputChange}
            placeholder="Enter your chassis number"
          />
          {errors.chassisNumber && <p className="error">{errors.chassisNumber}</p>}
        </div>

        <div className="form-group">
          <label>Manufacture Year:</label>
          <input
            type="text"
            name="manufactureYear"
            value={formData.manufactureYear}
            onChange={handleInputChange}
            placeholder="Enter manufacture year"
          />
          {errors.manufactureYear && <p className="error">{errors.manufactureYear}</p>}
        </div>

        <div className="form-group">
          <label>Vehicle Name:</label>
          <input
            type="text"
            name="vehicle"
            value={formData.vehicle}
            onChange={handleInputChange}
            placeholder="Enter vehicle name"
          />
          {errors.vehicle && <p className="error">{errors.vehicle}</p>}
        </div>

        <div className="form-group">
          <label>Password:</label>
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleInputChange}
            placeholder="Enter your password"
          />
          {errors.password && <p className="error">{errors.password}</p>}
        </div>

        <div className="form-group">
          <label>Vehicle Type:</label>
          <select
            name="vehicleType"
            value={formData.vehicleType}
            onChange={handleInputChange}
          >
            <option value="">Select vehicle type</option>
            <option value="Car">Car</option>
            <option value="Truck">Truck</option>
            <option value="Bike">Bike</option>
            <option value="Bus">Bus</option>
          </select>
          {errors.vehicleType && <p className="error">{errors.vehicleType}</p>}
        </div>

        <button type="submit" className="submit-button">Sign Up</button>
      </form>
    </div>
  );
};

export default SignUpForm;
