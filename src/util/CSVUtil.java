package util;

import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVUtil {

    private static final String DATA_PATH = "data/";

    // Date format used in your CSV files (adjust if different)
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static List<Patient> loadPatients() {
        List<Patient> patients = new ArrayList<>();
        String file = DATA_PATH + "patients.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6) {
                    Patient p = new Patient(
                            data[0].trim(),           // ID
                            data[1].trim(),           // Name
                            data[2].trim(),           // Contact
                            data[3].trim(),           // NHS Number
                            data[4].trim(),           // GP Surgery
                            data[5].trim()            // Medical History
                    );
                    patients.add(p);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading patients.csv: " + e.getMessage());
        }
        return patients;
    }

    public static List<Clinician> loadClinicians() {
        List<Clinician> clinicians = new ArrayList<>();
        String file = DATA_PATH + "clinicians.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6) {
                    String type = data[2].trim().toLowerCase(); // e.g., Doctor, Nurse, Specialist
                    Clinician c = null;

                    if (type.contains("gp") || type.contains("general")) {
                        c = new GeneralPractitioner(data[0].trim(), data[1].trim(), data[3].trim(), data[4].trim());
                    } else if (type.contains("specialist")) {
                        c = new Specialist(data[0].trim(), data[1].trim(), data[3].trim(), data[4].trim(), data[5].trim());
                    } else if (type.contains("nurse")) {
                        c = new Nurse(data[0].trim(), data[1].trim(), data[3].trim(), data[4].trim());
                    }

                    if (c != null) clinicians.add(c);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading clinicians.csv: " + e.getMessage());
        }
        return clinicians;
    }

    public static List<Facility> loadFacilities() {
        List<Facility> facilities = new ArrayList<>();
        String file = DATA_PATH + "facilities.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6) {
                    Facility f = new Facility(
                            data[0].trim(),
                            data[1].trim(),
                            data[2].trim(),
                            data[3].trim(),
                            data[4].trim(),
                            Integer.parseInt(data[5].trim())
                    );
                    facilities.add(f);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading facilities.csv: " + e.getMessage());
        }
        return facilities;
    }

    public static List<Appointment> loadAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String file = DATA_PATH + "appointments.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 7) {
                    Date date = null;
                    try {
                        date = DATE_FORMAT.parse(data[3].trim());
                    } catch (ParseException e) {
                        date = new Date(); // fallback
                    }

                    Appointment a = new Appointment(
                            data[0].trim(),
                            data[1].trim(),
                            data[2].trim(),
                            date,
                            data[4].trim(),
                            data[5].trim(),
                            data[6].trim()
                    );
                    appointments.add(a);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading appointments.csv: " + e.getMessage());
        }
        return appointments;
    }

    public static List<Prescription> loadPrescriptions() {
        List<Prescription> prescriptions = new ArrayList<>();
        String file = DATA_PATH + "prescriptions.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 7) {
                    Prescription p = new Prescription(
                            data[0].trim(),
                            data[1].trim(),
                            data[2].trim(),
                            data[3].trim(),
                            data[4].trim(),
                            data[5].trim(),
                            data[6].trim()
                    );
                    prescriptions.add(p);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading prescriptions.csv: " + e.getMessage());
        }
        return prescriptions;
    }

    public static List<Referral> loadReferrals() {
        List<Referral> referrals = new ArrayList<>();
        String file = DATA_PATH + "referrals.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 7) {
                    Date date = null;
                    try {
                        date = DATE_FORMAT.parse(data[6].trim());
                    } catch (ParseException e) {
                        date = new Date();
                    }

                    Referral r = new Referral(
                            data[0].trim(),
                            data[1].trim(),
                            data[2].trim(),
                            data[3].trim(),
                            data[4].trim(),
                            data[5].trim(),
                            date
                    );
                    referrals.add(r);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading referrals.csv: " + e.getMessage());
        }
        return referrals;
    }

    public static List<Staff> loadStaff() {
        List<Staff> staff = new ArrayList<>();
        String file = DATA_PATH + "staff.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    Staff s = new Staff(
                            data[0].trim(),
                            data[1].trim(),
                            data[2].trim(),
                            data[3].trim(),
                            data[4].trim()
                    );
                    staff.add(s);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading staff.csv: " + e.getMessage());
        }
        return staff;
    }
}