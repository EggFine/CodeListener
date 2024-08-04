package com.blbilink.codeListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] str) throws IOException {
        Scanner scanner;
        List<String> path = new ArrayList<>();
        int num = 1;


        System.out.println("请输入第 " + num + "个路径");
        scanner = new Scanner(System.in);
        path.add(scanner.next());
        System.out.println(path);
    }
}