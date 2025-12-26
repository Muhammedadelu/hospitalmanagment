package model;

public class Staff extends User {
    private String role;
    private String workplace; // Facility ID or name

    public Staff() {}

    public Staff(String id, String name, String contact, String role, String workplace) {
        super(id, name, contact);
        this.role = role;
        this.workplace = workplace;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public void manageOperations() {
        // Placeholder for admin operations
        System.out.println(getName() + " is managing operations.");
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}