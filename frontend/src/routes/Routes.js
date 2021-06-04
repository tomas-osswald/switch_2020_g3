import React from 'react';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import Mainpage from "../pages/Mainpage";
import Login from "../pages/Login";
import PrivateRoute from "./PrivateRoute";


function Routes() {
    return (
        <BrowserRouter>
            <Switch>

                <PrivateRoute exact path="/" component={Mainpage} />

                <Route path="/login">
                    <Login/>
                </Route>

            </Switch>
        </BrowserRouter>
    );
}

export default Routes;