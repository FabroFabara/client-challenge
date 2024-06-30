# client-challenge

## Descripcion

El siguiente proyecto esta desarrollado para poder gestionar clientes, ordenes y articulos mediante la creacion de sus respectivos CRUD y asociaciones.

Para solucionar este problema se ha planteado el uso de las siguientes tecnologias
- Java 17
- SpringBoot version 3.3.1
- Postgres como base de datos
- Liquibase para gestionar la base de datos
- Docker para contenerizar la aplicaicon
- JUnit 5 para los test unitarios
- OpenApi 3.0 para la documentacion de los APIs

Con estas tecnologias en uso se decidio crear una aplicacion modular para poder separar la misma en capas de logiac de negocio en el modulo bs, manejo de entidades en el modulo ds y la exposicion de los APIs en el modulo denominado ws.
El uso de Docker en esta solucion nos ayuda a generar la compilacion del proyecto y levantar el mismo levantando una base de datos Postrges y la aplicacion para gestionar los APIs expuestos

## Pasos Ejecucion

- Clonar el repositorio
- Una vez clonado el repositorio el proyecto se puede ejecutar de las siguientes maneras:
  
## Via Docker

- Para ejecutar via Docker debemos contar con la instalcion de docker desktop para poder ejecutar el siguiente comando
- Una vez verificado esto en nuestro equipo no debos colocar dentro de la carpeta clonada client-challenge
- Abrimos un terminal o un cmd ubicados dentro de esta carpeta
- Luego ejecutamos el siguiente comando

```
docker-compose up --build 
```
![image](https://github.com/FabroFabara/client-challenge/assets/92126613/12181392-da67-4675-9335-25329a1cc62c)

<img width="1081" alt="image" src="https://github.com/FabroFabara/client-challenge/assets/92126613/fa76caa7-2177-4505-af0d-4468d320ffbe">


## Validacion


## Via Swagger

- Para la validacion se puede acceder a un navegador y colocar la siguiente url

```
http://localhost:8080/swagger-ui/index.html
```
![image](https://github.com/FabroFabara/client-challenge/assets/92126613/0adf4d50-5325-41c8-ad47-2683dd8cb3e8)

## Test de la aplicacion

- Para los clientes, articulos y ordenes se tiene su respectiva implementacion

## Testeando APIs de Clientes

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/46541d89-b218-4f9a-92a3-4031049a1e21)

- Creacion de Cliente

```
{
  "idCliente": null,
  "nombre": "Juan",
  "apellido": "Perez"
}
```
![image](https://github.com/FabroFabara/client-challenge/assets/92126613/bc2640fb-065d-44d1-9b64-39d06452af3f)

- Actualizacion Cliente

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/53f7986e-38ad-4e06-8c62-d7eb2809d21d)

```
{
  "idCliente": 1,
  "nombre": "Luis",
  "apellido": "Perez"
}
```
![image](https://github.com/FabroFabara/client-challenge/assets/92126613/2e4a9736-f4d5-4367-91cf-84e98b26fb54)

- Obtener Clientes

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/6c013ebc-fea8-40ef-9a70-249420c166ff)

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/83579b1e-7f52-4868-84cb-d66ff61bf7b4)


- Obtener Cliente por Id

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/e3419d59-b010-4749-addf-b6c2efdce76e)

- Eliminacion cliente

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/ba240a16-55f6-4b01-8f74-d199da93f39f)


## Testeando APIs de Articulos

- Creacion de Articulo

```
{
  "idArticulo": null,
  "nombreArticulo": "Laptop HP",
  "precioUnitario": 500.32
}
```

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/95a8f06c-4f3f-4120-a0b9-9b07f48a993e)


- Actualizacion de Articulo

```
{
  "idArticulo": 2,
  "nombreArticulo": "IPHONE 15",
  "precioUnitario": 1230.32
}
```

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/0c79570f-c9cb-4809-b0b5-02193fc89f24)

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/002f5f3b-dced-4766-877b-639169bc00ba)


- Obtener todos los Articulos

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/d209d8d3-04f1-4f90-98b3-b512cf4bcd4f)

- Obtener Articulos por Id

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/2ffa69c1-ef19-4191-86ef-79ccbafd256f)

- Eliminacion de Articulo

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/7af9ed51-cde9-41be-b440-ee79219b0098)

## Testeando APIs de Orden

- Creacion de Orden

```
{
  "idOrden": "OC-2323",
  "fecha": "2024-07-01 10:00:00",
  "cliente": {
    "idCliente": 2
  },
  "articulos": [
    {
      "idArticulo": 2
    }
  ]
}
```
![image](https://github.com/FabroFabara/client-challenge/assets/92126613/613a5837-3277-4ee8-8b8b-d36b64726385)

- Actualizacion de Orden

```
{
  "idOrden": "OC-2323",
  "fecha": "2024-07-03 10:00:00",
  "cliente": {
    "idCliente": 2
  },
  "articulos": [
    {
      "idArticulo": 2
    }
  ]
}
```
![image](https://github.com/FabroFabara/client-challenge/assets/92126613/729ce601-c71a-48c4-b8e8-b5b4cc8faf60)

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/4add9cf1-d73b-423c-8fa0-283102cdd051)

- Obtener Ordenes

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/2dbd955f-6496-43b2-9826-65650652c2ed)

- Obtener Orden por Id

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/c1c954c1-63cb-4b8d-86ff-f7c735b5b93e)

- Eliminar Orden

  ![image](https://github.com/FabroFabara/client-challenge/assets/92126613/542d5293-3bfb-4506-a5ff-5bcfbc175365)

## Via POSTMAN

- Se debe importar la coleccion que se encuentra en la carpeta Documentacion en el proyecto clonado client-challenge

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/2f639160-dcab-46b1-8be8-16caa4fb8b12)

- Despues ejecutar cada uno de los APIs

  ![image](https://github.com/FabroFabara/client-challenge/assets/92126613/19ac8a96-e8cc-4770-abbb-91c852fbe746)

