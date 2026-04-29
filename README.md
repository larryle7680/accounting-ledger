LarryLegend's Accounting Ledger

A Java console-based accounting ledger application that allows users to record deposits, make payments, and search financial transactions through an interactive menu system.

Overview

LarryLegend's Accounting Ledger is a beginner-friendly bookkeeping program built in Java. It stores transactions in a CSV file and allows users to manage personal finances directly from the command line.

Users can:

Add deposits
Make payments
View complete ledger history
Filter deposits and payments
Search transactions by month, year, and vendor
Persist data using CSV file storage
Features
Home Screen Navigation

Users are greeted with an interactive menu:

D → Add Deposit
P → Make Payment
L → Open Ledger Screen
S → Surprise Screen
X → Exit Application
Add Deposit

Allows users to manually enter:

Date
Time
Description
Vendor
Amount

Deposits are saved to the ledger CSV file.

Make Payment

Users can record payments by entering:

Payee
Description
Price
Cardholder Name
Card Number

The application automatically records:

Current Date
Current Time

Payments are stored as negative amounts in the ledger.

Ledger Screen

Users can display:

All Entries
Deposits Only
Payments Only
Custom Search
Custom Search Options

Search reports by:

Month to Date
Previous Month
Year to Date
Previous Year
Vendor Name
Technologies Used
Java 17
Object-Oriented Programming
ArrayList
FileReader / BufferedReader
FileWriter / BufferedWriter
LocalDate / LocalTime
DateTimeFormatter
CSV File Persistence
Project Structure
src/
└── main/
├── java/com/pluralsight/
│     ├── AccountingLedgerApp.java
│     └── Transactions.java
└── resources/
└── transaction.csv
How It Works
CSV Storage

Transactions are saved in:

src/main/resources/transaction.csv

Each row contains:

Date | Time | Description | Vendor | Price

Example:

2026-04-28|14:22:10|Paycheck|Employer|1500.00
2026-04-28|18:35:42|Dinner|Restaurant|-24.99
Key Concepts Demonstrated
File Handling
Parsing CSV Data
LocalDate and LocalTime Formatting
Menu Driven Programs
Loops and Conditionals
Search Filtering
Sorting Objects with Comparator
Data Persistence
Future Improvements

Potential upgrades:

Hide / mask card numbers
Export reports
GUI version using JavaFX
Better exception handling
Improved menu looping
Sort newest transaction first
Running balance feature
Author

Created by LarryLegend
