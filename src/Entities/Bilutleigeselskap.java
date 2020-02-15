package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Thomas V.Yttri
 */
public class Bilutleigeselskap {
    private String navn;
    private long telefon;
    private Adresse firmaAdresse;
    private List<Utleigekontor> kontor;

    /**
     * Constructor Bilutleigeselskap
     * @param navn
     * @param telefon
     * @param firmaAdresse
     */
    public Bilutleigeselskap(String navn, long telefon, Adresse firmaAdresse) {
        this.navn = navn;
        this.telefon = telefon;
        this.firmaAdresse = firmaAdresse;
        this.kontor = new ArrayList<>();
    }

    /**
     * Getters and Setters
     *
     */
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public long getTelefon() {
        return telefon;
    }

    public void setTelefon(long telefon) {
        this.telefon = telefon;
    }

    public Adresse getFirmaAdresse() {
        return firmaAdresse;
    }

    public void setFirmaAdresse(Adresse firmaAdresse) {
        this.firmaAdresse = firmaAdresse;
    }
}
