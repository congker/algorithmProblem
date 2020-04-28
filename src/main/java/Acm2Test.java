package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Acm2Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入敏感字符：");
        String text = scanner.nextLine();
        String[] arr = text.split("\\s+");
        boolean exit = false;
        List<String> strList = new ArrayList<>();
        while (!exit) {
            System.out.print("请输入字符(输入0结束)：");
            String wenben = scanner.nextLine();
            if (!"0".equals(wenben)) {
                for (String ss : arr) {
                    if (wenben.contains(ss)) {
                        String res = wenben.replace(ss, "***");
                        strList.add(res);
                    }
                }
            } else {
                exit = true;
                System.out.println("任务结束");
            }
        }
        System.out.println("最终输出：" + strList);
    }


}
