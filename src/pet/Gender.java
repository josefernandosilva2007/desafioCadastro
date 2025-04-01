package pet;

public enum Gender {
    MACHO("MACHO"),
    FEMEA("FEMEA");

    private String gender;

    Gender(String gender) {
        this.gender = gender;

    }

    public String getGender() {
        return gender;
    }
}
