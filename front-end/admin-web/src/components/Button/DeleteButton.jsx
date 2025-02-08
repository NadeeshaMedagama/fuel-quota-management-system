import React from "react";
import "bootstrap/dist/css/bootstrap.min.css"; 

const DeleteButton = ({ onClick }) => {
  return (
    <button
      className="btn btn-danger " 
      onClick={onClick}
      aria-label="Delete" // Accessibility improvement
    
    >  Delete  </button>
  );
};

export default DeleteButton;
