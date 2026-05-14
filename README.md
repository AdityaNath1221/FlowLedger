# 💸 FlowLedger

> 🚧 **Currently Working On:**
> Migrating FlowLedger from a CLI-based application to a modern JavaFX desktop application with Maven-based architecture, improved UI design, and scalable GUI components.

FlowLedger is a Java-based expense tracking application built to evolve from a simple CLI tool into a modular, scalable desktop finance manager.

Originally designed as a console application to learn core Java and OOP principles, the project is now being expanded with a modern JavaFX GUI architecture powered by Maven, layered services, and analytics support.

---

# 🚀 Features

## 🟢 v1.0.0

* ➕ Add new expenses
* 📋 View all recorded expenses
* 🔢 Auto-generated unique IDs
* 🧠 Clean layered architecture (UI → Service → Model)

---

## 🔥 v1.1.0

* ✏️ Edit existing expenses
* ❌ Delete expenses by ID
* 🧩 Full CRUD support (Create, Read, Update, Delete)
* 🧾 Improved CLI interaction flow

---

## ⚡ v1.1.1

* 🛡️ Robust input validation
* 🔁 Centralized input handling (`InputHelper`)
* 📅 Flexible date parsing (multiple formats)
* 💬 Improved CLI feedback and error handling
* 🧠 Cleaner separation of concerns

---

## 🚀 v1.1.2

* ✅ Accurate success/failure feedback
* 🧠 Removed flawed ID validation logic
* 🔁 Service layer returns operation status (`boolean`)
* ❌ Eliminated misleading success messages
* 🔒 Proper resource handling

---

## 💾 v1.2.0

* 📂 CSV-based file persistence
* 🔄 Auto-loading data on startup
* 💾 Real-time save after operations
* 🧠 Smart ID management (no duplicates)
* 🛡️ Safe parsing with error handling
* 📁 Automatic file/directory creation
* 🔗 Clean separation of storage layer

---

## 📦 v1.3.0

* 🗂️ Category Management System
* Create and manage custom categories
* Prevent duplicate categories using normalization
* 🔄 Improved category integration with expenses
* 💾 Persistent category storage (CSV-based)
* 🧠 Smarter input validation for categories
* 🧼 Codebase cleanup and structural improvements

---

## 🆕 v1.3.1

* 🛠️ Fixed CSV parsing for descriptions containing commas
* 🔄 Improved integration between categories and expenses
* 🧠 Stronger input validation for categories and amounts
* 🧼 Codebase cleanup and structural simplification
* 🚀 Improved overall stability and reliability

---

## 🚀 v1.4.0 — Architecture Refactor & Analytics (Latest Stable Release)

### 🏗️ Major Architecture Refactor

* Introduced Controller layer for better separation of concerns
* Implemented manual Dependency Injection via `Main`
* Split storage into dedicated services:

  * `ExpenseStorageService`
  * `CategoryStorageService`
* Added generic `StorageService<T>` interface
* Fully decoupled UI from business logic

### 📊 Analytics

* Added `AnalyticsService` and `AnalyticsController`
* Implemented total expense calculation

### 🧠 Improvements

* Cleaner and scalable project structure
* Better maintainability and extensibility
* Prepared codebase for future GUI integration

---

## 🧪 In Development — JavaFX GUI Migration

### 🖥️ Planned GUI Features

* JavaFX-based graphical interface
* Responsive layouts using FXML
* Dashboard-oriented UI structure
* Sidebar navigation system
* Dashboard analytics section

### ⚙️ Build System Modernization

* Maven-based project structure
* Dependency management via `pom.xml`
* JavaFX runtime integration
* Runnable fat JAR packaging support

### 🧠 Ongoing Improvements

* Preserving layered architecture during GUI migration
* Decoupling GUI from business logic
* Resource-based FXML loading
* Preparing scalable UI architecture for future features

---

# 🏗️ Project Structure

```text
src/
└── main/
    ├── java/
    │   └── com/
    │       └── flowledger/
    │           ├── app/               # Entry point & dependency wiring
    │           ├── core/
    │           │   ├── controllers/   # Application controllers
    │           │   ├── models/        # Data models
    │           │   ├── services/      # Business logic
    │           │   └── storage/       # Persistence layer
    │           └── ui/
    │               ├── console/       # Legacy CLI interface
    │               └── gui/           # JavaFX GUI (in progress)
    │
    └── resources/
        └── com/
            └── flowledger/
                └── ui/
                    └── gui/           # FXML resources
```

---

# 🧠 Architecture Overview

FlowLedger follows a structured layered architecture:

* `Main` → wires dependencies
* `UI` → handles user interaction
* `Controllers` → handle application flow
* `Services` → contain business logic
* `Storage` → handles persistence
* `Models` → represent data

## 🔄 Application Flow

```text
Main → UI → Controller → Service → Storage → File
```

---

# 🛠️ Tech Stack

* Java
* JavaFX
* Maven
* Object-Oriented Programming (OOP)
* FXML
* CSV Persistence
* Layered Architecture

---

# ▶️ How to Run

## 🔹 Option 1 — Run Using Maven

### Requirements

* Java 25 or later
* Maven installed

### Clone Repository

```bash
git clone https://github.com/AdityaNath1221/FlowLedger.git
cd FlowLedger
```

### Run Application

If maven installed,
```bash
mvn javafx:run
```
else,
```bash
cd target 
java -jar FlowLedger-1.0.jar 
```

---

# 📸 Current Development Preview

## GUI Migration Progress

* Sidebar layout implementation
* Dashboard UI structure
* JavaFX + FXML integration
* Maven build configuration
* Fat JAR packaging setup

---

# 🎯 Roadmap

## 🧠 Future Enhancements

* Category-wise analytics
* Expense charts and visual insights
* Filtering by category and date
* Search functionality
* JSON / Database persistence
* Authentication system
* Export functionality (CSV/JSON/PDF)
* Dark mode
* Real-world small business integrations 👀

---

# 🏷️ Version

## Current Stable Version

`v1.4.0` — Architecture refactor with controller-service layering and analytics support

## In Development

`v2.0.0` — JavaFX GUI migration with Maven-based architecture

---

# 📄 License

This project is licensed under the MIT License.

---

# 🙌 Acknowledgment

Built as part of a hands-on journey to deeply learn Java, OOP, software architecture, GUI development, and real-world system design — evolving from a simple CLI tool into a modular desktop finance management application.
