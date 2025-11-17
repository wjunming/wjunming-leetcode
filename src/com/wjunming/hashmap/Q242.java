package com.wjunming.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @see <href a="https://leetcode.cn/problems/valid-anagram/description/">242. 有效的字母异位词</href>
 */
public class Q242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        byte[] sBytes = s.getBytes();
        byte[] tBytes = t.getBytes();
        Arrays.sort(sBytes);
        Arrays.sort(tBytes);
        return Arrays.equals(sBytes, tBytes);
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--arr[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
