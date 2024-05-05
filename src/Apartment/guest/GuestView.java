package Apartment.guest;

import Apartment.MainMenu;
import Apartment.models.Guest;
import Apartment.util.Utility;

import java.util.List;
import java.util.Scanner;


public class GuestView {
    private GuestModel guestModel;
    public GuestView(){
        guestModel=new GuestModel(this);
    }
    public void init(){
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("\n1.Add Guest\n2.View Guest\n3.Search Guest \n4.Update Outtime \n5.Back to main menu\n6.Logout");
            System.out.println("Enter your option:");
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    addGuestdetails();
                    break;
                case 2:
                    viewAllGuest();
                    break;
                case 3:
                    searchGuest();
                    break;
                case 4:
                    updateOutTime();
                    break;
                case 5:
                    MainMenu mainMenu=new MainMenu();
                    mainMenu.init();
                    break;
                case 6:
                    Utility.showAlert("Logout Successfully");
                    System.exit(0);
                default:
                    Utility.showAlert("Invalid choice");
                    init();
                    break;
            }
        }
    }

    private void updateOutTime() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Vehicle Details");
        String vehicle=scanner.next();
        guestModel.updateOut(vehicle);
    }

    private void viewAllGuest() {
        List<Guest> guestdetails=guestModel.viewAllGuest();
        System.out.println("________________________________________________________________________________________________________________________________");
        System.out.println("| S_No | Vehicle_details | Block | House_NO | Indate     | Intime      | Outdate    | Outtime  | Parking_slot | Reason         |");
        System.out.println("________________________________________________________________________________________________________________________________");
        for (Guest guest : guestdetails) {
            System.out.println(guest);
        }
    }

    private void searchGuest() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Vehicle_details ");
        String vehicle=scanner.next();
        System.out.println("_________________________________________________________________________________________________________________________________");
        System.out.println("| S_No | Vehicle_details | Block | House_NO | Indate     | Intime      | Outdate    | Outtime  | Parking_slot | Reason          |");
        System.out.println("_________________________________________________________________________________________________________________________________");
        System.out.println(guestModel.searchGuest(vehicle));
    }


    private void addGuestdetails() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Vehicle_details ");
        String vehicle= scanner.next();
        System.out.println("Enter the Block");
        String block=scanner.next();
        System.out.println("Enter the House_No");
        String house= scanner.next();
        System.out.println("Enter the parking_slot");
        String parking_slot= scanner.next();
        System.out.println("Enter the Reason:");
        scanner.nextLine();
        String reason=scanner.nextLine();
        guestModel.addGuest(vehicle, block, house, parking_slot,reason);
    }
}
