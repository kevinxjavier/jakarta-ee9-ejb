# RUN EJB REMOTE (install as lib and deploy in wildfly)
```
$ cd ./app-ejb/
# Follow $ cat README.md
$ mvn clean install 
$ mvn wildfly:redeploy
```

# RUN CLIENT
```
$ cd ./appclient-ejb
# Follow $ cat README.md
$ mvn clean compile package
$ java -jar target/appclient-ejb-1.0-SNAPSHOT-jar-with-dependencies.jar
```
