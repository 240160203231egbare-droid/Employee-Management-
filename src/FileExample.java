
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileExample {
    
    public static void saveEmployee(ArrayList<Employee> employees) {

        try (FileWriter writer = new FileWriter("employee.txt")) {

            for (Employee emp : employees) {

                String line = null;

                if (emp instanceof Developer) {
                    Developer dev = (Developer) emp;

                    line = "Developer;"
                        + dev.getName() + ";"
                        + dev.getId() + ";"
                        + dev.getSalary() + ";"
                        + dev.getDepartment() + ";"
                        + dev.getProgrammingLanguage();

                } else if (emp instanceof Manager) {
                    Manager mng = (Manager) emp;

                    line = "Manager;"
                        + mng.getName() + ";"
                        + mng.getId() + ";"
                        + mng.getSalary() + ";"
                        + mng.getDepartment() + ";"
                        + mng.getTeamSize();

                } else if (emp instanceof Tester) {
                    Tester tst = (Tester) emp;

                    line = "Tester;"
                        + tst.getName() + ";"
                        + tst.getId() + ";"
                        + tst.getSalary() + ";"
                        + tst.getDepartment() + ";"
                        + tst.getTestingTool();

                } else if (emp instanceof Intern) {
                    Intern itr = (Intern) emp;

                    line = "Intern;"
                        + itr.getName() + ";"
                        + itr.getId() + ";"
                        + itr.getSalary() + ";"
                        + itr.getDepartment() + ";"
                        + itr.getDuration();
                }

                if (line != null) {
                    System.out.println(line);
                    writer.write(line + "\n");
                }
            }

            System.out.println("File saved successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static ArrayList<Employee> readEmployee(){
        ArrayList<Employee> loadedEmployees = new ArrayList<>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader("employee.txt"))){
            String line;
            
            while((line = reader.readLine()) != null){
                String[] data = line.split(";");
                int id = Integer.parseInt(data[2]);
                double salary = Double.parseDouble(data[3]);
                
                if(data[0].equals("Developer")){
                    Developer dev = new Developer(data[1], id, salary, data[4], data[5]);
                    loadedEmployees.add(dev);
                    System.out.println("Developer recreated: " + dev.getName());
                    
                }else if(data[0].equals("Manager")){
                    int teamSize = Integer.parseInt(data[5]); 
                    Manager mng = new Manager(data[1], id, salary, data[4], teamSize);
                    loadedEmployees.add(mng);
                    System.out.println("Manager recreated: " + mng.getName());  
                    
                }else if(data[0].equals("Tester")){
                    Tester tst = new Tester(data[1], id, salary, data[4], data[5]);
                    loadedEmployees.add(tst);
                    System.out.println("Tester recreated: " + tst.getName());
                    
                }else if(data[0].equals("Intern")){
                    int duration = Integer.parseInt(data[5]);
                    Intern itr = new Intern(data[1], id, salary, data[4], duration);
                    loadedEmployees.add(itr);
                    System.out.println("Intern recreated: " + itr.getName());
                }
                
                System.out.println("Type of employee: " + data[0]);
                System.out.println("Employee name: " + data[1]);
                System.out.println("Employee ID: " + id);
                System.out.println("Employee salary: " + salary);
                System.out.println("Employee department: " + data[4]);
                System.out.println("Specific information: " + data[5]);
                
                System.out.println("---------------------------------------");
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        return loadedEmployees;
    }

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Developer("David TOJU", 12330, 5000.0, "CSE", "Java"));
        employees.add(new Manager("Beaugard EGBARE", 44779, 7499.99, "Cybersecurity", 58));
        employees.add(new Tester("Alice ARENI", 27843, 3700.0, "AI-ML", "Selenium"));
        employees.add(new Intern("Jacques LONGA", 85500, 1200.0, "CSE", 4));

        saveEmployee(employees);
        ArrayList<Employee> loadedEmployees = readEmployee();
        System.out.println("Number of employees loaded: " + loadedEmployees.size());

    }

}
