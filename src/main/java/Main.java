import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final int SUM_VALUE = 13;

    public static void main(String[] args) {
        String lineFromConsole = getLineFromConsole();
        String[] split = lineFromConsole.split(" ");
        Map<Integer, Integer> valueCountMap = getNumbersWithCounts(split);
        printPairs(valueCountMap);
    }

    private static void printPairs(Map<Integer, Integer> valueCountMap) {
        for (int i = 0; i <=SUM_VALUE/2 ; i++) {
            if(valueCountMap.containsKey(SUM_VALUE-i) && valueCountMap.containsKey(i)){
                Integer counter = valueCountMap.get(SUM_VALUE - i)<=valueCountMap.get(i) ? valueCountMap.get(SUM_VALUE-i) : valueCountMap.get(i);
                for (int j = 0; j < counter; j++) {
                    System.out.println(i + " " + (SUM_VALUE-i));
                }
            }
        }
    }

    private static Map<Integer, Integer> getNumbersWithCounts(String[] split) {
        Map<Integer, Integer> valueCountMap = new HashMap<>();
        for (String numStr : split) {
            Integer num = Integer.valueOf(numStr);
            if(num>SUM_VALUE){
                continue;
            }
            if(valueCountMap.containsKey(num)){
                Integer counts = valueCountMap.get(num);
                valueCountMap.put(num, counts+1);
            }else {
                valueCountMap.put(num, 1);
            }
        }
        return valueCountMap;
    }

    private static String getLineFromConsole(){
        Scanner scanner = new Scanner(System.in);
        String line ="";
        if(scanner.hasNextLine()){
            line = scanner.nextLine();
        }
        scanner.close();
        return line;
    }
}
