## Version
- java 18+
- java version "21.0.3" 2024-04-16 LTS
- wildfly-33.0.2.Final
- apache-maven-3.8.6

# WILDFLY JAKARTA
- WildFly versions 17 - 26 are Jakarta EE 8.
- WildFly Preview versions 22 - 26 are Jakarta EE 9.
- WildFly versions 27 - 33 (and Preview versions 27 - 30) are Jakarta EE 10.
- WildFly Preview versions 31 - 33 are Jakarta EE 11.

# CONFIGURE WILDFlY
```
# Create a User

	$ ./add-user.sh     # Select Manage User, leave groups blank and won't go to to be used for one AS process

# Admin Console

	$ curl http://127.0.0.1:9990
		# Deployments   >	MyProjects (jar, war, ear)
		# Configuration >	Subsystems  >	Datasources & Drivers   > Add Datasource
		# Runtime       >	Server      >	Monitor	> EJB (my ejb deploys on MyProjects)
```

# START WILDFlY
```
# From Wildfly Application Server
$ cd <WILDFLY_SERVER>/bin
$ ./standalone.sh

# After that the console will show the JNDI for the EJB ServiceEJB like this:
1:49:10,294 INFO  [org.jboss.as.ejb3.deployment] (MSC service thread 1-2) WFLYEJB0473: JNDI bindings for session bean named 'ServiceEJB' in deployment unit 'deployment "webapp-ejb.war"' are as follows:

	java:global/webapp-ejb/ServiceEJB!com.kevinpina.services.ServiceEJB
	java:app/webapp-ejb/ServiceEJB!com.kevinpina.services.ServiceEJB
	java:module/ServiceEJB!com.kevinpina.services.ServiceEJB
	java:global/webapp-ejb/ServiceEJB
	java:app/webapp-ejb/ServiceEJB
	java:module/ServiceEJB
	
	# above are the different ways of JNDI to look up the ServiceEJB. 
```

# START WILDFlY FROM MAVEN & DEPLOY
```
$ mvn wildfly:start  # Only start Wildfly does not deploy our war.
$ mvn wildfly:run    # Start Wildfly and deploy our war.
$ mvn wildfly:shutdown

$ mvn wildfly:deploy # Same as $ mvn wildfly:redeploy
$ mvn wildfly:undeploy
```

# RUN
```
$ curl http://localhost:8080/webapp-ejb/stateless
$ curl http://localhost:8080/webapp-ejb/statefull
$ curl http://localhost:8080/webapp-ejb/statefull_request_scope
$ curl http://localhost:8080/webapp-ejb/stateless_call_programmatically
$ curl http://localhost:8080/webapp-ejb/ejb_local
```
