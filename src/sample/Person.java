package sample;

public abstract class Person implements ISalary{
    protected String name;
    protected String address;
    protected String telephonenumber;
    protected String gender;

    public Person(String name, String address, String telephonenumber, String gender) {
        this.name = name;
        this.address = address;
        this.telephonenumber = telephonenumber;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephonenumber() {
        return telephonenumber;
    }

    public void setTelephonenumber(String telephonenumber) {
        this.telephonenumber = telephonenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public abstract double getsalary() ;

    @Override
    public abstract double calcbonus(double h) ;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephonenumber=" + telephonenumber +
                ", gender='" + gender + '\'' +
                '}';
    }
}
