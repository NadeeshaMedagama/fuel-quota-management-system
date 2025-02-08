import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./AddButton.css";  

const AddButton = ({ onClick }) => {
  return (
    <button className="btn custom-button btn-lg w-10"  onClick={onClick} > Add  </button>
  );
  
};

export default AddButton;
