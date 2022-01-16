######### MariaDB Script ##########

# MariaDB 10.6.5 (latest as of 1/10/22) 
# docker run --detach --name mariadb1 --env MARIADB_ALLOW_EMPTY_ROOT_PASSWORD=yes -p 3306:3306 -v /home/izzetc/dockerdata/mariadb:/var/lib/mysql mariadb:latest

# docker run --detach --name mariadb1 --env MARIADB_ROOT_PASSWORD=password -p 3306:3306 -v /home/izzetc/dockerdata/mariadb:/var/lib/mysql mariadb:latest

# If a mariadb container was run with volume /home/izzetc/dockerdata/mariadb before with different config, 
# then the previous config may still be valid (ignoring any environment vars). 

# The following command starts another mariadb container instance and runs the mysql command line client against your original mariadb container, 
# allowing you to execute SQL statements against your database instance:
# docker run -it --rm mariadb mysql -hmariadb1 -uroot -p

#... where some-mariadb is the name of your original mariadb container (connected to the some-network Docker network).
# This image can also be used as a client for non-Docker or remote instances:
# docker run -it --rm mariadb mysql -h <server container IP> -u example-user -p
# docker run -it --rm mariadb mysql -h172.17.206.83 -uroot -p


# Create a database: recipe_dev
CREATE DATABASE IF NOT EXISTS recipe_dev;
# Create a service user: recipe_dev_user
CREATE USER IF NOT EXISTS recipe_dev_user IDENTIFIED BY 'recipe';
# Grant only DML privileges
GRANT SELECT, INSERT, UPDATE, DELETE ON recipe_dev.* TO 'recipe_dev_user'@'%';
# Revoke any DDL privileges
REVOKE CREATE, DROP, ALTER on recipe_dev.* FROM recipe_dev_user;


# Create a database: recipe_prod
CREATE DATABASE IF NOT EXISTS recipe_prod;
# Create a service user: recipe_prod_user
CREATE USER IF NOT EXISTS recipe_prod_user IDENTIFIED BY 'recipe';
# Grant only DML privileges
GRANT SELECT, INSERT, UPDATE, DELETE ON recipe_prod.* TO 'recipe_prod_user'@'%';
# Revoke any DDL privileges
REVOKE CREATE, DROP, ALTER on recipe_prod.* FROM recipe_prod_user;

