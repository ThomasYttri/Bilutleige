package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Thomas V.Yttri
 */
public class Selskap {
    private String navn;
    private long telefon;
    private Adresse firmaAdresse;
    private List<Kontor> kontorListe;
    private List<Leigeforhold> leigeforholdListe;
    private long kontonummer;

    /**
     * Constructor Selskap
     * @param navn
     * @param telefon
     * @param firmaAdresse
     */
    public Selskap(String navn, long telefon, Adresse firmaAdresse, long kontonummer) {
        this.navn = navn;
        this.telefon = telefon;
        this.firmaAdresse = firmaAdresse;
        this.kontorListe = new ArrayList<>();
        this.leigeforholdListe = new ArrayList<>();
        this.kontonummer = kontonummer;
    }

    /**
     * Getters and Setters
     *
     */
    public List<Kontor> getKontor() {
        return kontorListe;
    }

    public List<Leigeforhold> getLeigeforholdListe() {
        return leigeforholdListe;
    }

    public void setKontorListe(List<Kontor> kontorListe){
        this.kontorListe = kontorListe;
    }

    /**
     * leigBil - Tar kunden gjennom heile prossessen for å bestille ein bil
     */
    public void leigBil() {
        System.out.println("********************** Velkommen til " + this.navn + " **********************");
        Kunde kunde = new Kunde();
        Scanner scanner = new Scanner(System.in);

        //Velge kontor
        List<Kontor> kontor = getKontor();
        System.out.println("Kor vil du leige bil frå? Velg ved å skrive navn på by. Mulige valg er: ");
        kontorByPrint();
        Kontor startKontor = kontorBy(scanner.next());
        while (startKontor == null) {
            System.out.println("Kjenner ikke igjen bynavn, hugs stor forbokstav");
            startKontor = kontorBy(scanner.next());
        }

        //Velge returkontor
        System.out.println("Kor vil du levere bilen? Velg ved å skrive navn på by.");
        Kontor sluttKontor = kontorBy(scanner.next());
        while (sluttKontor == null) {
            System.out.println("Kjenner ikke igjen bynavn, hugs stor forbokstav");
            sluttKontor = kontorBy(scanner.next());
        }

        //Hente dato
        System.out.println("Dato for henting av bil, skrives i formatet: yyyy mm dd");
        LocalDate startdato = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        while (startdato.isBefore(LocalDate.now())) {
            System.out.println("Datoen er før dagens dato, prøv igjen");
            startdato = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        //Retur dato
        System.out.println("Dato for retur av bil, skrives i formatet: dd mm yyyy");
        LocalDate sluttdato = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        while (sluttdato.isBefore(startdato)) {
            System.out.println("Datoen er før startdato, prøv igjen.");
            sluttdato = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        //Velge bilklasse
        System.out.println("Hvilken bilklasse ønsker du å leige? Velg mellom A - Liten bil, B - Medium bil, C - Premium bil, D - Luksusbil");
        System.out.println("Velg ved å skrive A, B, C eller D");
        String klasse = scanner.next();
        while (!(klasse.equals("A") || klasse.equals("B") || klasse.equals("C") || klasse.equals("D"))) {
            System.out.println("Ugyldig klasse, prøv på nytt");
            klasse = scanner.next();
        }

        //Sjekk ledige biler
        System.out.println("Ledige biler fra " + startKontor.getAdresse().getPoststed() + " i perioden: " + startdato + " til: " + sluttdato);
        List<Bil> alleLedige = ledigeBiler(startKontor, startdato, sluttdato);
        List<Bil> ledigeBiler = new ArrayList<>();
        for (Bil bil : alleLedige) {
            if (bil.getKlasse().equals(klasse)) {
                ledigeBiler.add(bil);
            }
        }
        printBiler(ledigeBiler);

        //Velg bil
        System.out.println("Velg ønsket bil ved å skrive regnr.");
        String regnr = scanner.next();
        Bil leigebil = bilByReg(ledigeBiler, regnr);
        while (leigebil == null) {
            System.out.println("Ugyldig regnr, prøv på nytt");
            regnr = scanner.next();
            leigebil = bilByReg(ledigeBiler, regnr);
        }

        kunde = kunde.readKunde();

        //Opprette leigeforhold
        Leigeforhold leigeforhold = new Leigeforhold(startdato, sluttdato, startKontor, sluttKontor, kunde, leigebil);
        //Legger leigeforhold til i lista for selskapet
        getLeigeforholdListe().add(leigeforhold);
        //Legger faktura til kunden
        kunde.setFaktura(new Faktura(leigeforhold, toString()));

        System.out.println("Takk for din bestilling! Ditt referansenr er: " + leigeforhold.getOrdrenr());

        //Printer faktura
        System.out.println("Din faktura: ");
        System.out.println(kunde.getFaktura().toString());
    }

    /**
     * returBil - retunerer bilen til gitt returkontor, endrer kmstand og sletter leigeforholdet.
     * @param leigeforhold
     * @param kmstand
     */
    public void returBil(Leigeforhold leigeforhold, int kmstand){
        leigeforhold.getBil().setKmstand(kmstand);
        leigeforhold.getReturkontor().leggTilBil(leigeforhold.getBil());
        leigeforhold.getKunde().getFaktura().toString();
        leigeforholdListe.remove(leigeforhold);
    }

    /**
     * kontorBy - Retunereer kontor med lik poststed, om ikkje finnes retuneres null
     * @return kontor
     */
    public Kontor kontorBy(String str){
        for(Kontor kontor : kontorListe){
            if (kontor.getAdresse().getPoststed().equals(str)){
                return kontor;
            }
        }
        return null;
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

    /**
     * ledigeBiler - retunerer ein liste med alle ledige biler fra gitt kontor i gitt leigeperiode
     * @param kontor
     * @param start
     * @param slutt
     * @return ledigeBiler
     */
    public List<Bil> ledigeBiler(Kontor kontor, LocalDate start, LocalDate slutt) {
        List<Bil> ledigeBiler = new ArrayList<>();
        //For alle biler ved kontor, om den er ledig legg til i liste over ledige biler
        for(Bil bil : kontor.getBiler()) {
            if(bil.isLedig(this.leigeforholdListe, start, slutt)){
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
     * kontorToString - Skriv ut alle poststed som har kontor
     */
    public void kontorByPrint() {
        for (Kontor kontor : kontorListe) {
            System.out.println(kontor.getAdresse().getPoststed());
        }
    }

    /**
     * toString()
     * @return string
     */
    @Override
    public String toString(){
        return (navn + "\n" + firmaAdresse + "\n" + "Tlf: " + telefon + "\n" + "Kontonummer: " + kontonummer);
    }

}
