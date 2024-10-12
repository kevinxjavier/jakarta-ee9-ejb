# RUN EJB  (install as lib)
```
# Follow $ cat ./webapp-ear-ejb/README.md
$ mvn -f webapp-ear-ejb/pom.xml clean install
```

# RUN WAR (install as lib)
```
# Follow $ cat ./webapp-ear-war/README.md
$ mvn -f ./webapp-ear-war/pom.xml clean install
```

# RUN EAR (Main project)
```
# Follow $ cat ./webapp-ear-ear/README.md
$ mvn -f ./webapp-ear-ear/pom.xml clean package
$ mvn -f ./webapp-ear-ear/pom.xml wildfly:deploy
```
