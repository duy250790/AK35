package tvn;

public class Product {
    private float originPrice;
    private float salesPrice;

    public Product(String originPrice, String salesPrice) {
        this.originPrice = Float.parseFloat(originPrice.replace(" đ",""));
        this.salesPrice = Float.parseFloat((salesPrice.replace(" đ","")));
    }

    public int getDiscount(){
        return Math.round(((this.originPrice - this.salesPrice)/this.originPrice)*100);
    }
}
