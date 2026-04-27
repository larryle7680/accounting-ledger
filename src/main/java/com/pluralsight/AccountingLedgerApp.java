package com.pluralsight;
import java.util.*;
public class AccountingLedgerApp {
    //Creating a static Scanner to be able to access it through any method I created
    static Scanner theScanner = new Scanner(System.in);
    public static void main(String[] args) {
        homeScreen();
    }//End of Main Method

    public static void homeScreen(){
        //Create a boolean to keep the menu false
        //But when the menu is running the variable would change to true
        boolean isRunning = false;
        //Create a while loop for when the menu is running
        while(!isRunning){
            System.out.println();
            System.out.println("=== LarryLegend's Production ===");
            System.out.println();
            System.out.println("""
                Welcome to LarryLegend's Production
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠤⠶⢶⠦⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠿⠴⠾⣦⠀⠀⠀⢨⢷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡼⠁⠀⠀⠀⠈⠁⠀⠀⠈⠘⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⡂⠀⠀⠀⣀⣤⠖⠀⠀⠀⢹⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡞⠛⠓⠒⠚⠛⠒⠚⢻⣦⣠⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣜⣀⣀⣀⣀⣀⠀⢀⣠⠟⠉⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠁⢹⠛⣻⠿⢿⠛⠋⠀⣼⢻⣤⣀⣤⣤⡶⠶⢶⣤⡀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣈⣧⡹⣾⠭⠀⣠⣾⠃⢤⣿⠋⠀⠀⠀⠀⠀⠉⢹⡄⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠴⠒⠉⣽⣛⣧⢳⣌⣥⣼⣿⢃⣴⠞⣡⠆⠀⠀⠀⠀⠀⠀⠀⣷⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡇⠀⠀⠀⠀⠙⢿⣿⣿⢿⡿⠟⢋⡥⠞⠁⠀⠀⠀⠀⠀⠀⢀⣠⣿⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡆⠀⠀⠀⠀⡇⣀⣙⣿⠿⠖⠋⠉⠴⠚⠉⠛⠛⠀⠀⠀⣾⡿⠋⡇⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣧⠀⢀⣀⡴⠿⢿⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣿⠟⠀⢠⡇⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣠⠤⠶⠛⠛⠉⠉⠀⠀⠀⠹⣿⣷⣦⣄⠀⣀⣤⣠⣶⣿⣿⡟⠁⠀⢠⢿⡇⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡼⢋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣨⣿⣿⣿⣷⣿⣿⣿⡿⠋⡠⠀⢠⠏⣼⠃⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡤⠞⠉⢀⡼⢠⠔⠒⠒⢶⡶⠲⠶⢾⣿⣿⣿⣿⡿⠿⠿⡿⠟⠛⠿⣿⡷⠊⢠⡶⠁⡼⠃⠀⠀⠀
                ⠀⠀⠀⠀⠀⣀⣀⣠⣤⣤⣤⣤⢴⡟⣠⣴⣶⣋⠀⣾⠀⠀⠀⢸⣇⠀⠀⣀⣠⣬⣽⣿⣄⠀⠀⠀⢀⣤⠞⠉⢀⡴⠋⠀⡼⠀⠀⠀⠀⠀
                ⠀⢠⣴⣾⣿⣿⡿⠿⠿⢿⣯⣴⢟⣼⣿⣿⣿⣿⣷⣽⣷⣦⡄⠀⠙⢧⣰⣿⣿⠟⠋⠉⠻⣧⣤⣴⠟⠁⢀⠴⠋⠀⠀⢰⡇⠀⠀⠀⠀⠀
                ⣀⠘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠻⣿⣿⣷⣄⠀⠀⠘⢿⣅⣀⡀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀
                ⠈⠙⠻⢿⣳⢿⣯⣭⣿⣿⣿⣟⡛⢛⣿⣛⣿⢽⣟⣛⣿⣯⣿⣿⣿⣶⣶⣾⣿⣿⣿⣧⡀⠀⠀⠉⠻⢯⣝⣒⠦⢤⣀⠘⢆⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠉⠛⠾⣝⣿⣿⣿⣽⣿⣌⣿⣷⣿⡿⠿⣿⣿⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⢠⡄⣦⠀⣙⠯⣍⣽⣮⣍⠛⠓⠄⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠿⣿⣻⡿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣽⣿⣿⡇⣼⡇⣿⣆⠹⣷⣦⣽⣿⠟⠀⢀⣠⣤⣶⠿
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠶⢮⣍⡛⠛⠿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣿⣷⠽⠿⠗⢛⣋⣭⣴⣶⡿⠟⠛⠉⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠤⠴⠶⠛⠛⠋⠉⠁⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠶⢤⣀⣀⣀⣤⠶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                Please choose an option to navigate through the home screen.
                """);
            System.out.println();
            System.out.println("Press D: Add Deposit");
            System.out.println("Press P: Make a Payment");
            System.out.println("Press L: Display Ledger Screen");
            System.out.println("Press S: For a Surprise");
            System.out.println("Press X: Exit");
            System.out.println();
            System.out.println("What would you like to access?");
            String usersChoice = theScanner.nextLine();

            //Create if statement to sort through the option when chosen
            if(usersChoice.equalsIgnoreCase("d")){
                addDeposit();
                break;
            }




        }
    }//End of homeScreen method
    public static void addDeposit(){
        System.out.println();
        System.out.println("=== Adding Deposit ===");
        System.out.println();
        System.out.println("Please fill these out to add your deposit");
        System.out.println();
        System.out.println("What is date of this transaction? In this format (yyyy-mm-dd)");
        String dateInput = theScanner.nextLine();
        System.out.println("What is the time of this transaction? In this format (hh:mm:ss)");
        String timeInput = theScanner.nextLine();
        System.out.println("What is the description of this transaction?");
        String descriptionInput = theScanner.nextLine();
        System.out.println("Who was the vendor for this transaction?");
        String vendorInput = theScanner.nextLine();
        System.out.println("What was price of this transaction?");
        double priceInput = theScanner.nextDouble();


    }










}//End of AccountingLedgerApp Class
