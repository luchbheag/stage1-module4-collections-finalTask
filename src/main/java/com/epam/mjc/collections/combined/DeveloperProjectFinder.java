package com.epam.mjc.collections.combined;

import java.util.*;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        Queue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String str1, String str2) {
                return str1.length() == str2.length() ? -str1.compareTo(str2) : str1.length() - str2.length();
            }
        });
        for (Map.Entry<String, Set<String>> entry : projects.entrySet()) {
            String project = entry.getKey();
            Set<String> set = entry.getValue();
            if (!set.isEmpty() && set.contains(developer)) {
                priorityQueue.add(project);
            }
        }
        List<String> result = new ArrayList<String>(priorityQueue);
        Collections.reverse(result);
        return result;
    }
}
