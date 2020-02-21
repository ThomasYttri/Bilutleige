package Entities;

import java.time.LocalDate;
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

    public List<Leigeforhold> getLeigeforhold() {
        return leigeforhold;
    }

    public void setKontorListe(List<Utleigekontor> kontorListe){
        this.kontorListe = kontorListe;
    }

    /**
     * kontorBy - Retunereer kontor med lik poststed, om ikkje finnes retuneres null
     * @return kontor
     */
    public Utleigekontor kontorBy(String str){
        for(Utleigekontor kontor : kontorListe){
            if (kontor.getAdresse().getPoststed().equals(str)){
                return kontor;
            }
        }
        return null;
    }

    /**
     * kontorToString - Skriv ut alle poststed som har kontor
     */
    public void kontorToString() {
        for (Utleigekontor kontor : kontorListe) {
            System.out.println(kontor.getAdresse().getPoststed());
        }
    }

    /**
     * ledigeBiler - retunerer ein liste med alle ledige biler fra gitt kontor i gitt leigeperiode
     * @param utleigekontor
     * @param start
     * @param slutt
     * @return ledigeBiler
     */
    public List<Bil> ledigeBiler(Utleigekontor utleigekontor, LocalDate start, LocalDate slutt) {
        List<Bil> ledigeBiler = new ArrayList<>();

        //For alle biler ved utleigekontor, om den er ledig legg til i liste over ledige biler
        for(Bil bil : utleigekontor.getBiler()) {
            if(bil.isLedig(this.leigeforhold, start, slutt)){
                ledigeBiler.add(bil);
            }
        }
        return ledigeBiler;
    }

    /**
     * bilerToString - Skriver ut alle biler i gitt liste
     * @param biler
     */
    public void printBiler(List<Bil> biler) {
       for(Bil bil : biler) {
           System.out.println(bil.toString());
       }
    }

    /**
     * bilByReg - Returnerer bil med gitt regnr i gitt liste av biler
     * @param ledigeBiler
     * @param regnr
     * @return bil
     */
    public Bil bilByReg(List<Bil> ledigeBiler, String regnr) {
        for (Bil bil : ledigeBiler) {
            if (bil.getRegnr().equals(regnr)) {
                return bil;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return (navn + "\n" + firmaAdresse + "\n" + telefon);
    }

}
