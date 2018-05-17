mvn clean package

#docker build -t jose/banco ./postgres
#docker run -p 5433:5432 -d --name bancopos jose/banco
#
#docker build -t jose/pos-aula .
#docker run -p 8082:8080 -d --name posapp --link bancopos:host-banco jose/pos-aula
docker-compose up -d
