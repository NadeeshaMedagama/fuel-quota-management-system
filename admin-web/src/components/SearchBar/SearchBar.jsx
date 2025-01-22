import React from "react";
import "./SearchBar.css";

const SearchBar = ({ placeholder = "Search here...", onSearch }) => {
  const handleKeyDown = (event) => {
    if (event.key === "Enter" && onSearch) {
      onSearch(event.target.value); // Trigger search only on Enter key press
    }
  };

  return (
    <div className="search-bar-container">
      <div className="search-bar">
        <input
          type="text"
          className="search-input"
          placeholder={placeholder}
          onKeyDown={handleKeyDown} // Listen for Enter key press
        />
      </div>
    </div>
  );
};

export default SearchBar;
