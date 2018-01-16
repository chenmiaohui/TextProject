package list.chenmiaohui.com.textproject;

/**
 * Created by cmh on 2018/1/15.
 */

public class Text {
    private String name;
    private int imgRed;

    public Text(String name, int imgRed) {
        this.name = name;
        this.imgRed = imgRed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgRed() {
        return imgRed;
    }

    public void setImgRed(int imgRed) {
        this.imgRed = imgRed;
    }

    @Override
    public String toString() {
        return "Text{" +
                "name='" + name + '\'' +
                ", imgRed=" + imgRed +
                '}';
    }
}
