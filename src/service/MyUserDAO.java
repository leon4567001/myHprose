package service;

import db.MyHibernateFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MyUserDAO {
    public boolean myLogin(String u,String p){
        //初始化事务
        Transaction tx = null;
        //初始化查询语句
        String hql = "";

        try {
            //获得会话
            Session session = MyHibernateFactory.getSessionFactory().getCurrentSession();
            //Session session = MyHibernateFactory.getSessionFactory().openSession();
            //开始事务
            tx = session.beginTransaction();
            // hql语句,?为占位符
            hql = "from UsersEntity where username=? and password=?";
            //创建query对象并传入hql语句
            Query query = session.createQuery(hql);
            // 传入占位符参数,序号从0开始,传入后返回一个结果集
            query.setParameter(0,u);
            query.setParameter(1, p);
            List list = query.list();
            //提交事务
            tx.commit();
            //判断是否查询到了数据
            if (list.size() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("发生异常:" + e.toString());//sout
            return false;
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
    }
}
