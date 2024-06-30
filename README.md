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

## Validacion


