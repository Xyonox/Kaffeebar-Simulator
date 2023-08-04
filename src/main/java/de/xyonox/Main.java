package de.xyonox;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> CoffeeTyp = new HashMap<>();
        CoffeeTyp.put("Espresso", 2.50);
        CoffeeTyp.put("Latte", 4.50);
        CoffeeTyp.put("Cappuccino", 5.00);

        double money = 7.00;

        Scanner input = new Scanner(System.in);
        System.out.println("Kontostand: " + money + "€");
        System.out.println("Willkommen in unserer Kaffeebar!");
        System.out.println("Welchen Kaffee wollen Sie haben?");
        while (true) {
            System.out.println(
                    "Kaffeeliste \n" +
                            "Espresso 2,50€\n" +
                            "Latte 4,50€\n" +
                            "Cappuccino 5,00€\n"
                    );

            System.out.println("Welchen Kaffee wollen Sie haben?");
            String kaffee = input.nextLine();
            if(!CoffeeTyp.containsKey(kaffee)){
                System.out.println("diesen kaffee gibt es nicht hier nochmal die Kaffeeliste:");
                continue;
            }


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
