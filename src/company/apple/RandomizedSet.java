package company.apple;

import java.util.*;

public class RandomizedSet {
    LinkedHashSet<Integer> lhSet;
    List<Integer> list;
    Random random;
    public RandomizedSet() {
        lhSet = new LinkedHashSet<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
         boolean result = lhSet.add(val);
         if(result) {
             list.add(val);
         }
         return result;
    }

    public boolean remove(int val) {
        boolean result = lhSet.remove(val);
        if(result) {
            list.remove(list.indexOf(val));
        }
        return result;
    }

    public int getRandom() {
        //if(list.size() != lhSet.size()) return -1;
        int randomNumber = random.nextInt(list.size());
        return list.get(randomNumber);
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(1));
        System.out.println(rs.remove(2));
        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
        System.out.println(rs.remove(1));
        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
    }
}