public class Score {

    //attributes
    private int initialScore; //the score when battle is started - initialize to 0
    private int battleScore; //current battle score
    private int sumBattleScore; // total score - updated after every battle
    private int highestScore; //highest score among all the battles

    //constructors
    public Score() {
        this.initialScore = 0;
        this.battleScore = 0;
        this.sumBattleScore = 0;
        this.highestScore = 0;
    }

    //setters
    public void updateBattleScore(int battleScore) {
        this.battleScore = battleScore;
        updatehighestScore();
    }


    //getters
    public int getInitialScire() {
        return initialScore;
    }

    public int getBattleScore() {
        return battleScore;
    }

    public int getSumBattleScore() {
        return sumBattleScore;
    }

    public int getHighestScore() {
        return highestScore;
    }

    //Other Methods
    private void updatehighestScore() {
        if(battleScore > highestScore) {
            highestScore = battleScore;
        }
        sumBattleScore += battleScore;
    }

    //toString
    @Override
    public String toString() {
        return String.format("Initial Score: %d, Battle Score: %d, Sum Battle Score: %d, Highest Score: %d", initialScore, battleScore, sumBattleScore, highestScore);
    }
}