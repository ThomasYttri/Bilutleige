package Controller;

import Entities.*;

import java.io.IOException;
import java.time.LocalDate;
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

    public void start(){
        Scanner scanner = new Scanner(System.in);
        Kunde kunde = new Kunde();

        //Velge kontor
        List<Utleigekontor> utleigekontor = bilutleigeselskap.getKontor();
        System.out.println("Kor vil du leige bil frå? Velg ved å skrive navn på by. Mulige valg er: ");
        bilutleigeselskap.kontorToString();
        Utleigekontor startKontor = bilutleigeselskap.kontorBy(scanner.next());

        //Velge returkontor
        System.out.println("Kor vil du levere bilen? Velg ved å skrive navn på by.");
        Utleigekontor sluttKontor = bilutleigeselskap.kontorBy(scanner.next());

        //Hente dato
        System.out.println("Dato for henting av bil, skrives i formatet: yyyy mm dd");
        LocalDate startdato = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        while (startdato.isBefore(LocalDate.now())){
            System.out.println("Datoen er før dagens dato, prøv igjen");
            startdato = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        
        //Retur dato
        System.out.println("Dato for retur av bil, skrives i formatet: dd mm yyyy");
        LocalDate sluttdato = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        while (sluttdato.isBefore(startdato)){
            System.out.println("Datoen er før startdato, prøv igjen.");
            sluttdato = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        //Sjekk ledige biler
        System.out.println("Ledige biler fra " + startKontor + " fra dato: " + startdato + " til: " + sluttdato);
        List<Bil> ledigeBiler = bilutleigeselskap.ledigeBiler(startKontor, startdato, sluttdato);
        bilutleigeselskap.bilerToString(ledigeBiler);

        //Velg bil
        System.out.println("Velg ønsket bil ved å skrive regnr.");
        String regnr = scanner.next();
        Bil leigebil = null;
        while (leigebil != null) {
            if (regnr != null) {
                for (Bil bil : ledigeBiler) {
                    if (bil.getRegnr().equals(regnr)) {
                        leigebil = bil;
                    }
                }
            }
            System.out.println("Ugyldig regnr");
            regnr = scanner.next();
        }

        //Kunde navn og etternavn


        bilutleigeselskap.getLeigeforhold().add(new Leigeforhold(startdato, sluttdato, startKontor, sluttKontor, kunde, leigebil));

    }

}
