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

# START WILDFlY
```
# From Wildfly Application Server
$ cd <WILDFLY_SERVER>/bin
$ ./standalone.sh

# After that the console will show the JNDI for the EJB ServiceEJB like this:
14:48:14,140 INFO  [org.jboss.as.repository] (management-handler-thread - 1) WFLYDR0001: Content added at location /opt/wildfly-33.0.2.Final/standalone/data/content/73/84c0cc07502d5877f9bc5b72098fa74e1632ea/content
14:48:14,324 INFO  [org.jboss.as.server.deployment] (MSC service thread 1-1) WFLYSRV0028: Stopped deployment app-ejb.jar (runtime-name: app-ejb.jar) in 169ms
14:48:14,345 INFO  [org.jboss.as.server.deployment] (MSC service thread 1-1) WFLYSRV0027: Starting deployment of "app-ejb.jar" (runtime-name: "app-ejb.jar")
14:48:14,454 INFO  [org.jboss.weld.deployer] (MSC service thread 1-8) WFLYWELD0003: Processing weld deployment app-ejb.jar
14:48:14,641 INFO  [org.jboss.as.ejb3.deployment] (MSC service thread 1-8) WFLYEJB0473: JNDI bindings for session bean named 'ServiceEJBRemoteImpl' in deployment unit 'deployment "app-ejb.jar"' are as follows:

	java:global/app-ejb/ServiceEJBRemoteImpl!com.kevinpina.services.ServiceEJBRemote
	java:app/app-ejb/ServiceEJBRemoteImpl!com.kevinpina.services.ServiceEJBRemote
	java:module/ServiceEJBRemoteImpl!com.kevinpina.services.ServiceEJBRemote
	java:jboss/exported/app-ejb/ServiceEJBRemoteImpl!com.kevinpina.services.ServiceEJBRemote
	ejb:/app-ejb/ServiceEJBRemoteImpl!com.kevinpina.services.ServiceEJBRemote
	java:global/app-ejb/ServiceEJBRemoteImpl
	java:app/app-ejb/ServiceEJBRemoteImpl
	java:module/ServiceEJBRemoteImpl

14:48:15,524 INFO  [org.jboss.as.server] (management-handler-thread - 1) WFLYSRV0016: Replaced deployment "app-ejb.jar" with deployment "app-ejb.jar"
	
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

# WILDFLY - Admin Console
```
$ curl http://127.0.0.1:9990
```

# INSTALL
```
$ mvn clean install
$ mvn clean install -U  # -U means force update of snapshot dependencies
```
