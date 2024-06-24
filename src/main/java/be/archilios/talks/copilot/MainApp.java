package be.archilios.talks.copilot;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        int number = Integer.parseInt(keyboard.nextLine());
        
        calculateAll(number).forEach(System.out::println);
    }
    
    
    public static List<Integer> calculateAll(int number) {
        List<Integer> collect = new java.util.ArrayList<>(Stream.iterate(2, i -> i + 1)
                .limit(number - 1)
                .toList());
        
        for (int i = 0; i < collect.size(); i++) {
            int current = collect.get(i);
            for (int j = i + 1; j < collect.size(); j++) {
                if (collect.get(j) % current == 0) {
                    collect.remove(j);
                }
            }
        }
        
        return collect;
        
    }
}
