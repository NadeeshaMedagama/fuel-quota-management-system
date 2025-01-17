import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Footer from "./user/common/Footer";
import Home from "./pages/Home.jsx";
import PrivacyPolicy from "./pages/Privacy.jsx";
import Terms from "./pages/Terms";
import Register from "./pages/SignUpForm";
import UserDashboard from "./pages/Userdashboard"; // Corrected capitalization
import VehicleRegistrationForm from "./pages/VehicleRegistrationForm"; // Import the VehicleRegistrationForm component
import LoginForm from "./pages/Login";
import "./App.css";

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          {/* Define routes for different components */}
          <Route path="/" element={<Home />} />
          <Route path="/privacy-policy" element={<PrivacyPolicy />} />
          <Route path="/terms" element={<Terms />} />
          <Route path="/register" element={<Register />} />
          <Route path="/Userdashboard" element={<UserDashboard />} />
          <Route path="/vehicleregistration" element={<VehicleRegistrationForm />} />
          <Route path="/Login" element={<LoginForm />} />
        </Routes>

        {/* Footer */}
        <Footer />
      </div>
    </Router>
  );
}

export default App;













