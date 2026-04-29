package de.niamatullah_kainz.chess.service;

import java.time.LocalDate;
import java.util.Scanner;
import org.springframework.stereotype.Service;
import de.niamatullah_kainz.chess.model.MatchData;

@Service
public class GameLoopService {

    private final Scanner scanner = new Scanner(System.in);
    private MatchData matchData;
    
    public GameLoopService() {

    }

    public void start() {
        do {
            setupMatch();
            playMatch();
            saveMatch();
            System.out.println("Game over! Do you want to play again? (yes/no)");
        } while (scanner.nextLine().toLowerCase().strip().equals("yes"));
    }

    public void end() {
        scanner.close();
        System.out.println("Thanks for playing!");
    }

    private void setupMatch() {
        matchData = new MatchData();
        matchData.setDate(LocalDate.now());
        //players are constructed this way to follow the PGN format of white and black players
        if(playerIsWhite()) {
            matchData.setWhite("Player");
            matchData.setBlack("Computer");
            System.out.println("You are white. Please enter your first move:");
        } else {
            matchData.setWhite("Computer");
            matchData.setBlack("Player");
            System.out.println("You are Black. White moves first!");
        }
    }

    private void playMatch() {
        boolean endMatch = false;
        String move;
        do {
            if (matchData.getWhite().equals("Player")) {
                //white's turn
                boolean endTurn;
                do {
                    endTurn = true;
                    move = scanner.next().strip().toLowerCase();
                    if (move.equals("resign")) {
                        endMatch = true;
                    } else if (validateMove(move)) {
                        matchData.addMove(move);
                    } else {
                        System.out.println("Please enter a valid move!");
                        endTurn = false;
                    }
                } while (!endTurn);
                //black's turn
                if (!endMatch) {
                    move = computeMove();
                    if (validateMove(move)) {
                        matchData.addMove(move);
                        System.out.println("Computer's move: " + move);
                    } else {
                        System.out.println("Computer generated an invalid move. You win!");
                        endMatch = true;
                }
            } 
            } else {
                //white's turn
                move = computeMove();
                if (validateMove(move)) {
                    matchData.addMove(move);
                    System.out.println("Computer's move: " + move);
                    //black's turn
                    boolean endTurn;
                    do {
                        endTurn = true;
                        move = scanner.next().strip().toLowerCase();
                        if (move.equals("resign")) {
                            endMatch = true;
                        } else if (validateMove(move)) {
                            matchData.addMove(move);
                        } else {
                            System.out.println("Please enter a valid move!");
                            endTurn = false;
                        }
                    } while (!endTurn);
                } else {
                    System.out.println("Computer generated an invalid move. You win!");
                    endMatch = true;
                }
            }
        } while (!endMatch);
    }

    private void saveMatch() {
        System.out.println("Saving match data...");
        System.out.println(matchData.formatToPGN()); //TODO: save to file instead of printing to console
    }

    private boolean playerIsWhite() {
        do {
            System.out.println("Welcome to Chess! Do you want to play black or white?");
            String input = scanner.nextLine().toLowerCase().strip();
            
            if (input.equals("white")) {
                return true;
            } else if (input.equals("black")) {
                return false;
            }
        } while (true);
    }

    private String computeMove() {
        // Placeholder for computer move generation logic
        // This method will eventually contain the AI logic to compute the computer's move based on the current game state.
        return "e4"; // Return the placeholder move for now
    }

    private boolean validateMove(String move) {
        //TODO: check if move is legal, and add notation like x (takes), # (checkmate) etc.
        if (move.equals("e4")) {
            return true;
        }
        return false;
    }
}
