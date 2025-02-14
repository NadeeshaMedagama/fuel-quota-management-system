import React from "react";
import { InputGroup, FormControl, Button } from "react-bootstrap"; 
import "./SearchBar.css";

const SearchBar = ({ placeholder = "Search here...", onSearch }) => {
  const handleKeyDown = (event) => {
    if (event.key === "Enter" && onSearch) {
      onSearch(event.target.value); 
    }
  };

  return (
    <div className="search-bar-container">
      <InputGroup className="search-bar">
        <FormControl
          type="text"
          className="search-input"
          placeholder={placeholder}
          onKeyDown={handleKeyDown} 
        />
        <Button
          variant="primary"
          onClick={() => onSearch && onSearch(document.querySelector('.search-input').value)} 
        >
          Search
        </Button>
      </InputGroup>
    </div>
  );
};

export default SearchBar;
