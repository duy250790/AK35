package OOP;



public class Rectangle_IM implements Color,IF_Sharp {
    @Override
    public void draw() {
        System.out.println("Draw" + this.getColor() +"Rectangle_IM" );
    }

    @Override
    public String getColor() {
        return "Red";
    }
}
