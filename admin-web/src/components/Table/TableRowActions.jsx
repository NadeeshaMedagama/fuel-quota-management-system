import React from "react";
import EditButton from "../Button/EditButton"; // Alias for the edit button
import DeleteButton from "../Button/DeleteButton"; // Alias for the delete button

const TableRowActions = ({ id, onDelete, onEdit }) => {
  return (
    <div>
      {onEdit && (
        <EditButton label="Edit" type="default" onClick={() => onEdit(id)} />
      )}
      {onDelete && (
        <DeleteButton label="Delete" type="delete" onClick={() => onDelete(id)} />
      )}
    </div>
  );
};

export default TableRowActions;
