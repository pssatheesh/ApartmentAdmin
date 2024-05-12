package Apartment.login;

import Apartment.MainMenu;
import Apartment.datas.LoginDetails;
import Apartment.util.Utility;



public class LoginModel {
    private LoginView loginView;
    private MainMenu mainMenu=new MainMenu();
    private LoginDetails loginDetails=new LoginDetails();

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
        if(loginDetails.isValidateCredential(user, pass)){
            return true;
        }
        return false;
    }

    private boolean isValidateUser(String user){
        if(loginDetails.isValidateUser(user)){
            return true;
        }
        return false;
    }
}
