package sample;

public class appetizers extends item{
    private String type;
    public appetizers(String type, double quantity) {
        super(type, quantity);
        this.type = type;
    }

    @Override
    public double pricing(double n) {
        if (type == "Fries") {
            return n *10;
        }
        if (type == "Onion Rings") {
            return n *10;
        }
        if (type == "Nachos") {
            return n *10;
        }
        if (type == "Curly fries") {
            return n *10;
        }
        else return 0;
    }
}
