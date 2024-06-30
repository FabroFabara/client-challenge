FROM maven:3.8.3-openjdk-17 as deps

WORKDIR /opt/app

COPY client-challenge-bs/pom.xml client-challenge-bs/pom.xml
COPY client-challenge-ds/pom.xml client-challenge-ds/pom.xml
COPY client-challenge-ws/pom.xml client-challenge-ws/pom.xml

COPY pom.xml .

RUN mvn -B -e -C org.apache.maven.plugins:maven-dependency-plugin:3.6.1:go-offline

FROM maven:3.8.3-openjdk-17 as build

WORKDIR /opt/app
COPY --from=deps /root/.m2 /root/.m2
COPY --from=deps /opt/app/ /opt/app

COPY client-challenge-bs/src client-challenge-bs/src
COPY client-challenge-ds/src client-challenge-ds/src
COPY client-challenge-ws/src client-challenge-ws/src

RUN mvn -B -e clean install -DskipTests=true.