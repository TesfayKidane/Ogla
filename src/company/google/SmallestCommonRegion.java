package company.google;

import java.util.*;

public class SmallestCommonRegion {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> parents = new HashMap<>();
        Set<String> ancestryHistory = new HashSet<>();

        // Create parents for each region.
        for(List<String> region : regions) {
            for(int i = 1; i < region.size(); i++) {
                parents.put(region.get(i), region.get(0));
            }
        }

        // Create ancestral hierarchy of region 1.
        while(region1 != null) {
            ancestryHistory.add(region1);
            region1 = parents.get(region1);
        }

        // Find the lowest common ancestor
        while(!ancestryHistory.contains(region2)) {
            region2 = parents.get(region2);
        }

        return region2;
    }


    public static void main(String[] args) {

    }
}
