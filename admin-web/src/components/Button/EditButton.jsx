import React from "react";
import "bootstrap/dist/css/bootstrap.min.css"; // Ensure Bootstrap is included

const EditButton = ({ onClick }) => {
  return (
    <button
      className="btn btn-primary btn-lg" // Bootstrap classes for primary large button
      onClick={onClick}
      aria-label="Edit" // Accessibility improvement
    >
      Edit
    </button>
  );
};

export default EditButton;
