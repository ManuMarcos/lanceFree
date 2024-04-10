import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';
import "./serviceCard.css";

export const ServiceCard = () => {

    const overFlowText = () => {
        console.log("overflow")
    }

    return (
    <Card sx={{ maxWidth: 300, height: 230}}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="140"
          image=""
          src='https://www.cyberark.com/wp-content/uploads/2019/11/Developer.jpg'
          alt="green iguana"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            Web developer
          </Typography>
          <Typography variant="body2" color="text.secondary" id="service-desc">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima consequatur ipsa sunt blanditiis. 
            Error mollitia doloremque in enim, possimus praesentium odio ex facere quod dolores ea nihil aperiam esse accusamus.
          </Typography>
        </CardContent>
      </CardActionArea>
    </Card>
  );
};
