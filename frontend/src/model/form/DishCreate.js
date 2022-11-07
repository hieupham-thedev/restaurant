import {Create, Form, TextInput, SaveButton, NumberInput} from 'react-admin';
import {Grid} from '@mui/material';

export const DishCreate = () => (
    <Create sx={{
        "& .RaCreate-main": {
            fontWeight: "bold",
        },
    }}>
        <Form>
            <Grid container>
                <Grid itm xs={12}>
                    <Grid itm xs={6}>
                        <TextInput label="Dish Name" source="name" fullWidth/>
                    </Grid>
                </Grid>
                <Grid itm xs={12}>
                    <Grid itm xs={6}>
                        <NumberInput label="Dish Stock" source="stock" fullWidth/>
                    </Grid>
                </Grid>
                <Grid itm xs={12}>
                    <Grid itm xs={6}>
                        <NumberInput label="Dish Price" source="price" fullWidth/>
                    </Grid>
                </Grid>
                <Grid itm xs={12}>
                    <SaveButton/>
                </Grid>
            </Grid>
        </Form>
    </Create>
);