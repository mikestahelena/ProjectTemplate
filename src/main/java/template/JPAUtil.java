package template;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Michael Sta. Helena on 30/05/2017.
 */
public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static void close() {
        if (factory != null) {
            factory.close();
        }
    }
}
