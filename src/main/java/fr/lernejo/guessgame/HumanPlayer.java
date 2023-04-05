package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private static final Logger logger = LoggerFactory.getContextualLogger(HumanPlayer.class);
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        logger.log("Enter your guess:");
        long guess = scanner.nextLong();
        logger.log("Player guessed: " + guess);
        return guess;
    }

    @Override
    public void respond(boolean lower) {
        if (lower) {
            logger.log("The number to guess is lower!");
        } else {
            logger.log("The number to guess is greater!");
        }
    }
}
