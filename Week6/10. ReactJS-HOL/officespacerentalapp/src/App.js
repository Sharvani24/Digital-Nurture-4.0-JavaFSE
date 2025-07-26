import React from 'react';
import './App.css';

function App() {
  const office = {
    name: 'DBS',
    rent: 50000,
    address: 'Chennai',
    image: `${process.env.PUBLIC_URL}/office.jpg`
  };

  const rentStyle = {
    color: office.rent < 60000 ? 'red' : 'green',
    fontWeight: 'bold'
  };

  return (
    <div className="container">
      <h1>Office Space , at Affordable Range</h1>
      <img src={office.image} alt="Office Space" className="office-image" />
      <p><strong>Name:</strong> {office.name}</p>
      <p style={rentStyle}>Rent: Rs. {office.rent}</p>
      <p><strong>Address:</strong> {office.address}</p>
    </div>
  );
}

export default App;
