package jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory = null;

	private static final String UNIT_NAME = "Pweb";

	private static synchronized void loadInstance() {
		if (factory == null) {
			try {

				factory = Persistence.createEntityManagerFactory(UNIT_NAME);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static EntityManager getEntityManager() {
		if (factory == null) {
			loadInstance();
		}

		return factory.createEntityManager();
	}

}