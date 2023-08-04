package de.xyonox;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Double> CoffeeTyp = new HashMap<>();
        CoffeeTyp.put("Espresso", 2.50);
        CoffeeTyp.put("Latte", 4.50);
        CoffeeTyp.put("Cappuccino", 5.00);

        double money = 7.00;
        String kaffeeliste =
                "Kaffeeliste \n" +
                        "Espresso 2,50€\n" +
                        "Latte 4,50€\n" +
                        "Cappuccino 5,00€\n";

        Scanner input = new Scanner(System.in);
        System.out.println("Kontostand: " + money + "€");
        System.out.println("Willkommen in unserer Kaffeebar!");
        while (true) {
            System.out.println("Wie heißen Sie?");
            String name = input.nextLine();


            System.out.println("Welchen Kaffee wollen Sie haben?");
            System.out.println(kaffeeliste);

            //TODO: abfrage ob es ein kaffee überhaupt ist
            String kaffee = input.nextLine();


            System.out.println("In welcher Anzahl?");
            while (!input.hasNextInt()) {
                System.out.println("Ungültige Eingabe. Bitte gib eine ganze Zahl ein.");
                input.next();
            }

            int number = input.nextInt();


            double prize = CoffeeTyp.get(kaffee) * number;

            if(prize < money){
                money = money - prize;
                System.out.println("hr einkauf war Erfolgreich.");
            } else {
                System.out.println("Sie haben nicht genug Geld.");
            }
            break;
        }
    }
}
