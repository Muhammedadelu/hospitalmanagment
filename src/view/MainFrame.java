package view;

import model.*;
import util.CSVUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;

    private List<Patient> patients;
    private List<Appointment> appointments;
    private List<Prescription> prescriptions;
    private List<Referral> referrals;

    public MainFrame() {
        setTitle("Healthcare Management System");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.TOP);

        loadAllData();

        tabbedPane.addTab("Patients", createPatientsPanel());
        tabbedPane.addTab("Appointments", createAppointmentsPanel());
        tabbedPane.addTab("Prescriptions", createPrescriptionsPanel());
        tabbedPane.addTab("Referrals", createReferralsPanel());

        add(tabbedPane);
    }

    private void loadAllData() {
        patients = CSVUtil.loadPatients();
        appointments = CSVUtil.loadAppointments();
        prescriptions = CSVUtil.loadPrescriptions();
        referrals = CSVUtil.loadReferrals();
    }

    //  PATIENTS TAB
    private JPanel createPatientsPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] columns = {"ID", "Name", "Contact", "NHS Number", "GP Surgery", "Medical History"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Patient p : patients) {
            model.addRow(new Object[]{
                    p.getId(),
                    p.getName(),
                    p.getContact(),
                    p.getNhsNumber(),
                    p.getGpSurgery(),
                    p.getMedicalHistory()
            });
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Buttons at TOP
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addButton = new JButton("Add New Patient");
        JButton editButton = new JButton("Edit Selected Patient");
        JButton deleteButton = new JButton("Delete Selected Patient");

        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        editButton.setFont(new Font("Arial", Font.BOLD, 14));
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));

        // === ADD NEW PATIENT ===
        addButton.addActionListener(e -> {
            String firstName = JOptionPane.showInputDialog(this, "Enter First Name:");
            if (firstName == null || firstName.trim().isEmpty()) return;

            String lastName = JOptionPane.showInputDialog(this, "Enter Last Name:");
            if (lastName == null || lastName.trim().isEmpty()) return;

            String fullName = firstName.trim() + " " + lastName.trim();

            String contact = JOptionPane.showInputDialog(this, "Enter Contact (Email/Phone):", "email@example.com");
            if (contact == null) contact = "email@example.com";

            String nhsNumber = JOptionPane.showInputDialog(this, "Enter NHS Number:");
            if (nhsNumber == null || nhsNumber.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "NHS Number is required!");
                return;
            }

            String gpSurgery = JOptionPane.showInputDialog(this, "Enter GP Surgery:", "Central GP Surgery");
            if (gpSurgery == null) gpSurgery = "Central GP Surgery";

            String medicalHistory = JOptionPane.showInputDialog(this, "Enter Medical History (optional):", "None recorded");
            if (medicalHistory == null) medicalHistory = "None recorded";

            String newId = "P" + String.format("%03d", patients.size() + 100);

            Patient newPatient = new Patient(newId, fullName, contact.trim(),
                    nhsNumber.trim(), gpSurgery.trim(), medicalHistory.trim());

            patients.add(newPatient);
            model.addRow(new Object[]{
                    newPatient.getId(), newPatient.getName(), newPatient.getContact(),
                    newPatient.getNhsNumber(), newPatient.getGpSurgery(), newPatient.getMedicalHistory()
            });

            JOptionPane.showMessageDialog(this, "Patient " + newId + " added successfully!");
        });

        // === EDIT SELECTED PATIENT ===
        editButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "Please select a patient to edit.");
                return;
            }

            Patient patient = patients.get(selectedRow);

            String name = JOptionPane.showInputDialog(this, "Edit Name:", patient.getName());
            if (name != null && !name.trim().isEmpty()) patient.setName(name.trim());

            String contact = JOptionPane.showInputDialog(this, "Edit Contact:", patient.getContact());
            if (contact != null) patient.setContact(contact.trim());

            String nhs = JOptionPane.showInputDialog(this, "Edit NHS Number:", patient.getNhsNumber());
            if (nhs != null && !nhs.trim().isEmpty()) patient.setNhsNumber(nhs.trim());

            String gp = JOptionPane.showInputDialog(this, "Edit GP Surgery:", patient.getGpSurgery());
            if (gp != null) patient.setGpSurgery(gp.trim());

            String history = JOptionPane.showInputDialog(this, "Edit Medical History:", patient.getMedicalHistory());
            if (history != null) patient.setMedicalHistory(history.trim());

            // Update table row
            model.setValueAt(patient.getName(), selectedRow, 1);
            model.setValueAt(patient.getContact(), selectedRow, 2);
            model.setValueAt(patient.getNhsNumber(), selectedRow, 3);
            model.setValueAt(patient.getGpSurgery(), selectedRow, 4);
            model.setValueAt(patient.getMedicalHistory(), selectedRow, 5);

            JOptionPane.showMessageDialog(this, "Patient updated successfully!");
        });

        // === DELETE SELECTED PATIENT ===
        deleteButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                model.removeRow(row);
                patients.remove(row);
                JOptionPane.showMessageDialog(this, "Patient deleted.");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a patient to delete.");
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    // APPOINTMENTS TAB
    private JPanel createAppointmentsPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] columns = {"ID", "Patient ID", "Clinician ID", "Date", "Time", "Status", "Reason"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Appointment a : appointments) {
            model.addRow(new Object[]{
                    a.getId(), a.getPatientId(), a.getClinicianId(),
                    a.getDate(), a.getTime(), a.getStatus(), a.getReason()
            });
        }

        JTable table = new JTable(model);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    //  PRESCRIPTIONS TAB
    private JPanel createPrescriptionsPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] columns = {"ID", "Patient ID", "Clinician ID", "Medication", "Dosage", "Pharmacy", "Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Prescription p : prescriptions) {
            model.addRow(new Object[]{
                    p.getId(), p.getPatientId(), p.getClinicianId(),
                    p.getMedication(), p.getDosage(), p.getPharmacy(), p.getCollectionStatus()
            });
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addButton = new JButton("Create New Prescription");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));

        addButton.addActionListener(e -> {
            String patientId = JOptionPane.showInputDialog(this, "Patient ID:");
            String clinicianId = JOptionPane.showInputDialog(this, "Clinician ID:");
            String medication = JOptionPane.showInputDialog(this, "Medication:");
            String dosage = JOptionPane.showInputDialog(this, "Dosage:");
            String pharmacy = JOptionPane.showInputDialog(this, "Pharmacy:");

            if (patientId != null && medication != null && !patientId.trim().isEmpty()) {
                String newId = "PR" + (prescriptions.size() + 100);
                Prescription newPres = new Prescription(newId, patientId.trim(),
                        clinicianId != null ? clinicianId.trim() : "GP001",
                        medication.trim(), dosage != null ? dosage.trim() : "",
                        pharmacy != null ? pharmacy.trim() : "Local", "Pending");

                prescriptions.add(newPres);
                model.addRow(new Object[]{
                        newPres.getId(), newPres.getPatientId(), newPres.getClinicianId(),
                        newPres.getMedication(), newPres.getDosage(), newPres.getPharmacy(), newPres.getCollectionStatus()
                });

                JOptionPane.showMessageDialog(this, "Prescription " + newId + " created!");
            }
        });

        buttonPanel.add(addButton);
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    //  REFERRALS TAB
    private JPanel createReferralsPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] columns = {"ID", "Patient ID", "From Clinician", "To Facility", "Summary", "Urgency", "Date"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Referral r : referrals) {
            model.addRow(new Object[]{
                    r.getId(), r.getPatientId(), r.getFromClinicianId(),
                    r.getToFacilityId(), r.getSummary(), r.getUrgency(), r.getDate()
            });
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton newReferralButton = new JButton("Create New Referral (Singleton)");
        newReferralButton.setFont(new Font("Arial", Font.BOLD, 14));

        newReferralButton.addActionListener(e -> {
            String patientId = JOptionPane.showInputDialog(this, "Patient ID:");
            String fromClinician = JOptionPane.showInputDialog(this, "From Clinician ID:");
            String toFacility = JOptionPane.showInputDialog(this, "To Facility ID:");
            String summary = JOptionPane.showInputDialog(this, "Clinical Summary:");
            String urgency = JOptionPane.showInputDialog(this, "Urgency (Low/Medium/High):");

            if (patientId != null && summary != null && !patientId.trim().isEmpty()) {
                String newId = "R" + (referrals.size() + 100);
                Referral newReferral = new Referral(newId, patientId.trim(),
                        fromClinician != null ? fromClinician.trim() : "GP001",
                        toFacility != null ? toFacility.trim() : "Hospital",
                        summary.trim(),
                        urgency != null ? urgency.trim() : "Medium",
                        new Date());

                ReferralManager.getInstance().createReferral(newReferral);

                referrals.add(newReferral);
                model.addRow(new Object[]{
                        newReferral.getId(), newReferral.getPatientId(), newReferral.getFromClinicianId(),
                        newReferral.getToFacilityId(), newReferral.getSummary(),
                        newReferral.getUrgency(), newReferral.getDate()
                });

                JOptionPane.showMessageDialog(this,
                        "Referral " + newId + " created!\nCheck referrals_output.txt");
            }
        });

        buttonPanel.add(newReferralButton);
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            new MainFrame().setVisible(true);
        });
    }
}