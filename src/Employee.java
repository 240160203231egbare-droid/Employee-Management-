public class Employee{
    private String name;
    private int id;
    private double salary;
    private String department;

    public Employee(String name, int id, double salary, String department){
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.department = department;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public double getSalary(){
        return salary;
    }
    public String getDepartment(){
        return department;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public void setDepartment(String department){
        this.department = department;
    }

    public void displayInfo(){
        System.out.println("Name :" + name);
        System.out.println("ID :" + id);
        System.out.println("Department :" + department);
        System.out.println("Salary :" + salary);
    }

    public void work(){
        System.out.println(name + " is working...");
    }

    public double calculateBonus(){
        return salary*0.10;
    }
}