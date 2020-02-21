package Controller;

import Entities.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Thomas V.Yttri
 */
public class BilutleigeKontroller {
    private static Selskap selskap;

    /**
     * Constructor BilutleigeKontroller
     */
    public BilutleigeKontroller(Selskap selskap) {
        this.selskap = selskap;
    }

    /**
     * GETTER / SETTER
     */
    public static Selskap getSelskap() {
        return selskap;
    }



    /*
    public void start() {
        Scanner scanner = new Scanner(System.in);
        Kunde kunde = new Kunde();
        Leigeforhold leigeforhold = new Leigeforhold();

        //Velge kontor
        List<Kontor> utleigekontor = selskap.getKontor();
        System.out.println("Kor vil du leige bil frå? Velg ved å skrive navn på by. Mulige valg er: ");
        selskap.kontorToString();
        Kontor startKontor = selskap.kontorBy(scanner.next());
        while (startKontor == null) {
            System.out.println("Kjenner ikke igjen bynavn, hugs stor forbokstav");
            startKontor = selskap.kontorBy(scanner.next());
        }

        //Velge returkontor
        System.out.println("Kor vil du levere bilen? Velg ved å skrive navn på by.");
        Kontor sluttKontor = selskap.kontorBy(scanner.next());
        while (sluttKontor == null) {
            System.out.println("Kjenner ikke igjen bynavn, hugs stor forbokstav");
            sluttKontor = selskap.kontorBy(scanner.next());
        }

        //Hente dato
        System.out.println("Dato for henting av bil, skrives i formatet: yyyy mm dd");
        LocalDate startdato = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        while (startdato.isBefore(LocalDate.now())) {
            System.out.println("Datoen er før dagens dato, prøv igjen");
            startdato = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }


        //Retur dato
        System.out.println("Dato for retur av bil, skrives i formatet: dd mm yyyy");
        LocalDate sluttdato = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        while (sluttdato.isBefore(startdato)) {
            System.out.println("Datoen er før startdato, prøv igjen.");
            sluttdato = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        //Velge bilklasse
        System.out.println("Hvilken bilklasse ønsker du å leige? Velg mellom A - Liten bil, B - Medium bil, C - Premium bil, D - Luksusbil");
        System.out.println("Velg ved å skrive A, B, C eller D");

        //Sjekk ledige biler
        System.out.println("Ledige biler fra " + startKontor.getAdresse().getPoststed() + " i perioden: " + startdato + " til: " + sluttdato);
        List<Bil> alleLedige = selskap.ledigeBiler(startKontor, startdato, sluttdato);
        List<Bil> ledigeBiler = new ArrayList<>();
        for (Bil bil : alleLedige) {
            if (bil.getKlasse() == scanner.next()) {
                ledigeBiler.add(bil);
            }
        }
        selskap.printBiler(ledigeBiler);

        //Velg bil
        System.out.println("Velg ønsket bil ved å skrive regnr.");
        String regnr = scanner.next();
        Bil leigebil = selskap.bilByReg(ledigeBiler, regnr);
        while (leigebil == null) {
            System.out.println("Ugyldig regnr, prøv på nytt");
            regnr = scanner.next();
            leigebil = selskap.bilByReg(ledigeBiler, regnr);
        }

        //Kunde navn og etternavn
        //Fornavn
        System.out.println("Skriv ditt fornavn");
        String fornavn = scanner.next();

        //Etternavn
        System.out.println("Skriv ditt etternavn");
        String etternavn = scanner.next();

        //Telefonnummer
        System.out.println("Skriv ditt telefonnummer");
        long nr = scanner.nextLong();

        //Adresse
        System.out.println("Skriv din addresse");

        System.out.println("Gateaddresse:");
        String gate = scanner.next();

        System.out.println("Postnummer:");
        int postnr = scanner.nextInt();
        while ((int)(Math.log10(postnr) + 1) != 4) {
            System.out.println("Postnummer må bestå av fire siffer.");
            postnr = scanner.nextInt();
        }

        System.out.println("Poststed: ");
        String poststed = scanner.next();
        while (poststed == null){
            System.out.println("Ugyldig poststed, prøv på nytt");
            poststed = scanner.next();
        }


        Adresse adresse = new Adresse(gate, postnr, poststed);

        //Kortnummer
        System.out.println("Kortnummer:");
        long kortnummer = scanner.nextLong();


        kunde = new Kunde(fornavn, etternavn, adresse, nr, kortnummer);
        leigeforhold = new Leigeforhold(startdato, sluttdato, startKontor, sluttKontor, kunde, leigebil);
        selskap.getLeigeforhold().add(leigeforhold);
        kunde.setFaktura(new Faktura(leigeforhold, selskap));
        System.out.println("Takk for din bestilling! Ditt referansenr er: " + leigeforhold.getOrdrenr());
        System.out.println("Din faktura: ");
        kunde.getFaktura().toString();


    }

     */

    public void init(){
        //LEGG TIL KONTORER
        List<Kontor> kontorer = new ArrayList<>();
        kontorer.add(new Kontor(new Adresse("Kontorgata 9", 5559, "Bergen"), 98989899));
        kontorer.add(new Kontor(new Adresse("Kontorgata 8", 5558, "Stavanger"), 98989898));
        kontorer.add(new Kontor(new Adresse("Kontorgata 7", 5557, "Haugesund"), 98989897));
        kontorer.add(new Kontor(new Adresse("Kontorgata 6", 5556, "Oslo"), 98989896));
        kontorer.add(new Kontor(new Adresse("Kontorgata 5", 5555, "Alta"), 98989895));
        kontorer.add(new Kontor(new Adresse("Kontorgata 4", 5554, "Bodø"), 98989894));
        kontorer.add(new Kontor(new Adresse("Kontorgata 3", 5553, "Trondheim"), 98989893));
        kontorer.add(new Kontor(new Adresse("Kontorgata 2", 5552, "Sogndal"), 98989892));
        kontorer.add(new Kontor(new Adresse("Kontorgata 1", 5551, "Hønefoss"), 98989891));

        selskap.setKontorListe(kontorer);

        selskap.getKontor().toString();

        //LEGG TIL STANDARD SETT MED BILER TIL KVART KONTOR
        for(Kontor kontor : selskap.getKontor()) {
            kontor.retur(new Bil("Toyota", "Yaris", "Blå", "A", "AB11111", kontor, 500, 100));
            kontor.retur(new Bil("Hyundai", "i10", "Svart", "A", "AB11112", kontor, 750, 100));
            kontor.retur(new Bil("Volkswagen", "Golf", "Grå", "B", "AB11113", kontor, 1000, 100));
            kontor.retur(new Bil("Toyota", "Auris", "Grønn", "B", "AB11114", kontor, 1250, 100));
            kontor.retur(new Bil("Volvo", "V40", "Blå", "C", "AB11115", kontor, 1500, 100));
            kontor.retur(new Bil("Tesla", "Model 3", "Svart", "C", "AB11116", kontor, 1750, 100));
            kontor.retur(new Bil("Volvo", "XC60", "Svart", "D", "AB11117", kontor, 2000, 100));
            kontor.retur(new Bil("Audi", "R8", "Grå", "D", "AB11118", kontor, 2500, 20));
            kontor.retur(new Bil("Lamborghini", "Aventador", "Rød", "D", "AB11119", kontor, 3500, 20));

        }

    }
}