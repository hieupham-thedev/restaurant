import {Create, Form, TextInput, SaveButton} from 'react-admin';
import {Grid} from '@mui/material';

export const KitchenCreate = () => (
    <Create sx={{
        "& .RaCreate-main": {
            fontWeight: "bold",
        },
    }}>
        <Form>
            <Grid container>
                <Grid itm xs={12}>
                    <Grid itm xs={6}>
                        <TextInput label="Kitchen Name" source="name" fullWidth/>
                    </Grid>
                </Grid>
                <Grid itm xs={12}>
                    <Grid itm xs={12}>
                        <SaveButton/>
                    </Grid>
                </Grid>
            </Grid>
        </Form>
    </Create>
);