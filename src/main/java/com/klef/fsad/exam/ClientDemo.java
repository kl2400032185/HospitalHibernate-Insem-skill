package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Scanner;

public class ClientDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Hospital.class);

        SessionFactory factory = cfg.buildSessionFactory();

        // ══════════════════════════════════════════════════
        //  OPERATION I : INSERT A NEW RECORD
        // ══════════════════════════════════════════════════
        System.out.println("\n========== INSERT RECORD ==========");

        System.out.print("Enter Hospital Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Description: ");
        String description = sc.nextLine();

        System.out.print("Enter Status (Active/Inactive): ");
        String status = sc.nextLine();

        System.out.print("Enter Location: ");
        String location = sc.nextLine();

        System.out.print("Enter Contact: ");
        String contact = sc.nextLine();

        Session insertSession = factory.openSession();
        insertSession.beginTransaction();

        Hospital h = new Hospital();
        h.setName(name);
        h.setDescription(description);
        h.setDate(new Date());
        h.setStatus(status);
        h.setLocation(location);
        h.setContact(contact);

        insertSession.persist(h);
        insertSession.getTransaction().commit();
        insertSession.close();

        System.out.println("✅ Record Inserted! Generated ID: " + h.getId());

        // ══════════════════════════════════════════════════
        //  OPERATION II : VIEW RECORD BY ID
        // ══════════════════════════════════════════════════
        System.out.println("\n========== VIEW RECORD BY ID ==========");

        System.out.print("Enter ID to search: ");
        int searchId = sc.nextInt();

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
        factory.close();
        sc.close();

        System.out.println("\n========== DONE ==========");
    }
}