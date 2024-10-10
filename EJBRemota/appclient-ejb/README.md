## Version
- java 18+
- java version "21.0.3" 2024-04-16 LTS
- apache-maven-3.8.6

# COMPILE
```
$ mvn clean compile package
$ mvn clean compile package -U       # -U means force update of snapshot dependencies

# If your local repository is somehow mucked up for release jars as opposed to snapshots (-U and --update-snapshots only update snapshots), you can purge the local repo using the following:
$ mvn dependency:purge-local-repository

# You probably then want to clean and install again (to solve the problem):
$ mvn dependency:purge-local-repository clean install
```

# RUN
```
$ java -jar target/appclient-ejb-1.0-SNAPSHOT-jar-with-dependencies.jar
```
