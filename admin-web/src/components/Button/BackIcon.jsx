import React from "react";
import { FaArrowLeft } from "react-icons/fa";
import { useNavigate } from "react-router-dom";
import "./BackIcon.css"; // Include styles for proper alignment if necessary

const BackIcon = () => {
  const navigate = useNavigate();

  const handleClick = () => {
    navigate(-1); // Navigate to the previous page
  };

  return (
    <div className="back-icon" onClick={handleClick}>
      <FaArrowLeft size={30} />
    </div>
  );
};

export default BackIcon;
