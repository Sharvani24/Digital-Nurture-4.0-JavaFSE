import React, { Component } from 'react';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
      amount: '',
      currency: 'Euro'
    };
  }

  increment = () => {
    this.setState({ count: this.state.count + 1 });
    this.sayHello();
  };

  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  };

  sayHello = () => {
    console.log("Hello! This is a static message.");
  };

  sayWelcome = () => {
    alert("Welcome!");
  };

  handleSyntheticEvent = () => {
    alert("I was clicked");
  };

  handleCurrencySubmit = (e) => {
    e.preventDefault();
    const { amount, currency } = this.state;

    if (currency === 'Euro') {
      const convertedAmount = parseFloat(amount) * 80; // Euro to INR
      alert(`Converting to Euro Amount is ${convertedAmount}`);
    }
  };

  render() {
    return (
      <div className="App">
        <h2>{this.state.count}</h2>
        <button onClick={this.increment}>Increment</button>
        <br />
        <button onClick={this.decrement}>Decrement</button>
        <br />
        <button onClick={this.sayWelcome}>Say welcome</button>
        <br />
        <button onClick={this.handleSyntheticEvent}>Click on me</button>

        <h2 className="green-heading">Currency Convertor!!!</h2>

        <form onSubmit={this.handleCurrencySubmit}>
          <label>
            Amount:
            <input
              type="number"
              value={this.state.amount}
              onChange={(e) => this.setState({ amount: e.target.value })}
              required
            />
          </label>
          <br />
          <label>
            Currency:
            <select
              value={this.state.currency}
              onChange={(e) => this.setState({ currency: e.target.value })}
            >
              <option value="Euro">Euro</option>
              {/* You can add more currencies here */}
            </select>
          </label>
          <br />
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default App;
