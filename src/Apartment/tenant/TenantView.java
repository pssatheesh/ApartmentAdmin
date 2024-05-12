package Apartment.tenant;

import Apartment.MainMenu;
import Apartment.login.LoginView;
import Apartment.models.Guest;
import Apartment.models.Tenant;
import Apartment.util.Utility;

import java.util.List;
import java.util.Scanner;


public class TenantView {
    private TenantModel tenantModel;
    private LoginView loginView;
    private Scanner scanner;
    public TenantView(){
        tenantModel=new TenantModel(this);
    }
    public void start(){
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("\n1.Add Tenant\n2.View Tenant\n3.Search Tenant \n4.Update Tenant details\n5.Delete Tenant details\n6.Update Outtime \n7.Back to main menu\n8.Logout");
            System.out.println("Enter your option:");
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    addTenantdetails();
                    break;
                case 2:
                    viewAllTenant();
                    break;
                case 3:
                    searchTenant();
                    break;
                case 4:
                    //update details
                    updateTenant();
                    break;
                case 5:
                    //DeleteTenant
                    deleteTenant();
                    break;
                case 6:
                    //Update Outtime
                    updateTenantOuttime();
                    break;
                case 7:
                    MainMenu mainMenu=new MainMenu();
                    mainMenu.init();
                    break;
                case 8:
                    System.out.println("Logout Successfully");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    start();
                    break;
            }
        }
    }

    private void updateTenantOuttime() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Register Number");
        int regno=scanner.nextInt();
        tenantModel.updateOut(regno);
    }

    private void updateTenant() {
        scanner=new Scanner(System.in);
        System.out.println("Enter the Register_No:");
        int regno=scanner.nextInt();
        System.out.println("1.Update Name\n2.Block\n3.House_No\n4.Address\n5.Vehicle_Details\n6.Back to Mainmenu");
        System.out.println("\nEnter the choice:");
        int choice=scanner.nextInt();
        String column="";
        switch(choice){
            case 1:
                column="Name";
                break;
            case 2:
                column="Block";
                break;
            case 3:
                column="House_No";
                break;
            case 4:
                column="Address";
                break;
            case 5:
                column="Vehicle_details";
                break;
            case 6:
                start();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
        System.out.println("Enter the data");
        String data=scanner.next();
        tenantModel.update(regno, column, data);

    }


    private void viewAllTenant() {
        List<Tenant> tenantdetails=tenantModel.viewAllTenant();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| S_No | Register_No |   Name    | Block | House_NO | Address       | Vehicle_Details | Indate   | Intime      | Outdate    | Outtime  | Parking_slot | ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Tenant t : tenantdetails) {
            System.out.println(t);
        }
    }

    private void addTenantdetails() {
        scanner=new Scanner(System.in);
        System.out.println("Enter the Register_No");
        int regno=scanner.nextInt();
        System.out.println("Enter the Name");
        String name=scanner.next();
        System.out.println("Enter the Block");
        String block=scanner.next();
        System.out.println("Enter the House_No");
        String house= scanner.next();
        System.out.println("Enter the Address:");
        scanner.nextLine();
        String address=scanner.nextLine();
        System.out.println("Enter the Vehicle_details ");
        String vehicle= scanner.next();
        System.out.println("Enter the parking_slot");
        String parking_slot= scanner.next();
        tenantModel.addTenant(regno, name,block,house, address, vehicle, parking_slot);

    }

    private void searchTenant() {
        scanner=new Scanner(System.in);
        System.out.println("Enter the Register_No ");
        int regno=scanner.nextInt();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| S_No | Register_No |   Name    | Block | House_NO | Address       | Vehicle_Details | Indate   | Intime      | Outdate    | Outtime  | Parking_slot | ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(tenantModel.searchTenant(regno));
    }

    private void deleteTenant() {
        scanner=new Scanner(System.in);
        System.out.println("Enter the Register_No ");
        int regno=scanner.nextInt();
        System.out.println("Enter the Reason ");
        scanner.nextLine();
        String reason=scanner.nextLine();
        int res=tenantModel.deleteTenant(regno, reason);
        if(res>=1){
            Utility.showAlert("Tenant details deleted");
        }else{
            Utility.showAlert("Detail are not deleted");
        }
    }
}
