package Apartment.dailyRegister;

import Apartment.MainMenu;
import Apartment.models.Guest;
import Apartment.models.Register;
import Apartment.models.Tenant;

import java.util.List;
import java.util.Scanner;


public class RegisterView {
    private static RegisterModel registerModel;
    private Scanner scanner;
    public RegisterView(){
        registerModel=new RegisterModel(this);
    }
    public void start(){
        scanner=new Scanner(System.in);
        while(true){
            System.out.println("\n1.Add Tenant to register\n2.View Registry\n3.Search Tenant to registry \n4.Update In details \n5.Back to main menu\n6.Logout");
            System.out.println("Enter your option:");
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    addDetails();
                    break;
                case 2:
                    //View
                    viewregistry();
                    break;
                case 3:
                    //Search
                    searchdetails();
                    break;
                case 4:
                    //Update
                    updateIntime();
                    break;
                case 5:
                    MainMenu mainMenu=new MainMenu();
                    mainMenu.init();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }

    private void updateIntime() {
        scanner=new Scanner(System.in);
        System.out.println("Enter the Vehicle details");
        String vehicle=scanner.next();
        registerModel.updateIntime(vehicle);
    }


    private void viewregistry() {
        List<Register> registryDetails=registerModel.viewRegistry();
        System.out.println("______________________________________________________________________________________________________");
        System.out.println("| S_No | Register_No | Name  | Vehicle_details | Outdate    | Outtime     | Indate     | Intime      |");
        System.out.println("______________________________________________________________________________________________________");
        for (Register datas : registryDetails) {
            System.out.println(datas);
        }
    }

    private void addDetails() {
        scanner=new Scanner(System.in);
        System.out.println("Enter the Vehicle details");
        String vehicle=scanner.next();
        registerModel.addDetails(vehicle);
    }
    private void searchdetails() {
        scanner=new Scanner(System.in);
        System.out.println("Enter the Vehicle_details ");
        String vehicle=scanner.next();

        System.out.println("______________________________________________________________________________________________________");
        System.out.println("| S_No | Register_No | Name  | Vehicle_details | Outdate    | Outtime     | Indate     | Intime      |");
        System.out.println("______________________________________________________________________________________________________");
        System.out.println(registerModel.searchRegister(vehicle));
    }

}
