import React, { Component } from 'react';

class ComplaintRegister extends Component {
  constructor() {
    super();
    this.state = {
      name: '',
      complaint: ''
    };
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    const transactionId = Math.floor(Math.random() * 1000); // Generate random transaction ID
    alert(`Thanks ${this.state.name}!\nYour Complaint was Submitted.\nTransaction ID is ${transactionId}`);
    this.setState({ name: '', complaint: '' }); // Reset form
  };

  render() {
    return (
      <div style={{ marginTop: '40px', textAlign: 'center' }}>
        <h2 style={{ color: 'red', fontWeight: 'bold' }}>
          Register your complaints here!!!
        </h2>
        <form onSubmit={this.handleSubmit}>
          <div style={{ marginBottom: '15px' }}>
            <label><strong>Name:</strong></label><br />
            <input
              type="text"
              name="name"
              value={this.state.name}
              onChange={this.handleChange}
              style={{ padding: '6px', width: '200px' }}
              required
            />
          </div>
          <div style={{ marginBottom: '15px' }}>
            <label><strong>Complaint:</strong></label><br />
            <textarea
              name="complaint"
              value={this.state.complaint}
              onChange={this.handleChange}
              rows="4"
              style={{ padding: '6px', width: '200px' }}
              required
            />
          </div>
          <button type="submit" style={{ padding: '6px 20px' }}>Submit</button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;
