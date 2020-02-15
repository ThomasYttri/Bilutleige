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
        Leigeforhold leigeforhold = new Leigeforhold();

        //Velge kontor
        List<Utleigekontor> utleigekontor = bilutleigeselskap.getKontor();
        System.out.println("Kor vil du leige bil frå? Velg ved å skrive navn på by. Mulige valg er: ");
        bilutleigeselskap.kontorToString();
        String leigekontor = scanner.next();
        leigeforhold.setLeigekontor(bilutleigeselskap.kontorBy(leigekontor));

        //Velge returkontor
        System.out.println("Kor vil du levere bilen? Velg ved å skrive navn på by.");
        String returkontor = scanner.next();
        leigeforhold.setReturkontor(bilutleigeselskap.kontorBy(returkontor));

        //Hente dato
        System.out.println("Dato for henting av bil, skrives i formatet: yyyy mm dd");
        LocalDate startdato = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        while (startdato.isBefore(LocalDate.now())){
            System.out.println("Datoen er før dagens dato, prøv igjen");
            LocalDate nystartdato = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            startdato = nystartdato;
        }

        
        //Retur dato
        System.out.println("Dato for retur av bil, skrives i formatet: dd mm yyyy");
        LocalDate sluttdato = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        //Sjekk dato og legg til
        if (leigeforhold.sjekkDato(startdato, sluttdato)){
            leigeforhold.setStart(startdato);
            leigeforhold.setSlutt(sluttdato);
        } else {
            System.out.println("Feil i dato, prøv igjen");
            
        }
    }

}
