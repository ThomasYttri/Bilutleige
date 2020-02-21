package Entities;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author Thomas V.Yttri
 */
public class Bil {
    private String bilMerke;
    private String modell;
    private String farge;
    private String klasse;
    private String regnr;
    private Kontor lokasjon;
    private int dagspris;
    private int kmstand;

    /**
     * Constructor Bil
     * @param bilMerke
     * @param modell
     * @param farge
     * @param klasse
     * @param regnr
     * @param lokasjon
     */
    public Bil(String bilMerke, String modell, String farge, String klasse, String regnr, Kontor lokasjon, int dagspris, int kmstand) {
        this.bilMerke = bilMerke;
        this.modell = modell;
        this.farge = farge;
        this.klasse = klasse;
        this.regnr = regnr;
        this.lokasjon = lokasjon;
        this.dagspris = dagspris;
        this.kmstand = kmstand;
    }

    /**
     * Getter & Setter
     *
     */
    public String getRegnr() {
        return regnr;
    }

    public int getDagspris() {
        return dagspris;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKmstand(int kmstand){
        this.kmstand = kmstand;
    }

    /**
     * isLedig - Retunerer true om bilen er ledig i gitt tidsrom
     * @param leigeforholdList
     * @param start
     * @param slutt
     * @return boolean
     */
    public boolean isLedig(List<Leigeforhold> leigeforholdList, LocalDate start, LocalDate slutt){
        for (Leigeforhold leigeforhold : leigeforholdList) {
            if (leigeforhold.getBil().getRegnr() == this.regnr) {
                if (start.isBefore(leigeforhold.getSlutt()) && slutt.isAfter(leigeforhold.getStart())){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * toString()
     * @return string
     */
    @Override
    public String toString(){
        return ("Bil: " + bilMerke + " " + modell + " " + "Farge: " + farge + " " + "Klasse: " + klasse + " " + "Regnr: " + regnr + " " + "Dagspris: " + dagspris);
    }
}
