package company.apple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VisitCounter {

    Map<Long, Long> count(Map<String, UserStats>... visits) {
        Map<Long, Long> result = new HashMap<>();
        if(visits.length == 0 || visits == null || Arrays.stream(visits).allMatch(null)) {
            return result;
        }

        for (final Map<String, UserStats> visitMap : visits) {
            for (Map.Entry<String, UserStats> e : visitMap.entrySet()) {
                Long userId;
                try {
                    userId = Long.parseLong(e.getKey());
                } catch (NumberFormatException nfe) {
                    continue;
                }

                if (e.getValue() == null || !e.getValue().getVisitCount().isPresent()) {
                    continue;
                }

                Long visitCount = result.getOrDefault(userId, 0L).longValue() + e.getValue().getVisitCount().orElse(0L);

                if(result.values()
                        .stream()
                        .allMatch(null) ) {
                    return new HashMap<>();
                }
                result.put(userId, visitCount);
            }
        }
        return result;
    }

    static class UserStats {
        private Optional<Long> visitCount;

        public UserStats(Optional<Long> visitCount) {
            this.visitCount = visitCount;
        }

        public Optional<Long> getVisitCount() {
            return visitCount;
        }
    }

    public static void main(String[] args) {
        VisitCounter vc = new VisitCounter();
        Map<String, UserStats> test1 = new HashMap<>();
        test1.put("1", new UserStats(Optional.of(21L)));
        vc.count();
        System.out.println(vc.count(test1));
    }
}
