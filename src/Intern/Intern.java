public class Intern extends Employee{
            private int duration;

            public Intern(String name, int id, double salary, String department, int duration){
                super(name, id, salary, department);
                this.duration = duration;
            }

            public void setDuration(int duration){
                this.duration = duration;
            }
            public int getDuration(){
                return duration;
            }

            @Override
            public void displayInfo(){
                super.displayInfo();
                System.out.println("Role : Intern");
                System.out.println("Duration: " + duration + " months");
            }

            @Override
            public void work(){
                System.out.println(getName() + " is learning and assisting the team ");  
            }
            
            @Override
            public double calculateBonus(){
                return getSalary()*0.05;
            }
        }
