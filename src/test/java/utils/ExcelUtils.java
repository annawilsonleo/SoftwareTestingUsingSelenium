package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelUtils {
    public static void main(String[] args) {
        List<String> packet1 = Arrays.asList("bis1", "bis2", "bis3", "bis4", "bis5");
        List<String> packet2 = Arrays.asList("bis1", "bis2", "bis3", "bis4", "bis5");
        List<String> packet3 = Arrays.asList("bis1", "bis2", "bis3", "bis4", "bis5");
        List<String> packet4 = Arrays.asList("bis1", "bis2", "bis3", "bis4", "bis5");
        List<String> packet5 = Arrays.asList("bis1", "bis2", "bis3", "bis4", "bis5");

        List<List<String>> box = new ArrayList<>();
        box.add(packet1);
        box.add(packet2);
        box.add(packet3);
        box.add(packet4);
        box.add(packet5);

        for(List<String> packet: box){
            for(String bis: packet){
                System.out.print(bis+ " ");
            }
            System.out.println();
        }
    }
}
