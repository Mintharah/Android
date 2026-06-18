import java.util.Scanner;

public class StudentGradingSystem {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("How many students? ");
    int numStudents = scanner.nextInt();

    for (int i = 1; i <= numStudents; i++) {
      System.out.print("Enter name for student " + i + ": ");
      String name = scanner.next();

      System.out.print("Enter score for " + name + "(0-100): ");
      double score = scanner.nextDouble();

      char grade = getLetterGrade(score);
      System.out.println(name + " scored " + score + " -> Grade: " + grade);
    }

    scanner.close();
  }

  public static char getLetterGrade(double score) {
    if (score >= 90) {
      return 'A';
    } else if (score >= 80) {
      return 'B';
    } else if (score >= 70) {
      return 'C';
    } else if (score >= 60) {
      return 'D';
    } else {
      return 'F';
    }
  }
}