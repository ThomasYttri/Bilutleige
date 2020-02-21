package Entities;

/**
 * @Author Thomas V.Yttri
 */
public class Adresse {
    private String gateadresse;
    private int postnummer;
    private String poststed;

    /**
     * Constructor Adresse
     * @param gateadresse
     * @param postnummer
     * @param poststed
     */
    public Adresse(String gateadresse, int postnummer, String poststed) {
        this.gateadresse = gateadresse;
        this.postnummer = postnummer;
        this.poststed = poststed;
    }

    /**
     * Getters and Setters
     */
    public String getGateadresse() {
        return gateadresse;
    }

    public void setGateadresse(String gateadresse) {
        this.gateadresse = gateadresse;
    }

    public int getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(int postnummer) {
        this.postnummer = postnummer;
    }

    public String getPoststed() {
        return poststed;
    }

    public void setPoststed(String poststed) {
        this.poststed = poststed;
    }

    /**
     * toString()
     * @return string
     */
    @Override
    public String toString(){
        return (gateadresse + "\n" + postnummer + " " + poststed);
    }
}
