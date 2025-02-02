import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Login from "./pages/Login";
import SignUp from "./pages/SignUp";
import PrivacyPolicy from "./pages/PrivacyPolicy";
import TermsAndConditions from "./pages/TermsAndConditions";
import VehicleRegistrationForm from "./pages/VehicleRegistrationForm";
import RegistrationSuccessfull from "./pages/RegistrationSuccessfull";
import QRDisplay from "./pages/QRdisplay"; // ✅ Ensure case sensitivity


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/PrivacyPolicy" element={<PrivacyPolicy />} />
        <Route path="/TermsAndConditions" element={<TermsAndConditions />} />
        <Route path="/VehicleRegistrationForm" element={<VehicleRegistrationForm />} />
        <Route path="/RegistrationSuccessfull" element={<RegistrationSuccessfull />} />
        <Route path="/QRDisplay" element={<QRDisplay />} />  {/* ✅ Fixed Route Placement */}
     
      </Routes>
    </Router>
  );
}

export default App;













