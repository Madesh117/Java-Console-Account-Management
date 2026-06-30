# 🏦 Bank Management System (Java Console Application)

A **menu-driven Bank Management System** developed using **Core Java**. This console-based application enables users to create and manage bank accounts, perform banking transactions, and demonstrates the practical implementation of Object-Oriented Programming (OOP) concepts.

## 📖 Project Overview

The Bank Management System simulates basic banking operations through a command-line interface. It supports multiple account types, allows deposits and withdrawals, searches for customer accounts, and displays all registered accounts while applying appropriate business rules for each account type.

This project was developed to strengthen Core Java programming skills and to demonstrate concepts such as inheritance, polymorphism, encapsulation, exception handling, and object-oriented design.

## ✨ Features

* Create Savings Account
* Create Current Account
* Deposit Money
* Withdraw Money
* Search Account by Account Number
* Display All Accounts
* Custom Exception Handling
* Menu-Driven Console Interface
* Different withdrawal rules for Savings and Current accounts

## 🛠 Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Console-Based User Interface

## 🧠 Core Java Concepts Implemented

* Classes and Objects
* Encapsulation
* Inheritance
* Method Overriding (Runtime Polymorphism)
* Constructors
* Arrays
* Exception Handling
* Custom Exceptions
* Access Modifiers
* Scanner Class
* Conditional Statements
* Loops


## 🏗 Project Structure

│── BankMain.java
│── README.md


## 💼 Account Types

### Savings Account

* Supports deposits and withdrawals.
* Withdrawal is allowed only if sufficient balance is available.
* Throws a custom exception when balance is insufficient.

### Current Account

* Supports deposits and withdrawals.
* Provides an overdraft facility of ₹5000.
* Throws an exception if the withdrawal exceeds the overdraft limit.

## ⚙ Functionalities

### Create Account

Users can create either:

* Savings Account
* Current Account

Each account contains:

* Account Number
* Customer Name
* Initial Balance

### Deposit

* Deposits money into an existing account.
* Prevents invalid deposit amounts.
* Updates the account balance after a successful transaction.

### Withdraw

* Withdraws money from an existing account.
* Applies different business rules based on account type.
* Handles insufficient balance using a custom exception.

### Search Account

Searches an account using its Account Number and displays:

* Account Number
* Customer Name
* Current Balance

### Display All Accounts

Displays all accounts currently stored in the bank system.


## 🚀 Sample Menu

===== BANK MANAGEMENT SYSTEM =====

1. Create Savings Account
2. Create Current Account
3. Deposit
4. Withdraw
5. Search Account
6. Display All Accounts
7. Exit

## ⚠ Exception Handling

The application uses a custom exception:

InsufficientBalanceException

This exception is thrown when:

* Savings account balance is insufficient.
* Current account overdraft limit is exceeded.


## 📸 Sample Output

===== BANK MANAGEMENT SYSTEM =====

1. Create Savings Account
2. Create Current Account
3. Deposit
4. Withdraw
5. Search Account
6. Display All Accounts
7. Exit

Enter Choice :

## 📚 Learning Outcomes

This project helped in understanding:

* Object-Oriented Programming principles
* Designing reusable Java classes
* Implementing inheritance and polymorphism
* Creating custom exceptions
* Building menu-driven console applications
* Managing data using arrays
* Applying real-world business logic


## 🔮 Future Enhancements

* JDBC integration with MySQL
* User Login Authentication
* Transaction History
* Money Transfer Between Accounts
* Interest Calculation for Savings Accounts
* File Handling for Persistent Storage
* Java Swing or JavaFX GUI
* Account Update and Delete Operations
* Input Validation using Regular Expressions

