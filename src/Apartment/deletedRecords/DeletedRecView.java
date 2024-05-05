package Apartment.deletedRecords;

import Apartment.MainMenu;
import Apartment.models.DeletedRecords;
import Apartment.models.Guest;
import Apartment.util.Utility;

import java.util.List;
import java.util.Scanner;

public class DeletedRecView {
    private  static DeletedRecModel deletedRecModel;
    private static Scanner scanner;
    public DeletedRecView(){
        deletedRecModel=new DeletedRecModel(this);
    }

    public void init() {
        scanner=new Scanner(System.in);
        while(true){
            System.out.println("\1.View Record\n2.Search Record \n3.Back to main menu\n4.Logout");
            System.out.println("Enter your option:");
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    viewAllRecords();
                    break;
                case 2:
                    searchRecords();
                    break;
                case 3:
                    MainMenu mainMenu=new MainMenu();
                    mainMenu.init();
                    break;
                case 4:
                    Utility.showAlert("Logout Successfully");
                    System.exit(0);
                default:
                    Utility.showAlert("Invalid choice");
                    init();
                    break;
            }
        }
    }

    private void searchRecords() {
        scanner=new Scanner(System.in);
        System.out.println("Enter the Register_No ");
        int regno=scanner.nextInt();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| S_No | Register_No |   Name    | Block | House_NO | Address       | Vehicle_Details | Indate   | Intime      | Outdate    | Outtime  | Parking_slot |    Reason  |");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(deletedRecModel.searchRecords(regno));
    }

    private void viewAllRecords() {
        List<DeletedRecords> deletedRecords=deletedRecModel.viewAllRecords();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| S_No | Register_No |   Name    | Block | House_NO | Address       | Vehicle_Details | Indate   | Intime      | Outdate    | Outtime  | Parking_slot |    Reason  |");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (DeletedRecords records : deletedRecords) {
            System.out.println(records);
        }
    }
}
