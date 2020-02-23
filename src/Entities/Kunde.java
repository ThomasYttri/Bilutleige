package Entities;

import java.util.Scanner;

/**
 * @Author Thomas V.Yttri
 */
public class Kunde {
    private String fornavn;
    private String etternavn;
    private Adresse adresse;
    private long telefon;
    private Faktura faktura;
    private Long kortnummer;


    /**
     * Constructor Kunde - Empty
     */
    public Kunde() {
    }

    /**
     * Constructor Kunde
     * @param fornavn
     * @param etternavn
     * @param adresse
     * @param telefon
     * @param kortnummer
     */
    public Kunde(String fornavn, String etternavn, Adresse adresse, long telefon, long kortnummer) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.adresse = adresse;
        this.telefon = telefon;
        this.kortnummer = kortnummer;
    }

    /**
     * Getters and Setters
     *
     */

    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }

    public Faktura getFaktura(){
        return this.faktura;
    }

    /**
     * readKunde() - Leser inn kundeinformasjon og retunerer nytt kunde objekt
     * @return kunde
     */
    public Kunde readKunde(){
        Scanner scanner = new Scanner(System.in);
        Adresse adr = new Adresse();

        //Fornavn
        System.out.println("Skriv ditt fornavn");
        String fornavn = scanner.next();

        //Etternavn
        System.out.println("Skriv ditt etternavn");
        String etternavn = scanner.next();

        //Telefonnummer
        System.out.println("Skriv ditt telefonnummer");
        long tlf = scanner.nextLong();

        //Kortnummer
        System.out.println("Kortnummer:");
        long kortnr = scanner.nextLong();

        //Adresse
        adr = adr.readAdresse();

        return new Kunde(fornavn, etternavn, adr, tlf, kortnr);
    }

    /**
     * toString()
     * @return string
     */
    @Override
    public String toString(){
        return (fornavn + " " + etternavn + "\n" +  telefon + "\n" + adresse.toString());
    }
}
