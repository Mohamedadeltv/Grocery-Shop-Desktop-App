package sample;

public class food extends item{
    private String type;
    public food(String type, double quantity) {
        super(type, quantity);
        this.type = type;
    }

    @Override
    public double pricing(double n) {
        if (type == "Cheese Burger") {
            return n *50;
        }
        if (type == "Mushrom Burger") {
            return n *50;
        }
        if (type == "Fried chicken") {
            return n *50;
        }
        if (type == "Grilled CHicken") {
            return n *50;
        }
        else return 0;
    }
}
