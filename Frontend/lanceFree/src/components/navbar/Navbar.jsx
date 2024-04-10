import "./navbar.css"
import Grid from '@mui/material/Grid';
import Button from '@mui/material/Button';
import { useState } from "react";
import { Divider, IconButton, Stack, Tooltip } from "@mui/material";
import Avatar from '@mui/material/Avatar';
import MenuItem from '@mui/material/MenuItem';
import Menu from '@mui/material/Menu';
import Logout from '@mui/icons-material/Logout';
import ListItemIcon from '@mui/material/ListItemIcon';
import PersonIcon from '@mui/icons-material/Person';
import { Login } from "@mui/icons-material";
import {SignUpModal } from "../signup/SignUpModal";
import { LoginModal } from "../login/LoginModal";




export const Navbar = () => {

    const [openSignUp, setOpenSingUp] = useState(false);
    const [openLogin, setOpenLogin] = useState(false);
    const isLoggedIn = false;

    const handleCloseSignUp = () => setOpenSingUp(false);
    const handleOpenSignUp = () => setOpenSingUp(true);
    
    const handleCloseLogin = () =>{ setOpenLogin(false)}
    const handleOpenLogin = () => {setOpenLogin(true)}

    const [anchorEl, setAnchorEl] = useState(null);
    const open = Boolean(anchorEl);
    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };
    const handleClose = () => {
        setAnchorEl(null);
    };


    return(  
        <>
        <header id='header'>
            <img src="Icons/lancefree-logo.png" alt="" id='logo'/>
                    {!isLoggedIn ? (
                        <Stack className='stack' direction="row" spacing={2} divider={<Divider orientation="vertical" flexItem />}>
                            <Button size='small' onClick={handleOpenSignUp}>Registrarse</Button>
                            <Button size='small' onClick={handleOpenLogin} id='login-btn' variant="contained">Login</Button>
                        </Stack>
                    )
                    : (
                      <>
                        <Tooltip title="Mi perfil">
                        <IconButton
                            onClick={handleClick}
                            size="small"
                            sx={{ ml: 2 }}
                            aria-controls={open ? 'account-menu' : undefined}
                            aria-haspopup="true"
                            aria-expanded={open ? 'true' : undefined}
                            >
                            <Avatar src="Icons/profile-example.jpg" sx={{ width: 40, height: 40 }}></Avatar>
                            </IconButton>
                        </Tooltip>
                        <Menu
                            anchorEl={anchorEl}
                            id="account-menu"
                            open={open}
                            onClose={handleClose}
                            onClick={handleClose}>
                        <MenuItem onClick={handleClose}>
                            <ListItemIcon>
                                <PersonIcon fontSize="small" />
                            </ListItemIcon>
                            Profile
                        </MenuItem>
                        <MenuItem onClick={handleClose}>
                            <ListItemIcon>
                                <Logout fontSize="small" />
                            </ListItemIcon>
                            Logout
                        </MenuItem>
                        </Menu>
                        </>   
                    )}
        </header>
        <div>
            <SignUpModal handleClose={handleCloseSignUp} open={openSignUp}></SignUpModal>
            <LoginModal handleClose={handleCloseLogin} open={openLogin}></LoginModal>
        </div>  
        </>
    )
}