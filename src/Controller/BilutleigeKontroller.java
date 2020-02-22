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

        //LEGG TIL STANDARD SETT MED BILER TIL ALLE KONTOR
        for(Kontor kontor : selskap.getKontor()) {
            kontor.leggTilBil(new Bil("Toyota", "Yaris", "Blå", "A", "AB11111", kontor, 500, 100));
            kontor.leggTilBil(new Bil("Hyundai", "i10", "Svart", "A", "AB11112", kontor, 500, 100));
            kontor.leggTilBil(new Bil("Volkswagen", "Golf", "Grå", "B", "AB11113", kontor, 1250, 100));
            kontor.leggTilBil(new Bil("Toyota", "Auris", "Grønn", "B", "AB11114", kontor, 1250, 100));
            kontor.leggTilBil(new Bil("Volvo", "V40", "Blå", "C", "AB11115", kontor, 1750, 100));
            kontor.leggTilBil(new Bil("Tesla", "Model 3", "Svart", "C", "AB11116", kontor, 1750, 100));
            kontor.leggTilBil(new Bil("Volvo", "XC60", "Svart", "C", "AB11117", kontor, 1750, 100));
            kontor.leggTilBil(new Bil("Audi", "R8", "Grå", "D", "AB11118", kontor, 3500, 20));
            kontor.leggTilBil(new Bil("Lamborghini", "Aventador", "Rød", "D", "AB11119", kontor, 3500, 20));
        }
    }
}