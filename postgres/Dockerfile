FROM postgres
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD 12345
<<<<<<< HEAD
ENV POSTGRES_DB atividade-docker
=======
ENV POSTGRES_DB pessoas
>>>>>>> f316764c53c317fa80b75dccce651963c7556164
COPY create.sql /docker-entrypoint-initdb.d/
COPY insert.sql /docker-entrypoint-initdb.d/
