import * as React from "react";
import {List, Datagrid, TextField, DateField} from 'react-admin';

export const DishList = () => (
    <List>
        <Datagrid sx={{
            "& .RaDatagrid-headerCell": {
                fontWeight: "bold",
            },
        }}>
            <TextField label="Dish ID" source="id" />
            <TextField label="Dish Name" source="name" />
            <TextField label="Stock" source="stock" />
            <TextField label="Price" source="price" />
            <DateField label="Created Time" source="createdDateTime" showTime={true} />
            <DateField label="Updated Time" source="updatedDateTime" showTime={true} />
        </Datagrid>
    </List>
);