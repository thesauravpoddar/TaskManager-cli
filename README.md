<div align="center">
  <img src="https://media.giphy.com/media/5VKbvrjxpVJCM/giphy.gif" width="200px" alt="Task CLI Logo">
  <h1>📋 Task Manager CLI</h1>
  <p><strong>A blazing-fast Command Line Interface (CLI) app to manage your daily tasks with Java & Spring Boot</strong></p>
</div>

---

## 🚀 Features

- 🔒 Secure, local task storage in JSON format (no external libraries)
- ➕ Add, 📝 Update, ✅ Mark as Done / In Progress, ❌ Remove tasks
- 📃 Filter tasks by status: `TODO`, `IN_PROGRESS`, `DONE`
- 💾 Persistent task storage using plain JSON file (`tasks.json`)
- 🧠 Intelligent CLI that understands commands like `add`, `list`, `remove`, etc.

---
project url : https://github.com/thesauravpoddar/TaskManager-cli

## 📦 Project Structure

📁 taskmanagercli/
│
├── 📄 TaskManagerCliApplication.java # Entry point of the Spring Boot CLI app
|
├── 📄 Interecting_With_Cli.java # Handles user interaction in terminal
|
├── 📄 SavingTasks.java # Logic to manage tasks (CRUD, persist, filter)
|
├── 📄 Tasks.java # Task model class (id, desc, status, timestamps)
|
├── 📄 Status.java # Enum to define task status (TODO, IN_PROGRESS, DONE)
|
└── 📄 tasks.json # Auto-generated file for storing tasks



---

## 🛠️ Commands

Run the application and use the following commands in the terminal:

| Command               | Description                                     |
|-----------------------|-------------------------------------------------|
| `add <description>`   | Add a new task                                  |
| `list`                | List all tasks                                  |
| `list done`           | List tasks with `DONE` status                   |
| `remove`              | Removes a task (asks for ID)                    |
| `update`              | Updates task description (asks for ID)          |
| `mark-in-progress`    | Marks a task as `IN_PROGRESS` (asks for ID)     |
| `mark-as-done`        | Marks a task as `DONE` (asks for ID)            |
| `exit`                | Exits the CLI                                   |

---

## 🔧 Setup Instructions

### ✅ Prerequisites

- Java 17+
- Maven or any Java build tool
- Terminal / CMD

### 🏁 Run the App

```bash
# Compile and run
./mvnw spring-boot:run

# OR manually compile and run
javac -d out $(find . -name "*.java")
cd out
java com.project.taskmanagercli.TaskManagerCliApplication

📂 Sample JSON Output
[
  {
    "id": "1",
    "description": "complete homework",
    "status": "TODO",
    "createdAt": "2025-07-14T09:40:00",
    "updatedAt": "2025-07-14T09:40:00"
  }
]
---
💡 Future Improvements
Add user authentication (login/register)

Allow deadline & reminder support

Export/Import tasks

Enhanced CLI styling (e.g. colors, animations)

🙌 Author
Saurav Kumar
📧 saurav@example.com (replace with actual)
🔗 GitHub Profile

⭐️ Support the Project
If you liked this project, consider giving it a ⭐️ on GitHub!
---


