package Entities;

/**
 * @Author Thomas V.Yttri
 */
public class Faktura {
    private Leigeforhold leigeforhold;
    private String str;

    /**
     * Faktura Consturctor
     * @param leigeforhold
     * @param str
     */
    public Faktura (Leigeforhold leigeforhold, String str) {
        this.leigeforhold = leigeforhold;
        this.str = str;
    }

    /**
     * toString()
     * @return string
     */
    @Override
    public String toString() {
        return ("******** FAKTURA ********" + "\n" + "\n" + "Betales av:" + "\n" + leigeforhold.getKunde().toString() +
                "\n" + "\n" + "__________________________" + "\n" + "Betales til:" + "\n" + str +
                "\n" + "\n" + "__________________________" + "\n" + "SUM Å BETALE " + leigeforhold.getPris() + "\n");
    }
}
