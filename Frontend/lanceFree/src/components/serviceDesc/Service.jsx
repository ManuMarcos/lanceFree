import Grid from "@mui/material/Unstable_Grid2";
import { Provider } from "../providerDesc/Provider";
import "./service.css";
import Typography from "@mui/material/Typography";
import Rating from "@mui/material/Rating";
import Divider from "@mui/material/Divider";

export const Service = () => {
  return (
    <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
      <Grid id="a" xs={8}>
        <h2>Lorem ipsum dolor sit amet consectetur, adipisicing elit.</h2>
        <div>
          <Provider
            user={{
              name: "Manuel Marcos",
              rating: "3.4",
              title: "Ingeniero en Informatica",
              img: "Icons/profile-example.jpg",
            }}
          ></Provider>
        </div>
        <img
          id="service-img"
          src="https://www.optimalvirtualemployee.com/wp-content/uploads/2022/12/Web-Developer-skill.jpg"
          alt=""
          srcset=""
          width={700}
        />
        <Typography id="service-img-sub" variant="subtitle1" color="initial">
          Acerca de este servicio
        </Typography>
        <Typography color="initial">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Modi ab
          dolorem suscipit nobis fuga dolorum, tempore fugiat rerum aut, itaque
          ipsam quia laboriosam, rem minus tempora nulla. Est dolorem,
          reiciendis quisquam, aspernatur itaque architecto atque consequuntur
          quas fugit dolorum iusto.
        </Typography>
        <Typography id="service-img-sub" variant="subtitle1" color="initial">
          Reseñas
        </Typography>
        <div id="service-rating">
          <Typography variant="subtitle1" color="initial">
            100 comentarios sobre este Servicio
          </Typography>
          <Rating name="read-only" value={3} readOnly sx={{ color: "black" }} />
        </div>
        <Divider id="divider"></Divider>
        <Provider
          user={{ name: "Manuel Marcos" }}
          imgSize={{ height: 40, width: 40 }}
        ></Provider>

        <Grid xs={6}></Grid>
        <Grid xs={6}></Grid>
        <Grid xs={6}></Grid>
      </Grid>
      <Grid id="b" xs={4}></Grid>
    </Grid>
  );
};
