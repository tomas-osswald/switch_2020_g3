/*
import logo from '../logo.svg';
import './App.css';
import Table from './Table';
//import Frame from "./Frame";

import React, { useContext, useEffect, useState } from 'react';
import AppContext from '../context/AppContext';
import {UPDATE_NAME} from '../context/Actions';
*/
/*
function App() {
    const { state, dispatch } = useContext(AppContext);
    const { name } = state;
    const { data } = name;

  return (
    <div className="App">
        {/*<Frame />*//*
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
        <h3>{data}</h3>
      </header>
      <Table />
    </div>
  );
}
*/

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
