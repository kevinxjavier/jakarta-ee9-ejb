## EJB - "Local" (EJBLocal)
* feature/01_ejb_local
	- Type file: war
	- Explain: @Local, @Statefull, @Stateless, (@EJB, @Inject and Programmatically)

## EJB - "Remote" (EJBRemote)
* feature/02_ejb_remote
	- Type file: jar
	- Explain: @Remote

## EJB - "Remote" (webapp-ear-module)
* feature/03_ejb_in_modularized
	- Type file: ear (contains ejb, war)
	- Explain: DataSource in Wildfly Server, @Local, @WebServlet, @Inject, JPA

## EJB - "Remote" (webapp-jpa-ejb)
* feature/04_ejb_migrating_jakarta-ee9.jakarta-ee9-webapp-cdi
	- Type file: ear (contains ejb, war)
	- Explain: DataSource in Wildfly Server, @Local, @WebServlet, @Inject, JPA

## EJB - "Remote" (webapp-jpa-ejb2)
* feature/05_ejb_migrating_jakarta-ee9.jakarta-ee9-webapp-cdi_separating_entity_manager
	- Type file: ear (contains ejb, war)
	- Explain: DataSource in Wildfly Server, @Local, @WebServlet, @Inject, JPA, Separating EntityManager and manage by the Context JPA the closing
