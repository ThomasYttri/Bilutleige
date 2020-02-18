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
    private Utleigekontor leigekontor;
    private Utleigekontor returkontor;
    private Kunde kunde;
    private Bil bil;
    private static final AtomicInteger teller = new AtomicInteger(1000);
    private int ordrenr;

    /**
     * Constructor Leigeforhold - Empty
     */
    public Leigeforhold(){
        this.ordrenr = teller.incrementAndGet();
    }
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

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public int getVarighet() {
        return varighet;
    }

    public void setVarighet(int varighet) {
        this.varighet = varighet;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getSlutt() {
        return slutt;
    }

    public void setSlutt(LocalDate slutt) {
        this.slutt = slutt;
    }

    public Utleigekontor getLeigekontor() {
        return leigekontor;
    }

    public void setLeigekontor(Utleigekontor leigekontor) {
        this.leigekontor = leigekontor;
    }

    public Utleigekontor getReturkontor() {
        return returkontor;
    }

    public void setReturkontor(Utleigekontor returkontor) {
        this.returkontor = returkontor;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Bil getBil() {
        return bil;
    }

    public void setBil(Bil bil) {
        this.bil = bil;
    }

    public static AtomicInteger getTeller() {
        return teller;
    }

    public int getOrdrenr() {
        return ordrenr;
    }

    public void setOrdrenr(int ordrenr) {
        this.ordrenr = ordrenr;
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

    public boolean sjekkDato(LocalDate startdato, LocalDate sluttdato) {
        if (startdato.isBefore(sluttdato) && startdato.isAfter(LocalDate.now())){
            return true;
        }
        return false;
    }
}
