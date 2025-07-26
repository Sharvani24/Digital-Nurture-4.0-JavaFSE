import React, { useState } from 'react';
import './App.css';
import Employee from './Employee';
import ThemeContext from './ThemeContext'; // NEW

function App() {
  const [theme, setTheme] = useState('light');

  const toggleTheme = () => {
    setTheme(prev => (prev === 'light' ? 'dark' : 'light'));
  };

  return (
    <ThemeContext.Provider value={theme}>
      <div className="App">
        <h1>Employee Management App</h1>
        <button onClick={toggleTheme}>Toggle Theme</button>
        <Employee /> {/* Removed theme prop */}
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
