import React from 'react';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import Mainpage from "../pages/Mainpage";
import Login from "../pages/Login";




function Routes() {
    return (
        <BrowserRouter>
            <Switch>

                <Route path="/" exact>
                    <Mainpage/>
                </Route>

                <Route path="/login">
                    <Login/>
                </Route>

            </Switch>
        </BrowserRouter>
    );
}

export default Routes;