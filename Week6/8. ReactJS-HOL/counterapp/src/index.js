import React from 'react';
import ReactDOM from 'react-dom/client'; // Import createRoot from react-dom/client
import './index.css'; // You can keep or remove this if you're primarily using Tailwind
import App from './App'; // Import the main App component

// Get the root DOM element where the React app will be mounted
const root = ReactDOM.createRoot(document.getElementById('root'));

// Render the App component into the root element
// React.StrictMode is a tool for highlighting potential problems in an application.
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
