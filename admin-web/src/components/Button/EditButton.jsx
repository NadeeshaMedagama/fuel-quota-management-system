import React from "react";
import "bootstrap/dist/css/bootstrap.min.css"; // Ensure Bootstrap is included

const EditButton = ({ onClick }) => {
  return (
    <button
      className="btn btn-primary me-2" 
      onClick={onClick}
      aria-label="Edit" // Accessibility improvement
    >
      Edit
    </button>
  );
};

export default EditButton;
