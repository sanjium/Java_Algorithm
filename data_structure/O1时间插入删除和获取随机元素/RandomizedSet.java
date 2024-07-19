package data_structure.O1时间插入删除和获取随机元素;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 380. O(1) 时间插入、删除和获取随机元素:https://leetcode.cn/problems/insert-delete-getrandom-o1/description/
public class RandomizedSet {

    public static Map<Integer, Integer> map;

    public static List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int value = list.get(list.size() - 1);
        list.set(index, value);
        list.remove(list.size() - 1);
        map.put(value, index);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}
