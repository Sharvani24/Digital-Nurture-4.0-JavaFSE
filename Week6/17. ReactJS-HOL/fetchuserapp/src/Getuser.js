import React, { Component } from 'react';

class Getuser extends Component {
  constructor() {
    super();
    this.state = {
      user: null,
      loading: true
    };
  }

  async componentDidMount() {
    try {
      const response = await fetch('https://api.randomuser.me/');
      const data = await response.json();
      this.setState({ user: data.results[0], loading: false });
    } catch (error) {
      console.error('Error fetching user:', error);
    }
  }

  render() {
    const { user, loading } = this.state;

    if (loading) {
      return <h3 style={{ textAlign: 'center' }}>Loading user...</h3>;
    }

    const fullName = `${user.name.title} ${user.name.first} ${user.name.last}`;

    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h2 style={{ fontWeight: 'bold' }}>{fullName}</h2>
        <img
          src={user.picture.large}
          alt="User"
          style={{
            borderRadius: '10px',
            boxShadow: '0 0 10px rgba(0,0,0,0.2)',
            marginTop: '15px'
          }}
        />
      </div>
    );
  }
}

export default Getuser;
