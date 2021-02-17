FROM		ft-alpine:java

WORKDIR		/opt/

RUN		git clone https://github.com/nhamill21/newav.git

EXPOSE		8080

WORKDIR		/opt/newav

ENTRYPOINT	mvn clean install spring-boot:repackage && java -jar target/newav-1.0-SNAPSHOT.jar
