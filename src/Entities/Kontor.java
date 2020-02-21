package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Thomas V.Yttri
 */
public class Kontor {
    private static final AtomicInteger teller = new AtomicInteger(0);
    private int kontornummer;
    private Adresse adresse;
    private long telefon;
    private List<Bil> biler;

    /**
     * Constructor Kontor
     * @param adresse
     * @param telefon
     */
    public Kontor(Adresse adresse, long telefon) {
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

    public Adresse getAdresse() {
        return adresse;
    }

    public List<Bil> getBiler() {
        return biler;
    }

    /**
     * retur - Legger bil til i liste over biler
     * @param bil
     */
    public void retur(Bil bil){
        this.biler.add(bil);
    }

    /**
     * toString()
     * @return string
     */
    @Override
    public String toString(){
        return ("Kontornr: " + kontornummer + "\n" + telefon + "\n" + adresse.toString());
    }

}
