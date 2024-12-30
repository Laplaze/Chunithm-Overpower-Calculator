import entity.ScoreOpCalced;

import java.util.List;
import java.util.Objects;

public class Start {
    public static void main(String[] args) {
        List<ScoreOpCalced> scoreOpCalcedList = JsonReceive.getScoreOC();
        int sumOP_200 = 0;
        int[] sumOPbyGenre = {0,0,0,0,0,0,0};
        //{ORIGINAL,GEKIMAI,IRODORIMIDORI,VARIETY,TOUHOU,niconico,POPS}
        
        for (ScoreOpCalced scoreOpCalced : scoreOpCalcedList){
            int op_s = 0,op_r = 0,op_e = 0;
            double op_ed = 0.0;
            double constT = scoreOpCalced.getConstant()*200;
            int c = (int) constT;
            int score = scoreOpCalced.getHighscore();
            String genre = scoreOpCalced.getGenre();
            
            if(Objects.equals(scoreOpCalced.getFull_combo(), "alljustice")){
                op_r = 100*2;
            } else if (!Objects.equals(scoreOpCalced.getFull_combo(), "")){
                op_r = 50*2;
            } else if (score==1010000){
                op_r = 125*2;
            }

            if(score<975000){
                op_s = 0;
            } else if (score<=1000000) {
                op_s = c + (score-975000)/125;
            } else if (score<=1005000) {
                op_s = c + 100*2 + (score-1000000)/50;
            } else if (score<=1007500) {
                op_s = c + 150*2 + (score-1005000)/25;
            } else {
                op_s = c + 200*2;
                op_ed = (score-1007500)/3.0*10;
                op_e = (int) op_ed;
            }
            scoreOpCalced.setOverpower_200(op_s+op_r+op_e);
            sumOP_200 += scoreOpCalced.getOverpower_200();
            switch (genre) {
                case "ORIGINAL" -> sumOPbyGenre[0] += scoreOpCalced.getOverpower_200();
                case "ゲキマイ" -> sumOPbyGenre[1] += scoreOpCalced.getOverpower_200();
                case "イロドリミドリ" -> sumOPbyGenre[2] += scoreOpCalced.getOverpower_200();
                case "VARIETY" -> sumOPbyGenre[3] += scoreOpCalced.getOverpower_200();
                case "東方Project" -> sumOPbyGenre[4] += scoreOpCalced.getOverpower_200();
                case "niconico" -> sumOPbyGenre[5] += scoreOpCalced.getOverpower_200();
                case "POPS & ANIME" -> sumOPbyGenre[6] += scoreOpCalced.getOverpower_200();
                case null, default -> System.out.println(scoreOpCalced);
            }
        }
    }


}

