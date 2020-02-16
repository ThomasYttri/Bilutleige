package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Thomas V.Yttri
 */
public class Utleigekontor{
    private static final AtomicInteger teller = new AtomicInteger(0);
    private int kontornummer;
    private Adresse adresse;
    private long telefon;
    private List<Bil> biler;

    /**
     * Constructor Utleigekontor
     * @param adresse
     * @param telefon
     */
    public Utleigekontor(Adresse adresse, long telefon) {
        kontornummer = teller.incrementAndGet();
        this.adresse = adresse;
        this.telefon = telefon;
        this.biler = new ArrayList<>();
    }

    /**
     * Getters og Setters
     */
    public int getKontornummer() {
        return kontornummer;
    }

    public void setKontornummer(int kontornummer) {
        this.kontornummer = kontornummer;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public long getTelefon() {
        return telefon;
    }

    public void setTelefon(long telefon) {
        this.telefon = telefon;
    }

    public List<Bil> getBiler() {
        return biler;
    }

    public void setBiler(List<Bil> biler) {
        this.biler = biler;
    }

    /**
     * retur - Legger bil til i liste over biler
     * @param bil
     */
    public void retur(Bil bil){
        this.biler.add(bil);
    }

    /**
     * utleie - Fjerner bil fra liste over biler
     * @param bil
     */
    public void utleige(Bil bil){
        this.biler.remove(bil);
    }
}
