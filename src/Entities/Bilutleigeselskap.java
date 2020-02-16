package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            kontor.getAdresse().getPoststed().toString();
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
        List<Bil> bilerVedKontor = utleigekontor.getBiler().stream()
                .filter(b -> b.getLokasjon().equals(utleigekontor))
                .collect(Collectors.toList());

        // TODO: 2020-02-16
        // CLUSTErFUK
        //Biler som er ved kontor og ikkje utleigd
        for(Bil bil : bilerVedKontor) {
            for(Leigeforhold leigeforhold : leigeforhold) {
                if (leigeforhold.getBil().equals(bil)) {
                    if (leigeforhold.getSlutt().isBefore(start) || leigeforhold.getStart().isAfter(slutt)) {
                        ledigeBiler.add(leigeforhold.getBil());
                    }
                } else {
                    ledigeBiler.add(leigeforhold.getBil());
                }
            }
        }
        return ledigeBiler;
    }

    /**
     * bilerToString - Skriver ut alle biler i gitt liste
     * @param biler
     */
    public void bilerToString(List<Bil> biler) {
        for (Bil bil : biler){
            bil.toString();
        }
    }
}
