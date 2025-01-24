import React from "react";
import TableRowActions from "./TableRowActions";

const TableRow = ({ data, columns, onDelete, onEdit }) => {
  return (
    <tr>
      {columns.map((column, index) => (
        <td key={index}>
          {column.render ? column.render(data[column.key]) : data[column.key]}
        </td>
      ))}
      {(onEdit || onDelete) && (
        <td>
          <TableRowActions
            id={data.id}
            onDelete={onDelete}
            onEdit={onEdit}
          />
        </td>
      )}
    </tr>
  );
};

export default TableRow;
