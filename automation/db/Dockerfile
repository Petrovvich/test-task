FROM postgres:9.6-alpine
ARG POSTGRES_USER
ARG POSTGRES_PASSWORD
ARG POSTGRES_DB

COPY init-schema.sql /docker-entrypoint-initdb.d/
#COPY init.sh /docker-entrypoint-initdb.d/
#RUN chmod +x /docker-entrypoint-initdb.d/init.sh