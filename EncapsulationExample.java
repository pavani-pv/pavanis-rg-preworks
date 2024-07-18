class Student {
    private String name;
    private int age;
    private String department;

    // Constructor
    public Student(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        if (age > 0 && age < 100) { // Example validation
            this.age = age;
        } else {
            System.out.println("Invalid age input");
        }
    }

    // Getter for department
    public String getDepartment() {
        return department;
    }

    // Setter for department
    public void setDepartment(String department) {
        this.department = department;
    }

    // Method to display student information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
    }
}

public class EncapsulationExample {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 20, "Computer Science");
        
        // Accessing information using getter methods
        System.out.println("Name: " + student1.getName());
        System.out.println("Age: " + student1.getAge());
        System.out.println("Department: " + student1.getDepartment()+"\n");
        
        // Modifying information using setter methods
        student1.setAge(21);
        student1.setDepartment("Information Technology");
        
        // Display updated information
        student1.displayInfo();
    }
}
