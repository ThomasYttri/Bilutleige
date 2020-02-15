package Entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Thomas V.Yttri
 */
public class Leigeforhold {
    private final int AVGIFT = 500;
    private int pris;
    private int varighet;
    private LocalDate start;
    private LocalDate slutt;
    private Utleigekontor leigekontor;
    private Utleigekontor returkontor;
    private Kunde kunde;
    private Bil bil;
    private static final AtomicInteger teller = new AtomicInteger(1000);
    private int ordrenr;

    /**
     * Constructor Leigeforhold
     * @param start
     * @param slutt
     * @param leigekontor
     * @param returkontor
     * @param kunde
     * @param bil
     */
    public Leigeforhold(LocalDate start, LocalDate slutt, Utleigekontor leigekontor, Utleigekontor returkontor, Kunde kunde, Bil bil) {
        this.start = start;
        this.slutt = slutt;
        this.leigekontor = leigekontor;
        this.returkontor = returkontor;
        this.kunde = kunde;
        this.bil = bil;
        this.ordrenr = teller.incrementAndGet();
        this.varighet = finnVarighet();
        this.pris = finnPris();
    }

    /**
     * finnVarighet() - Finner varigheten på leigeforholdet
     * @return varighet
     */
    public int finnVarighet(){
        long dager = ChronoUnit.DAYS.between(start, slutt);
        this.varighet = Math.toIntExact(dager);
        return varighet;
    }

    /**
     * finnPris() - Rekner ut pris på leigeforhold
     * @return pris
     */
    public int finnPris(){
        pris = bil.getDagspris() * varighet;
        if (leigekontor != returkontor){
            pris += AVGIFT;
        }
        return pris;
    }
}
