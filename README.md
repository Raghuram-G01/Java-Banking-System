# 🏦 Java Web-Based Banking System

## 📌 Project Description
This is a **Web-Based Online Banking System** built using Java.  
It allows users to manage their bank accounts securely, perform transactions, and view transaction history through a web interface.  
This project demonstrates **core Java web technologies** such as **Servlets, JSP, JDBC**, and **file/database storage**.

---

## ⚙️ Features
- **User Account Management**: Create and manage user accounts  
- **Secure Login & Logout**: Authenticate users securely  
- **Deposit & Withdraw Money**: Perform banking transactions  
- **Balance Inquiry**: View current account balance  
- **Transaction History**: Track all deposits and withdrawals  
- **Admin Panel (Optional)**: View all registered accounts  

---

## 🛠 Technology Stack
- **Backend**: Java (Servlets, JSP)  
- **Database**: MySQL / File-based storage  
- **Frontend**: HTML, CSS, JSP  
- **Build Tool**: Apache Tomcat / IDE (Eclipse, IntelliJ IDEA)  

---

## 📚 Java Concepts Used
- **Object-Oriented Programming (OOP)**  
  - Classes & Objects (`Account`, `OnlineBankingSystem`)  
  - Encapsulation (user details & transactions bundled in `Account`)  
  - Abstraction (account operations exposed as methods)  
  - Polymorphism & Inheritance (extendable for `AdminAccount`, `SavingsAccount`)  

- **Collections Framework**  
  - `ArrayList<String>` → Transaction history  
  - `HashMap<String, Account>` → Store user accounts  

- **Serialization & File Handling**  
  - `Serializable` → Save/load account objects  
  - `ObjectOutputStream`, `ObjectInputStream` → Persistent storage  

- **Exception Handling**  
  - `try-catch` for file operations and errors  

- **User Input Handling**  
  - `Scanner` for console-based input  

- **Control Flow**  
  - `switch-case` for menus  
  - `do-while` loops for navigation  
  - `if-else` for validation (login, withdraw, etc.)  

- **Access Modifiers & Static**  
  - `private static Map<String, Account> accounts` → central storage  
  - Static methods for system-level operations  

- **Core Java Features**  
  - Generics (`ArrayList<String>`, `HashMap<String, Account>`)  
  - Type casting while reading objects  
  - String concatenation for transaction messages  

---

## 🚀 How to Run
1. Clone the repository  
   ```bash
   git clone https://github.com/Raghuram-G01/Java-Banking-System.git
