import java.util.*;

public class Question2 {

    private static int getNumberCountFromMap(Map<Integer,Integer> numberCount, Integer i) {
        Integer count = numberCount.get(i);
        if (count == null) {
            count = 0;
        }
        return count;
    }
    public static List findTrippletSumZero(List<Integer> input) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (input == null || input.size() < 3 ) {
            return result;
        }
        // sort the input
        Collections.sort(input);

        Map<Integer, Integer> numberCount = new HashMap<Integer,Integer>();
        for (Integer i : input) {
            Integer count = getNumberCountFromMap(numberCount, i);
            numberCount.put(i, count + 1);
        }
        for (int i =0; i< input.size()-2; i ++){
            // to avoid duplication
            if (i >0 && input.get(i) == input.get(i-1)) {
                continue;
            }
            for (int j = i+1; j < input.size() -1; j++) {
                if (j > i+1 && input.get(j) == input.get(j-1)) {
                    continue;
                }
                Integer num1 = input.get(i);
                Integer num2 = input.get(j);
                Integer num3 = -1 * (num1 + num2) ;
                if ((num3 == num2 && getNumberCountFromMap(numberCount, num3) > 1)
                    || (num3 > num2) && getNumberCountFromMap(numberCount, num3) >0) {
                   List triplet = Arrays.asList(new Integer[]{num1, num2, num3});
                   result.add(triplet);
                }
            }
        }
        return result;



    }
}
