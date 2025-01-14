import React from "react";
import "./Button.css";

const DeleteButton = ({ onClick }) => {
  return (
    <button className="btn btn-danger" onClick={onClick}>
      Delete
    </button>
  );
};

export default DeleteButton;
