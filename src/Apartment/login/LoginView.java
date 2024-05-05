package Apartment.login;

import java.util.Scanner;

public class LoginView {
    private LoginModel loginModel;
    public LoginView(){
        loginModel=new LoginModel(this);
    }
    public void loginCode(){

        System.out.println("Proceed to login");
        proceedToLogin();
    }

    private void proceedToLogin() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Username");
        String user=scanner.next();
        System.out.println("Enter the password");
        String pass=scanner.next();
        loginModel.validate(user, pass);
    }


}
