package de.niamatullah_kainz.chess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import de.niamatullah_kainz.chess.model.MatchData;

@Repository
public interface ChessRepository extends JpaRepository<MatchData, Long > {
    
}