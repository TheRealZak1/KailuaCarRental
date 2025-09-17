package model;

// jeg har valgt at lave en klasse til
// bilkategorier, da jeg definerede det i min analyse og diagram
// men bliver ikke anvendt. Har derfor ikke så mange funktioner og att. som først tænk

public class CarCategori {
    private int categoryId;   // PK
    private String name;      // fx "Luxury"
    private String description; // lidt tekst om kategorien


    public CarCategori() {}

    // konstrukter
    public CarCategori(int categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    // getters og setters
    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    // toString så jeg kan printe kategorien ud, hvis jeg har brug for det
    @Override
    public String toString() {
        return categoryId + ": " + name + " - " + description;
    }
}
