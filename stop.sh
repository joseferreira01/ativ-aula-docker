mvn clean
docker stop banco
docker kill bancopos

docker rmi jose/banco
docker stop posapp
docker kill posapp
docker rm posapp
docker rm bancopos
docker rmi pos-aula
