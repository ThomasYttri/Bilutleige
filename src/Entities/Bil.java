package Entities;

import java.time.LocalDate;

/**
 * @Author Thomas V.Yttri
 */
public class Bil {
    private String bilMerke;
    private String modell;
    private String farge;
    private String klasse;
    private String regnr;
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
    public Bil(String bilMerke, String modell, String farge, String klasse, String regnr, Utleigekontor lokasjon, int dagspris) {
        this.bilMerke = bilMerke;
        this.modell = modell;
        this.farge = farge;
        this.klasse = klasse;
        this.regnr = regnr;
        this.lokasjon = lokasjon;
        this.dagspris = dagspris;
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

    public String getRegnr() {
        return regnr;
    }

    public void setRegnr(String regnr) {
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

    public void setDagspris(int dagspris) {
        this.dagspris = dagspris;
    }

    public int getDagspris() {
        return dagspris;
    }

    @Override
    public String toString(){
        return ("Merke: " + bilMerke + " " + "Modell: " + modell + " " + "Farge: " + farge + " " + "Klasse: " + klasse + " " + "Regnr: " + regnr + " " + "Dagspris: " + dagspris);
    }

    /*
    public boolean isLedig(Bilutleigeselskap bilutleigeselskap, LocalDate start, LocalDate slutt){
        for (Leigeforhold leigeforhold : bilutleigeselskap.getLeigeforhold()) {
            if (leigeforhold.getBil().getRegnr() == this.regnr) {
                if (leigeforhold.getStart().isAfter(slutt) || leigeforhold.getSlutt().isBefore(start)){
                    return true;
                }
            }
        }
    }
    
     */
}
