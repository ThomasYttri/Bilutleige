package Entities;

import java.util.Scanner;

/**
 * @Author Thomas V.Yttri
 */
public class Adresse {
    private String gateadresse;
    private int postnummer;
    private String poststed;

    /**
     * Adresse Empty Constuctor
     */
    public Adresse() {
    }

    /**
     * Constructor Adresse
     * @param gateadresse
     * @param postnummer
     * @param poststed
     */
    public Adresse(String gateadresse, int postnummer, String poststed) {
        this.gateadresse = gateadresse;
        this.postnummer = postnummer;
        this.poststed = poststed;
    }

    /**
     * Getters and Setters
     */
    public String getPoststed() {
        return poststed;
    }

    /**
     * readAdresse() - lar brukeren skrive inn adressen sin og retunerer eit adresse objekt
     * @return adresse
     */
    public Adresse readAdresse(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv din addresse");

        System.out.println("Gateaddresse:");
        String gate = scanner.next();

        System.out.println("Poststed: ");
        String sted = scanner.next();
        while (sted == null){
            System.out.println("Ugyldig poststed, prøv på nytt");
            sted = scanner.next();
        }

        System.out.println("Postnummer:");
        int postnr = scanner.nextInt();
        while ((int)(Math.log10(postnr) + 1) != 4) {
            System.out.println("Postnummer må bestå av fire siffer.");
            postnr = scanner.nextInt();
        }

        return new Adresse(gate, postnr, sted);
    }

    /**
     * toString()
     * @return string
     */
    @Override
    public String toString(){
        return (gateadresse + "\n" + postnummer + " " + poststed);
    }
}
