import entity.JsonData;
import entity.ReceivedScoreData;
import entity.ScoreOpCalced;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class JsonReceive {
    public static List<ScoreOpCalced> getScoreOC() {
        List<ScoreOpCalced> scoreList = new ArrayList<>();

        new JsonData();
        new ReceivedScoreData();

        for (int i = 0; i < ReceivedScoreData.ScoreData.length(); i++) {
            JSONObject jsonObject = ReceivedScoreData.ScoreData.getJSONObject(i);
            ScoreOpCalced scoreOpCalced = new ScoreOpCalced(
                    jsonObject.getInt("id"),
                    jsonObject.getString("title"),
                    jsonObject.getInt("highscore"),
                    jsonObject.getString("full_combo"),
                    jsonObject.getInt("level_index")
            );
            if(Objects.equals(scoreOpCalced.getTitle(), "Snow Colored entity.Score")){
                scoreOpCalced.setTitle("Snow Colored Score");
            }
            scoreList.add(scoreOpCalced);
        }
        scoreList.removeIf(x -> x.getTitle().equals("まっすぐ→→→ストリーム!"));
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
                    }
                }
            }
        }
        System.out.println("set genre and constant successfully");
        System.out.println("count="+count);
        return scoreList;





    }

}