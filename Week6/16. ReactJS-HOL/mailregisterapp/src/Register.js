import React, { Component } from 'react';

class Register extends Component {
  constructor() {
    super();
    this.state = {
      name: '',
      email: '',
      password: ''
    };
  }

  handleChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const { name, email, password } = this.state;

    if (name.length < 5) {
      alert("Name must be at least 5 characters long!");
      return;
    }

    if (!email.includes('@') || !email.includes('.')) {
      alert("Email must contain '@' and '.' !");
      return;
    }

    if (password.length < 8) {
      alert("Password must be 8 characters long!");
      return;
    }

    alert("Form submitted successfully!");
    this.setState({ name: '', email: '', password: '' });
  };

  render() {
    const { name, email, password } = this.state;

    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h2 style={{ color: 'red', fontWeight: 'bold' }}>Register Here!!!</h2>
        <form onSubmit={this.handleSubmit}>
          <div style={{ marginBottom: '15px' }}>
            <label><strong>Name:</strong></label><br />
            <input
              type="text"
              name="name"
              value={name}
              onChange={this.handleChange}
              required
            />
          </div>
          <div style={{ marginBottom: '15px' }}>
            <label><strong>Email:</strong></label><br />
            <input
              type="text"
              name="email"
              value={email}
              onChange={this.handleChange}
              required
            />
          </div>
          <div style={{ marginBottom: '15px' }}>
            <label><strong>Password:</strong></label><br />
            <input
              type="password"
              name="password"
              value={password}
              onChange={this.handleChange}
              required
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default Register;
