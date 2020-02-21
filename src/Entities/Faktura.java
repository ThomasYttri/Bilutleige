package Entities;

/**
 * @Author Thomas V.Yttri
 */
public class Faktura {
    private Leigeforhold leigeforhold;
    private Bilutleigeselskap bilutleigeselskap;

    public Faktura (Leigeforhold leigeforhold, Bilutleigeselskap bilutleigeselskap) {
        this.leigeforhold = leigeforhold;
        this.bilutleigeselskap = bilutleigeselskap;
    }

    public void printFaktura() {
        System.out.println("******** FAKTURA ********" + "\n");
        System.out.println("Betalt av:" + "\n" + leigeforhold.getKunde().toString());
        System.out.println("\n" + "__________________________" + "\n");
        System.out.println("Betalt til:" + "\n" + bilutleigeselskap.toString());
        System.out.println("\n" + "__________________________" + "\n");
        System.out.println("SUM Å BETALE " + leigeforhold.getPris());
    }
}
