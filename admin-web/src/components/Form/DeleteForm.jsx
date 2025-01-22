import React from "react";
import "./Form.css";

const DeleteForm = ({ onSubmit, itemName }) => {
  return (
    <form className="form" onSubmit={onSubmit}>
      <h3>Delete Item</h3>
      <p>
        Are you sure you want to delete <strong>{itemName}</strong>?
      </p>
      <button type="submit" className="btn btn-danger">
        Confirm Delete
      </button>
    </form>
  );
};

export default DeleteForm;
