package lvov.lab4.lab2.model;

public enum Systems {
    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System");

    private final String description;

    Systems(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public static Systems fromString(String value) {
        for (Systems system : values()) {
            if (system.name().equalsIgnoreCase(value)) {
                return system;
            }
        }
        return null;
    }
}
