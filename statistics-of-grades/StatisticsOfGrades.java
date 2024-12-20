import java.util.Scanner;
import java.util.Arrays;

class StatisticsOfGrades {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int N;

        System.out.println("Please enter the number of students: ");
        N = scanner.nextInt();

        //Call method to take int student grades
        int[] studentGrades = takeGrades(N);

        //Call method to calculate min, max and average grades
        int[] minMaxAverage = findMinMaxAverage(studentGrades, N);
        int minGrade = minMaxAverage[0];
        int maxGrade = minMaxAverage[1];
        double totalsum = minMaxAverage[2];
        double averageGrade = totalsum / N;

        // Call method to compute stats of grade ranges
        int[] stats = computeStats(studentGrades);

        //Print max, min and average
        System.out.println("Values: ");
        System.out.println();
        System.out.println("Minimum grade: " + minGrade);
        System.out.println("Maximum grade: " + maxGrade);
        System.out.println("Average grade: " + averageGrade);
       
        // Print the bars
        System.out.println();
        printBars(stats);
        System.out.println();
        //2 20 21 22 23 30 48 49 50 55 60 65 72 63 76 80 68 90 85 98
    }

    public static int[] takeGrades(int N){
        /**
         * Method to take in the grades of students
         * Returns the student grades as an array
         */
        int[] studentGrades = new int[N];

        System.out.println("Enter the grades of the student below: ");
        for (int i = 0; i < N; i++){
            System.out.println("Enter grades fo student "+ (i + 1));
            studentGrades[i] = scanner.nextInt();
        }

        return studentGrades;
    }

    public static int[] findMinMaxAverage(int[] grades, int N){
        /**
         * method to find the min, max and average grades
         * returns the min, max and totalSum of grades
         */
        int maxGrade = 0, minGrade = 100, totalsum = 0;
        for (int i = 0; i < N; i++){
            if (grades[i] < minGrade){
                minGrade = grades[i];
            }

            if (grades[i] > maxGrade){
                maxGrade = grades[i];
            }

            totalsum += grades[i];
        }

        return new int[]{minGrade, maxGrade, totalsum};
    }

    public static int[] computeStats(int[] grades){
        /**
         * method to computer the stats for grade ranges
         * returns an array of the stats
         */
        int[] stats = new int[5];

        for (int i = 0; i < grades.length; i++){
            if (grades[i] > 80){
                stats[4] += 1;
            } else if(grades[i] > 60){
                stats[3] += 1;
            } else if(grades[i] > 40){
                stats[2] += 1;
            } else if (grades[i] > 20){
                stats[1] += 1;
            } else if (grades[0] > 0){
                stats[0] += 1;
            }
        }

        return stats;
    }

    public static void printBars(int[] stats){
        /**
         * method to print the bars in the right format
         * returns void
         */
        int tallestBar = 0;
        for (int i = 0; i < 5; i++){
            if (stats[i] > tallestBar){
                tallestBar = stats[i];
            }
        }

        int barDeterminant = tallestBar;// determines when a particular bar should start printing

        for (int i = 0; i < tallestBar; i++){
            System.out.print((tallestBar - i) +  " >"); // prints the height of a bar
            for (int j = 0; j < 5; j++){
                System.out.print("  ");
                if (stats[j] >= barDeterminant){
                    System.out.print("#######");
                } else {
                    System.out.print("       ");
                }
                System.out.print("  ");
            }
            barDeterminant -= 1;

            System.out.println();

        }

        System.out.println("   +----------+---------+---------+-----------+-----------+");
        System.out.println("   I    0-20   I  21-40  I  41-60  I  61-80  I  81-100 I");
    }
}