import React from 'react';

const WelcomeButton = () => {
  const sayMessage = (message) => {
    alert(`Message: ${message}`);
  };

  return (
    <div>
      <button onClick={() => sayMessage("Welcome")}>Say Welcome</button>
    </div>
  );
};

export default WelcomeButton;
