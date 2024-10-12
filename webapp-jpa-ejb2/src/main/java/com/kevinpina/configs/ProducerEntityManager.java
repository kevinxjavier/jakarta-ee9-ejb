package com.kevinpina.configs;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@RequestScoped
/** 
 * @Dependent In CDI, classes annotated with @Dependent are "pseudo-scoped", what means:
 * 		- "No injected instance of the bean is ever shared between multiple injection points"
 *  	- Multiple instances can exist at the same time
 *  	- "Any instance of the bean injected into an object that is being created by the container is bound to the lifecycle of the newly created object."
 *  	- A "POJO" declared with @Dependent annotation and injected into a e.g. @Stateless or @RequestScoped bean has the same lifecycle as the corresponding bean.
 */
public class ProducerEntityManager {

	@PersistenceContext(name = "mysqlConnecion")
	private EntityManager entityManager;

	// Uses persistence.xml that use EntityManager
	@Produces
	@RequestScoped
	private EntityManager beanEntityManager() {
		return entityManager;
	}

	// Now the close() will be handle by Context Persistance JPA automatically after a commit in a method of @EJB or Transactional Method.
	/*public void close(@Disposes EntityManager entityManager) {
		if (entityManager.isOpen()) {
			entityManager.close();
			log.info("Closing connection automatically of EntityManager!");
		}
	}*/

}
