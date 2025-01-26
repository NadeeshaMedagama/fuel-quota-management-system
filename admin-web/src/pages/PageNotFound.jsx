import React from "react";
import { Link } from "react-router-dom"; // For navigation (optional)
import "bootstrap/dist/css/bootstrap.min.css";

const PageNotFound = () => {
  return (
    <div className="container text-center d-flex align-items-center justify-content-center vh-100">
      <div>
        <h1 className="display-3 text-danger">404</h1>
        <h2 className="text-dark">Page Not Found</h2>
        <p className="text-muted">
          The page you're looking for doesn't exist or has been moved.
        </p>
        <Link to="/" className="btn btn-primary mt-3">
          Go Back to Home
        </Link>
      </div>
    </div>
  );
};

export default PageNotFound;