package de.niamatullah_kainz.chess.service;

import java.util.Scanner;
import org.springframework.stereotype.Service;

/*
Manages all the logic that is needed as soon as the player wants to start playing chess -
too when the player wants to stop playing matches.
*/
@Service
public class GameLoopService {

    private final Scanner scanner = new Scanner(System.in);
    private final MatchService matchService = new MatchService();
    
    public GameLoopService() {

    }

    public void start() {
        do {
            matchService.start();
            System.out.println("Do you want to play again? (yes/no)");
        } while (scanner.nextLine().toLowerCase().strip().equals("yes"));
    }

    public void end() {
        scanner.close();
        System.out.println("Thanks for playing!");
    }
}
