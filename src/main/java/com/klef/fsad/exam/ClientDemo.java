package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * ClientDemo - Main class to demonstrate Hibernate operations
 * on the Hospital entity.
 *
 * Operations:
 *   I.  Insert a new Hospital record into the database.
 *   II. View (retrieve) a Hospital record by its ID.
 *
 * @author KLEF FSAD Lab
 */
public class ClientDemo {

    public static void main(String[] args) {

        // ─── Build SessionFactory ──────────────────────────
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");   // loads hibernate.cfg.xml
        cfg.addAnnotatedClass(Hospital.class); // register entity

        SessionFactory factory = cfg.buildSessionFactory();

        // ══════════════════════════════════════════════════
        //  OPERATION I : INSERT A NEW RECORD
        // ══════════════════════════════════════════════════
        System.out.println("\n========== INSERT RECORD ==========");

        Session insertSession = factory.openSession();
        insertSession.beginTransaction();

        Hospital h = new Hospital();
        h.setName("Apollo Hospital");
        h.setDescription("Multi-speciality hospital with advanced medical care");
        h.setDate(new Date());
        h.setStatus("Active");
        h.setLocation("Hyderabad, Telangana");
        h.setContact("9000000001");

        insertSession.persist(h);
        insertSession.getTransaction().commit();
        insertSession.close();

        System.out.println("✅ Record Inserted Successfully!");
        System.out.println("   Generated ID : " + h.getId());
        System.out.println("   Name         : " + h.getName());
        System.out.println("   Status       : " + h.getStatus());

        // ══════════════════════════════════════════════════
        //  OPERATION II : VIEW RECORD BY ID
        // ══════════════════════════════════════════════════
        System.out.println("\n========== VIEW RECORD BY ID ==========");

        int searchId = h.getId(); // use the auto-generated ID from insert

        Session viewSession = factory.openSession();
        viewSession.beginTransaction();

        Hospital retrieved = viewSession.get(Hospital.class, searchId);

        if (retrieved != null) {
            System.out.println("✅ Record Found:");
            System.out.println("   ID          : " + retrieved.getId());
            System.out.println("   Name        : " + retrieved.getName());
            System.out.println("   Description : " + retrieved.getDescription());
            System.out.println("   Date        : " + retrieved.getDate());
            System.out.println("   Status      : " + retrieved.getStatus());
            System.out.println("   Location    : " + retrieved.getLocation());
            System.out.println("   Contact     : " + retrieved.getContact());
        } else {
            System.out.println("❌ No record found for ID: " + searchId);
        }

        viewSession.getTransaction().commit();
        viewSession.close();

        // ─── Cleanup ───────────────────────────────────────
        factory.close();
        System.out.println("\n========== DONE ==========");
    }
}
