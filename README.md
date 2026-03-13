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
| date        | Date   | Establishment / record date  |
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

Run the following SQL in MySQL before running the project:

```sql
CREATE DATABASE fsadexam;
```

Hibernate will automatically create/update the `hospital` table via `hbm2ddl.auto=update`.

---

## 🚀 Operations Implemented

### I. Insert a New Record
A new `Hospital` object is created, populated with data, and persisted to the database using `session.persist()`.

### II. View Record by ID
The inserted record is retrieved from the database using `session.get(Hospital.class, id)` and displayed on the console.

---

## 🔧 How to Run

1. **Clone the repository**
   ```bash
   git clone <your-repo-url>
   cd HospitalHibernate
   ```

2. **Set up MySQL**
   ```sql
   CREATE DATABASE fsadexam;
   ```

3. **Update credentials in `hibernate.cfg.xml`** (if your MySQL password is different):
   ```xml
   <property name="hibernate.connection.username">root</property>
   <property name="hibernate.connection.password">root</property>
   ```

4. **Build the project**
   ```bash
   mvn clean install
   ```

5. **Run `ClientDemo.java`** from your IDE (Eclipse / IntelliJ) or via:
   ```bash
   mvn exec:java -Dexec.mainClass="com.klef.fsad.exam.ClientDemo"
   ```

---

## 📋 Expected Output

```
========== INSERT RECORD ==========
✅ Record Inserted Successfully!
   Generated ID : 1
   Name         : Apollo Hospital
   Status       : Active

========== VIEW RECORD BY ID ==========
✅ Record Found:
   ID          : 1
   Name        : Apollo Hospital
   Description : Multi-speciality hospital with advanced medical care
   Date        : 2025-01-01
   Status      : Active
   Location    : Hyderabad, Telangana
   Contact     : 9000000001

========== DONE ==========
```

---

## 📌 Package

```
com.klef.fsad.exam
```

---

## 📝 Inference

The Hibernate framework was successfully used to perform database operations using a persistent object. The Hospital entity class was created with attributes such as ID, Name, Description, Date, and Status. The ID was generated automatically using Hibernate annotations.

## 📊 Analysis

This experiment demonstrates how Hibernate simplifies database interaction in Java applications using Object Relational Mapping (ORM). Instead of writing SQL queries manually, Hibernate maps Java objects to database tables and performs operations such as insert and retrieve through session methods.
