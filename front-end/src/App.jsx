import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Footer from "./user/common/Footer";  // No need to specify the file extension for JSX files
import Home from "./pages/Home";  // No need to specify the file extension
import "./App.css";
import Header from "./user/common/Header";  // No need to specify the file extension

function App() {
    return (
        <Router>
            <div className="App">
                <Header />
                
                <Routes>
                    {/* Define your routes here */}
                    <Route path="/" element={<Home />} />  {/* Home should be mapped to "/" */}
                    {/* Add more routes as needed */}
                </Routes>
                
                <Footer />
            </div>
        </Router>
    );
}

export default App;





