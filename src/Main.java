import model.*;
import util.CSVUtil;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Load data first
        List<Patient> patients = CSVUtil.loadPatients();
        List<Referral> loadedReferrals = CSVUtil.loadReferrals();

        // Test Singleton
        ReferralManager manager1 = ReferralManager.getInstance();
        ReferralManager manager2 = ReferralManager.getInstance();

        System.out.println("\nSingleton Test:");
        System.out.println("Same instance? " + (manager1 == manager2)); // Should print true

        // Create a test referral
        if (!patients.isEmpty()) {
            Patient p = patients.get(0);
            Referral testReferral = new Referral(
                    "R999", p.getId(), "GP001", "F002",
                    "Suspected cardiac issue - urgent review needed", "High", new Date()
            );

            manager1.createReferral(testReferral);

            System.out.println("Total referrals managed: " + manager1.getReferralCount());
        }

        // Load existing referrals into manager if you want
        for (Referral r : loadedReferrals) {
            manager1.createReferral(r);
        }
    }
}