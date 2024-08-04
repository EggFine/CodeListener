package com.blbilink.codeListener;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String listenPath;
    static List<String> corePath = new ArrayList<>();
    static int coreNum;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] str) {
        System.out.println("请输入监听路径: ");
        listenPath = scanner.next();

        for (coreNum = 1; ; coreNum++) {
            String cache;
            System.out.println("（输入 stop 结束）请输入第" + coreNum + "个核心路径: ");
            cache = scanner.next();
            if (cache != "stop") {
                corePath.add(cache);
            } else {
                break;

            }
        }

    }


    private void dirListener(String dir) throws IOException {
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path path = Paths.get(dir);
        path.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);

        try {
            while (true) {
                WatchKey key = watcher.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.OVERFLOW) {
                        continue;
                    }
                    Path fileName = (Path) event.context();
                    System.out.println("文件更新: " + fileName);
                }
                if (!key.reset()) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}