import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class JsonReceive {
    public static void main(String[] args) {
        try (FileReader reader1 = new FileReader("C:/Users/92075/IdeaProjects/opCalc/response.txt")) {
            // Read the JSON file and convert it to a string
            int c1;
            StringBuilder sb1 = new StringBuilder();
            while ((c1 = reader1.read()) != -1) {
                sb1.append((char) c1);
            }
//            //
//            String target = "まっすぐ→→→ストリーム!";
//            String replacement = "まっすぐ→→→ストリーム！";
//            c1 = 0;
//            while ((c1 = sb1.indexOf(target, c1)) != -1) {
//                sb1.replace(c1, c1 + target.length(), replacement);
//                c1 += replacement.length();
//            }
//            //
            String jsonStrResponse = sb1.toString();
            JSONArray jsonArray = new JSONArray(jsonStrResponse);

            new JsonData();
/*
            System.out.println(JsonData.MusicData
                    .getJSONObject(0)
                    .getJSONObject("charts")
                    .getJSONObject("master")
                    .getDouble("constant")
            );

            System.out.println(JsonData.MusicData
                    .getJSONObject(0)
                    .getString("title")
            );
*/

            List<ScoreOpCalced> scoreList = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                /*
                Score score = new Score(
                        jsonObject.getInt("id"),
                        jsonObject.getString("title"),
                        jsonObject.getInt("level_index"),
                        jsonObject.getInt("highscore"),
                        jsonObject.getInt("rank_index"),
                        jsonObject.getString("clear"),
                        jsonObject.getString("full_combo"),
                        jsonObject.getString("full_chain"),
                        jsonObject.getString("idx"),
                        jsonObject.getString("createdAt"),
                        jsonObject.getString("updatedAt")
                        );

                 */
                ScoreOpCalced scoreOpCalced = new ScoreOpCalced(
                        jsonObject.getInt("id"),
                        jsonObject.getString("title"),
                        jsonObject.getInt("highscore"),
                        jsonObject.getString("full_combo"),
                        jsonObject.getInt("level_index")
                );
                scoreList.add(scoreOpCalced);
            }
            System.out.println("construct ScoreList successfully");
            int count = 0;
            for(ScoreOpCalced soc : scoreList){
                count++;
                for(int i = 0;i < JsonData.MusicData.length() ; i++){
                    if(Objects.equals(JsonData.MusicData
                            .getJSONObject(i)
                            .getString("title"), soc.getTitle())){
                        System.out.println("title:"+soc.getTitle());
                        System.out.println("score:"+soc.getHighscore());
                        System.out.println("artist:"+(JsonData.MusicData
                                .getJSONObject(i)
                                .getString("artist")));
                        soc.setGenre(JsonData.MusicData
                                .getJSONObject(i)
                                .getString("genre"));
                        String diff = switch (soc.getLevel_index()) {
                            case 0 -> "basic";
                            case 1 -> "advanced";
                            case 2 -> "expert";
                            case 3 -> "master";
                            case 4 -> "ultima";
                            default -> "basic";
                        };
                        if(soc.getConstant()==0.0){
                        soc.setConstant(JsonData.MusicData
                                .getJSONObject(i)
                                .getJSONObject("charts")
                                .getJSONObject(diff)
                                .getDouble("constant"));
//                            //System.out.println(soc);
//                            soc.setConstant(JsonData.MusicData
//                                    .getJSONObject(i)
//                                    .getJSONObject("charts")
//                                    .getJSONObject(diff)
//                                    .getInt("constant")+0.1-0.1);
//                            //System.out.println(soc);
                        }
                    }
//            for(int i=0;i<10000;i++){
//                if(JsonData.MusicData
//                        .getJSONObject(i)
//                        .getInt("musicId")==69){
//                    System.out.println(JsonData.MusicData
//                            .getJSONObject(i)
//                            .getString("title"));
                }
            }
            System.out.println("set genre and constant successfully");
            {
                int i = 0;
                for (ScoreOpCalced soc : scoreList){
                    if(Objects.equals(soc.getTitle(), "まっすぐ→→→ストリーム!")){
                        scoreList.remove(i);
                    }
                    i++;
                }
            }
            System.out.println("count="+count);

//            int count2 = 0;
//            int cons = 131;
//
//            for(;cons < 135;cons += 1){
//                for (ScoreOpCalced soc : scoreList){
//                    if(soc.getConstant()==13.1/* && soc.getConstant()<=(cons)*/){
//                        System.out.println(soc);
//                        count2++;
//                    }
//                }
//                System.out.println((cons)+"~"+(cons+1)+":"+count2);
//                count2 = 0;
//            }


        } catch (IOException ignored) {}

    }

}