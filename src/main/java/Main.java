import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import template.JPAUtil;
import template.domain.ConfigEnum;
import template.domain.User;

import javax.persistence.EntityManager;
import java.util.Date;


/**
 * Created by Michael Sta. Helena on 30/05/2017.
 */
public class Main {
    protected static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        // Check database version
        String sql = "select version()";

        String result = (String) entityManager.createNativeQuery(sql).getSingleResult();
        System.out.println(result);

        User user = new User();
        user.setConfig(ConfigEnum.MASTER);
        user.setTimestamp(new Date());

        entityManager.persist(user);
        logger.info("USERID: " + user.getId());

        User user2 = new User();
        user2.setConfig(ConfigEnum.ROOT);
        user2.setTimestamp(new Date());

        entityManager.persist(user2);
        logger.info("USERID: " + user2.getId());

        entityManager.getTransaction().commit();
        entityManager.close();

        JPAUtil.close();
    }
}
