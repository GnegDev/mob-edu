package com.gnegdev.final_2;

public class Row {
    private static int nextStrikeNumber = 0;
    private int strikeNumber;
    private String jotaroEnergy;
    private String dioEnergy;

    public Row(int jotaroEnergy, int dioEnergy) {
        this.strikeNumber = nextStrikeNumber;
        nextStrikeNumber ++;
        this.jotaroEnergy = jotaroEnergy + " / 100";
        this.dioEnergy = dioEnergy + " / 100";
    }

    public static void resetNextStrikeNumber() {
        nextStrikeNumber = 0;
    }

    public static int getNextStrikeNumber() {
        return nextStrikeNumber;
    }

    public int getStrikeNumber() {
        return strikeNumber;
    }

    public String getJotaroEnergy() {
        return jotaroEnergy;
    }

    public String getDioEnergy() {
        return dioEnergy;
    }
}
