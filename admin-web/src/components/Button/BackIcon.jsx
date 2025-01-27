import React from "react";
import { FaArrowLeft } from "react-icons/fa";
import { useNavigate } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css"; 




const BackIcon = () => {
  const navigate = useNavigate();


  const handleClick = () => {
    if (window.history.length > 2) {
      navigate(-1); // Go back to the previous page if possible
    } else {
      navigate("/"); 
    }
  };



  return (
    
    <div

      className="d-flex align-items-center justify-content-center p-2"
      onClick={handleClick}
      role="button"
      tabIndex={0}
      aria-label="Go back"
      onKeyDown={(e) => e.key === "Enter" && handleClick()}


      style={{
        cursor: "pointer",
        color: "#000000",
        width: "40px",
        height: "40px",
        border: "1px solid #ccc",
        borderRadius: "50%",
        background:"#ffffff",
        marginTop:"-20px",
        paddingLeft:"-115px",

      }}  >

      <FaArrowLeft size={24} />
    </div>
    
  );

  
};

export default BackIcon;
