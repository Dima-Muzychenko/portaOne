import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            //choose necessary file
            FileChoose fc = new FileChoose();
            String fileStr = fc.chooseFile();
            //start time measuring
            long startTime = System.currentTimeMillis();

            File file = new File(fileStr);
            Scanner scanner = new Scanner(file).useDelimiter("[\\s,.]+"); //s-пробіл

            ArrayList<Integer> numbers = new ArrayList<>();
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                numbers.add(num);
            }
            scanner.close();

            FindInFile findInFile = new FindInFile();
            if (!numbers.isEmpty()) {
                int max = findInFile.getMax(numbers);
                int min = findInFile.getMin(numbers);
                double median = findInFile.findMedian(new ArrayList<>(numbers));//копія
                double average = findInFile.findAverage(numbers);
                ArrayList<Integer> increasingSequence = findInFile.findIncreasingSequence(numbers);
                ArrayList<Integer> decreasingSequence = findInFile.findDecreasingSequence(numbers);

                long endTime = System.currentTimeMillis();
                long timePassed = endTime - startTime;
                double seconds = (double) timePassed / 1000.0;
                System.out.println("Time passed: " + seconds + " seconds");

                System.out.println("Максимальне число: " + max);
                System.out.println("Мінімальне число: " + min);
                System.out.println("Медіана: " + median);
                System.out.println("Середнє арифметичне: " + String.format("%.3f", average));
                System.out.println("Найбільша послідовність чисел, яка збільшується: " + increasingSequence);
                System.out.println("Найбільша послідовність чисел, яка зменшується: " + decreasingSequence);
            }else {
                System.out.println("Файл містить не підходящі дані");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено.");
        }
        System.exit(0);
    }
}
