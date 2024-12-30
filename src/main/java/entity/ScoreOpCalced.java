package entity;

public class ScoreOpCalced {

    private Integer id;
    private String title;
    private Integer highscore;
    private String full_combo;
    private Integer level_index;
    private String genre;
    private Double constant = 0.0;
    private Integer overpower_100;

    @Override
    public String toString() {
        return "ScoreOpCalced{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", highscore=" + highscore +
                ", full_combo='" + full_combo + '\'' +
                ", level_index=" + level_index +
                ", genre='" + genre + '\'' +
                ", constant=" + constant +
                ", overpower_100=" + overpower_100 +
                '}';
    }

    public ScoreOpCalced(Integer id, String title, Integer highscore, String full_combo, Integer level_index) {
        this.id = id;
        this.title = title;
        this.highscore = highscore;
        this.full_combo = full_combo;
        this.level_index = level_index;
    }

    public Integer getOverpower_100() {
        return overpower_100;
    }

    public void setOverpower_100(Integer overpower_100) {
        this.overpower_100 = overpower_100;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getConstant() {
        return constant;
    }

    public void setConstant(Double constant) {
        this.constant = constant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getHighscore() {
        return highscore;
    }

    public void setHighscore(Integer highscore) {
        this.highscore = highscore;
    }

    public String getFull_combo() {
        return full_combo;
    }

    public void setFull_combo(String full_combo) {
        this.full_combo = full_combo;
    }

    public Integer getLevel_index() {
        return level_index;
    }

    public void setLevel_index(Integer level_index) {
        this.level_index = level_index;
    }
}
