package com.pluralsight;
import java.io.*;
import java.sql.Array;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class AccountingLedgerApp {
    //Creating a static Scanner to be able to access it through any method I created
    static Scanner theScanner = new Scanner(System.in);
    //Create and empty static Array List to input stuff into your object
    static ArrayList<Transactions>transactions = new ArrayList<>();
    static LocalDate date = LocalDate.now();

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
            }else if (usersChoice.equalsIgnoreCase("L")) {
                ledger();
                break;
            }else if(usersChoice.equalsIgnoreCase("S")){
                surprise();
                break;
            }else if(usersChoice.equalsIgnoreCase("X")){
                return;
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
                homeScreen();
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
            //Reformat it to fit the template and create it into a string to file into the csv
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String timeText = LocalTime.now().format(timeFormatter);
            String dayText = LocalDate.now().format(dateFormatter);

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

                    bufWriter.write(dayText + "|" + timeText + "|" + forPayment + "|" + payee + "|" + "-" + productPrice +"\n");

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
                homeScreen();
            }

            break;

            }
        }//End of MakePayment method
    public static void ledger(){
        ArrayList<Transactions> transactions = getTransactions();
        boolean isRunning = false;
        while(!isRunning) {
            //Prompt the questions to navigate through menu
            System.out.println("=== LarryLegend's Ledger Menu ===");
            System.out.println();
            System.out.println("Please choose an option to navigate through the menu.");
            System.out.println();
            System.out.println("Press A: Display All Entries");
            System.out.println("Press D: View the Deposits");
            System.out.println("Press P: View the Payments");
            System.out.println("Press R: Custom Search");
            System.out.println("Press X: To Exit Ledger Menu");
            //Store their input
            String usersInput = theScanner.nextLine();
            if (usersInput.equalsIgnoreCase("A")) {
                System.out.println("=== Diplaying all Entries ===");
                System.out.println();
                for (int i = 0; i < transactions.size(); i++) {
                    Transactions t = transactions.get(i);
                    System.out.printf("Date: %s| Time: %s| Description: %s| Vendor: %s| Amount: $%.2f\n", t.getDate(),
                            t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                }
            } else if (usersInput.equalsIgnoreCase("D")) {
                System.out.println("=== Displaying all Deposits ===");
                System.out.println();
                for (int i = 0; i < transactions.size(); i++) {
                    Transactions t = transactions.get(i);
                    if (t.getAmount() > 0) {
                        System.out.printf("Date: %s| Time: %s| Description: %s| Vendor: %s| Amount: $%.2f\n",
                                t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                    }
                }
            } else if (usersInput.equalsIgnoreCase("P")) {
                System.out.println("=== Displaying all Payments ===");
                System.out.println();
                for (int i = 0; i < transactions.size(); i++) {
                    Transactions t = transactions.get(i);
                    if (t.getAmount() < 0) {
                        System.out.printf("Date: %s| Time: %s| Description: %s| Vendor: %s| Amount: $%.2f\n",
                                t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                    }
                }
            } else if(usersInput.equalsIgnoreCase("R")){
                search();
            }else if(usersInput.equalsIgnoreCase("X")){
                isRunning = false;
            }


        }
    }//End of ledger method
    public static ArrayList<Transactions> getTransactions(){
        //create a file reader to read through the csv files of transaction
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/main/resources/transaction.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            //Skip the first 2 lines for headers
            bufReader.readLine();
            bufReader.readLine();

            //add a variable for line so it can read
            String line;
           //Use a while loop to read through the files
            while((line = bufReader.readLine()) != null){
                //Split the data into its designated variables
                String[] lineParts = line.split("\\|");
                //Parse the Date and Time into an actual date/time
                LocalDate datePart = LocalDate.parse(lineParts[0]);
                LocalTime timePart = LocalTime.parse(lineParts[1]);
                String descriptionPart = lineParts[2];
                String vendorParts = lineParts[3];
                double priceParts = Double.parseDouble(lineParts[4]);

                //Add them into the empty Array
                Transactions transaction = new Transactions(datePart,timePart,descriptionPart,vendorParts,priceParts);
                //Store them into transaction ArrayList
                transactions.add(transaction);
                //Sort them the now to show the newest entries first
                //Comparator.comparing is a java tool
                //In the comparing tool argument
                //For each object in Transaction compare using getDate values
                transactions.sort(Comparator.comparing(Transactions::getDate));
            }
            bufReader.close();
        } catch (Exception e) {
            System.out.println("Can't find the file.");
            throw new RuntimeException(e);
        }


        return transactions;
    }//End of getTransaction method
    public static void search(){

        //Create a sub menu for searching the reports
        boolean isRunning = false;
        //Prompt users choice and store their answer to use later
        while(!isRunning) {
            System.out.println("=== Custom Search ===");
            System.out.println();
            System.out.println("Press 1: Month to Date");
            System.out.println("Press 2: Previous Month");
            System.out.println("Press 3: Year to Date");
            System.out.println("Press 4: Previous Year");
            System.out.println("Press 5: Search by Vendor");
            System.out.println("Press 6: For more Options");
            System.out.println("Press 0: Back");
            System.out.println("Press H: For Home");
            System.out.println();
            int usersChoice = theScanner.nextInt();
//            //Eat the line
//            theScanner.nextLine();
            String usersChoiceS = theScanner.nextLine();

            //Create a conditional for "H" to go back home
            if(usersChoiceS.equalsIgnoreCase("H")){
                isRunning = false;
            }

            //Create a switch statement for the numbers
            switch(usersChoice) {
                case 0:
                    ledger();
                    break;
                case 1:
                    System.out.println("Please type in a month");
                    String monthSearch = theScanner.nextLine();
                    //Iterate through the list
                    for (int i = 0; i < transactions.size(); i++) {
                         Transactions t = transactions.get(i);
                        //Converted the date to a string to compare
                        //Get month from the getDate
                        //value of is a java tool that assigns the month to its respective number
                        String monthName = String.valueOf(t.getDate().getMonth());
                        if (monthSearch.equalsIgnoreCase(monthName)) {
                            System.out.printf("Date: %s| Time: %s| Description: %s| Vendor: %s| Amount: $%.2f\n",
                                    t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                        }
                    }
                    break;
                case 2:

                    String previousMonth = String.valueOf(date.minusMonths(1).getMonth());
                    //loop through the ArrayList to find previous month transactions
                    for (int i = 0; i < transactions.size(); i++) {
                        Transactions t = transactions.get(i);
                        String monthName = t.getDate().getMonth().toString();
                        if (previousMonth.equalsIgnoreCase(monthName)) {
                            System.out.printf("Date: %s| Time: %s| Description: %s| Vendor: %s| Amount: $%.2f\n",
                                    t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                        }
                    }
                break;
                case 3:
                    System.out.println("Please type in a year");
                    String yearSearch = theScanner.nextLine();
                    //Iterate through the list
                    for (int i = 0; i < transactions.size(); i++) {
                        Transactions t = transactions.get(i);
                        //Converted the date to a string to compare
                        //Get year from the getDate
                        //value of is a java tool that assigns the month to its respective number
                        String yearName = String.valueOf(t.getDate().getYear());
                        if (yearSearch.equalsIgnoreCase(yearName)) {
                            System.out.printf("Date: %s| Time: %s| Description: %s| Vendor: %s| Amount: $%.2f\n",
                                    t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                        }
                    }
                    break;
                case 4:
                    String previousYear = String.valueOf(date.minusYears(1).getYear());
                    //loop through the ArrayList to find previous month transactions
                    for (int i = 0; i < transactions.size(); i++) {
                        Transactions t = transactions.get(i);
                        //Couldn't use .toString() because int doesn't have this method.
                        String yearName = String.valueOf(t.getDate().getYear());
                        if (previousYear.equalsIgnoreCase(yearName)) {
                            System.out.printf("Date: %s| Time: %s| Description: %s| Vendor: %s| Amount: $%.2f\n",
                                    t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                        }
                    }
                    break;
                case 5:
                    System.out.println("=== Search By Vendor ===");
                    System.out.println();
                    System.out.println("Please Enter The Vendor's Name");
                    String vendorsName = theScanner.nextLine();
                    System.out.println();
                    for(int i = 0; i < transactions.size(); i++){
                        Transactions t = transactions.get(i);
                        if(vendorsName.equalsIgnoreCase(t.getVendor())){
                            System.out.printf("Date: %s| Time: %s| Description: %s| Vendor: %s| Amount: $%.2f\n",
                                    t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                        }
                    }
                    break;
                case 6:
                    nextMenu();
                    break;
            }


        }
    }//End of search method
    public static void surprise(){
        System.out.println("░░░░░░▄▄▄▄▀▀▀▀▀▀▀▀▄▄▄▄▄▄▄\n" +
                "░░░░░█░░░░░░░░░░░░░░░░░░▀▀▄\n" +
                "░░░░█░░░░░░░░░░░░░░░░░░░░░░█\n" +
                "░░░█░░░░░░▄██▀▄▄░░░░░▄▄▄░░░░█\n" +
                "░▄▀░▄▄▄░░█▀▀▀▀▄▄█░░░██▄▄█░░░░█\n" +
                "█░░█░▄░▀▄▄▄▀░░░░░░░░█░░░░░░░░░█\n" +
                "█░░█░█▀▄▄░░░░░█▀░░░░▀▄░░▄▀▀▀▄░█\n" +
                "░█░▀▄░█▄░█▀▄▄░▀░▀▀░▄▄▀░░░░█░░█\n" +
                "░░█░░░▀▄▀█▄▄░█▀▀▀▄▄▄▄▀▀█▀██░█\n" +
                "░░░█░░░░██░░▀█▄▄▄█▄▄█▄▄██▄░░█\n" +
                "░░░░█░░░░▀▀▄░█░░░█░█▀█▀█▀██░█\n" +
                "░░░░░▀▄░░░░░▀▀▄▄▄█▄█▄█▄█▄▀░░█\n" +
                "░░░░░░░▀▄▄░░░░░░░░░░░░░░░░░░░█\n" +
                "░░▐▌░█░░░░▀▀▄▄░░░░░░░░░░░░░░░█\n" +
                "░░░█▐▌░░░░░░█░▀▄▄▄▄▄░░░░░░░░█\n" +
                "░░███░░░░░▄▄█░▄▄░██▄▄▄▄▄▄▄▄▀\n" +
                "░▐████░░▄▀█▀█▄▄▄▄▄█▀▄▀▄\n" +
                "░░█░░▌░█░░░▀▄░█▀█░▄▀░░░█\n" +
                "░░█░░▌░█░░█░░█░░░█░░█░░█\n" +
                "░░█░░▀▀░░██░░█░░░█░░█░░█\n" +
                "░░░▀▀▄▄▀▀░█░░░▀▄▀▀▀▀█░░█\n" +
                "░░░░░░░░░░█░░░░▄░░▄██▄▄▀\n" +
                "░░░░░░░░░░█░░░░▄░░████\n" +
                "░░░░░░░░░░█▄░░▄▄▄░░▄█\n" +
                "░░░░░░░░░░░█▀▀░▄░▀▀█\n" +
                "░░░░░░░░░░░█░░░█░░░█\n" +
                "░░░░░░░░░░░█░░░▐░░░█\n" +
                "░░░░░░░░░░░█░░░▐░░░█\n" +
                "░░░░░░░░░░░█░░░▐░░░█\n" +
                "░░░░░░░░░░░█░░░▐░░░█\n" +
                "░░░░░░░░░░░█░░░▐░░░█\n" +
                "░░░░░░░░░░░█▄▄▄▐▄▄▄█\n" +
                "░░░░░░░▄▄▄▄▀▄▄▀█▀▄▄▀▄▄▄▄\n" +
                "░░░░░▄▀▄░▄░▄░░░█░░░▄░▄░▄▀▄\n" +
                "░░░░░█▄▄▄▄▄▄▄▄▄▀▄▄▄▄▄▄▄▄▄█");
    }//End of surprise method
    public static void nextMenu(){
        boolean isRunning = false;
        while(!isRunning){
            System.out.println("=== Custom Search 2 ===");
            System.out.println();
            System.out.println("1. Date Range Search (yyyy-mm-dd)");
            System.out.println("2. Description");
            System.out.println("3. Amount Range");
            System.out.println();
            System.out.println("Please choose an option: ");
            System.out.println();
            int usersInput = theScanner.nextInt();

            boolean found = false;

            //Create a switch statement to sort t
            switch(usersInput){
                case 1:
                    while(!found){
                        System.out.println("Please Enter the Start Date: (yyyy-mm-dd");
                        String startDate = theScanner.nextLine();
                        System.out.println("Please Enter the End Date: (yyyy-mm-dd");
                        String endDate = theScanner.nextLine();

                        //Parse the users input to an actual date
                        LocalDate startParsedDate = LocalDate.parse(startDate);
                        LocalDate endParsedDate = LocalDate.parse(endDate);

                        //Loop through the ArrayList<Transaction>
                        for(int i = 0; i < transactions.size(); i++){
                            Transactions t = transactions.get(i);
                            LocalDate getDate = t.getDate();
                            if(getDate.isAfter(startParsedDate) && getDate.isBefore(endParsedDate)){
                                System.out.println("Here are the transactions within the range:");
                                System.out.println();
                                System.out.printf("Date: %s| Time: %s| Description: %s| Vendor: %s| Amount: $%.2f\n",
                                        t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());

                            }

                        }
                    }
            }

        }

    }










}//End of AccountingLedgerApp Class
