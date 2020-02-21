package Entities;

/**
 * @Author Thomas V.Yttri
 */
public class Faktura {
    private Leigeforhold leigeforhold;

    public Faktura (Leigeforhold leigeforhold) {
        this.leigeforhold = leigeforhold;
    }

    public void printFaktura() {
        System.out.println("******** FAKTURA ********");
        System.out.println("Betalt av: " + leigeforhold.getKunde().toString());
        System.out.println("Betalet til: " + leigeforhold.getLeigekontor().getAdresse());
        System.out.println("Referansenr leigeforhold: " + leigeforhold.getOrdrenr());
        System.out.println("Kontonr: " + leigeforhold.getLeigekontor().getKontornummer());
        System.out.println("Sum: " + leigeforhold.getPris());
    }
}
