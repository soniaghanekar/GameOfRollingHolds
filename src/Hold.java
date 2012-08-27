
public class Hold {

    public boolean executeHold(IAmAPlayer player) {
        player.setScore(player.getScore() + player.getTurn_total());
        player.setTurn_total(0);
        return false;
    }

}
