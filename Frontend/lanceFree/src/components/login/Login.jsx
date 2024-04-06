
import Modal from '@mui/material/Modal';


export const Login = (handleClose, open) => {

    return (
        <Modal
        open={open}
        onClose={handleClose}
        >
        <Box sx={style}>
          <Typography id="modal-modal-title" variant="h6" component="h2">
            Text in a modal
          </Typography>
          <Typography id="modal-modal-description" sx={{ mt: 2 }}>
            Duis mollis, est non commodo luctus, nisi erat porttitor ligula.
          </Typography>
        </Box>
        </Modal>
    );
}