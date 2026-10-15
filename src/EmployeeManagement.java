import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class EmployeeManagement {

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

    public static int getValidInt(Scanner sc) {
        while (true) {
            try {
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input ! Please enter a valid value.");
                sc.nextLine();
            }
        }
    }

    public static double getValidDouble(Scanner sc) {
        while (true) {
            try {
                double value = sc.nextDouble();
                sc.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Inavlid input ! Please enter a valid value.");
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<Employee> employees = new ArrayList<>();

        Developer d = new Developer("David TOJU", 12330, 5000.0, "CSE", "Java");
        Manager m = new Manager("Beaugard E.", 44779, 7499.99, "IT Security Department", 58);
        Intern i = new Intern("Jacques LONGA", 85500, 1200, "CSE", 4);
        Tester t = new Tester("Alice KEBE", 27843, 3700, "Computer Science", "Selenium");

        employees.add(d);
        employees.add(m);
        employees.add(i);
        employees.add(t);

        boolean running = true;

        while (running) {

            System.out.println("\n======= EMPLOYEE MANAGEMENT SYSTEM =======\n");
            System.out.println("1. Display all employees");
            System.out.println("2. Search employee");
            System.out.println("3. Add employee");
            System.out.println("4. Update employee");
            System.out.println("5. Remove employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = getValidInt(sc);

            switch (choice) {
                case 1:
                    System.out.println("\n======= EMPLOYEE DETAILS =======\n");
                    for (Employee emp : employees) {
                        emp.displayInfo();
                        emp.work();
                        System.out.println("Bonus " + emp.calculateBonus());
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.println("\n======== SEARCH EMPLOYEE ========\n");
                    System.out.print("Enter the employee ID: ");
                    int searchId = getValidInt(sc);
                    boolean found = false;

                    for (Employee emp : employees) {
                        if (searchId == emp.getId()) {
                            System.out.println("\nEmployee found\n");
                            emp.displayInfo();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("\nEmployee not found!");
                    }
                    break;

                case 3:
                    System.out.println("==== ADDING AN EMPLOYEE ====\n");
                    System.out.println("    1. Developer\n    2. Manager\n    3. Intern\n    4. Tester");
                    System.out.print("Type of employee: ");
                    int employeeType;
                    while (true) {
                        employeeType = getValidInt(sc);
                        if (employeeType < 1 || employeeType > 4) {
                            System.out.println("Invalid input ! \n  Employee type input must lie between 1 and 4");
                            continue;
                        }
                        break;
                    }

                    System.out.print("New employee name: ");
                    String newEmployeeName = sc.nextLine();

                    int id = generateUniqueId(employees, rand);

                    System.out.println("Generated employee ID: " + id);
                    System.out.print("New employee salary: ");

                    double newEmployeeSalary;
                    while (true) {
                        newEmployeeSalary = getValidDouble(sc);

                        if (newEmployeeSalary <= 0) {
                            System.out.println("Invalid salary input !");
                            continue;
                        }
                        break;
                    }
                    int teamSize;
                    int duration;

                    System.out.print("New employee department: ");
                    String newEmployeeDepartment = sc.nextLine();

                    switch (employeeType) {
                        case 1:
                            System.out.print("Preferred Programming Language: ");
                            String programmingLanguage = sc.nextLine();
                            Developer newD = new Developer(newEmployeeName, id, newEmployeeSalary,
                                    newEmployeeDepartment, programmingLanguage);
                            employees.add(newD);
                            System.out.println("New Developer successfully registered...");
                            break;

                        case 2:
                            System.out.print("Team size: ");
                            while (true) {
                                teamSize = getValidInt(sc);

                                if (teamSize < 0) {
                                    System.out.println("Invalid team size input !");
                                    continue;
                                }
                                break;
                            }

                            Manager newM = new Manager(newEmployeeName, id, newEmployeeSalary, newEmployeeDepartment,
                                    teamSize);
                            employees.add(newM);
                            System.out.println("New Manager successfully registered...");
                            break;

                        case 3:
                            System.out.print("Duration of internship: ");
                            while (true) {
                                duration = getValidInt(sc);
                                if (duration <= 0) {
                                    System.out.println("Invalid duration input !");
                                    continue;
                                }
                                break;
                            }

                            Intern newI = new Intern(newEmployeeName, id, newEmployeeSalary, newEmployeeDepartment,
                                    duration);
                            employees.add(newI);
                            System.out.println("New Intern successfully registered...");
                            break;

                        case 4:
                            System.out.print("Testing tool: ");
                            String testingTool = sc.nextLine();
                            Tester newT = new Tester(newEmployeeName, id, newEmployeeSalary, newEmployeeDepartment,
                                    testingTool);
                            employees.add(newT);
                            System.out.println("New Tester successfully registered...");
                    }
                    break;

                case 4:
                    System.out.println("\n===== UPDATE EMPLOYEE =====\n");
                    System.out.print("Enter ID of employee to update: ");
                    int updateId = getValidInt(sc);

                    boolean updateId_found = false;
                    for (Employee emp : employees) {
                        if (emp.getId() == updateId) {
                            updateId_found = true;

                            System.out.println("\n      Employee found");
                            emp.displayInfo();

                            System.out.println("\nWhat do you want to update ?");
                            System.out.println("1. Name");
                            System.out.println("2. Salary");
                            System.out.println("3. Department");
                            System.out.println("4. Cancel");

                            System.out.print("Enter your option: ");
                            int updateOption;

                            while (true) {
                                updateOption = getValidInt(sc);

                                if (updateOption < 1 || updateOption > 4) {
                                    System.out.println("Invalid option! Choose between 1 and 4.");
                                    continue;
                                }

                                break;
                            }
                            String oldName = emp.getName();

                            switch (updateOption) {
                                case 1:
                                    System.out.print("Enter the new name: ");
                                    String newName = sc.nextLine();
                                    emp.setName(newName);
                                    System.out.println(
                                            "Employee name successfully changed from " + oldName + " to " + newName);
                                    break;

                                case 2:
                                    double oldSalary = emp.getSalary();
                                    System.out.print("Enter new salary: ");
                                    double newSalary;
                                    while (true) {
                                        newSalary = getValidDouble(sc);

                                        if (newSalary <= 0) {
                                            System.out.println("Invalid salary input !");
                                            continue;
                                        }
                                        break;
                                    }
                                    emp.setSalary(newSalary);
                                    System.out.println(oldName + "'s salary successfully changed from " + oldSalary
                                            + " to " + newSalary);
                                    break;

                                case 3:
                                    String oldDepartment = emp.getDepartment();
                                    System.out.print("Enter new department: ");
                                    String newDepartment = sc.nextLine();
                                    emp.setDepartment(newDepartment);
                                    System.out.println(oldName + "'s department successfully changed from \""
                                            + oldDepartment + "\" to \"" + newDepartment + "\"");
                                    break;

                                case 4:
                                    System.out.println("Cancelling ...");
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {

                                    }
                                    System.out.println("Successfully cancelled !");
                                    break;

                                default:
                                    System.out.println("Invalid option");
                            }
                            break;
                        }
                    }
                    if (!updateId_found) {
                        System.out.println("Employee not found !");
                    }
                    break;
                case 5:
                    System.out.println("\n===== REMOVE EMPLOYEE =====\n");
                    System.out.print("Enter ID of employee to remove: ");

                    int idToRemove = getValidInt(sc);

                    boolean idToRemove_found = false;

                    for (int j = 0; j < employees.size(); j++) {
                        if (employees.get(j).getId() == idToRemove) {
                            idToRemove_found = true;

                            System.out.println("\nEmployee found, here are details: \n");
                            employees.get(j).displayInfo();
                            while (true) {
                                System.out
                                        .print("Are you sure you want to remove this employee ? (yes/y/1 OR no/n/0): ");
                                String confirmation = sc.nextLine();
                                confirmation = confirmation.trim().toLowerCase();
                                if (confirmation.equals("yes") || confirmation.equals("y")
                                        || confirmation.equals("1")) {
                                    employees.remove(j);
                                    System.out.println("Employee with the ID " + idToRemove
                                            + " is successfully removed from the system.");
                                    break;
                                } else if (confirmation.equals("no") || confirmation.equals("n")
                                        || confirmation.equals("0")) {
                                    System.out.println("Employee Removal Cancelled !");
                                    break;
                                } else {
                                    System.out.println("Please enter a valid decision (Yes or No)");
                                }
                            }
                        }
                    }
                    if (!idToRemove_found) {
                        System.out.println("Employee not found");
                    }
                    break;

                case 6:
                    System.out.println("EXITING ....");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {

                    }
                    running = false;
                    break;
            }
        }

    }
}
