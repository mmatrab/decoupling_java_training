package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;
public class HumanPlayer implements Player {
    private static final Logger logger = LoggerFactory.getLogger(HumanPlayer.class.getName());
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public long askNextGuess() {
        logger.log("Asking user for next guess");
        System.out.println("Enter your next guess:");
        return scanner.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        logger.log("Informing user that the previous guess was " + (lowerOrGreater ? "lower" : "greater"));
        System.out.println("Your guess was " + (lowerOrGreater ? "too high" : "too low"));
    }
}
