package oop.Quiz_class_01;

public class PasswordManager {

    private String password;

    PasswordManager(String password){
        this.password = password;
    }

    public boolean changePassword(String oldpw, String newpw){
        if(oldpw.equals(this.password) && !newpw.equals(this.password)){
            this.password = newpw;
            return true;
        }else
            return false;
    }
}
