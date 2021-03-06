package Entity;


import java.util.Date;
import java.util.Objects;

public class Contact {
    private int id;
    private String name;
    private String sername;
    private int age;
    private double height;
    private boolean maried=false;
    private String phoneNumber;
    private Date createDate;


    public Contact() {
    }

    public Contact(int id, String name, String sername, int age, double growth, boolean maried, String phoneNumber, Date createDate) {
        this.id = id;
        this.name = name;
        this.sername = sername;
        this.age = age;
        this.height = growth;
        this.maried = maried;
        this.phoneNumber = phoneNumber;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSername() {
        return sername;
    }

    public void setSername(String sername) {
        this.sername = sername;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isMaried() {
        return maried;
    }

    public void setMaried(boolean maried) {
        this.maried = maried;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return  age == contact.age &&
                Double.compare(contact.height, height) == 0 &&
                maried == contact.maried &&
                Objects.equals(name, contact.name) &&
                Objects.equals(sername, contact.sername) &&
                Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sername != null ? sername.hashCode() : 0);
        result = 31 * result + age;
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (maried ? 1 : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sername='" + sername + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", maried=" + maried +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
