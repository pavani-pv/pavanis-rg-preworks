import java.util.*;

class Employee{
	private int id;
	private String name;
	private String department;
	
	//function to create new emplyee record
	void createEmployee(int id, String name, String department){
	    this.id = id;
	    this.name = name;
	    this.department = department;
	}
	
	//getters and setters for data members
	void setId(int id){
	    this.id = id;
	}
	void setName(String name){
	    this.name = name;
	}
	void setDepartment(String department){
	    this.department = department;
	}
	int getId(){
	    return this.id;
	}
	String getName(){
	    return this.name;
	}
	String getDepartment(){
	    return this.department;
	}
	
	//employee details display func
	void displayInfo(){
	    System.out.println("id:" + this.id);
	    System.out.println("name:" + this.name);
	    System.out.println("department:" + this.department);
	}
}

public class EmployeeCRUDdemo{
    
    ArrayList <Employee> emplist = new ArrayList<Employee>();
    
    void addEmployee(Employee obj){
        emplist.add(obj);
        System.out.println("\nemployee record created!!\n");
    }
    void deleteEmployee(int id){
        for(Employee obj: emplist){
            if(obj.getId() == id){
                emplist.remove(obj);
                System.out.println("user with id" + id + "has been deleted");
                break;
            }
        }
    }
    void displayEmployee(int id){
        for(Employee obj: emplist){
            if(obj.getId() == id){
                System.out.println("Employee id:" + obj.getId());
                System.out.println("Employee name:" + obj.getName());
                System.out.println("Employee department:" + obj.getDepartment());
                break;
            }
        }
    }
    void updateEmployee(int id){
        for(Employee obj: emplist){
            if(obj.getId() == id){
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter 1 for updating name \nEnter 2 to update department \nEnter 3 to update both");
                int choice = sc.nextInt();
                if(choice == 1){
                    System.out.println("enter new name:");
                    String name = sc.next();
                    obj.setName(name);
                }
                else if(choice == 2){
                    System.out.println("enter new department:");
                    String department = sc.next();
                    obj.setDepartment(department);
                }
                else{
                    System.out.println("enter new name:");
                    String name = sc.next();
                    System.out.println("enter new department:");
                    String department = sc.next();
                    obj.setName(name);
                    obj.setDepartment(department);
                }
                
                System.out.println("\nRecord updated successfully\n");
                //sc.close();
                break;
            }
        }
        
    }
    
    public static void main(String args[]){
        EmployeeCRUDdemo obj = new EmployeeCRUDdemo();
        Scanner s = new Scanner(System.in);
        int choice;
        System.out.println("Employee Database!! \n");
        
        do{
            System.out.println("Enter 1 to create new employee record \nEnter 2 to display employee \nenter 3 to update employee \nenter 4 delete employee \nenter 5 to exit\n");
            
            choice = s.nextInt();
            if(choice ==1){
                System.out.println("Enter name:");
                String name = s.next();
                System.out.println("Enter ID:");
                int id = s.nextInt();
                System.out.println("Enter department:");
                String department = s.next();
                Employee emp = new Employee();
                emp.createEmployee(id, name, department);
                obj.addEmployee(emp);
            }
            else if(choice == 2){
                System.out.println("enter id of the employee record to be displayed");
                int id = s.nextInt();
                obj.displayEmployee(id);
            }
            else if(choice == 3){
                System.out.println("enter id of the employee record to be updated");
                int id = s.nextInt();
                obj.updateEmployee(id);
            }
            else if(choice == 4){
                System.out.println("enter id of the employee record to be deleted");
                int id = s.nextInt();
                obj.deleteEmployee(id);
            }
            else{
                System.out.println("Exit");
            }
            
        }
        while(choice!= 5);
        
        s.close();
    }
}
