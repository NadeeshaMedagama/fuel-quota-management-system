import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom"; // Importing Router and Routes for navigation
import Dashboard from "./pages/Dashboard/Dashboard"; // Dashboard component
/*import VehiclePage from "./pages/VehicleManagement/VehiclePage"; // Vehicle Management Page 8 */
import FuelStation from "./pages/FuelStationManagement/FuelStation"; // Fuel Station Management Page
import EditFuelStation from "./pages/FuelStationManagement/EditFuelStation"; // Edit Fuel Station Page
import AddFuelStation from "./pages/FuelStationManagement/AddFuelStation"; // Add Fuel Station Page
/*import DistributionTracking from "./pages/DistributionTracking/DistributionTracking"; // Distribution Tracking Page
import FuelQuota from "./pages/FuelQuota/FuelQuota"; // Fuel Quota Page
import ReportPage from "./pages/reports/reports"; // Report Page Component */
import PageNotFound from "./pages/PageNotFound"; // 404 Page Not Found Component
/*import AddFuelQuota from "./pages/FuelQuota/AddFuelQuota";
import EditFuelQuota from "./pages/FuelQuota/EditFuelQuota";
import NotificationPage from "./pages/Notification/NotificationPage"; // Import the Notification Page */
import "bootstrap/dist/css/bootstrap.min.css"; // Import Bootstrap for styling

const App = () => {
  return (
    <Router>
      <div className="App">
        <Routes>
          {/* Dashboard Route */}
          <Route path="/" element={<Dashboard />} /> {/* Default route: Dashboard */}

          

          {/* Fuel Station Management */}
          <Route path="/fuel-stations" element={<FuelStation />} /> {/* View Fuel Stations */}
          <Route path="/edit-fuel-station/:id" element={<EditFuelStation />} /> {/* Edit Fuel Station */}
          <Route path="/add-fuel-station" element={<AddFuelStation />} /> {/* Add New Fuel Station */}

         

          {/* 404 Page */}
          <Route path="*" element={<PageNotFound />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
