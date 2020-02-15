package Entities;

/**
 * @Author Thomas V.Yttri
 */
public class Bil {
    private String bilMerke;
    private String modell;
    private String farge;
    private String klasse;
    private long regnr;
    private Utleigekontor lokasjon;
    private boolean ledig;

    /**
     * Constructor Bil
     * @param bilMerke
     * @param modell
     * @param farge
     * @param klasse
     * @param regnr
     * @param lokasjon
     */
    public Bil(String bilMerke, String modell, String farge, String klasse, long regnr, Utleigekontor lokasjon) {
        this.bilMerke = bilMerke;
        this.modell = modell;
        this.farge = farge;
        this.klasse = klasse;
        this.regnr = regnr;
        this.lokasjon = lokasjon;
        this.ledig = false;
    }


    /**
     * Getter & Setter
     *
     */
    public String getBilMerke() {
        return bilMerke;
    }

    public void setBilMerke(String bilMerke) {
        this.bilMerke = bilMerke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getFarge() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    public long getRegnr() {
        return regnr;
    }

    public void setRegnr(long regnr) {
        this.regnr = regnr;
    }

    public Utleigekontor getLokasjon() {
        return lokasjon;
    }

    public void setLokasjon(Utleigekontor lokasjon) {
        this.lokasjon = lokasjon;
    }

    public boolean isLedig() {
        return ledig;
    }

    public void setLedig(boolean ledig) {
        this.ledig = ledig;
    }
}
