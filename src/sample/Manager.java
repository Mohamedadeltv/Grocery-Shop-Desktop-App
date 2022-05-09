package sample;

public class Manager extends Person{
     static double basesalary=3500;
     double bonus;
     double hours;
     double salary;

    public Manager(String name, String address, String telephonenumber, String gender) {
        super(name, address, telephonenumber, gender);

    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }


    @Override
    public double calcbonus(double h) {
        if (h>60)
            bonus=0.2;
        else
            bonus=0.15;
        return bonus;


    }

    @Override
    public double getsalary() {
        salary=basesalary+basesalary*bonus ;
        return salary;

    }

    @Override
    public String toString() {
        return "Manager{" +
                ", hours=" + hours +
                ", salary=" + getsalary()+
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephonenumber=" + telephonenumber +
                ", gender='" + gender + '\'' +
                '}';
    }
}
