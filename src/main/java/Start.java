import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Start {
    public static void main(String[] args) {
//        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
//        boolean isRemoved = numbers.remove(Integer.valueOf(3)); // 移除数字3
//        System.out.println(numbers);
        aaa a1 = new aaa("1","111");
        aaa a2 = new aaa("2","222");
        List<aaa> aaaList = new ArrayList<>();
        aaaList.add(a1);
        aaaList.add(a2);
        System.out.println(aaaList);
//        aaaList.remove(0);
        aaaList.removeIf(x -> x.getTitle().equals("1"));
        System.out.println(aaaList);
    }
}
class aaa{
    private String title;
    private String content;

    @Override
    public String toString() {
        return "aaa{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public aaa(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
