import { useState } from "react";
import axios from "axios";
import TermsPopup from "./Terms";

const RegistrationForm = () => {
  const [isTermsOpen, setIsTermsOpen] = useState(false);
  const [formData, setFormData] = useState({
    ownerName: "",
    ownerPhone: "",
    email: "",
    password: "",
    confirmPassword: "",
    termsAccepted: false,
  });

  const handleInputChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData({
      ...formData,
      [name]: type === "checkbox" ? checked : value,
    });
  };

  const handleOpenTerms = () => {
    setIsTermsOpen(true);
  };

  const handleCloseTerms = () => {
    setIsTermsOpen(false);
  };

  async function save(event) {
    event.preventDefault();
    if (formData.password !== formData.confirmPassword) {
      alert("Passwords do not match");
      return;
    }

    try {
      await axios.post("http://localhost:8080/api/v1/VehicleOwner/save", {
        ownerName: formData.ownerName,
        ownerPhone: formData.ownerPhone,
        ownerEmail: formData.email,
        ownerPassword: formData.password,
      });
      alert("Vehicle Registration Successfully");
    } catch (err) {
      alert("Registration failed: " + err.message);
    }
  }

  return (
    <div className="registration-container">
      <div className="form-container">
        <h2 className="form-title">User Registration</h2>

        <form onSubmit={save} className="registration-form">
          <div className="input-group">
            <label htmlFor="ownerName" className="input-label">Owner Name</label>
            <input
              type="text"
              id="ownerName"
              name="ownerName"
              value={formData.ownerName}
              onChange={handleInputChange}
              placeholder="Enter owner name"
              className="input-field"
              required
            />
          </div>

          <div className="input-group">
            <label htmlFor="ownerPhone" className="input-label">Owner Phone</label>
            <input
              type="text"
              id="ownerPhone"
              name="ownerPhone"
              value={formData.ownerPhone}
              onChange={handleInputChange}
              placeholder="Enter owner phone"
              className="input-field"
              required
            />
          </div>

          <div className="input-group">
            <label htmlFor="email" className="input-label">Email</label>
            <input
              type="email"
              id="email"
              name="email"
              value={formData.email}
              onChange={handleInputChange}
              placeholder="Enter your email"
              className="input-field"
              required
            />
          </div>

          <div className="input-group">
            <label htmlFor="password" className="input-label">Password</label>
            <input
              type="password"
              id="password"
              name="password"
              value={formData.password}
              onChange={handleInputChange}
              placeholder="Enter your password"
              className="input-field"
              required
            />
          </div>

          <div className="input-group">
            <label htmlFor="confirmPassword" className="input-label">Confirm Password</label>
            <input
              type="password"
              id="confirmPassword"
              name="confirmPassword"
              value={formData.confirmPassword}
              onChange={handleInputChange}
              placeholder="Confirm your password"
              className="input-field"
              required
            />
          </div>

          <div className="terms-group">
            <input
              type="checkbox"
              id="termsAccepted"
              name="termsAccepted"
              checked={formData.termsAccepted}
              onChange={handleInputChange}
              className="terms-checkbox"
              required
            />
            <label htmlFor="termsAccepted" className="terms-label">
              I accept the{" "}
              <button
                type="button"
                onClick={handleOpenTerms}
                className="terms-link"
              >
                Terms and Conditions
              </button>
            </label>
          </div>

          <button
            type="submit"
            className="submit-button"
          >
            Register User
          </button>
        </form>
      </div>

      <TermsPopup isOpen={isTermsOpen} onClose={handleCloseTerms} />
    </div>
  );
};

export default RegistrationForm;

