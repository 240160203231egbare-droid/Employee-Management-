public class Developer extends Employee{
        private String programmingLanguage;
        
        public Developer(String name, int id, double salary, String department, String programmingLanguage){
            super(name, id, salary, department);
            this.programmingLanguage = programmingLanguage;
        } 

        public void setProgrammingLanguage(String programmingLanguage){
            this.programmingLanguage = programmingLanguage;
        }
        public String getProgrammingLanguage(){
            return programmingLanguage;
        }

        @Override
        public void displayInfo(){
            super.displayInfo();
            System.out.println("Role: Software Developer");
            System.out.println("Preferred Language: " + programmingLanguage);   
        }

        @Override
        public void work(){
            System.out.println(getName() + " is developing a software using " + programmingLanguage);
        }

        @Override
        public double calculateBonus(){
            return getSalary()*0.15;
        }
    }

