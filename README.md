# Hospital Hibernate Maven Project

**KLEF FSAD Lab Exam — Maven Hibernate Project**

A Maven-based Java project demonstrating Hibernate ORM operations on a `Hospital` entity class.

---

## 📁 Project Structure
```
HospitalHibernate/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── com/klef/fsad/exam/
        │       ├── Hospital.java       ← Entity Class
        │       └── ClientDemo.java     ← Main Class
        └── resources/
            └── hibernate.cfg.xml       ← Hibernate Configuration
```

---

## 🏥 Hospital Entity Attributes

| Field       | Type   | Description                  |
|-------------|--------|------------------------------|
| id          | int    | Auto-generated primary key   |
| name        | String | Hospital name                |
| description | String | Hospital description         |
| date        | Date   | Record date (auto set)       |
| status      | String | Active / Inactive            |
| location    | String | City / address               |
| contact     | String | Contact number               |

---

## ⚙️ Technologies Used

- **Java 17**
- **Maven** — Build & dependency management
- **Hibernate 6.4.4** — ORM framework
- **MySQL 8** — Relational database
- **Jakarta Persistence API** — JPA annotations

---

## 🗄️ Database Setup
```sql
CREATE DATABASE fsadexam;
```

---

## 🚀 Operations Implemented

### I. Insert a New Record
User enters hospital details and the record is saved to the database automatically.

### II. View Record by ID
User enters an ID and the matching hospital record is displayed.

---

## 🔧 How to Run
```bash
cd HospitalHibernate
mvn exec:java -Dexec.mainClass="com.klef.fsad.exam.ClientDemo"
```

---

## ✅ Expected Output
```
========== INSERT RECORD ==========
Enter Hospital Name: Apollo Hospital
Enter Description: Multi-speciality hospital
Enter Status (Active/Inactive): Active
Enter Location: Hyderabad, Telangana
Enter Contact: 9000000001
✅ Record Inserted! Generated ID: 1

========== VIEW RECORD BY ID ==========
Enter ID to search: 1
✅ Record Found:
   ID          : 1
   Name        : Apollo Hospital
   Description : Multi-speciality hospital
   Date        : 2026-03-13
   Status      : Active
   Location    : Hyderabad, Telangana
   Contact     : 9000000001

========== DONE ==========
```

---

## 📝 Inference

Hibernate ORM was used to insert and retrieve hospital records from the database using persistent objects and session management.

## 📊 Analysis

Hibernate simplifies database interaction by mapping Java objects to relational tables, eliminating the need for manual SQL queries.