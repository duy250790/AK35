package OOP;

public abstract class Sharp {
    private String color = "red";
    public Sharp() {

    }

    public String getColor() {
        return color;
    }

    public abstract void draw();
}
