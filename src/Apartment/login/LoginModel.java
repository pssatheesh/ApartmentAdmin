package Apartment.login;

import Apartment.MainMenu;
import Apartment.database.DbCode;
import Apartment.guest.GuestView;
import Apartment.util.Utility;

public class LoginModel {
    private LoginView loginView;
    private MainMenu mainMenu=new MainMenu();

    public LoginModel(LoginView loginView){
        this.loginView=loginView;
    }

    public void validate(String user, String pass) {
        if(isValidateUser(user)){
            if(isValidateCredential(user, pass)){
                mainMenu.init();
            }else{
                Utility.showAlert("Invalid password");
            }
        }else{
            Utility.showAlert("Invalid username");
        }
    }

    private boolean isValidateCredential(String user, String pass) {
        if(DbCode.getInstance().isValidateCredential(user, pass)){
            return true;
        }
        return false;
    }

    private boolean isValidateUser(String user){
        if(DbCode.getInstance().isValidateUser(user)){
            return true;
        }
        return false;
    }
}
