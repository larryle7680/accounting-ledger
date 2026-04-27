package com.pluralsight;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class AccountingLedgerApp {
    //Creating a static Scanner to be able to access it through any method I created
    static Scanner theScanner = new Scanner(System.in);
    //Create and empty static Array List to input stuff into your object
    static ArrayList<Transactions>transactions = new ArrayList<>();

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
            if(usersChoice.equalsIgnoreCase("D")){
                addDeposit();
                break;
            }else if (usersChoice.equalsIgnoreCase("P")){
                makePayment();
                break;
            }




        }
    }//End of homeScreen method
    public static void addDeposit(){
        //Make this menu into a while loop
        boolean isRunning = false;
        while(!isRunning) {
            //Prompt users questions and store their input
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
            System.out.println();

            //Reflect users input to see if they added the correct input
            System.out.printf("""
                    You added:
                    Date: %s
                    Time: %s
                    Description: %s
                    Vendor: %s
                    Price: $%.2f
                    
                    Is this correct? Press Y or N
                    """, dateInput, timeInput, descriptionInput, vendorInput, priceInput);

            //Eat a line
            theScanner.nextLine();
            String yesNo = theScanner.nextLine();

            //Create a FileWriter and BufferedWriter to add to the csv file
            FileWriter fileWriter = null;
            if (yesNo.equalsIgnoreCase("y")) {
                try {
                    File file = new File("src/main/resources/transaction.csv");
                    boolean header = !file.exists() || file.length() == 0;
                    fileWriter = new FileWriter("src/main/resources/transaction.csv", true);
                    BufferedWriter bufWriter = new BufferedWriter(fileWriter);

                    if(header){
                        bufWriter.write("=== LarryLegend's Ledger ===");
                        bufWriter.write("Date|Time|Description|Vendor|Price");
                    }

                    bufWriter.write(dateInput + "|" + timeInput + "|" + descriptionInput + "|" + vendorInput + "|" + priceInput +"\n");

                    bufWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else {
                System.out.println();
                System.out.println("Please try again.");
                System.out.println();
                addDeposit();
            }
            System.out.println("Would you like to add another? Y or N");
            String addAnother = theScanner.nextLine();
            if(addAnother.equalsIgnoreCase("Y")){
                addDeposit();
            }else{
                return;
            }

        break;
        }
    }//End of addDeposit method
    public static void makePayment(){
        boolean isRunning = false;
        while(!isRunning) {
            System.out.println("=== Make A Payment ===");
            System.out.println();
            System.out.println("Who's the payment to?");
            String payee = theScanner.nextLine();
            System.out.println("What's the payment for?");
            String forPayment = theScanner.nextLine();
            System.out.println("Price of Product/Service");
            double productPrice = theScanner.nextDouble();

            //Eat the line
            theScanner.nextLine();

            System.out.println("Please enter Card holder's name");
            String nameCard = theScanner.nextLine();
            System.out.println("Please enter Debit/Credit card number");
            String cardNum = theScanner.nextLine();
            System.out.println();
            System.out.printf("""
                    You entered:
                    
                    Payee: %s
                    Description: %s
                    Cost: $%.2f
                    Card Holder Name: %s
                    Card Number: %s
                    """, payee, forPayment, productPrice, nameCard, cardNum);
            System.out.println();
            System.out.println("Is this correct? Y or N");
            String yesOrNo = theScanner.nextLine();

            //Add LocalDate and LocalTime because when paying it should automatically show up on time of payment
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();

            DateTimeFormatter newDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter newTime = DateTimeFormatter.ofPattern("HH:mm:ss");

            FileWriter fileWriter = null;
            if (yesOrNo.equalsIgnoreCase("y")) {
                try {
                    File file = new File("src/main/resources/transaction.csv");
                    boolean header = !file.exists() || file.length() == 0;
                    fileWriter = new FileWriter("src/main/resources/transaction.csv", true);
                    BufferedWriter bufWriter = new BufferedWriter(fileWriter);

                    if(header){
                        bufWriter.write("=== LarryLegend's Ledger ===");
                        bufWriter.write("Date|Time|Description|Vendor|Price");
                    }

                    bufWriter.write(newDate + "|" + newTime + "|" + forPayment + "|" + payee + "|" + productPrice +"\n");

                    bufWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else {
                System.out.println();
                System.out.println("Please try again.");
                System.out.println();
                makePayment();
            }
            System.out.println("Would you like to add another? Y or N");
            String addAnother = theScanner.nextLine();
            if(addAnother.equalsIgnoreCase("Y")){
                makePayment();
            }else{
                return;
            }

            break;

            }
        }
    }










}//End of AccountingLedgerApp Class
