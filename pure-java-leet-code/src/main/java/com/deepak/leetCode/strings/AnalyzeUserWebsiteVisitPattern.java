package com.deepak.leetCode.strings;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {
    static class Event {
        private final String user;
        private final int timestamp;
        private final String web;

        Event(String user, int timestamp, String web) {
            this.user = user;
            this.timestamp = timestamp;
            this.web = web;
        }
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<Event> events = new ArrayList<>();
        //1. create event obj and add to list
        for (int i = 0; i < username.length; i++) {
            events.add(new Event(username[i], timestamp[i], website[i]));
        }

        //2. sort list
        Comparator<Event> comp = Comparator.comparingInt((Event a) -> a.timestamp);
        events.sort(comp);

        // 3. create map of user and websites visited
        Map<String, List<String>> userAndWebsites = new HashMap<>();
        for (Event e: events) {
            if (!userAndWebsites.containsKey(e.user))
                userAndWebsites.put(e.user, new ArrayList<>());
            userAndWebsites.get(e.user).add(e.web);
        }

        // 4. create map website and frequency
        Map<String, Integer> webAndFreq = new HashMap<>();
        for (String user: userAndWebsites.keySet()) {
            Set<String> sequence = getThreeSeq(userAndWebsites.get(user));
            for (String seq: sequence)
                webAndFreq.put(seq, webAndFreq.getOrDefault(seq, 0) + 1);
        }


        // 5. compute answer
        int max = 0;
        String ans = "";
        for (String sequence: webAndFreq.keySet()) {
            int freq = webAndFreq.get(sequence);
            if (freq < max) continue;
            if (freq > max) ans = sequence;
            if (max == freq) ans = (sequence.compareTo(ans) < 0) ? sequence: ans;
            max = freq;
        }
        return Arrays.asList(ans.split("#"));
    }

    private Set<String> getThreeSeq(List<String> websites) {
        Set<String> res = new HashSet<>();

        if (websites.size() < 3)
            return res;

        dfs(websites, 0, new ArrayList<>(), res);

        return res;
    }

    private void dfs(List<String> websites, int idx, List<String> tmp, Set<String> res) {
        if (tmp.size() == 3) {
            String seq = tmp.get(0) + "#" + tmp.get(1) + "#" + tmp.get(2);
            res.add(seq);
            return;
        }
        for (int i = idx; i < websites.size(); i++) {
            tmp.add(websites.get(i));
            dfs(websites, i + 1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}
