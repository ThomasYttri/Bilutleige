package Controller;

import Entities.Adresse;
import Entities.Bil;
import Entities.Bilutleigeselskap;
import Entities.Utleigekontor;

import java.util.*;

/**
 * @Author Thomas V.Yttri
 */
public class UtleigeKontroller {
    /**
     * main som oppretter spill, starter valg av spillere og kjører spillet
     * @param args
     */
    public static void main (String[] args) {
        Bilutleigeselskap bilutleigeselskap = new Bilutleigeselskap("Car Rental Bergen", 12345678, new Adresse("Bilutleigevegen 5", 5050, "Bergen"));
        BilutleigeKontroller bilutleigeKontroller = new BilutleigeKontroller(bilutleigeselskap);

        //LEGG TIL KONTORER
        List<Utleigekontor> kontorer = new ArrayList<>();
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 9", 5559, "Bergen"), 98989898));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 8", 5558, "Stavanger"), 98989897));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 8", 5558, "Stavanger"), 98989897));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 7", 5557, "Haugesund"), 98989896));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 6", 5556, "Oslo"), 98989895));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 5", 5555, "Alta"), 98989894));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 4", 5554, "Bodø"), 98989893));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 3", 5553, "Trondheim"), 98989892));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 2", 5552, "Sogndal"), 98989891));
        kontorer.add(new Utleigekontor(new Adresse("Kontorgata 1", 5551, "Hønefoss"), 98989890));

        bilutleigeselskap.setKontorListe(kontorer);

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
