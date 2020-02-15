package Entities;

import java.util.Date;

/**
 * @Author Thomas V.Yttri
 */
public class Leieforhold {
    private Date start;
    private Date slutt;
    private Utleigekontor leigekontor;
    private Utleigekontor returkontor;
    private Kunde kunde;
    private Bil bil;
    private int pris;

    public Leieforhold(Date start, Date slutt, Utleigekontor leigekontor, Utleigekontor returkontor, Kunde kunde, Bil bil) {
        this.start = start;
        this.slutt = slutt;
        this.leigekontor = leigekontor;
        this.returkontor = returkontor;
        this.kunde = kunde;
        this.bil = bil;
    }

}
