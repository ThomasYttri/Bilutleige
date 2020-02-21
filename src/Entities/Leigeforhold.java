package Entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    private Kontor leigekontor;
    private Kontor returkontor;
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
    public Leigeforhold(LocalDate start, LocalDate slutt, Kontor leigekontor, Kontor returkontor, Kunde kunde, Bil bil) {
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

    public int getPris() {
        return pris;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getSlutt() {
        return slutt;
    }

    public Kontor getReturkontor() {
        return returkontor;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public Bil getBil() {
        return bil;
    }

    public int getOrdrenr() {
        return ordrenr;
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
        pris = this.bil.getDagspris() * finnVarighet();
        if (leigekontor != returkontor){
            pris += AVGIFT;
        }
        return pris;
    }
}
