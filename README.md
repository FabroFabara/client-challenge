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

## Abrir el proyecto desde el IDE de preferencia

- Abrir el proyecto clonado en nuestro IDE de preferencia
- Luego realizar un Maven install de aplicacion con el siguiente comando
```
mvn clean -U install
```
- Dirigirse al proyecto client-challenge-ws
- Una vez ubicado en el proyecto dirigirse a la siguiente ruta src/main/java/com/client/challenge/ec/ws/ServiceApplication.java
- Luego dar click derecho sobre esta clase y ejecutar un Run Application
  
![image](https://github.com/FabroFabara/client-challenge/assets/92126613/619b6175-a8e3-4072-bcac-f14e48d91098)

## Via Comando por medio de terminal o CMD

- Para ejecutarlo via comando primero debemos verficar que tengamos instalado MAVEN en nuestro equipo
- Una vez verificado que contemos con MAVEN en nuestro equipo no debos colocar dentro de la carpeta clonada client-challenge
- Abrimos un terminal o un cmd ubicados dentro de esta carpeta
- Luego ejecutariamos el siguiente comando y la aplicacion iniciara

```
mvn package spring-boot:run -pl client-challenge-ws
```

![image](https://github.com/FabroFabara/client-challenge/assets/92126613/2ecd6b05-19cd-4a6b-a25e-460e8b48e9f2)

## Via Docker

- Para ejecutar via Docker debemos contar con la instalcion de docker desktop para poder ejecutar el siguiente comando
- Una vez verificado esto en nuestro equipo no debos colocar dentro de la carpeta clonada client-challenge
- Abrimos un terminal o un cmd ubicados dentro de esta carpeta
- Luego ejecutamos el siguiente comando

```
docker-compose up --build 
```
![image](https://github.com/FabroFabara/client-challenge/assets/92126613/12181392-da67-4675-9335-25329a1cc62c)
