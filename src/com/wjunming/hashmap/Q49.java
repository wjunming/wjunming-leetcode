package com.wjunming.hashmap;

import java.util.*;

/**
 * @see <a href="https://leetcode.cn/problems/group-anagrams/description/">49. 字母异位词分组</a>
 */
public class Q49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                arr[c - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    builder.append((char) (i + 'a'));
                    builder.append(arr[i]);
                }
            }
            String key = builder.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
