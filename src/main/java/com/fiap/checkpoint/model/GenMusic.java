package com.fiap.checkpoint.model;

public enum GenMusic {

    ROCK("Rock"),
    POP("Pop"),
    HIPHOP("Hip Hop"),
    REGGAE("Reggae"),
    KPOP("K-pop"),
    RNB("R&B"),
    METAL("Metal");

    private final String label;

    GenMusic(String label) {
        this.label = label;
    }



    public String getLabel() {
        return label;
    }
}
