import java.util.Scanner;
import com.student.manage.Student;
import com.student.manage.StudentOperations;

public class Start {
    public static void main(String[] args) {
        System.out.println("Welcome to Student Management System");
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Press 1 to add student");
            System.out.println("Press 2 to delete student");
            System.out.println("Press 3 to display student");
            System.out.println("Press 4 to update");
            System.out.println("Press 5 to exit");
            int choice = sc.nextInt();
            if(choice == 1) {
                // add student
                System.out.println("Enter student name:");
                String name = sc.next();
                System.out.println("Enter student city:");
                String city = sc.next();
                System.out.println("Enter student id:");
                int id = sc.nextInt();
                // creating student object
                Student stu = new Student(id, name, city);
                boolean answer = StudentOperations.insertIntoDB(stu);
                if(answer) {
                    System.out.println("Added....");
                } else {
                    System.out.println("Something went wrong try again");
                }
            } else if(choice == 2) {
                // delete student
                System.out.println("Enter Student id to delete");
                int userID = sc.nextInt();
                boolean f = StudentOperations.deleteFromDB(userID);
                if(f) {
                    System.out.println("Deleted.....");
                } else {
                    System.out.println("Something went wrong try again");
                }
            } else if(choice == 3) {
                // display student
                StudentOperations.showAllStudents();
            } else if(choice == 4) {
                // update
                System.out.println("Enter new name");
                String newName = sc.next();
                System.out.println("Enter new City");
                String newCity = sc.next();
                System.out.println("Enter student id");
                int id = sc.nextInt();
                boolean answer = StudentOperations.updateDB(id, newName, newCity);
                if(answer) {
                    System.out.println("Changed....");
                } else {
                    System.out.println("Something went wrong try again");
                }
            } else if(choice == 5) {
                break;
            } else {}
        }
        System.out.println("Thankyou for using my application");
        System.out.println("See you soon");
    }
}
