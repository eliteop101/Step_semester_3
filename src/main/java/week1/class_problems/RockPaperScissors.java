package week1.class_problems;

import java.util.Random;
import java.util.Scanner;

/**
 * Problem 1: Rock-Paper-Scissors Game
 * Scenario: The College Coding Arcade
 * Simulates multiple rounds of Rock-Paper-Scissors between a player and computer,
 * records each round's outcome, and displays a summary table and scoreboard.
 */
public class RockPaperScissors {

    public static final String ROCK = "Rock";
    public static final String PAPER = "Paper";
    public static final String SCISSORS = "Scissors";
    public static final String[] MOVES = {ROCK, PAPER, SCISSORS};

    /**
     * Determines the outcome of a single round of Rock-Paper-Scissors.
     *
     * @param playerMove   The player's move ("Rock", "Paper", or "Scissors")
     * @param computerMove The computer's move ("Rock", "Paper", or "Scissors")
     * @return "Player Wins", "Computer Wins", or "Draw"
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            return "Invalid Move";
        }

        String p = playerMove.trim();
        String c = computerMove.trim();

        if (p.equalsIgnoreCase(c)) {
            return "Draw";
        }

        if (p.equalsIgnoreCase(ROCK)) {
            return c.equalsIgnoreCase(SCISSORS) ? "Player Wins" : "Computer Wins";
        } else if (p.equalsIgnoreCase(PAPER)) {
            return c.equalsIgnoreCase(ROCK) ? "Player Wins" : "Computer Wins";
        } else if (p.equalsIgnoreCase(SCISSORS)) {
            return c.equalsIgnoreCase(PAPER) ? "Player Wins" : "Computer Wins";
        } else {
            return "Invalid Move";
        }
    }

    /**
     * Structure to store the record of a single round.
     */
    public static class RoundResult {
        public final int roundNumber;
        public final String playerMove;
        public final String computerMove;
        public final String result;

        public RoundResult(int roundNumber, String playerMove, String computerMove, String result) {
            this.roundNumber = roundNumber;
            this.playerMove = playerMove;
            this.computerMove = computerMove;
            this.result = result;
        }
    }

    /**
     * Runs a full game simulation of N rounds and prints the summary.
     *
     * @param predefinedMoves Optional predefined moves for automated testing/demo.
     *                        If null or empty, interactive input is used.
     * @param totalRounds     Number of rounds to play.
     */
    public static void runGame(String[] predefinedMoves, int totalRounds) {
        Random random = new Random(42); // Seeded for reproducible demo output
        RoundResult[] results = new RoundResult[totalRounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("==================================================");
        System.out.println("        Welcome to the College Coding Arcade      ");
        System.out.println("              Rock - Paper - Scissors             ");
        System.out.println("==================================================");

        for (int i = 0; i < totalRounds; i++) {
            String playerMove;
            if (predefinedMoves != null && i < predefinedMoves.length) {
                playerMove = predefinedMoves[i];
            } else {
                playerMove = MOVES[i % MOVES.length];
            }

            // Generate random move for computer
            String computerMove = MOVES[random.nextInt(MOVES.length)];

            String outcome = playRound(playerMove, computerMove);
            results[i] = new RoundResult(i + 1, playerMove, computerMove, outcome);

            if (outcome.equals("Player Wins")) {
                wins++;
            } else if (outcome.equals("Computer Wins")) {
                losses++;
            } else if (outcome.equals("Draw")) {
                draws++;
            }

            System.out.printf("Round %d — Player: %s, Computer: %s -> %s%n",
                    (i + 1), playerMove, computerMove, outcome);
        }

        // Print Summary Table
        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-8s | %-12s | %-14s | %-14s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-------------------------------------------------------------");
        for (RoundResult res : results) {
            System.out.printf("%-8d | %-12s | %-14s | %-14s%n",
                    res.roundNumber, res.playerMove, res.computerMove, res.result);
        }
        System.out.println("-------------------------------------------------------------");

        // Print Scoreboard & Win Percentage
        double winPercentage = (totalRounds > 0) ? ((double) wins / totalRounds) * 100.0 : 0.0;
        System.out.printf("Final Summary (after %d rounds) -> Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                totalRounds, wins, losses, draws, winPercentage);
        System.out.println("=============================================================\n");
    }

    public static void main(String[] args) {
        // Predefined demo moves matching the assignment scenario
        String[] demoMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        runGame(demoMoves, 5);
    }
}
