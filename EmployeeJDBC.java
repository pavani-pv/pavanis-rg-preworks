import java.sql.*;
import java.util.Scanner;
class Employee{
    private int id;
    private String name;
    private String department;

    void createemployeeobj(int id,String name,String department){
        this.id=id;
        this.name=name;
        this.department=department;
    }
    int getid(){
        return this.id;
    }
    String getname(){
        return this.name;
    }
    String getdepartment(){
        return this.department;
    }
    void setid(int id){
        this.id=id;
    }
    void setname(String name){
        this.name=name;
    }
    void setdepartment(String department){
        this.department=department;
    }

}

public class EmployeeJDBC {
    // JDBC URL, username, and password of MySQL server
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    static final String JDBC_USER = "root";
    static final String JDBC_PASSWORD = "Pavni@4545";
    static Connection con;

    void addemployee(Employee emp){
        try {
            String sql = "INSERT INTO employeetable (id, name, department) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, emp.getid());
            statement.setString(2, emp.getname());
            statement.setString(3, emp.getdepartment());

            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    void updateemployee(int id, String name, String department){
        try {
            String sql = "UPDATE employeetable SET id = ?, name = ?, department = ? WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, department);
            statement.setInt(4, id);

            statement.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    void deleteemployee(int id){
        try {
            String sql = "DELETE FROM employeetable WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    void displayemployee(int id){
        try {
            String sql = "SELECT id, name, department FROM employeetable WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int column1 = result.getInt("id");
                String column2 = result.getString("name");
                String column3 = result.getString("department");
                System.out.println("Id: " + column1);
                System.out.println("Name: " + column2);
                System.out.println("Department: " + column3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try{
            con= DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            System.out.println("Connection Successful!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        EmployeeJDBC obj = new EmployeeJDBC();
        Scanner s = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Press 1 to Add Employee \n 2 to Update Employe\n 3 to Delete Employee\n 4 to Display Details\n 5 to exit");
            choice=s.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter new ID");
                    int id=s.nextInt();
                    System.out.println("Enter new name: ");
                    String name=s.next();
                    System.out.println("Enter new department: ");
                    String department=s.next();
                    Employee emp = new Employee();
                    emp.createemployeeobj(id,name,department);
                    obj.addemployee(emp);
                    break;
                case 2:
                    System.out.println("Enter ID to update");
                    int id1=s.nextInt();
                    System.out.println("Enter new name: ");
                    String name1=s.next();
                    System.out.println("Enter new department: ");
                    String department1=s.next();
                    obj.updateemployee(id1,name1,department1);
                    break;
                case 3:
                    System.out.println("Enter ID to delete");
                    int id2=s.nextInt();
                    obj.deleteemployee(id2);
                    break;
                case 4:
                    System.out.println("Enter ID to display");
                    int id3=s.nextInt();
                    obj.displayemployee(id3);
                    break;
                case 5:
                    System.out.println("Thank you for using Employee Database!!!");
                    break;

            }
        }
        while(choice!=5);

    }
}
