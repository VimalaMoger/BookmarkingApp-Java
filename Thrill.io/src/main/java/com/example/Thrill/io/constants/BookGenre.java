package com.example.Thrill.io.constants;

public enum BookGenre {

    ART("Art"),
    BIOGRAPHY("Biography"),
    CHILDREN("Children"),
    FICTION ("Fiction"),
    HISTORY("History"),
    MYSTERY("Mistery"),
    PHILOSOPHY("Philosophy"),
    RELIGION("Religion"),
    ROMANCE("Romance"),
    SELFT_HELP("Self help"),
    TECHNICAL("Technical");


    private BookGenre(String name) {
        this.name = name;
    }
    private String name;
    public String getName() {
        return name;
    }

    public static BookGenre valueOfName(String feature) {
        for (BookGenre e : values()) {
            if (e.name.equals(feature)) {
                return e;
            }
        }
        return null;
    }
}
