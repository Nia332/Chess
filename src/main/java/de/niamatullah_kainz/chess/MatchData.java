package de.niamatullah_kainz.chess;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*Based on the [PGN](Portable_Game_Notation.txt) standard */
public class MatchData {
    String event;
    String site;
    LocalDate date;
    int round;
    Player playerWhite;
    Player playerBlack;
    String timeControl;
    List<String> moves;

    public MatchData() {
        this.moves = new ArrayList<>();
    }

    public MatchData(String event, String site, LocalDate date, int round, Player playerWhite, Player playerBlack, String timeControl, List<String> moves) {
        this.event = event;
        this.site = site;
        this.date = date;
        this.round = round;
        this.playerWhite = playerWhite;
        this.playerBlack = playerBlack;
        this.timeControl = timeControl;
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
                "[White \"" + playerWhite.getName() + "\"]\n" +
                "[Black \"" + playerBlack.getName() + "\"]\n" +
                "[TimeControl \"" + timeControl + "\"]\n" +
                "[Result \"" + playerWhite.getScore() + "-" + playerBlack.getScore() + "\"]\n\n" + 
                moveText.toString().trim() + " " + playerWhite.getScore() + "-" + playerBlack.getScore();  
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

    public Player getPlayerWhite() {
        return playerWhite;
    }

    public Player getPlayerBlack() {
        return playerBlack;
    }

    public String getTimeControl() {
        return timeControl;
    }

    public List<String> getMoves() {
        return moves;
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

    public void setPlayerWhite(Player playerWhite) {
        this.playerWhite = playerWhite;
    }

    public void setPlayerBlack(Player playerBlack) {
        this.playerBlack = playerBlack;
    }

    public void setTimeControl(String timeControl) {
        this.timeControl = timeControl;
    }

    public void setMoves(List<String> moves) {
        this.moves = moves;
    }
}
