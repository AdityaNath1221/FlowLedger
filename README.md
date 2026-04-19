# 💸 FlowLedger

**FlowLedger** is a Java-based console application for tracking daily expenses.
It allows users to record, view, and manage expenses in a clean and structured way while following solid object-oriented design principles.

---

## 🚀 v1.0.0 Features

* ➕ Add new expenses
* 📋 View all recorded expenses
* 🔢 Auto-generated unique IDs for each expense
* 🧠 Clean layered architecture (UI → Service → Model)

---

## 🏗️ Project Structure

```
src/
└── com/
    └── flowledger/
        ├── app/        # Entry point & Console UI
        ├── services/   # Business logic
        └── models/     # Data models
```

---

## 🧠 Architecture Overview

FlowLedger follows a layered design:

* **Main** → starts the application
* **ConsoleUI** → handles user interaction
* **ExpenseManager** → manages business logic
* **Expense** → represents expense data

```
Main → ConsoleUI → ExpenseManager → Expense
```

---

## 🛠️ Tech Stack

* **Java (Core)**
* OOP Principles (Encapsulation, Separation of Concerns)
* CLI-based interface

---

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/AdityaNath1221/FlowLedger.git
cd FlowLedger
```

### 2. Compile the project

```bash
javac -d out $(find src -name "*.java")
```

### 3. Run the application

```bash
java -cp out com.flowledger.app.Main
```

---

## 📸 Sample Usage

```
===== Expense Tracker Console UI =====

Enter 1 to Add a new Expense.
Enter 2 to view all Expenses.
Enter -1 to exit.

Enter Choice: 1
```

---

## 🎯 Future Improvements

* 💾 File-based storage (save & load expenses)
* ✏️ Edit and delete expenses
* 📊 Expense analytics (category-wise breakdown)
* 🖥️ GUI using Java Swing

---

## 🏷️ Version

**v1.0.0** – Initial stable release

---

## 📄 License

This project is licensed under the MIT License.

---

## 🙌 Acknowledgment

Built as part of a hands-on journey to learn Java, OOP, and real-world system design.

---
