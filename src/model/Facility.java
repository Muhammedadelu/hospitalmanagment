package model;

public class Facility {
    private String id;
    private String name;
    private String type; // e.g., GP Surgery, Hospital
    private String services;
    private String contact;
    private int capacity;

    public Facility() {}

    public Facility(String id, String name, String type, String services, String contact, int capacity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.services = services;
        this.contact = contact;
        this.capacity = capacity;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getServices() { return services; }
    public void setServices(String services) { this.services = services; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    @Override
    public String toString() {
        return "Facility{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}