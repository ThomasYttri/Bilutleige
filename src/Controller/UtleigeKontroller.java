package Controller;

import Entities.Adresse;
import Entities.Bil;
import Entities.Bilutleigeselskap;
import Entities.Utleigekontor;

import java.util.ArrayList;

/**
 * @Author Thomas V.Yttri
 */
public class UtleigeKontroller {
    /**
     * main som oppretter spill, starter valg av spillere og kjører spillet
     * @param args
     */
    public static void main (String[] args){
        Bilutleigeselskap bilutleigeselskap = new Bilutleigeselskap("Car Rental Bergen", 12345678, new Adresse("Bilutleigevegen 5", 5050, "Bergen"));
        BilutleigeKontroller bilutleigeKontroller = new BilutleigeKontroller(bilutleigeselskap);

        bilutleigeselskap.setKontorListe((
                new Utleigekontor(new Adresse("Kontorgata 1", 5555, "Bergen"), 98989898),
                new Utleigekontor(new Adresse("Kontorgata 1", 5555, "Stavanger"), 98989898),
                new Utleigekontor(new Adresse("Kontorgata 1", 5555, "Haugesund"), 98989898),
                new Utleigekontor(new Adresse("Kontorgata 1", 5555, "Oslo"), 98989898),
                new Utleigekontor(new Adresse("Kontorgata 1", 5555, "Alta"), 98989898),
                new Utleigekontor(new Adresse("Kontorgata 1", 5555, "Bodø"), 98989898),
                new Utleigekontor(new Adresse("Kontorgata 1", 5555, "Trondheim"), 98989898),
                new Utleigekontor(new Adresse("Kontorgata 1", 5555, "Sogndal"), 98989898),
                new Utleigekontor(new Adresse("Kontorgata 1", 5555, "Hønefoss"), 98989898)
                );
        bilutleigeselskap.getKontor().forEach(k -> k.setBiler((
                new Bil("Toyota", "Yaris", "Blå", "A", "AB11111", k, 500),
                new Bil("Hyundai", "i10", "Svart", "A", "AB11112", k, 750),
                new Bil("Volkswagen", "Golf", "Grå", "B", "AB11113", k, 1000),
                new Bil("Toyota", "Auris", "Grønn", "B", "AB11114", k, 1250),
                new Bil("Volvo", "V40", "Blå", "C", "AB11115", k, 1500),
                new Bil("Tesla", "Model 3", "Svart", "C", "AB11116", k, 1750),
                new Bil("Volvo", "XC60", "Svart", "D", "AB11117", k, 2000),
                new Bil("Audi", "R8", "Grå", "D", "AB11118", k, 2500),
                new Bil("Lamborghini", "Aventador", "Rød", "D", "AB11119", k, 3500)
        ));
    }
}
