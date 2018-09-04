package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateFactory {

    //定义会话工厂
    private static SessionFactory sessionFactory;

    //定义私有化构造方法,保证单例模式
    private MyHibernateFactory() {
    }

    //公有静态方法,返回会话工厂
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            //初始化配置
            Configuration configuration = new Configuration().configure();
            //创建服务
//            ServiceRegistry serviceRegistry =
//                    new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//            sessionFactory=configuration.buildSessionFactory(serviceRegistry);
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                    .buildServiceRegistry();
            //这句漏掉了,导致不能创建服务
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;

        }else {
            return sessionFactory;
        }
    }
}
