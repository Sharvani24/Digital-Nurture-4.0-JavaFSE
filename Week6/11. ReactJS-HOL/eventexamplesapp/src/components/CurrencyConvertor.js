import React, { useState } from 'react';

const CurrencyConvertor = () => {
  const [rupees, setRupees] = useState('');
  const [euros, setEuros] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const euroValue = (parseFloat(rupees) * 0.011).toFixed(2); // 1 INR ≈ 0.011 EUR
    setEuros(euroValue);
  };

  return (
    <div>
      <h3>Currency Convertor (INR to EUR)</h3>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          value={rupees}
          onChange={(e) => setRupees(e.target.value)}
          placeholder="Enter INR"
        />
        <button type="submit">Convert</button>
      </form>
      {euros && <p>Equivalent in Euros: €{euros}</p>}
    </div>
  );
};

export default CurrencyConvertor;
