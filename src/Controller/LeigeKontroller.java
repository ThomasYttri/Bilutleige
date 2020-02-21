package Controller;

import Entities.Adresse;
import Entities.Selskap;

/**
 * @Author Thomas V.Yttri
 */
public class LeigeKontroller {
    /**
     * main som oppretter spill, starter valg av spillere og kjører spillet
     * @param args
     */
    public static void main (String[] args) {
        Selskap selskap = new Selskap("Car Rental Bergen", 12345678, new Adresse("Bilutleigevegen 5", 5050, "Bergen"));
        BilutleigeKontroller bilutleigeKontroller = new BilutleigeKontroller(selskap);

        bilutleigeKontroller.init();
        selskap.leigBil();
    }
}
