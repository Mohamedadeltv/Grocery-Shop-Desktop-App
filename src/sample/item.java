package sample;

public abstract  class item implements IPay {
    private String name;
    protected double quantity;

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public item(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    public abstract double pricing(double n);
}
