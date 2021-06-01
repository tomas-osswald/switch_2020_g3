import logo from '../logo.svg';
import './App.css';
import Table from './Table';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
      <Table />
    </div>
  );
}
/*
import logo from '../logo.svg';
import './App.css';
import Frame from "./Frame";


function App() {
    return (
        <div className="App">
            <Frame />
        </div>
    );
}

export default App;
*/
export default App;
