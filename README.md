# 💸 FlowLedger

**FlowLedger** is a Java-based console application for tracking daily expenses.
It allows users to record, view, edit, and manage expenses using a clean, layered architecture built with core OOP principles.

---

## 🚀 Features

### 🟢 v1.0.0

* ➕ Add new expenses
* 📋 View all recorded expenses
* 🔢 Auto-generated unique IDs
* 🧠 Clean layered architecture (UI → Service → Model)

### 🔥 v1.1.0

* ✏️ Edit existing expenses
* ❌ Delete expenses by ID
* 🧩 Full CRUD support (Create, Read, Update, Delete)
* 🧾 Improved CLI interaction flow

### ⚡ v1.1.1

* 🛡️ Robust input validation (no more crashes on invalid input)
* 🔁 Safe input handling using centralized `InputHelper` utility
* 📅 Flexible date parsing (multiple formats supported)
* 💬 Improved CLI error messages and user feedback
* 🧠 Better separation of concerns (cleaner UI logic)

### 🚀 v1.1.2 (Latest)

* ✅ Accurate success/failure feedback for edit and delete operations
* 🧠 Removed flawed ID range validation (now checks actual existence)
* 🔁 Service layer returns operation status (`boolean`)
* ❌ Eliminated misleading success messages
* 🧼 Cleaned up input handling and minor bugs
* 🔒 Proper resource handling (Scanner closed on exit)

---

## 🏗️ Project Structure

```
src/
└── com/
    └── flowledger/
        ├── app/        # Entry point & Console UI
        ├── services/   # Business logic
        ├── models/     # Data models
        └── utility/    # Input handling utilities
```

---

## 🧠 Architecture Overview

FlowLedger follows a layered design:

* **Main** → starts the application
* **ConsoleUI** → handles user interaction
* **ExpenseManager** → manages business logic
* **Expense** → represents expense data
* **InputHelper** → handles validated user input

```
Main → ConsoleUI → ExpenseManager → Expense
           ↓
      InputHelper
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
Enter 2 to View all Expenses.
Enter 3 to Delete an Expense.
Enter 4 to Edit an Expense.
Enter -1 to Exit.
```

---

## 🎯 Roadmap

### 💾 v1.2.0 (Next)

* File-based persistence (save & load expenses)
* Data retention across sessions

### 📊 Future Enhancements

* Expense analytics (category-wise breakdown)
* Filtering by category/date
* GUI using Java Swing

---

## 🏷️ Version

**v1.1.2** – Stability and correctness improvements with reliable CRUD operations

---

## 📄 License

This project is licensed under the MIT License.

---

## 🙌 Acknowledgment

Built as part of a hands-on journey to learn Java, OOP, and real-world system design.
