package co.com.sofka.util;

public enum Hobbies {
    SPORTS("Sports"),
    READING("Reading"),
    MUSIC("Music");

    private final String pasatiempo;

    public String getPasatiempo() {
        return pasatiempo;
    }

    private Hobbies(String pasatiempo) {
        this.pasatiempo = pasatiempo;
    }
}
