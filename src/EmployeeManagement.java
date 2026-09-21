import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

        public class EmployeeManagement{

            public static int generateUniqueId(ArrayList<Employee> employees, Random rand) {
                    int id;
                    do {
                    id = 10000 + rand.nextInt(90000);
                    } while (idExists(employees, id));
                    return id;
                }

                public static boolean idExists(ArrayList<Employee> employees, int id) {

                for (Employee emp : employees) {
                if (emp.getId() == id) {
                return true;
               }
            }

             return false;
            }
            
            public static void main(String[] args){

                Scanner sc = new Scanner(System.in);
                Random rand = new Random();
                ArrayList <Employee> employees = new ArrayList<>();


                Developer d = new Developer("David", 12330, 5000.0, "CSE", "Java");
                Manager m = new Manager("Beau-G", 44779, 7499.99, "IT Security Department", 58);
                Intern i = new Intern("Jacques", 85500, 1200, "CSE", 4);
                Tester t = new Tester("Alice", 27843, 3700, "Computer Science", "Selenium");

                employees.add(d);
                employees.add(m);
                employees.add(i);
                employees.add(t);

                boolean running = true;

                while(running){

                    System.out.println("\n======= EMPLOYEE MANAGEMENT SYSTEM =======\n");
                    System.out.println("1. Display all employees");
                    System.out.println("2. Search employee");
                    System.out.println("3. Add employee");
                    System.out.println("4. Update employee");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");
                    int choice = sc.nextInt();

                switch(choice){
                    case 1:
                        System.out.println("\n======= EMPLOYEE DETAILS =======\n");
                        for(Employee emp : employees){
                        emp.displayInfo();
                        emp.work();
                        System.out.println("Bonus " + emp.calculateBonus());
                        System.out.println();
                       }
                       break;

                       case 2:
                    
                      System.out.print("Enter the employee ID: ");
                      int searchId = sc.nextInt();
                      boolean found = false;

                      for(Employee emp : employees){
                      if (searchId == emp.getId()){
                        System.out.println("\nEmployee found");
                        emp.displayInfo();
                        found = true;
                        break;
                    }
                }

                   if (!found) {
                   System.out.println("Employee not found!");
                }
                break;

                case 3:
                    System.out.println("==== ADDING AN EMPLOYEE ====\n");
                    System.out.println("    1. Developer\n2. Manager\n3. Intern\n4. Tester");
                    System.out.println("Type of employee: ");
                    int employeeType = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New employee name: ");
                    String newEmployeeName = sc.nextLine();
                    int id = generateUniqueId(employees, rand);
                    System.out.println("Generated employee ID: " + id);
                    System.out.print("New employee salary: ");
                    double newEmployeeSalary = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("New employee department: ");
                    String newEmployeeDepartment = sc.nextLine();

                    switch(employeeType){
                        case 1:
                            System.out.print("Preferred Programming Language: ");
                            String programmingLanguage = sc.nextLine();
                            Developer newD = new Developer(newEmployeeName, id, newEmployeeSalary, newEmployeeDepartment, programmingLanguage);
                            employees.add(newD);
                            System.out.println("New Developer successfully registered...");
                            break;

                         case 2:
                            System.out.print("Team size: ");
                            int teamSize = sc.nextInt();
                            sc.nextLine();
                            Manager newM = new Manager(newEmployeeName, id, newEmployeeSalary, newEmployeeDepartment, teamSize); 
                            employees.add(newM);
                            System.out.println("New Manager successfully registered...");
                            break;

                        case 3:
                            System.out.print("Duration of internship: ");
                            int duration = sc.nextInt();
                            sc.nextLine();
                            Intern newI = new Intern(newEmployeeName, id, newEmployeeSalary, newEmployeeDepartment, duration);
                            employees.add(newI);
                            System.out.println("New Intern successfully registered...");
                            break;

                         case 4:
                            System.out.print("Testing tool: ");
                            String testingTool = sc.nextLine();
                            Tester newT = new Tester(newEmployeeName, id, newEmployeeSalary, newEmployeeDepartment, testingTool);
                            employees.add(newT);
                            System.out.println("New Tester successfully registered...");
                    }
                    break;

                case 4:
                    System.out.println("\n===== UPDATE EMPLOYEE =====\n");
                    System.out.print("Enter ID of employee to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    boolean updateId_found = false;
                    for(Employee emp : employees){
                        if (emp.getId() == updateId){
                            updateId_found = true;

                            System.out.println("\n      Employee found");
                            emp.displayInfo();

                            System.out.println("\nWhat do you want to update ?");
                            System.out.println("1. Name");
                            System.out.println("2. Salary");
                            System.out.println("3. Department");
                            System.out.println("4. Cancel");

                            System.out.print("Enter your option: ");
                            int updateOption = sc.nextInt();
                            sc.nextLine();
                            String oldName = emp.getName();

                            switch(updateOption){
                                case 1:
                                    System.out.print("Enter the new name: ");
                                    String newName = sc.nextLine();
                                    emp.setName(newName);
                                    System.out.println("Employee name successfully changed from " + oldName + " to " + newName);
                                    break;

                                case 2:
                                    double oldSalary = emp.getSalary();
                                    System.out.print("Enter new salary: ");
                                    double newSalary = sc.nextDouble();
                                    emp.setSalary(newSalary);
                                    System.out.println(oldName + "'s salary successfully changed from " + oldSalary + " to " + newSalary);
                                    break;

                                case 3:
                                    String oldDepartment = emp.getDepartment();
                                    System.out.print("Enter new department: ");
                                    String newDepartment = sc.nextLine();
                                    emp.setDepartment(newDepartment);
                                    System.out.println(oldName + "'s department successfully changed from \"" + oldDepartment + "\" to \"" + newDepartment + "\"");
                                    break;

                                case 4:
                                    System.out.println("Cancelling ...");
                                    try{
                                        Thread.sleep(2000);
                                    }catch(InterruptedException e){

                                    }
                                    System.out.println("Successfully cancelled !");
                                    break;

                                default:
                                    System.out.println("Invalid option");
                            }
                            break;
                        }
                    }
                    if (!updateId_found){
                        System.out.println("Employee not found !");
                    }
                    break;

                case 5:
                    System.out.println("EXITING ....");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){

                    }
                    running = false;
                    break;
                }      
                }

    
            }
        }