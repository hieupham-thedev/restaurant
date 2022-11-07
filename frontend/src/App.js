// in src/App.js
import * as React from "react";
import {Admin, Resource} from 'react-admin';
import jsonServerProvider from 'ra-data-json-server';
import {KitchenList} from "./model/KitchenList";
import {KitchenCreate} from "./model/form/KitchenCreate";
import {DishList} from "./model/DishList";
import {DishCreate} from "./model/form/DishCreate";

const dataProvider = jsonServerProvider('http://localhost:8081/api');

const App = () => (
    <Admin dataProvider={dataProvider}>
        <Resource name="kitchens" list={KitchenList} create={KitchenCreate}/>
        <Resource name="dishes" list={DishList} create={DishCreate}/>
    </Admin>
);

export default App;