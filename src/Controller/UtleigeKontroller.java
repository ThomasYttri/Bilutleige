package Controller;

import Entities.Adresse;
import Entities.Bilutleigeselskap;

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

        bilutleigeKontroller.init();
        bilutleigeKontroller.start();
    }
}
