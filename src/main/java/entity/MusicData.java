package entity;

public class MusicData {
    private Integer musicID;
    private String title;
    private String artist;
    private String genre;//分类
    private Integer bpm;
    private String from;//版本
    private Charts charts;

    public MusicData(Integer musicID, String title, String artist, String genre, Integer bpm, String from, Charts charts) {
        this.musicID = musicID;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.bpm = bpm;
        this.from = from;
        this.charts = charts;
    }

    @Override
    public String toString() {
        return "entity.MusicData{" +
                "musicID=" + musicID +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", bpm=" + bpm +
                ", from='" + from + '\'' +
                ", charts=" + charts +
                '}';
    }

    public Integer getMusicID() {
        return musicID;
    }

    public void setMusicID(Integer musicID) {
        this.musicID = musicID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getBpm() {
        return bpm;
    }

    public void setBpm(Integer bpm) {
        this.bpm = bpm;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Charts getCharts() {
        return charts;
    }

    public void setCharts(Charts charts) {
        this.charts = charts;
    }
}
class Charts {
    private Normal basic;
    private Normal advanced;
    private Normal expert;

    private Normal master;
    private Normal ultima;
    private WEchart worldsend;

    @Override
    public String toString() {
        return "entity.Charts{" +
                "basic=" + basic +
                ", advanced=" + advanced +
                ", expert=" + expert +
                ", master=" + master +
                ", ultima=" + ultima +
                ", worldsend=" + worldsend +
                '}';
    }

    public Charts(Normal basic, Normal advanced, Normal expert, Normal master, Normal ultima, WEchart worldsend) {
        this.basic = basic;
        this.advanced = advanced;
        this.expert = expert;
        this.master = master;
        this.ultima = ultima;
        this.worldsend = worldsend;
    }

    public Normal getBasic() {
        return basic;
    }

    public void setBasic(Normal basic) {
        this.basic = basic;
    }

    public Normal getAdvanced() {
        return advanced;
    }

    public void setAdvanced(Normal advanced) {
        this.advanced = advanced;
    }

    public Normal getExpert() {
        return expert;
    }

    public void setExpert(Normal expert) {
        this.expert = expert;
    }

    public Normal getMaster() {
        return master;
    }

    public void setMaster(Normal master) {
        this.master = master;
    }

    public Normal getUltima() {
        return ultima;
    }

    public void setUltima(Normal ultima) {
        this.ultima = ultima;
    }

    public WEchart getWorldsend() {
        return worldsend;
    }

    public void setWorldsend(WEchart worldsend) {
        this.worldsend = worldsend;
    }
}
class Normal {
    private boolean enabled;
    private Double constant;
    private String level;
    private String charter;
    private ObjectCount object_count;

    public Normal(boolean enabled, Double constant, String level, String charter, ObjectCount object_count) {
        this.enabled = enabled;
        this.constant = constant;
        this.level = level;
        this.charter = charter;
        this.object_count = object_count;
    }

    @Override
    public String toString() {
        return "entity.Normal{" +
                "enabled=" + enabled +
                ", constant=" + constant +
                ", level='" + level + '\'' +
                ", charter='" + charter + '\'' +
                ", object_count=" + object_count +
                '}';
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Double getConstant() {
        return constant;
    }

    public void setConstant(Double constant) {
        this.constant = constant;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCharter() {
        return charter;
    }

    public void setCharter(String charter) {
        this.charter = charter;
    }

    public ObjectCount getObject_count() {
        return object_count;
    }

    public void setObject_count(ObjectCount object_count) {
        this.object_count = object_count;
    }
}
class WEchart {
    private boolean enabled;
    private Integer constant;
    private String level;
    private String charter;
    private String wetype;
    private Integer wediff;
    private ObjectCount object_count;

    public WEchart(boolean enabled, Integer constant, String level, String charter, String wetype, Integer wediff, ObjectCount object_count) {
        this.enabled = enabled;
        this.constant = constant;
        this.level = level;
        this.charter = charter;
        this.wetype = wetype;
        this.wediff = wediff;
        this.object_count = object_count;
    }

    @Override
    public String toString() {
        return "entity.WEchart{" +
                "enabled=" + enabled +
                ", constant=" + constant +
                ", level='" + level + '\'' +
                ", charter='" + charter + '\'' +
                ", wetype='" + wetype + '\'' +
                ", wediff=" + wediff +
                ", object_count=" + object_count +
                '}';
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getConstant() {
        return constant;
    }

    public void setConstant(Integer constant) {
        this.constant = constant;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCharter() {
        return charter;
    }

    public void setCharter(String charter) {
        this.charter = charter;
    }

    public String getWetype() {
        return wetype;
    }

    public void setWetype(String wetype) {
        this.wetype = wetype;
    }

    public Integer getWediff() {
        return wediff;
    }

    public void setWediff(Integer wediff) {
        this.wediff = wediff;
    }

    public ObjectCount getObject_count() {
        return object_count;
    }

    public void setObject_count(ObjectCount object_count) {
        this.object_count = object_count;
    }
}
class ObjectCount {
    private Integer tap;
    private Integer hold;
    private Integer slide;
    private Integer air;
    private Integer flick;
    private Integer total;

    public ObjectCount(Integer tap, Integer hold, Integer slide, Integer air, Integer flick, Integer total) {
        this.tap = tap;
        this.hold = hold;
        this.slide = slide;
        this.air = air;
        this.flick = flick;
        this.total = total;
    }

    @Override
    public String toString() {
        return "entity.ObjectCount{" +
                "tap=" + tap +
                ", hold=" + hold +
                ", slide=" + slide +
                ", air=" + air +
                ", flick=" + flick +
                ", total=" + total +
                '}';
    }

    public Integer getTap() {
        return tap;
    }

    public void setTap(Integer tap) {
        this.tap = tap;
    }

    public Integer getHold() {
        return hold;
    }

    public void setHold(Integer hold) {
        this.hold = hold;
    }

    public Integer getSlide() {
        return slide;
    }

    public void setSlide(Integer slide) {
        this.slide = slide;
    }

    public Integer getAir() {
        return air;
    }

    public void setAir(Integer air) {
        this.air = air;
    }

    public Integer getFlick() {
        return flick;
    }

    public void setFlick(Integer flick) {
        this.flick = flick;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
