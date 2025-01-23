import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./AddButton.css";  // Import custom CSS file

const AddButton = ({ onClick }) => {
  return (
    <button
      className="btn custom-button btn-lg w-10" // Custom class
      onClick={onClick}
    >
      Add
    </button>
  );
};

export default AddButton;
