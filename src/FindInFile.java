import java.util.ArrayList;
import java.util.Collections;

public class FindInFile {

    public int getMax(ArrayList<Integer> list){
        int res = list.get(0);
        for (int i:list) {
            if (i>res){
                res=i;
            }
        }
        return res;
    }

    public int getMin(ArrayList<Integer> list){
        return Collections.min(list);
    }

    public double findMedian(ArrayList<Integer> numbers) {
        Collections.sort(numbers);
        int size = numbers.size();
        if (size % 2 == 0) {
            int middle1 = numbers.get(size / 2 - 1);
            int middle2 = numbers.get(size / 2);
            return (middle1 + middle2) / 2.0;
        } else {
            return numbers.get(size / 2);
        }
    }

    public double findAverage(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.size();
    }

    public ArrayList<Integer> findIncreasingSequence(ArrayList<Integer> numbers) {
        ArrayList<Integer> maxSequence = new ArrayList<>();
        ArrayList<Integer> currentSequence = new ArrayList<>();

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) < numbers.get(i + 1)) {
                currentSequence.add(numbers.get(i));
            } else {
                currentSequence.add(numbers.get(i));
                if (currentSequence.size() > maxSequence.size()) {
                    maxSequence = new ArrayList<>(currentSequence);
                }
                currentSequence.clear();
            }
        }

        if (!currentSequence.isEmpty() && currentSequence.size() > maxSequence.size()) {
            maxSequence = new ArrayList<>(currentSequence);
        }
        return maxSequence;
    }

    public ArrayList<Integer> findDecreasingSequence(ArrayList<Integer> numbers) {
        ArrayList<Integer> maxSequence = new ArrayList<>();
        ArrayList<Integer> currentSequence = new ArrayList<>();

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                currentSequence.add(numbers.get(i));
            } else {
                currentSequence.add(numbers.get(i));
                if (currentSequence.size() > maxSequence.size()) {
                    maxSequence = new ArrayList<>(currentSequence);
                }
                currentSequence.clear();
            }
        }

        if (!currentSequence.isEmpty() && currentSequence.size() > maxSequence.size()) {
            maxSequence = new ArrayList<>(currentSequence);
        }
        return maxSequence;
    }


}
