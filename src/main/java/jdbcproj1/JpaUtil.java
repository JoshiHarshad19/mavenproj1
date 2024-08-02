package jdbcproj1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;
	static {
		factory = Persistence.createEntityManagerFactory("JPA-PU");
	}
	public static EntityManager getEntityManager() {
		if(entityManager==null||!entityManager.isOpen()) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	public static void cleanup() {
		entityManager.close();
		factory.close();
	}
}