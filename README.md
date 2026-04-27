# 💸 FlowLedger

FlowLedger is a Java-based console application for tracking daily expenses. It allows users to record, manage, and persist expenses using a clean, layered architecture built on core OOP principles — now enhanced with a controller-service architecture and basic analytics support.

---

## 🚀 Features

### 🟢 v1.0.0
- ➕ Add new expenses
- 📋 View all recorded expenses
- 🔢 Auto-generated unique IDs
- 🧠 Clean layered architecture (UI → Service → Model)

---

### 🔥 v1.1.0
- ✏️ Edit existing expenses
- ❌ Delete expenses by ID
- 🧩 Full CRUD support (Create, Read, Update, Delete)
- 🧾 Improved CLI interaction flow

---

### ⚡ v1.1.1
- 🛡️ Robust input validation
- 🔁 Centralized input handling (InputHelper)
- 📅 Flexible date parsing (multiple formats)
- 💬 Improved CLI feedback and error handling
- 🧠 Cleaner separation of concerns

---

### 🚀 v1.1.2
- ✅ Accurate success/failure feedback
- 🧠 Removed flawed ID validation logic
- 🔁 Service layer returns operation status (boolean)
- ❌ Eliminated misleading success messages
- 🔒 Proper resource handling

---

### 💾 v1.2.0
- 📂 CSV-based file persistence
- 🔄 Auto-loading data on startup
- 💾 Real-time save after operations
- 🧠 Smart ID management (no duplicates)
- 🛡️ Safe parsing with error handling
- 📁 Automatic file/directory creation
- 🔗 Clean separation of storage layer

---

### 📦 v1.3.0
- 🗂️ Category Management System
- Create and manage custom categories
- Prevent duplicate categories using normalization
- 🔄 Improved category integration with expenses
- 💾 Persistent category storage (CSV-based)
- 🧠 Smarter input validation for categories
- 🧼 Codebase cleanup and structural improvements

---

### 🆕 v1.3.1
- 🛠️ Fixed CSV parsing for descriptions containing commas
- 🔄 Improved integration between categories and expenses
- 🧠 Stronger input validation for categories and amounts
- 🧼 Codebase cleanup and structural simplification
- 🚀 Improved overall stability and reliability

---

### 🚀 v1.4.0 (Latest) — Architecture Refactor & Analytics

#### 🏗️ Major Architecture Refactor
- Introduced Controller layer for better separation of concerns
- Implemented manual Dependency Injection via `Main`
- Split storage into dedicated services:
  - `ExpenseStorageService`
  - `CategoryStorageService`
- Added generic `StorageService<T>` interface
- Fully decoupled UI from business logic

#### 📊 New Feature: Analytics
- Added `AnalyticsService` and `AnalyticsController`
- Implemented total expense calculation

#### 🧠 Improvements
- Cleaner and scalable project structure
- Better maintainability and extensibility
- Prepared codebase for future GUI integration

---

## 🏗️ Project Structure

```
src/
└── com/
└── flowledger/
├── app/ # Entry point & dependency wiring
├── core/
│ ├── models/ # Data models
│ ├── controllers/# Application controllers
│ ├── services/ # Business logic
│ └── storage/ # Persistence layer
└── ui/
└── console/ # CLI interface
```


---

## 🧠 Architecture Overview

FlowLedger now follows a structured layered architecture:

- **Main** → wires dependencies
- **ConsoleUI** → handles user interaction
- **Controllers** → handle application flow
- **Services** → contain business logic
- **Storage** → handles persistence
- **Models** → represent data

### 🔄 Flow

`Main → ConsoleUI → Controller → Service → Storage → File`

---

## 🛠️ Tech Stack

- Java (Core)
- Object-Oriented Programming (Encapsulation, Separation of Concerns)
- File Handling (CSV persistence)
- CLI-based interface

---

## ▶️ How to Run

### 1. Clone the repository

```
git clone https://github.com/AdityaNath1221/FlowLedger.git
cd FlowLedger
```

### 2. Compile

```
javac -d out $(find src -name "*.java")
```

### 3. Run

```
java -cp out com.flowledger.app.Main
```

## 📸 Sample Usage

```
===== Expense Tracker Console UI =====

Enter 1 to Add a new Expense.
Enter 2 to View all Expenses.
Enter 3 to Delete an Expense.
Enter 4 to Edit an Expense.
Enter 5 to View Categories.
Enter 6 to Add Category.
Enter 7 to View Total Spending.
Enter -1 to Exit.
```

---

## 🎯 Roadmap

### 🧠 Future Enhancements

- Category-wise analytics
- Filtering by category and date
- Search functionality
- JSON-based storage (replace CSV)
- GUI (Java Swing / JavaFX)
- Export functionality (CSV/JSON)
- Real-world integrations (small business use cases 👀)

---

## 🏷️ Version

v1.4.0 – Architecture refactor with controller-service layering and analytics support

---

## 📄 License

This project is licensed under the MIT License.

---

## 🙌 Acknowledgment

Built as part of a hands-on journey to learn Java, OOP, and real-world system design — evolving from a simple CLI tool into a modular, scalable expense tracking system.