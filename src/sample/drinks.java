package sample;

public class drinks extends item {
   private String type;
    //private double price;

    public drinks(String type, double quantity) {
       super(type, quantity);
        this.type = type;

    }

    @Override
    public double pricing(double n) {
        if (type == "mojito") {
            return n *20;
        }
        if (type == "Pinacolada") {
            return n *20;
        }
        if (type == "milkshake") {
            return n *20;
        }
        if (type == "ice tea") {
            return n *20;
        }
        if (type == "pepsi") {
            return n *40;
        }
        if (type == "redbull") {
            return n *40;
        }
        if (type == "spirit") {
            return n *40;
        }
        if (type == "apple fanta") {
            return n *40;
        }
        else return 0;
    }



    public double bubbletea(){
        if(quantity>=2)
            return quantity*25*0.7;
        else
            return 0;
    }
}
