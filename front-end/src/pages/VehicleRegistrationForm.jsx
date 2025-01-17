import React from "react";
import "./VehicleRegistrationForm.css";


const VehicleRegistrationForm = () => {
    

    const navigate = useNavigate(); // Initialize the navigate function
  
    const handleQRcodeScannerClick  = () => {
      navigate("/QRcodeScanner"); // Navigate to the Register route
    };
  return (
    <section className="registration-form">
      <h2>Register Your Vehicle</h2>
      <form>
        <label>
          Registration Number
          <input type="text" placeholder="Enter your registration number" />
        </label>
        <label>
          Vehicle Type
          <input type="text" placeholder="Enter vehicle type" />
        </label>
        <label>
          Owner Name
          <input type="text" placeholder="Enter owner name" />
        </label>
        <label>
          Contact Number
          <input type="text" placeholder="Enter contact number" />
        </label>
        <button type="submit"
       onClick={handleQRcodeScannerClick} >Register</button>
      </form>
    </section>
  );
};

export default VehicleRegistrationForm;
