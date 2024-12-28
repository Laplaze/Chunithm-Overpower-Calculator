package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

//@AllArgsConstructor
//@Data
public class Score {
    private Integer id;//id
    private String title;//标题
    private Integer level_index;//难度（0-B，1-N，2-E，3-M，4-U）
    private Integer highscore;//分数
    private Integer rank_index;//等级
    private String clear;//通关标签
    private String full_combo;//fc标签
    private String full_chain;//
    private String idx;//可能是谱面id
    private String createdAt;//创建时间
    private String updatedAt;//更新时间

    @Override
    public String toString() {
        return "entity.Score{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", level_index=" + level_index +
                ", highscore=" + highscore +
                ", rank_index=" + rank_index +
                ", clear='" + clear + '\'' +
                ", full_combo='" + full_combo + '\'' +
                ", full_chain='" + full_chain + '\'' +
                ", idx='" + idx + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    public Score(Integer id, String title, Integer level_index, Integer highscore, Integer rank_index, String clear, String full_combo, String full_chain, String idx, String createdAt, String updatedAt) {
        this.id = id;
        this.title = title;
        this.level_index = level_index;
        this.highscore = highscore;
        this.rank_index = rank_index;
        this.clear = clear;
        this.full_combo = full_combo;
        this.full_chain = full_chain;
        this.idx = idx;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public Integer getLevel_index() {
        return level_index;
    }

    public void setLevel_index(Integer level_index) {
        this.level_index = level_index;
    }

    public Integer getHighscore() {
        return highscore;
    }

    public void setHighscore(Integer highscore) {
        this.highscore = highscore;
    }

    public Integer getRank_index() {
        return rank_index;
    }

    public void setRank_index(Integer rank_index) {
        this.rank_index = rank_index;
    }

    public String getClear() {
        return clear;
    }

    public void setClear(String clear) {
        this.clear = clear;
    }

    public String getFull_combo() {
        return full_combo;
    }

    public void setFull_combo(String full_combo) {
        this.full_combo = full_combo;
    }

    public String getFull_chain() {
        return full_chain;
    }

    public void setFull_chain(String full_chain) {
        this.full_chain = full_chain;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
