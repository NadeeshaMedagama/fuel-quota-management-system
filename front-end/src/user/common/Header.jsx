import React, { useState } from 'react';
import './Header.css';

const Header = () => {
    const [isDropdownOpen, setIsDropdownOpen] = useState(false);

    const toggleDropdown = () => {
        setIsDropdownOpen(!isDropdownOpen);
    };

    return (
        <header className="header">
            <div className="logo">
                <img src="logo.png" alt="Logo" height="50" />
            </div>

            <nav>
                <ul>
                    <li><a href="#home">Home</a></li>
                    <li><a href="#about-us">About Us</a></li>
                    <li><a href="#contact-us">Contact Us</a></li>
                </ul>
            </nav>

            <div className="profile">
                <img src="profile.png" alt="Profile" className="profile-pic" height="40" />
                <span className="username">Username</span>
                <div className="dropdown">
                    <button className="dropdown-btn" onClick={toggleDropdown}>
                        ▼
                    </button>
                    {isDropdownOpen && (
                        <div className="dropdown-content">
                            <a href="#settings">Settings</a>
                            <a href="#logout">Logout</a>
                        </div>
                    )}
                </div>
            </div>
        </header>
    );
};

export default Header;


