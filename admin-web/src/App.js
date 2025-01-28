import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Dashboard from "./pages/Dashboard/Dashboard";
import VehiclePage from "./pages/VehicleManagement/VehiclePage";
import FuelStation from "./pages/FuelStationManagement/FuelStation";
import EditFuelStation from "./pages/FuelStationManagement/EditFuelStation";
import AddFuelStation from "./pages/FuelStationManagement/AddFuelStation";
import DistributionTracking from "./pages/DistributionTracking/DistributionTracking";
import FuelQuota from "./pages/FuelQuota/FuelQuota";
import EditFuelQuota from "./pages/FuelQuota/EditFuelQuota";
import AddFuelQuota from "./pages/FuelQuota/AddFuelQuota";
import ReportPage from "./pages/reports/reports";
import NotificationPage from "./pages/Notification/NotificationPage";
import PageNotFound from "./pages/PageNotFound";
import "bootstrap/dist/css/bootstrap.min.css";
import LoginPage from "./pages/LoginPage/LoginPage";

const App = () => {
  return (
    <Router>
      <Routes>

      <Route path="/" element={<LoginPage />} />
        <Route path="/Dashboard" element={<Dashboard />} />
        <Route path="/vehicles" element={<VehiclePage />} />
        <Route path="/fuel-stations" element={<FuelStation />} />
        <Route path="/edit-fuel-station/:id" element={<EditFuelStation />} />
        <Route path="/add-fuel-station" element={<AddFuelStation />} />
        <Route path="/distribution-tracking" element={<DistributionTracking />} />
        <Route path="/fuel-quotas" element={<FuelQuota />} />
        <Route path="/add-fuel-quota" element={<AddFuelQuota />} />
        <Route path="/edit-fuel-quota/:id" element={<EditFuelQuota />} />
        <Route path="/reports" element={<ReportPage />} />
        <Route path="/notifications" element={<NotificationPage />} />
        <Route path="*" element={<PageNotFound />} />
      </Routes>
    </Router>
  );
};

export default App;
