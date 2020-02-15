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
    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
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
}
