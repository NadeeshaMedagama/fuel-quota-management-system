import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Footer from "./user/common/Footer";
import Home from "./pages/Home";
import PrivacyPolicy from "./user/common/Privacy";
import Terms from "./user/common/Terms";
import Register from "./pages/SignUpForm";
import UserDashboard from "./pages/Userdashboard"; // Corrected capitalization for consistency
import VehicleRegistrationForm from "./pages/VehicleRegistrationForm"; // Import the VehicleRegistrationForm component
import LoginForm from "./pages/Login";
import "./App.css";
import QRCodeScanner from "./pages/QRCodeScanner";

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          {/* Define routes for different components */}
          <Route path="/" element={<Home />} />
          <Route path="/Privacy" element={<PrivacyPolicy />} />
          <Route path="/terms" element={<Terms />} />
          <Route path="/register" element={<Register />} />
          <Route path="/Userdashboard" element={<UserDashboard />} /> {/* Corrected capitalization */}
          <Route path="/VehicleRegistrationForm" element={<VehicleRegistrationForm />} /> {/* Fixed the closing tag */}
          <Route path="/Login" element={<LoginForm />} />
          <Route path="/Footer" element={<Footer />} />
          <Route path="/QRCodeScanner" element={<QRCodeScanner />} /> {/* Fixed the missing closing tag */}
        </Routes>
      </div>
    </Router>
  );
}

export default App;












