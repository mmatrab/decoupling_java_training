package fr.lernejo.guessgame;
import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        if (args.length > 0) {
            if ("-interactive".equals(args[0])) {
                Simulation simulation = new Simulation(new HumanPlayer());
                simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
            } else if ("-auto".equals(args[0]) && args.length > 1) {
                try {
                    int age = Integer.parseInt(args[1]);
                    Simulation simulation = new Simulation(new ComputerPlayer());
                    simulation.initialize(age);
                    simulation.loopUntilPlayerSucceed(1000);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid age value");
                }
            } else {
                System.out.println("Usage: Launcher [-interactive | -auto <age>]");
            }
        } else {
            System.out.println("Usage: Launcher [-interactive | -auto <age>]");
        }
    }
}


