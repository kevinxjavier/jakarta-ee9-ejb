## Version
- java 18+
- java version "21.0.3" 2024-04-16 LTS
- wildfly-33.0.2.Final
- apache-maven-3.8.6
- mysql-8.0.33

# WILDFLY JAKARTA
- WildFly versions 17 - 26 are Jakarta EE 8.
- WildFly Preview versions 22 - 26 are Jakarta EE 9.
- WildFly versions 27 - 33 (and Preview versions 27 - 30) are Jakarta EE 10.
- WildFly Preview versions 31 - 33 are Jakarta EE 11.

# DATABASE
```
> mysql -u root -p
CREATE DATABASE enterprise;
USE enterprise;
CREATE TABLE user(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(36),
    password VARCHAR(36),
    email VARCHAR(50)
);
INSERT INTO user (name, password, email) VALUES ("kevin", "123456", "kevin@gmail.com"), 
("javier", "456783", "javier@gmail.com"), ("pina", "098765", "pina@gmail.com");
```

# RUN 
```
$ mvn install
```