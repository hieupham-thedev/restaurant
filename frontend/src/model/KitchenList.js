import * as React from "react";
import {List, Datagrid, TextField, DateField} from 'react-admin';

export const KitchenList = () => (
    <List>
        <Datagrid sx={{
            "& .RaDatagrid-headerCell": {
                fontWeight: "bold",
            },
        }}>
            <TextField label="Kitchen ID" source="id" />
            <TextField label="Kitchen Name" source="name" />
            <DateField label="Created Time" source="createdDateTime" showTime={true} />
            <DateField label="Updated Time" source="updatedDateTime" showTime={true} />
        </Datagrid>
    </List>
);