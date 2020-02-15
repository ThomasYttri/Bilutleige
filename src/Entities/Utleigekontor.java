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

    public void kerk(){
        //Sjekke om bil er tilgjengelig på gitt kontor
        //sjekke om bil er tilgjengelig fra start dato
        //Sjekke om bil er tilgjengelig heilt til slutt dato
        //Opprette leigeforhold
        //Opprette faktura?
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
