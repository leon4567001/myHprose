package service;

public class HproseValidate {
    public String validate(String u,String p){
        MyUserDAO myUserDAO = new MyUserDAO();
        if(myUserDAO.myLogin(u,p)){
            return "success";
        }else{
            return "failure";
        }
    }
}
