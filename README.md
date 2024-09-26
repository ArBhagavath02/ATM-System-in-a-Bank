# ATM System in a Bank - Java Project

## Project Overview

This project simulates an **ATM (Automated Teller Machine)** system for a bank using **Java**. The system allows users to perform basic banking functions such as checking their balance, withdrawing money, depositing money, and changing their PIN.

## Features

- **Login System:** Customers log in using their unique account number and PIN.
- **Balance Inquiry:** Users can check their account balance.
- **Withdraw Funds:** Users can withdraw a specified amount, provided they have sufficient balance.
- **Deposit Funds:** Users can deposit money into their account.
- **Change PIN:** Users can securely change their account PIN.
- **Exit:** Option to exit the system safely.

## Technologies Used

- **Java**: Core programming language used to build the project.
- **OOP Concepts**: Implemented object-oriented principles like encapsulation, inheritance, and polymorphism.
- **Exception Handling**: Managed possible errors like insufficient balance and incorrect login attempts.

## How to Run the Project

1. **Clone the repository:**

    ```bash
   https://github.com/ArBhagavath02/ATM-System-in-a-Bank.git
    ```

2. **Navigate to the project directory:**

    ```bash
    cd ATM-System-in-a-Bank.git
    ```

3. **Compile and run the project:**

    ```bash
    javac ATMApp.java
    java ATMApp.java
    ```

## Project Structure

```bash
ATM-System/
│
├── ATM.java           # Main class handling the ATM operations
├── Customer.java      # Class to store customer details (account number, balance, PIN)
└── README.md          # Project documentation

Welcome to the ATM System
Enter your account number: ******
Enter your PIN: ******
1. Check Balance
2. Withdraw Money
3. Deposit Money
4. Change PIN
5. Exit
Select an option: 1
Your balance is: $5000



