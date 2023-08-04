package de.xyonox;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //eine Map für die Kaffee Sorten(String) und dazurigen Preis(double)
        Map<String, Double> CoffeeTyp = new HashMap<>();
        CoffeeTyp.put("Espresso", 2.50);
        CoffeeTyp.put("Latte", 4.50);
        CoffeeTyp.put("Cappuccino", 5.00);

        //das Geld des Users
        double money = 9.00;

        //Kaffeeliste als String Speichern um nicht mehrmals neu zu schreiben/kopieren
        String kaffeeliste =
                "Kaffeeliste \n" +
                        "Espresso 2,50€\n" +
                        "Latte 4,50€\n" +
                        "Cappuccino 5,00€";

        //Den input der Kosole abzurufen zu können
        Scanner input = new Scanner(System.in);

        System.out.println("Kontostand: " + money + "€");
        System.out.println("Willkommen in unserer Kaffeebar!");

        //Name für denn Kassenzettel übermitteln
        System.out.println("Wie heißen Sie?");
        String name = input.nextLine();


        System.out.println("Welchen Kaffee wollen Sie haben?");
        System.out.println(kaffeeliste);

        //die kaffeesorte abfragen und wenn es keine gültige angabe ist drauf hinweisen und erneut nach der sorte fragen
        String kaffee = input.nextLine();
        while (!CoffeeTyp.containsKey(kaffee)) {
            System.out.println("Ungültige Eingabe. Bitte gib einen Kaffee ein \n Hier nochmal die " + kaffeeliste);
            kaffee = input.nextLine();
        }

        //die menge ermittelen und wenn es keine Zahl angegeben würd hinweisen und erneut nach fragen
        System.out.println("In welcher Anzahl?");
        while (!input.hasNextInt()) {
            System.out.println("Ungültige Eingabe. Bitte gib eine ganze Zahl ein.");
            input.next();
        }
        int number = input.nextInt();

        //den Preis errechnen
        double prize = CoffeeTyp.get(kaffee) * number;

        //abfrage ob man genug geld hat
        if(prize < money || prize == money){
            money = money - prize;
            System.out.println("hr einkauf war Erfolgreich.");

            //inhalt des kassenzettel
            String content =
                    "Zahlung für " + name + "\n" + number + "x " + kaffee + " " + prize + "0€";
            //kassenzettel datei erstellen
            File file = new File( "kassenzettel.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter w = new FileWriter(file);
            w.write(content.replace(".", ","));
            w.close();

            System.out.println("Der Kassenzettel liegt in " + file.getAbsolutePath() + ".");
        } else {
            System.out.println("Sie haben nicht genug Geld.");
        }
    }
}
