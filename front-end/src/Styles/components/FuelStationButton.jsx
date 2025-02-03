import React from "react";
import { useNavigate } from "react-router-dom";

const FuelStationButton = () => {
  const navigate = useNavigate();  // Use navigate hook from react-router-dom

  const handleFuelStationClick = () => {
    navigate("/FuelStationRegistration");  
  };

  return (
    <button className="fuelstation-btn" onClick={handleFuelStationClick}>
      Fuel Station
    </button>
  );
};

export default FuelStationButton ;