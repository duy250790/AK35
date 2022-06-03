package OOP;

public class Rectangle extends Sharp {
    @Override
    public void draw(){
        System.out.println("Rectangle " + super.getColor()  );
    }
}
