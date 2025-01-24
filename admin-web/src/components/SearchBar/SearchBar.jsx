import React from "react";
import { InputGroup, FormControl, Button } from "react-bootstrap"; // Import necessary Bootstrap components
import "./SearchBar.css";

const SearchBar = ({ placeholder = "Search here...", onSearch }) => {
  const handleKeyDown = (event) => {
    if (event.key === "Enter" && onSearch) {
      onSearch(event.target.value); // Trigger search only on Enter key press
    }
  };

  return (
    <div className="search-bar-container">
      <InputGroup className="search-bar">
        <FormControl
          type="text"
          className="search-input"
          placeholder={placeholder}
          onKeyDown={handleKeyDown} // Listen for Enter key press
        />
        <Button
          variant="primary"
          onClick={() => onSearch && onSearch(document.querySelector('.search-input').value)} // Trigger search on button click
        >
          Search
        </Button>
      </InputGroup>
    </div>
  );
};

export default SearchBar;
