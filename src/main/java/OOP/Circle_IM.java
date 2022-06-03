package OOP;

public class Circle_IM implements Color,IF_Sharp{
    @Override
    public void draw() {
        System.out.println("Draw" + this.getColor() + "Circle_IM");
    }

    @Override
    public String getColor() {
        return "Red";
    }
}
