package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
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

    public void loopUntilPlayerSucceed() {
        boolean success = false;
        while(!success){
            success = nextRound();
        }
    }
}
