import "./provider.css";
import Avatar from "@mui/material/Avatar";
import Typography from "@mui/material/Typography";
import Divider from "@mui/material/Divider";
import Stack from "@mui/material/Stack";
import StarIcon from "@mui/icons-material/Star";

export const Provider = ({ user, imgSize = { width: 56, height: 56 } }) => {
  return (
    <div id="row">
        <Avatar src={user.img ? (user.img) : ("/broken-image.jpg")} sx={imgSize}/>
      
      <div id="provider-data">
        <Stack
          direction="row"
          divider={<Divider orientation="vertical" flexItem />}
          spacing={1}
        >
          {user.name ? (
            <Typography id="provider-name" color="initial">
              {user.name}
            </Typography>
          ) : null}
          {user.rating ? (
            <div id="provider-rating">
              <StarIcon fontSize="small"></StarIcon>
              <Typography color="initial">{user.rating}</Typography>
            </div>
          ) : null}
        </Stack>
        <div></div>
        <Typography id="provider-title" color="initial">
            {user.title ? (user.title) : (null)}
        </Typography>
      </div>
    </div>
  );
};
