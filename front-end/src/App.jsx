import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Footer from "./user/common/Footer"; // No need to specify the file extension for JSX files
import Home from "./pages/Home"; // No need to specify the file extension
import "./App.css";
import Header from "./user/common/Header"; // No need to specify the file extension
import PrivacyPolicy from "./pages/Privacy"; // Adjust the path based on where the file is located
import Terms from "./pages/Terms"; // Adjust the path based on where the file is located

function App() {
    return (
        <Router>
            <div className="App">
            

                <Routes>
                    {/* Define your routes here */}
                    <Route path="/" element={<Home />} /> {/* Home should be mapped to "/" */}
                    <Route path="/privacy-policy" element={<PrivacyPolicy />} /> {/* Add route for Privacy Policy */}
                    <Route path="/terms" element={<Terms />} /> {/* Add route for Terms */}
                    {/* Add more routes as needed */}
                </Routes>
                
                <Footer /> {/* Footer component */}
            </div>
        </Router>
    );
}

export default App;






