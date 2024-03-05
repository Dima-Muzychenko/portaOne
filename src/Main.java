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

            File file = new File(fileStr);
            Scanner scanner = new Scanner(file).useDelimiter("[\\s,.]+"); //s-пробіл

            ArrayList<Integer> numbers = new ArrayList<>();
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                numbers.add(num);
            }
            scanner.close();

            FindInFile findInFile = new FindInFile();
            int max = findInFile.getMax(numbers);
            int min = findInFile.getMin(numbers);
            double median = findInFile.findMedian(new ArrayList<>(numbers));//копія
            double average = findInFile.findAverage(numbers);
            ArrayList<Integer> increasingSequence = findInFile.findIncreasingSequence(numbers);
            ArrayList<Integer> decreasingSequence = findInFile.findDecreasingSequence(numbers);


            System.out.println("Максимальне число: " + max);
            System.out.println("Мінімальне число: " + min);
            System.out.println("Медіана: " + median);
            System.out.println("Середнє арифметичне: " + String.format("%.3f", average));
            System.out.println("Найбільша послідовність чисел, яка збільшується: " + increasingSequence);
            System.out.println("Найбільша послідовність чисел, яка зменшується: " + decreasingSequence);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено.");
            e.printStackTrace();
        }
    }
}
