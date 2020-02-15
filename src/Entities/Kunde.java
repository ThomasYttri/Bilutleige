package Entities;

/**
 * @Author Thomas V.Yttri
 */
public class Kunde {
    private String fornavn;
    private String etternavn;
    private Adresse adresse;
    private long telefon;

    /**
     * Constructor Kunde
     * @param fornavn
     * @param etternavn
     * @param adresse
     * @param telefon
     */
    public Kunde(String fornavn, String etternavn, Adresse adresse, long telefon) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.adresse = adresse;
        this.telefon = telefon;
    }

    /**
     * Getters and Setters
     *
     */

}
