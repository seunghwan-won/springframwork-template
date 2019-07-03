import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import seunghwan.won.config.ApplicationConfig;
import seunghwan.won.dao.TestDataDao;

import static org.junit.Assert.assertNotNull;

public class TestDB {
    @Test
    public void init() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        TestDataDao dao = ac.getBean(TestDataDao.class);
        assertNotNull(dao.selectAll());
        System.out.println(dao.selectAll());
    }
}
