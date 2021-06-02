import './App.css';


import React, { useContext, useEffect, useState } from 'react';
import AppContext from '../context/AppContext';
import {UPDATE_NAME} from '../context/Actions';
import Mainpage from "./Mainpage/index.js";
import {MainviewDiv} from "./Mainview/MainviewElements";
import {NavbarDiv} from "./Navbar/NavBarElements";
import logo from "../logo.svg";
import Table from "./Table";


function App() {
    const { state, dispatch } = useContext(AppContext);
    const {name} = state;
    const {data} = name;

    return (
        <div className="App">

            <Mainpage />

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
