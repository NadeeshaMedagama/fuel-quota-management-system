import React from "react";
import { Button, Form } from "react-bootstrap"; // Import Bootstrap components
import "./Form.css";

const DeleteForm = ({ onSubmit, itemName }) => {
  return (
    <Form className="form" onSubmit={onSubmit}>
      <h3>Delete Item</h3>
      <p>
        Are you sure you want to delete <strong>{itemName}</strong>?
      </p>
      <Button variant="danger" type="submit" block>
        Confirm Delete
      </Button>
    </Form>
  );
};

export default DeleteForm;
