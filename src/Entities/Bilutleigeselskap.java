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
    private List<Utleigekontor> kontorListe;
    private List<Leigeforhold> leigeforhold;

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
        this.kontorListe = new ArrayList<>();
        this.leigeforhold = new ArrayList<>();
    }

    /**
     * Getters and Setters
     *
     */
    public List<Utleigekontor> getKontor() {
        return kontorListe;
    }

    /**
     *
     * @return
     */
    public Utleigekontor kontorBy(String str){
        for(Utleigekontor kontor : kontorListe){
            if (kontor.getAdresse().getPoststed().equals(str)){
                return kontor;
            }
        }
        return null;
    }

    public void kontorToString() {
        for (Utleigekontor kontor : kontorListe) {
            kontor.getAdresse().getPoststed().toString();
        }
    }
}
