import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "../Styles/VehicleRegistrationForm.css";

const VehicleRegistrationForm = () => {
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
  const [successMessage, setSuccessMessage] = useState("");

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });

    // Clear individual field error on change
    setErrors((prevErrors) => ({
      ...prevErrors,
      [name]: "",
    }));
  };

  const validateForm = () => {
    let formErrors = {};
    if (!formData.contactNumber.match(/^\d{10}$/)) {
      formErrors.contactNumber = "Contact number must be 10 digits.";
    }
    if (!formData.registrationNumber.trim()) {
      formErrors.registrationNumber = "Registration number is required.";
    }
    if (!formData.chassisNumber.trim()) {
      formErrors.chassisNumber = "Chassis number is required.";
    }
    if (!formData.manufactureYear.match(/^(19|20)\d{2}$/)) {
      formErrors.manufactureYear = "Manufacture year must be a valid year.";
    }
    if (!formData.vehicle.trim()) {
      formErrors.vehicle = "Vehicle name is required.";
    }
    if (formData.password.length < 6) {
      formErrors.password = "Password must be at least 6 characters long.";
    }
    if (!formData.vehicleType.trim()) {
      formErrors.vehicleType = "Vehicle type is required.";
    }

    setErrors(formErrors);
    return Object.keys(formErrors).length === 0;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (validateForm()) {
      try {
        const response = await axios.post(
          "http://localhost:8080/api/v1/vehicle/register",
          formData
        );
        if (response.status === 200) {
          setSuccessMessage("Registration successful! Redirecting...");
          setTimeout(() => navigate("/RegistrationSuccessfull"), 2000);
        } else {
          setErrors({ form: "Registration failed. Please try again." });
        }
      } catch (error) {
        console.error("There was an error during registration", error);
        setErrors({
          form: "Unable to register. Please check your inputs and try again.",
        });
      }
    }
  };

  return (
    <div className="vehicle-registration-form-container">
      <h2>Vehicle Registration</h2>
      {successMessage && (
        <p className="success-message">{successMessage}</p>
      )}
      <form onSubmit={handleSubmit}>
        {[
          {
            label: "Contact Number",
            name: "contactNumber",
            type: "text",
            placeholder: "Enter your contact number",
          },
          {
            label: "Registration Number",
            name: "registrationNumber",
            type: "text",
            placeholder: "Enter your registration number",
          },
          {
            label: "Chassis Number",
            name: "chassisNumber",
            type: "text",
            placeholder: "Enter your chassis number",
          },
          {
            label: "Manufacture Year",
            name: "manufactureYear",
            type: "text",
            placeholder: "Enter manufacture year",
          },
          {
            label: "Vehicle Name",
            name: "vehicle",
            type: "text",
            placeholder: "Enter vehicle name",
          },
          {
            label: "Password",
            name: "password",
            type: "password",
            placeholder: "Enter your password",
          },
        ].map((field, index) => (
          <div className="form-group" key={index}>
            <label>{field.label}:</label>
            <input
              type={field.type}
              name={field.name}
              value={formData[field.name]}
              onChange={handleInputChange}
              placeholder={field.placeholder}
              className={errors[field.name] ? "error-input" : ""}
            />
            {errors[field.name] && (
              <p className="error">{errors[field.name]}</p>
            )}
          </div>
        ))}

        <div className="form-group">
          <label>Vehicle Type:</label>
          <select
            name="vehicleType"
            value={formData.vehicleType}
            onChange={handleInputChange}
            className={errors.vehicleType ? "error-input" : ""}
          >
            <option value="">Select vehicle type</option>
            <option value="Car">Car</option>
            <option value="Truck">Truck</option>
            <option value="Bike">Bike</option>
            <option value="Bus">Bus</option>
          </select>
          {errors.vehicleType && (
            <p className="error">{errors.vehicleType}</p>
          )}
        </div>

        {errors.form && (
          <p className="form-error">{errors.form}</p>
        )}

        <button type="submit" className="submit-button">
          Register
        </button>
      </form>
    </div>
  );
};

export default VehicleRegistrationForm;
