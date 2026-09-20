public class Manager extends Employee{
        private int teamSize;

        public Manager(String name, int id, double salary, String department, int teamSize){
            super(name, id, salary, department);
            this.teamSize = teamSize;
        }

        public void setTeamSize(int teamSize){
            this.teamSize = teamSize;
        }

        public int getTeamSize(){
            return teamSize;
        }

        @Override
        public void displayInfo(){
            super.displayInfo();
            System.out.println("Role: Manager");
        }

        @Override
        public void work(){
            System.out.println("The responsability of " + getName() + " is to correctly manage the company ressorces.");
            System.out.println(getName() + " should manage a team of " +  teamSize + " employees");
        }


        @Override
        public double calculateBonus(){
            return getSalary()*0.20;
        }
    }
