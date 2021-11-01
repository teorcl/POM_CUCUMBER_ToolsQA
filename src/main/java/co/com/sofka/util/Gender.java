package co.com.sofka.util;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private final String genero;

    public String getGenero() {
        return genero;
    }

    private Gender(String genero) {
        this.genero = genero;
    }
}
