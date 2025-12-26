package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReferralManager {
    // Singleton instance
    private static ReferralManager instance;

    // List to hold all referrals
    private List<Referral> referrals;

    // File for simulating "email" output
    private static final String OUTPUT_FILE = "referrals_output.txt";

    // Private constructor - prevents direct instantiation
    private ReferralManager() {
        referrals = new ArrayList<>();
        // Clear output file on startup (or append – your choice)
        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE))) {
            writer.println("=== Referral Email Log - Generated on " + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()) + " ===");
        } catch (IOException e) {
            System.err.println("Could not initialize referral log file.");
        }
    }

    // Public method to get the single instance
    public static ReferralManager getInstance() {
        if (instance == null) {
            instance = new ReferralManager();
        }
        return instance;
    }

    // Add a new referral
    public void createReferral(Referral referral) {
        if (referral != null) {
            referrals.add(referral);
            sendReferralViaEmail(referral);
            updateEHR(referral);
            System.out.println("Referral created and processed: " + referral.getId());
        }
    }

    // Simulate sending email by writing to text file
    private void sendReferralViaEmail(Referral referral) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE, true))) {
            writer.println("\n--- Referral Email Sent ---");
            writer.println("To: " + referral.getToFacilityId());
            writer.println("Patient: " + referral.getPatientId());
            writer.println("From: Clinician " + referral.getFromClinicianId());
            writer.println("Urgency: " + referral.getUrgency());
            writer.println("Summary: " + referral.getSummary());
            writer.println("Date: " + referral.getDate());
            writer.println("---------------------------");
        } catch (IOException e) {
            System.err.println("Failed to log referral email: " + e.getMessage());
        }
    }

    // Simulate EHR update
    private void updateEHR(Referral referral) {
        // In real system: update database
        // Here: just print simulation
        System.out.println("EHR updated for patient " + referral.getPatientId() + " with referral " + referral.getId());
    }

    public List<Referral> getAllReferrals() {
        return new ArrayList<>(referrals); // Return copy for safety
    }

    public int getReferralCount() {
        return referrals.size();
    }
}