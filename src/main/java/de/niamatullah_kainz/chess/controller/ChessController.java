package de.niamatullah_kainz.chess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import de.niamatullah_kainz.chess.model.MatchData;
import de.niamatullah_kainz.chess.service.ChessService;

@RestController
@RequestMapping(path = "")
public class ChessController {
    private final ChessService chessService;

    @Autowired
    public ChessController(ChessService chessService) {
        this.chessService = chessService;
    }

    @GetMapping
    public String index() {
        return chessService.index();
    }

    @GetMapping("/all")
    public List<MatchData> getAllMatches() {
        return chessService.getAllMatches();
    }
}
