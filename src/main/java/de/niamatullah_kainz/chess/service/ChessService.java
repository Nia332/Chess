package de.niamatullah_kainz.chess.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.niamatullah_kainz.chess.repository.ChessRepository;
import de.niamatullah_kainz.chess.model.MatchData;

@Service
public class ChessService {

    private final ChessRepository chessRepository;

    @Autowired
    public ChessService(ChessRepository chessRepository) {
        this.chessRepository = chessRepository;
    }

    public String index() {
            return "Hello World!";    
    }

    public List<MatchData> getAllMatches() {
        return chessRepository.findAll();
    }
}
