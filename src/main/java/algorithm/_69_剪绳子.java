package algorithm;

import java.util.HashSet;
import java.util.Set;

public class _69_剪绳子 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(2);
        System.out.println(set.add(3)); // true
        System.out.println(set.add(2)); // false
    }
}
