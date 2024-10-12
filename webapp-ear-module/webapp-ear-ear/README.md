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

# CONFIGURE WILDFlY
```
# Create a User

    $ ./add-user.sh     # Select Manage User, leave groups blank and won't go to to be used for one AS process
```

# START WILDFlY
```
# From Wildfly Application Server
$ cd <WILDFLY_SERVER>/bin
$ ./standalone.sh
```

# WILDFLY DATASOURCE MySQL
```
# Download MySQL Driver
    $ mvn dependency:copy \
      -Dartifact=mysql:mysql-connector-java:8.0.33 \
      -DoutputDirectory=/home/kevin

$ curl http://127.0.0.1:9990
        # Deployments   >       Upload Deployments  >   mysql-connector-java:8.0.33.jar
        # Configuration >       Subsystems  >   Datasources & Drivers   > JDBC Drivers  >   mysql-connector-j-8.0.33.jar
        # Configuration >       Subsystems  >   Datasources & Drivers   > Datasources   >   Add Datasource  > MySQL > [copy JNDI Name] -> *next...
```

# START WILDFlY FROM MAVEN & DEPLOY
```
$ mvn wildfly:start  # Only start Wildfly does not deploy our war.
$ mvn wildfly:run    # Start Wildfly and deploy our war.
$ mvn wildfly:shutdown

$ mvn wildfly:deploy # Same as $ mvn wildfly:redeploy
$ mvn wildfly:undeploy
```

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
$ mvn -f ./webapp-ear-ejb/pom.xml clean install
$ mvn -f ./webapp-ear-war/pom.xml clean install
$ mvn -f ./webapp-ear-ear/pom.xml clean package wildfly:deploy
```