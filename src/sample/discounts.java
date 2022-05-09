package sample;

public class discounts  {
    private double discount=0;
    private double promocode=0;
    public  discounts(String name, String promocode){
        if (promocode.equals("adel1021")) //for all users
        {
            this.discount = 0.15;
            this.promocode=0.15;
        }
        if(name.equals("adel") && promocode.equals("ADEL85949")) //for that specific user
        {
            this.discount = 0.3;
            this.promocode=0.3;

        }
        if(promocode.equals("ADEL85949")){
            this.promocode=0.3;
        }
 }
    public double promo()
    {
        return promocode;
    }
    public double dsa()
    {
        return discount;
    }
}
