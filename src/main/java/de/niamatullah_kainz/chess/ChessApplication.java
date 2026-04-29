package de.niamatullah_kainz.chess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import de.niamatullah_kainz.chess.model.GameLoopSingleton;

@SpringBootApplication
public class ChessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessApplication.class, args);
		GameLoopSingleton.getInstance().start();
		GameLoopSingleton.getInstance().end();
	}
}
