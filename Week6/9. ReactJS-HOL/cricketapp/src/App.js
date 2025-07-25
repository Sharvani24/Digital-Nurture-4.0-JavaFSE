import React from 'react';
import CountPeople from './CountPeople'; // Import the CountPeople component

/**
 * App Component
 * The main functional component that renders the CountPeople component.
 * It also includes the necessary Tailwind CSS CDN and custom font styling.
 */
function App() {
  return (
    <>
      {/* Script tag to load Tailwind CSS from CDN. This makes Tailwind classes available directly. */}
      {/* In a larger project, Tailwind would typically be installed and configured via PostCSS. */}
      {/* This script should ideally be in public/index.html's head, but for simplicity in a single-file React immersive, */}
      {/* it's placed here to ensure it loads with the React app context. */}
      <script src="https://cdn.tailwindcss.com"></script>
      {/* Custom style block for importing and applying the 'Inter' font. */}
      {/* Similarly, this style block would typically be in public/index.html or a CSS file. */}
      <style>
        {`
        @import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700;800&display=swap');
        body {
          font-family: 'Inter', sans-serif; /* Apply Inter font to the body */
        }
        `}
      </style>
      {/* Main div for the application layout. */}
      {/* It ensures the content is vertically and horizontally centered on a light gray background. */}
      <div className="min-h-screen bg-gray-200 flex items-center justify-center p-6">
        <CountPeople /> {/* Render the CountPeople component */}
      </div>
    </>
  );
}

export default App; // Export the App component as the default export
