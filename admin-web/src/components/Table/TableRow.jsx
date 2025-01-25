import React from "react";
import PropTypes from "prop-types";
import TableRowActions from "./TableRowActions";

const TableRow = ({ data, columns, onDelete, onEdit }) => {
  return (
    <tr>
      {columns.map((column) => (
        <td key={column.key}>
          {column.render ? column.render(data[column.key]) : data[column.key] ?? "N/A"}
        </td>
      ))}
      {(onEdit || onDelete) && (
        <td>
          <TableRowActions id={data.id} onDelete={onDelete} onEdit={onEdit} />
        </td>
      )}
    </tr>
  );
};

// Add PropTypes validation
TableRow.propTypes = {
  data: PropTypes.object.isRequired,
  columns: PropTypes.arrayOf(
    PropTypes.shape({
      key: PropTypes.string.isRequired,
      render: PropTypes.func,
    })
  ).isRequired,
  onDelete: PropTypes.func,
  onEdit: PropTypes.func,
};

export default TableRow;
