
public class Player implements IAmAPlayer{
    private String name;

    private int score;

    private int turn_total;

    private char choice;

    Player(String name){
        this.name = name;
        score = 0;
        turn_total = 0;
    }

    public int getTurn_total() {
        return turn_total;
    }

    public void setTurn_total(int turn_total) {
        this.turn_total = turn_total;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public char getChoice() {
        return choice;
    }

    public int getScore() {
        return score;
    }

    public void setChoice(char choice){
        this.choice = choice;
    }


}
