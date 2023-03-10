package it.polimi.ingsw;

import it.polimi.ingsw.client.CLI;
import it.polimi.ingsw.client.MainClient;
import it.polimi.ingsw.org.example.GUI;
import it.polimi.ingsw.org.example.JavaFXMain;
import it.polimi.ingsw.server.MainServer;

import java.util.Scanner;

public class App {

    private static final Scanner scanner=new Scanner(System.in);

    public static void main( String[] args ) {
        System.out.println("WELCOME IN:");
        System.out.println("\n                          MASTERS OF RENAISSANCE!\n");
        System.out.println("Would you like to play or to host the server?");
        System.out.println("1)server");
        System.out.println("2)CLI");
        System.out.println("3)GUI");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("server"))
            MainServer.main(args);
        else if (input.equalsIgnoreCase("cli"))
            CLI.main();
        else if (input.equalsIgnoreCase("gui"))
            GUI.main();
    }
}
