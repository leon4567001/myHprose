package service;


import hibernate.UsersEntity;

public interface UserDAO {
    //用户登陆方法
    public boolean usersLongin(UsersEntity u);
}
