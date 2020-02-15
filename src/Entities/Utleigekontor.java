package Entities;

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
}
