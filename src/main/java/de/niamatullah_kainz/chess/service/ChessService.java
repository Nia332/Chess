package de.niamatullah_kainz.chess.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.niamatullah_kainz.chess.model.MatchData;
import de.niamatullah_kainz.chess.repository.ChessRepository;

@Service
public class ChessService {

    private final ChessRepository chessRepository;

    @Autowired
    public ChessService(ChessRepository chessRepository) {
        this.chessRepository = chessRepository;
    }

    public String index() {
        chessRepository.save(
            new MatchData(
                "WCh 2023", 
                "Astana KAZ", 
                LocalDate.of(2023, 4, 10), 
                1, 
                "Nepomniachtchi, Ian", 
                "Ding, Liren", 
                "", 
                new double[]{0.5,0.5}, 
                List.of("e4 e5", "Nf3 Nc6", "Bb5 Nf6", "d3 Bc5", "c3 O-O"))
            );
            return "Hello World!";    
    }

    public List<MatchData> getAllMatches() {
        return chessRepository.findAll();
    }
}
