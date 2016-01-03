package com.ljkdream.test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**dao
 * tester
 * Created by ljk on 16-1-2.
 */
public class HashSetTest {
    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            set.add(random.nextInt(5));
        }

        System.out.println(set);
    }
}
