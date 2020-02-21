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

    public String getRegnr() {
        return regnr;
    }

    public int getDagspris() {
        return dagspris;
    }

    @Override
    public String toString(){
        return ("Merke: " + bilMerke + " " + "Modell: " + modell + " " + "Farge: " + farge + " " + "Klasse: " + klasse + " " + "Regnr: " + regnr + " " + "Dagspris: " + dagspris);
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

}
