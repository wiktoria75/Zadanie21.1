package com.example.zadanie;

public enum Category {

    FOOD("Art. spożywcze", "spozywcze"),
    HOUSEHOLD_ITEMS("Art. gosp. domowego", "domowe"),
    OTHER("Inne", "inne");

    private String description;
    private String plName;

    Category(String description, String plName) {
        this.description = description;
        this.plName = plName;
    }

    public String getDescription() {
        return description;
    }

    public String getPlName() {
        return plName;
    }

    public static Category findByPlName(String givenPlName) {
        for (Category category : values()) {
            if (category.plName.equals(givenPlName)) {
                return category;
            }
        }
        return null;
    }
}
