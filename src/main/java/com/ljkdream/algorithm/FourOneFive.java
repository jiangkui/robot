package com.ljkdream.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 4.1-5 习题
 *
 * 求最大子数组，线性时间算法。
 *
 * Created by LJK on 2015/11/4.
 */
public class FourOneFive {

    private static void findMaxArray(List<Integer> list) {
        int max = Integer.MIN_VALUE; //最大子数组
        int sum = 0; //子数组的和
        int cur_low = 0;
        int low = 0;// 最大子数组下标 起点
        int height = 0;//最大子数组下标  终点

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);

            if (sum > max) {
                max = sum;
                low = cur_low;
                height = i;
            } else if (sum < 0) {
                sum = 0;
                cur_low = i + 1;
            }
        }

        if (max > 0) {
            System.out.println("max:" + max + "; [" + low + "," + height + "]");

            List<Integer> subList = new ArrayList<>();
            for (int i = low; i <= height; i++) {
                subList.add(list.get(i));
            }

            System.out.println("子数组：" + subList);
        } else {
            System.out.println("没找到最大子数组");
        }
        //
    }

    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int r = random.nextInt(10) -5;
            list.add(r);
        }

        System.out.println("数组：" + list.toString());

        FourOneFive.findMaxArray(list);
    }
}
