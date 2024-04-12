import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';
import "./serviceCard.css";

export const ServiceCard = ({service}) => {

    const overFlowText = () => {
        console.log("overflow")
    }

    return (
    <Card sx={{ maxWidth: 300, height: 230}}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="140"
          src= {service.imgUrl}
          alt="green iguana"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {service.title}
          </Typography>
          <Typography variant="body2" color="text.secondary" id="service-desc">
            {service.description}
          </Typography>
        </CardContent>
      </CardActionArea>
    </Card>
  );
};
