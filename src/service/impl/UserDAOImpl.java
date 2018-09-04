package service.impl;

import db.MyHibernateFactory;
import hibernate.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.UserDAO;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean usersLongin(UsersEntity u) {
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
            query.setParameter(0, u.getUsername());
            query.setParameter(1, u.getPassword());
            List list = query.list();
            System.out.println("用户名:"+u.getUsername());
            System.out.println("密码:"+u.getPassword());
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
