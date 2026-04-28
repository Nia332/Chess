package de.niamatullah_kainz.chess;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//Based on the [PGN](Portable_Game_Notation.txt) standard

@Entity
@Table
public class MatchData {
    @Id
    @Column(name="MATCH_ID")
    @SequenceGenerator(
        name = "matchData_sequence",
        sequenceName = "matchData_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "matchData_sequence"
    )
    private Long id;
    private String event;
    private String site;
    private LocalDate date;
    private int round;
    private String white;
    private String black;
    private String timeControl;
    private int[] result;
    @ElementCollection
    @CollectionTable(name = "MOVES", joinColumns = @JoinColumn(name="id"))
    @Column(name="MOVE_NOTATION")
    private List<String> moves;

    public MatchData() {
        this.result = new int[]{0,0};
        this.moves = new ArrayList<>();
    }

    public MatchData(String event, String site, LocalDate date, int round, String white, String black, String timeControl, int[] result,
                    List<String> moves) {
        this.event = event;
        this.site = site;
        this.date = date;
        this.round = round;
        this.white = white;
        this.black = black;
        this.timeControl = timeControl;
        this.result = result;
        this.moves = moves;
    }

    public void addMove(String move) {
        moves.add(move);
    }

    /**
     * Formats the match information in PGN format.
     * @return the PGN string for the match
     */
    public String formatToPGN() { 
        //Build the text of all moves with move numbers
        StringBuilder moveText = new StringBuilder();
        for (int i = 0; i < moves.size(); i += 2) {
            int moveNumber = (i / 2) + 1;
            moveText.append(moveNumber).append(". ").append(moves.get(i));
            if (i + 1 < moves.size()) {
                moveText.append(" ").append(moves.get(i + 1));
            }
            moveText.append(" ");
        }

        return  "[Event \"" + event + "\"]\n" +
                "[Site \"" + site + "\"]\n" +
                "[Date \"" + date + "\"]\n" +
                "[Round \"" + round + "\"]\n" +
                "[White \"" + white + "\"]\n" +
                "[Black \"" + black + "\"]\n" +
                "[TimeControl \"" + timeControl + "\"]\n" +
                "[Result \"" + result[0] + "-" + result[1] + "\"]\n\n" + 
                moveText.toString().trim() + " " + result[0] + "-" + result[1];  
    }

    public Long getId() {
        return id;
    }

    public String getEvent() {
        return event;
    }

    public String getSite() {
        return site;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getRound() {
        return round;
    }

    public String getWhite() {
        return white;
    }

    public String getBlack() {
        return black;
    }

    public String getTimeControl() {
        return timeControl;
    }

    public int[] getResult() {
        return result;
    }

    public List<String> getMoves() {
        return moves;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void setWhite(String white) {
        this.white = white;
    }

    public void setBlack(String black) {
        this.black = black;
    }

    public void setTimeControl(String timeControl) {
        this.timeControl = timeControl;
    }

    public void setResult(int[] result) {
        this.result = result;
    }

    public void setMoves(List<String> moves) {
        this.moves = moves;
    }
}
