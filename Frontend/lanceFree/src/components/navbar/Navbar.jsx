import "./navbar.css"
import Grid from '@mui/material/Grid';
import Button from '@mui/material/Button';
import { useState } from "react";
import { Login } from "../login/login";


export const Navbar = () => {
    const [openSignUp, setOpenSingUp] = useState(false);

    const handleCloseSignUp = () => setOpenSingUp(false);
    const handleOpenSignUp = () => setOpenSingUp(true);

    return(  
        <>
        <header>
            <Grid id="navbar" container>
                <Grid id="uno" item xs={4}>
                    
                    <img id="logo" src="/images/logo-lancefree.png" alt="logo lanceFree" />
                </Grid>
                <Grid id="dos" item xs={4}>
                </Grid>
                <Grid item xs={4} id="navbar-buttons">
                    <Button variant="contained" size="small">Login</Button>
                    <Button onClick={handleOpenSignUp}>Sign Up</Button>
                </Grid>
            </Grid>
        </header>
        <div>
        <Login open={openSignUp} handleClose={handleCloseSignUp}></Login>

        </div>
        </>
    )
}