package OOP;

public class Rectangle_II implements Sharp_Color{
    @Override
    public String getColor() {
        return "White";
    }

    @Override
    public void draw() {
        System.out.println("Draw " + getColor() + " Rectangle_II");
    }
}
