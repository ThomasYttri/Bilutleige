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
    private int dagspris;

    /**
     * Constructor Bil
     * @param bilMerke
     * @param modell
     * @param farge
     * @param klasse
     * @param regnr
     * @param lokasjon
     */
    public Bil(String bilMerke, String modell, String farge, String klasse, long regnr, Utleigekontor lokasjon, int dagspris) {
        this.bilMerke = bilMerke;
        this.modell = modell;
        this.farge = farge;
        this.klasse = klasse;
        this.regnr = regnr;
        this.lokasjon = lokasjon;
        this.dagspris = dagspris;
        this.ledig = false;
    }

    /**
     * Getter & Setter
     *
     */
    public int getDagspris() {
        return dagspris;
    }
}
