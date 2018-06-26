package com.almaralengineering.pokedex;

public class Pokemon {
    private String id;
    private String name;
    private String imageUrl; //descagaremos de internet las imagene sd elos pokemons
    private int soundId;
    private Type type;
    private Stats stats;

    //para solo aceptar estos "tipos" de valores (enum)
    public enum Type {
        FIRE, WATER, PLANT, ELECTRIC
    }

    public Pokemon(String id, String name, String imageUrl, int soundId, Type type, Stats stats) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.soundId = soundId;
        this.type = type;
        this.stats = stats;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getSoundId() {
        return soundId;
    }

    public Type getType() {
        return type;
    }

    public Stats getStats(){
        return stats;
    }
}
