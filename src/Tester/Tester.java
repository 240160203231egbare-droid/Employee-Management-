public class Tester extends Employee{
            private String testingTool;

            public Tester(String name, int id, double salary, String department, String testingTool){
                super(name, id, salary, department);
                this.testingTool = testingTool;
            }

            public void setTestingTool(String testingTool){
                this.testingTool = testingTool;
            }
            public String getTestingTool(){
                return testingTool;
            }

            @Override
            public void displayInfo(){
                super.displayInfo();
                System.out.println("Role: Tester");
                System.out.println("Tool used: " + getTestingTool());
            }

            @Override
            public void work(){
                System.out.println(getName() + " will test the software");
            }

            @Override
            public double calculateBonus(){
                return getSalary()*0.12;
            }
        }
