package sample;

public abstract class guest extends  Person{


    public guest(String name, String address, String telephonenumber, String gender) {
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
}
