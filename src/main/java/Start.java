import entity.ScoreOpCalced;

import java.util.List;
import java.util.Objects;

public class Start {
    public static void main(String[] args) {
        List<ScoreOpCalced> scoreOpCalcedList = JsonReceive.getScoreOC();
        int sumOP_200 = 0;
        int count = 0;
        int[] sumOPbyGenre = {0,0,0,0,0,0,0};
        int[] countOPbyGenre = {0,0,0,0,0,0,0};
        //{ORIGINAL,GEKIMAI,IRODORIMIDORI,VARIETY,TOUHOU,niconico,POPS}
        
        for (ScoreOpCalced scoreOpCalced : scoreOpCalcedList){
            int op_s = 0,op_r = 0,op_e = 0;
            double op_ed = 0.0;
            double constT = scoreOpCalced.getConstant()*200;
            int c = (int) constT;
            int score = scoreOpCalced.getHighscore();
            String genre = scoreOpCalced.getGenre();
            //System.out.println("Start: "+scoreOpCalced.showOp());
            
            if(Objects.equals(scoreOpCalced.getFull_combo(), "alljustice")){
                op_r = 100*2;
            } else if (!Objects.equals(scoreOpCalced.getFull_combo(), "")){
                op_r = 50*2;
            } else if (score==1010000){
                op_r = 125*2;
            }
            System.out.println("R:"+scoreOpCalced.getFull_combo()+","+(double)op_r/200);

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
                op_ed = (score-1007500)*0.3;
                op_e = (int) op_ed;
            }
            System.out.println("S:"+scoreOpCalced.getHighscore()+","+(double)op_s*5/200);
            System.out.println("E:"+scoreOpCalced.getHighscore()+","+(double)op_e/200);
            scoreOpCalced.setOverpower_200(op_s*5+op_r+op_e);
            System.out.println("End: "+scoreOpCalced.showOp());
            sumOP_200 += scoreOpCalced.getOverpower_200();
            count++;
            if(scoreOpCalced.getLevel_index()==4) continue;
            switch (genre) {
                case "ORIGINAL" -> {
                    sumOPbyGenre[0] += scoreOpCalced.getOverpower_200();
                    countOPbyGenre[0]++;
                }
                case "ゲキマイ" -> {
                    sumOPbyGenre[1] += scoreOpCalced.getOverpower_200();
                    countOPbyGenre[1]++;
                }
                case "イロドリミドリ" -> {
                    sumOPbyGenre[2] += scoreOpCalced.getOverpower_200();
                    countOPbyGenre[2]++;
                }
                case "VARIETY" -> {
                    sumOPbyGenre[3] += scoreOpCalced.getOverpower_200();
                    countOPbyGenre[3]++;
                }
                case "東方Project" -> {
                    sumOPbyGenre[4] += scoreOpCalced.getOverpower_200();
                    countOPbyGenre[4]++;
                }
                case "niconico" -> {
                    sumOPbyGenre[5] += scoreOpCalced.getOverpower_200();
                    countOPbyGenre[5]++;
                }
                case "POPS & ANIME" -> {
                    sumOPbyGenre[6] += scoreOpCalced.getOverpower_200();
                    countOPbyGenre[6]++;
                }
                case null, default -> System.out.println(scoreOpCalced);
            }
        }
        System.out.println("总OP："+ (double) sumOP_200/200 + ", Count: "+ count);
        for(int i = 0;i<=6;i++){
            switch (i) {
                case 0 :
                    System.out.print("ORIGINAL");break;
                case 1 :
                    System.out.print("ゲキマイ");break;
                case 2 :
                    System.out.print("イロドリミドリ");break;
                case 3 :
                    System.out.print("VARIETY");break;
                case 4 :
                    System.out.print("東方Project");break;
                case 5 :
                    System.out.print("niconico");break;
                case 6 :
                    System.out.print("POPS & ANIME");break;
            }
            double result = (double) sumOPbyGenre[i] /200;
            System.out.println("OP:"+result+", count:"+countOPbyGenre[i]);
        }

    }


}

