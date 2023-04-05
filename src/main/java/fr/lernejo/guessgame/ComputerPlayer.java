package fr.lernejo.guessgame;

public class ComputerPlayer implements Player {
    private long min = 0;
    private long max = 100;

    @Override
    public long askNextGuess() {
        long guess = (min + max) / 2;
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            max = (min + max) / 2 - 1;
        } else {
            min = (min + max) / 2 + 1;
        }
    }
}
