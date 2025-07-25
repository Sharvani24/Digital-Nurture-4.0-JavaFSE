import React from 'react'; // Import React library
class CountPeople extends React.Component {
  constructor(props) {
    super(props); 
    this.state = {
      entrycount: 0,
      exitcount: 0
    };

    this.updateEntry = this.updateEntry.bind(this);
    this.updateExit = this.updateExit.bind(this);
  }
  updateEntry() {
    this.setState(prevState => ({
      entrycount: prevState.entrycount + 1 // Increment entrycount by 1
    }));
  }

  updateExit() {
    this.setState(prevState => ({
      exitcount: prevState.exitcount + 1 // Increment exitcount by 1
    }));
  }


  render() {
    return (
      <div className="flex flex-col items-center justify-center min-h-[250px] w-full max-w-screen-lg bg-white p-8 rounded-xl shadow-2xl">
        {/* Container for the two counter sections (Login and Exit) */}
        {/* Uses flexbox for horizontal arrangement on larger screens and vertical on small screens. */}
        <div className="flex flex-col sm:flex-row justify-evenly items-center gap-y-8 w-full">
          {/* Login Section */}
          {/* Displays the "Login" button and the current entry count. */}
          {/* Uses flexbox for horizontal alignment of button and text. */}
          <div className="flex items-center space-x-4 bg-gray-50 p-4 rounded-lg shadow-inner">
            <button
              onClick={this.updateEntry} // Attach the updateEntry method to the button's click event
              className="bg-green-600 hover:bg-green-700 text-white font-bold py-2 px-6 rounded-full shadow-lg transition duration-300 ease-in-out transform hover:scale-105 focus:outline-none focus:ring-4 focus:ring-green-300 focus:ring-opacity-75 text-lg"
              aria-label="Increment login count"
            >
              Login
            </button>
            <p className="text-xl font-semibold text-gray-700 whitespace-nowrap">
              {this.state.entrycount} People Entered!!! {/* Display the current entry count */}
            </p>
          </div>

          {/* Exit Section */}
          {/* Displays the "Exit" button and the current exit count. */}
          {/* Uses flexbox for horizontal alignment of button and text. */}
          <div className="flex items-center space-x-4 bg-gray-50 p-4 rounded-lg shadow-inner">
            <button
              onClick={this.updateExit} // Attach the updateExit method to the button's click event
              className="bg-red-600 hover:bg-red-700 text-white font-bold py-2 px-6 rounded-full shadow-lg transition duration-300 ease-in-out transform hover:scale-105 focus:outline-none focus:ring-4 focus:ring-red-300 focus:ring-opacity-75 text-lg"
              aria-label="Increment exit count"
            >
              Exit
            </button>
            <p className="text-xl font-semibold text-gray-700 whitespace-nowrap">
              {this.state.exitcount} People Left!!! {/* Display the current exit count */}
            </p>
          </div>
        </div>
      </div>
    );
  }
}

export default CountPeople; // Export the CountPeople component