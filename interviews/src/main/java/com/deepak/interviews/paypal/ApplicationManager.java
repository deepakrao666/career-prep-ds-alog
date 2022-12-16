package com.deepak.interviews.paypal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ApplicationManager {

    public static List<String> getOpenApplications(List<String> commands) {
        ArrayDeque<String> deque = new ArrayDeque<>();

        for (String command : commands) {
            String[] arr = command.split(" ");

            if (arr.length > 0) {

                if (arr[0].equals("open")) {
                    deque.addLast(arr[1]);
                }
                if (arr[0].equals("close")) {

                    int k = Integer.parseInt(arr[1]);
                    for (int i = 0; i < k; i++) {
                        if (!deque.isEmpty())
                            deque.removeLast();
                    }
                }
                if (arr[0].equals("clear")) {
                    deque = new ArrayDeque<>();
                }
            }
        }


        List<String> res = new ArrayList<>();
        while (!deque.isEmpty()) {
            res.add(deque.poll());
        }

        return res;
    }
}
