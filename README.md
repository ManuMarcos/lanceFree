# LanceFree 
Sitio web para ofrecer servicios

La aplicación debe incluir un sitio institucional en donde los usuarios pueden consultar y buscar los servicios particulares que necesitan. A modo de ejemplo: tutorías escolares, cuidado de niños, clases de idioma, clases de música, etc.  


## Requerimientos

Debe incluir como mínimo:  

- Descripción de la aplicación: Explicación de las funcionalidades disponibles para los usuarios 
- Registro de nuevos usuarios para los que ofrecerán sus servicios  
- Ingreso a la aplicación 	 
- Búsqueda de servicio por filtros
  
  - Categoría 
  - Tipo de clase (individual, grupal)  
  - Frecuencia (única, semanal, mensual)  
  - Calificación  

- De cada servicio se debe poder ver la siguiente información:  

  - Responsable: nombre y experiencia (breve descripción brindada por el responsable con sus títulos y trabajos anteriores que muestren su experiencia en la materia)  
  - Descripción del servicio  
  - Duración y frecuencia  
  - Costo  
  - Comentarios de personas que hayan contratado  

#### Registro nuevos usuarios
Los usuarios podrán registrarse para utilizar la aplicación.
Para registrarse deberán completar un formulario con la siguiente información: nombre y apellido, mail, número de teléfono.  
No se permitirá registrar usuarios con el mismo mail.  
Una vez registrados los datos personales, deberá completar su perfil especifico:  
o Titulo  
o Experiencia

#### Ingreso usuarios
Los usuarios podrán ingresar a la aplicación con su mail y contraseña. Tendrán la posibilidad de solicitar una nueva en caso de olvidarla mediante la opción OLVIDE CONTRASEÑA. Se recomienda utilizar algún criterio de validación para el reseteo de la misma.  

#### Registro de servicios
Los usuarios deben poder crear, modificar, publicar, despublicar y eliminar sus servicios. Un usuario puede tener publicados varios servicios.  
De cada servicio se debe registrar la siguiente información:  
- Nombre
- Servicio
- Duración
- Frecuencia
- Costo

#### Comentar un servicio
Los usuarios del Marketplace podrían ingresar comentarios a los servicios publicados.  

#### Bloquear comentarios
Los proveedores de servicio podrán ver los comentarios sobre sus servicios previos a su publicación y bloquearlos en caso de corresponder. 

Los comentarios aceptados se muestran en la página principal.  
#### Contratar servicios
Los usuarios del Marketplace podrán contratar servicios desde la publicación. Una vez seleccionada el servicio se requerirá que ingrese los siguientes datos:  
- Teléfono y mail de contacto  
- Horario de referencia para el contacto  
- Mensaje al proveedor sobre el motivo por el cual esta interesado en el servicio
Los proveedores cuentan con una sección en su perfil en donde pueden visualizar las contrataciones de servicios. 

Estas contrataciones pueden tener los siguientes estados: solicitada, aceptada, finalizada.  

Los proveedores al recibir una contratación se ponen en contacto con el usuario y de llegar a un acuerdo modifica el estado de la clase a Aceptada.  

Cuando el servicio llega a su fin, el proveedor modifica la contratación a estado Finalizada.  

Si luego de la charla el usuario y proveedor no se ponen de acuerdo, el proveedor cambia el estado de la contratación a Cancelada. 


