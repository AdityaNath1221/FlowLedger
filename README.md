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

### 🔥 v1.1.0 (Latest)

* ✏️ Edit existing expenses
* ❌ Delete expenses by ID
* 🧩 Full CRUD support (Create, Read, Update, Delete)
* 🧾 Improved CLI interaction flow

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
Enter 2 to View all Expenses.
Enter 3 to Delete an Expense.
Enter 4 to Edit an Expense.
Enter -1 to Exit.
```

---

## 🎯 Roadmap

### 🔧 v1.1.1 (Upcoming)

* Input validation (prevent crashes)
* Graceful error handling
* Improved user feedback

### 💾 v1.2.0 (Planned)

* File-based persistence (save & load expenses)
* Data retention across sessions

### 📊 Future Enhancements

* Expense analytics (category-wise breakdown)
* Filtering by category/date
* GUI using Java Swing

---

## 🏷️ Version

**v1.1.0** – Added edit and delete functionality (full CRUD support)

---

## 📄 License

This project is licensed under the MIT License.

---

## 🙌 Acknowledgment

Built as part of a hands-on journey to learn Java, OOP, and real-world system design.

---
