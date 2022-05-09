package sample;

public class Owner extends Person{
    private static Owner owner=null;

    private Owner(String name, String address, String telephonenumber, String gender) {
        super(name, address, telephonenumber, gender);
    }

    @Override
    public double getsalary() {
        return 0;
    }

    @Override
    public double calcbonus(double h) {
        return 0;
    }

    public static Owner getInstance()
    {
        if(owner==null)
            owner=new Owner("Mark","6th avenue","0112349867","Male");
        return owner;
    }
    public String getadress()
    {
        return address;
    }
    public String gettele ()
    {
        return telephonenumber;
    }


    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephonenumber=" + telephonenumber +
                ", gender='" + gender + '\'' +
                '}';
    }
}
