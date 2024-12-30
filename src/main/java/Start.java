import entity.ScoreOpCalced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Start {
    public static void main(String[] args) {
        List<ScoreOpCalced> scoreOpCalcedList = JsonReceive.getScoreOC();
        
        for (ScoreOpCalced scoreOpCalced : scoreOpCalcedList){
            int op_s = 0,op_r = 0,op_e = 0;
            
            if(Objects.equals(scoreOpCalced.getFull_combo(), "alljustice")){
                op_r = 100;
            } else if (!Objects.equals(scoreOpCalced.getFull_combo(), "")){
                op_r = 50;
            } else if (scoreOpCalced.getHighscore()==1010000){
                op_r = 125;
            }

            scoreOpCalced.setOverpower_100(op_s+op_r+op_e);
        }
    }


}

