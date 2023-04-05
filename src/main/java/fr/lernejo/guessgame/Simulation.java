package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {
    private final Logger logger = LoggerFactory.getContextualLogger(Simulation.class);
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long guess = player.askNextGuess();
        if (guess == numberToGuess){
            return true;
        } else {
            boolean lowerOrGreater = guess < numberToGuess;
            player.respond(lowerOrGreater);
            return false;
        }
    }

    public boolean loopUntilPlayerSucceed(long maxIterations) {
        long startTime = System.currentTimeMillis();
        boolean success = false;
        for (long i = 1; i <= maxIterations; i++) {
            if (nextRound()) {
                success = true;
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        logger.log("Game duration: " + String.format("%02d:%02d.%03d", duration / 60000, (duration / 1000) % 60, duration % 1000));
        if (!success) {
            logger.log("The player did not find the number " + numberToGuess + " within the limit of " + maxIterations + " iterations.");
        }
        logger.log("You won !");
        return success;
    }
}
