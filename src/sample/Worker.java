package sample;

public class Worker extends Person{
    private static double basesalary=1500;
    private double bonus;
    private double hours;
    private double salary;
    public  Worker(String name, String address, String telephonenumber, String gender) {
        super(name, address, telephonenumber, gender);

    }



    @Override
    public double calcbonus(double h) {
        if (h>60)
            bonus=0.15;
        else
            bonus=0.10;
        return bonus;


    }

    @Override
    public double getsalary() {
        salary=basesalary+basesalary*bonus;
        return salary;

    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephonenumber=" + telephonenumber +
                ", gender='" + gender + '\'' +
                ", hours=" + hours +
                ", salary=" + getsalary() +
                '}';
    }
}
