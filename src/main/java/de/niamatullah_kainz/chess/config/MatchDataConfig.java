package de.niamatullah_kainz.chess.config;

import java.util.List;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import de.niamatullah_kainz.chess.model.MatchData;
import de.niamatullah_kainz.chess.repository.ChessRepository;

@Configuration
public class MatchDataConfig {

    @Bean
    CommandLineRunner commandlinerunner(ChessRepository chessRepository) {
        return args -> {
            MatchData test = new MatchData(
                "WCh 2023", 
                "Astana KAZ", 
                LocalDate.of(2023, 4, 10), 
                1, 
                "Nepomniachtchi, Ian", 
                "Ding, Liren", 
                "", 
                new double[]{0.5,0.5}, 
                List.of("e4 e5", "Nf3 Nc6", "Bb5 Nf6", "d3 Bc5", "c3 O-O")
            );

            chessRepository.save(test);
        };
            
    }
}

