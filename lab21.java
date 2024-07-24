

import java.util.Scanner;

public class lab21 {
    static int n; 
    static int[][] marks;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        n = scanner.nextInt();
        marks = new int[n][3];

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add student marks");
            System.out.println("2. Update student mark");
            System.out.println("3. Get the average for a subject");
            System.out.println("4. Get the average for a student");
            System.out.println("5. Get the total mark of a student");
            System.out.println("6. Display grades for all students");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudentMarks(scanner);
                    break;
                case 2:
                    updateStudentMark(scanner);
                    break;
                case 3:
                    getSubjectAverage(scanner);
                    break;
                case 4:
                    getStudentAverage(scanner);
                    break;
                case 5:
                    getStudentTotal(scanner);
                    break;
                case 6:
                    displayGrades();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void addStudentMarks(Scanner scanner) {
        for (int i = 0; i < n; i++) {
            System.out.println("Entering marks for student index " + i + ":");
            System.out.print("Enter Mathematics marks: ");
            marks[i][0] = scanner.nextInt();
            System.out.print("Enter Chemistry marks: ");
            marks[i][1] = scanner.nextInt();
            System.out.print("Enter Physics marks: ");
            marks[i][2] = scanner.nextInt();
        }
    }

    public static void updateStudentMark(Scanner scanner) {
        System.out.print("Enter student index to update marks: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < n) {
            System.out.print("Enter new Mathematics marks: ");
            marks[index][0] = scanner.nextInt();
            System.out.print("Enter new Chemistry marks: ");
            marks[index][1] = scanner.nextInt();
            System.out.print("Enter new Physics marks: ");
            marks[index][2] = scanner.nextInt();
        } else {
            System.out.println("Invalid student index.");
        }
    }

    public static void getSubjectAverage(Scanner scanner) {
        System.out.println("Select subject to get average:");
        System.out.println("1. Mathematics");
        System.out.println("2. Chemistry");
        System.out.println("3. Physics");
        System.out.print("Enter your choice: ");
        int subject = scanner.nextInt();

        if (subject < 1 || subject > 3) {
            System.out.println("Invalid subject choice.");
            return;
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            total += marks[i][subject - 1];
        }

        double average = total / n;
        System.out.println("Average marks for subject " + subject + ": " + average);
    }

    public static void getStudentAverage(Scanner scanner) {
        System.out.print("Enter student index to get average: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < n) {
            double total = 0;
            for (int i = 0; i < 3; i++) {
                total += marks[index][i];
            }
            double average = total / 3;
            System.out.println("Average marks for student index " + index + ": " + average);
        } else {
            System.out.println("Invalid student index.");
        }
    }

    public static void getStudentTotal(Scanner scanner) {
        System.out.print("Enter student index to get total marks: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < n) {
            int total = 0;
            for (int i = 0; i < 3; i++) {
                total += marks[index][i];
            }
            System.out.println("Total marks for student index " + index + ": " + total);
        } else {
            System.out.println("Invalid student index.");
        }
    }

    public static void displayGrades() {
        System.out.printf("%-10s %-10s %-10s %-10s%n", "Index", "Math", "Chemistry", "Physics");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d", i);
            for (int j = 0; j < 3; j++) {
                System.out.printf("%-10s", getGrade(marks[i][j]));
            }
            System.out.println();
        }
    }

    public static String getGrade(int score) {
        if(score>100||score<0){
            return "Invalid score";
        }else if (score >= 90) {
            return "Grade A";
        }else if (score >= 80) {
            return "Grade B";
        } else if (score >= 70) {
            return "Grade C";
        } else if (score >= 60) {
            return "Grade D";
        } else {
            return "Fail";
        }
    }
}