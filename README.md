# 💸 FlowLedger

**FlowLedger** is a Java-based console application for tracking daily expenses.
It allows users to record, manage, and persist expenses using a clean, layered architecture built on core OOP principles — now with an extensible **category management system**.

---

## 🚀 Features

### 🟢 v1.0.0

* ➕ Add new expenses
* 📋 View all recorded expenses
* 🔢 Auto-generated unique IDs
* 🧠 Clean layered architecture (UI → Service → Model)

---

### 🔥 v1.1.0

* ✏️ Edit existing expenses
* ❌ Delete expenses by ID
* 🧩 Full CRUD support (Create, Read, Update, Delete)
* 🧾 Improved CLI interaction flow

---

### ⚡ v1.1.1

* 🛡️ Robust input validation
* 🔁 Centralized input handling (`InputHelper`)
* 📅 Flexible date parsing (multiple formats)
* 💬 Improved CLI feedback and error handling
* 🧠 Cleaner separation of concerns

---

### 🚀 v1.1.2

* ✅ Accurate success/failure feedback
* 🧠 Removed flawed ID validation logic
* 🔁 Service layer returns operation status (`boolean`)
* ❌ Eliminated misleading success messages
* 🔒 Proper resource handling

---

### 💾 v1.2.0

* 📂 CSV-based file persistence
* 🔄 Auto-loading data on startup
* 💾 Real-time save after operations
* 🧠 Smart ID management (no duplicates)
* 🛡️ Safe parsing with error handling
* 📁 Automatic file/directory creation
* 🔗 Clean separation of storage layer

---

### 📦 v1.3.0

* 🗂️ **Category Management System**

  * Create and manage custom categories
  * Prevent duplicate categories using normalization
* 🔄 Improved category integration with expenses
* 💾 Persistent category storage (CSV-based)
* 🧠 Smarter input validation for categories
* 🧼 Codebase cleanup and structural improvements

---

### 🆕 v1.3.1 (Latest)

* 🗂️ Category Management System

  * Create and manage custom categories
  * Prevent duplicate categories using normalization
* 💾 Persistent category storage (CSV-based)
* 🔄 Improved integration between categories and expenses
* 🧠 Stronger input validation for categories and amounts
* 🛠️ Fixed CSV parsing for descriptions containing commas
* 🧼 Codebase cleanup and structural simplification
* 🚀 Improved overall stability and reliability

---

## 🏗️ Project Structure

```
src/
└── com/
    └── flowledger/
        ├── app/        # Entry point & Console UI
        ├── services/   # Business logic & storage handling
        ├── models/     # Data models
        └── utility/    # Input handling utilities
```

---

## 🧠 Architecture Overview

FlowLedger follows a layered design:

* **Main** → starts the application
* **ConsoleUI** → handles user interaction
* **ExpenseManager** → core business logic & ID handling
* **CategoryService** → category management & validation
* **StorageService** → file persistence (CSV)
* **Models** → `Expense`, `Category`
* **InputHelper** → validated user input

```
Main → ConsoleUI → ExpenseManager → StorageService → File
           ↓
      CategoryService
           ↓
      InputHelper
```

---

## 🛠️ Tech Stack

* **Java (Core)**
* Object-Oriented Programming (Encapsulation, Separation of Concerns)
* File Handling (CSV persistence)
* CLI-based interface

---

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/AdityaNath1221/FlowLedger.git
cd FlowLedger
```

### 2. Compile

```bash
javac -d out $(find src -name "*.java")
```

### 3. Run

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
Enter 5 to View Categories.
Enter 6 to Add Category.
Enter -1 to Exit.
```

---

## 🎯 Roadmap

### 🧠 Future Enhancements

* Expense analytics (total spending, category-wise breakdown)
* Filtering by category and date
* Search functionality
* JSON-based storage (replace CSV)
* GUI (Java Swing / JavaFX)
* Export functionality (CSV/JSON)
* Real-world integrations (small business use cases 👀)

---

## 🏷️ Version

**v1.3.1** – Stable release with improved CSV parsing, enhanced validation, and refined category management

---

## 📄 License

This project is licensed under the MIT License.

---

## 🙌 Acknowledgment

Built as part of a hands-on journey to learn Java, OOP, and real-world system design — evolving from a simple CLI tool into a **stateful, modular expense tracking system**.
