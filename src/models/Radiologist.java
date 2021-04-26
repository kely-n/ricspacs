package models;

public class Radiologist {
    private int staff_no;
    private String name;
    private String department;
    private String password;

    public Radiologist(int staff_no, String name, String department) {
        this.staff_no = staff_no;
        this.name = name;
        this.department = department;
    }

    public int getStaff_no() {
        return staff_no;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
