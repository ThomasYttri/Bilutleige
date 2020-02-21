package Controller;

import Entities.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author Thomas V.Yttri
 */
public class BilutleigeKontroller {
    private Bilutleigeselskap bilutleigeselskap;

    /**
     * Constructor BilutleigeKontroller
     */
    public BilutleigeKontroller(Bilutleigeselskap bilutleigeselskap) {
        this.bilutleigeselskap = bilutleigeselskap;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Kunde kunde = new Kunde();
        Leigeforhold leigeforhold = new Leigeforhold();

        //Velge kontor
        List<Utleigekontor> utleigekontor = bilutleigeselskap.getKontor();
        System.out.println("Kor vil du leige bil frå? Velg ved å skrive navn på by. Mulige valg er: ");
        bilutleigeselskap.kontorToString();
        Utleigekontor startKontor = bilutleigeselskap.kontorBy(scanner.next());
        while (startKontor == null) {
            System.out.println("Kjenner ikke igjen bynavn, hugs stor forbokstav");
            startKontor = bilutleigeselskap.kontorBy(scanner.next());
        }

        //Velge returkontor
        System.out.println("Kor vil du levere bilen? Velg ved å skrive navn på by.");
        Utleigekontor sluttKontor = bilutleigeselskap.kontorBy(scanner.next());
        while (sluttKontor == null) {
            System.out.println("Kjenner ikke igjen bynavn, hugs stor forbokstav");
            sluttKontor = bilutleigeselskap.kontorBy(scanner.next());
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

        //Sjekk ledige biler
        System.out.println("Ledige biler fra " + startKontor.getAdresse().getPoststed() + " i perioden: " + startdato + " til: " + sluttdato);
        List<Bil> ledigeBiler = bilutleigeselskap.ledigeBiler(startKontor, startdato, sluttdato);
        bilutleigeselskap.printBiler(ledigeBiler);

        //Velg bil
        System.out.println("Velg ønsket bil ved å skrive regnr.");
        String regnr = scanner.next();
        Bil leigebil = bilutleigeselskap.bilByReg(ledigeBiler, regnr);
        while (leigebil == null) {
            System.out.println("Ugyldig regnr, prøv på nytt");
            regnr = scanner.next();
            leigebil = bilutleigeselskap.bilByReg(ledigeBiler, regnr);
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


        kunde = new Kunde(fornavn, etternavn, adresse, nr);
        leigeforhold = new Leigeforhold(startdato, sluttdato, startKontor, sluttKontor, kunde, leigebil);
        bilutleigeselskap.getLeigeforhold().add(leigeforhold);
        kunde.setFaktura(new Faktura(leigeforhold, bilutleigeselskap));
        System.out.println("Takk for din bestilling! Ditt referansenr er: " + leigeforhold.getOrdrenr());
        System.out.println("Din faktura: ");
        kunde.getFaktura().printFaktura();


    }

    public void init(){
        //LEGG TIL KONTORER
        List<Utleigekontor> kontorer = new ArrayList<>();
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 9", 5559, "Bergen"), 98989899));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 8", 5558, "Stavanger"), 98989898));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 7", 5557, "Haugesund"), 98989897));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 6", 5556, "Oslo"), 98989896));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 5", 5555, "Alta"), 98989895));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 4", 5554, "Bodø"), 98989894));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 3", 5553, "Trondheim"), 98989893));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 2", 5552, "Sogndal"), 98989892));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 1", 5551, "Hønefoss"), 98989891));

        bilutleigeselskap.setKontorListe(kontorer);

        bilutleigeselskap.getKontor().toString();

        //LEGG TIL STANDARD SETT MED BILER TIL KVART KONTOR
        for(Utleigekontor kontor : bilutleigeselskap.getKontor()) {
            kontor.retur(new Bil("Toyota", "Yaris", "Blå", "A", "AB11111", kontor, 500));
            kontor.retur(new Bil("Hyundai", "i10", "Svart", "A", "AB11112", kontor, 750));
            kontor.retur(new Bil("Volkswagen", "Golf", "Grå", "B", "AB11113", kontor, 1000));
            kontor.retur(new Bil("Toyota", "Auris", "Grønn", "B", "AB11114", kontor, 1250));
            kontor.retur(new Bil("Volvo", "V40", "Blå", "C", "AB11115", kontor, 1500));
            kontor.retur(new Bil("Tesla", "Model 3", "Svart", "C", "AB11116", kontor, 1750));
            kontor.retur(new Bil("Volvo", "XC60", "Svart", "D", "AB11117", kontor, 2000));
            kontor.retur(new Bil("Audi", "R8", "Grå", "D", "AB11118", kontor, 2500));
            kontor.retur(new Bil("Lamborghini", "Aventador", "Rød", "D", "AB11119", kontor, 3500));

        }

    }
}