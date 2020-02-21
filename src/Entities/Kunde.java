package Entities;

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
     * Constructor Kunde Empty
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
     * toString()
     * @return string
     */
    @Override
    public String toString(){
        return (fornavn + " " + etternavn + "\n" +  telefon + "\n" + adresse.toString());
    }
}
