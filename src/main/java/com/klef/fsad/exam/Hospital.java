package com.klef.fsad.exam;

import jakarta.persistence.*;
import java.util.Date;

/**
 * Hospital Entity Class
 * Mapped to the 'hospital' table in the 'fsadexam' database.
 * 
 * @author KLEF FSAD Lab
 */
@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "location", length = 150)
    private String location;

    @Column(name = "contact", length = 15)
    private String contact;

    // ─── Default Constructor ───────────────────────────────
    public Hospital() {
    }

    // ─── Parameterized Constructor ─────────────────────────
    public Hospital(String name, String description, Date date,
                    String status, String location, String contact) {
        this.name        = name;
        this.description = description;
        this.date        = date;
        this.status      = status;
        this.location    = location;
        this.contact     = contact;
    }

    // ─── Getters and Setters ───────────────────────────────
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    // ─── toString ─────────────────────────────────────────
    @Override
    public String toString() {
        return "Hospital{" +
                "id="          + id          +
                ", name='"     + name        + '\'' +
                ", description='" + description + '\'' +
                ", date="      + date        +
                ", status='"   + status      + '\'' +
                ", location='" + location    + '\'' +
                ", contact='"  + contact     + '\'' +
                '}';
    }
}
