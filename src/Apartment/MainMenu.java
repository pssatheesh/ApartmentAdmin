package Apartment;

import Apartment.dailyRegister.RegisterView;
import Apartment.deletedRecords.DeletedRecView;
import Apartment.guest.GuestView;
import Apartment.login.LoginView;
import Apartment.tenant.TenantView;

import java.util.Scanner;

public class MainMenu {
    private static MainMenu mainMenu;
    private Scanner scanner=new Scanner(System.in);
     public MainMenu getInstance(){
         if(mainMenu==null){
             mainMenu=new MainMenu();
         }
         return mainMenu;
     }
     public void init(){
         System.out.println("Main Menu");
         while(true){
             System.out.println("1.Daily Entry\n2.Tenant\n3.Guest \n4.View Deleted Records\n5.Logout \n6.Exit");
             System.out.println("Enter the choice: ");
             int choice=scanner.nextInt();
             switch (choice){
                 case 1:
                     RegisterView registerView=new RegisterView();
                     registerView.start();
                     break;
                 case 2:
                     TenantView tenantView=new TenantView();
                     tenantView.start();
                     break;
                 case 3:
                     GuestView guestView=new GuestView();
                     guestView.init();
                     break;
                 case 4:
                     DeletedRecView deletedRecView=new DeletedRecView();
                     deletedRecView.init();
                     break;
                 case 5:
                     System.out.println("Logout Successfully");
                     submenu();
                     break;
                 case 6:
                     System.out.println("Exit the app");
                     System.exit(0);
                 default:
                     System.out.println("Invalid choice");
                     init();

             }
         }
     }
    public void submenu(){
        System.out.println("1.Login\n2.Exit");
        System.out.println("Enter your choice");
        int choice=scanner.nextInt();
        switch (choice){
            case 1:
                LoginView loginView=new LoginView();
                loginView.loginCode();
                break;
            case 2:
                System.out.println("Exit the app");
                System.exit(0);
            default:
                System.out.println("Invalid choice");
                submenu();
        }
    }
}
