import React from "react";
import "bootstrap/dist/css/bootstrap.min.css"; // Import Bootstrap

const DeleteButton = ({ onClick }) => {
  return (
    <button
      className="btn btn-danger btn-lg" // Bootstrap classes for styling
      onClick={onClick}
      aria-label="Delete" // Accessibility improvement
    >
      Delete
    </button>
  );
};

export default DeleteButton;
