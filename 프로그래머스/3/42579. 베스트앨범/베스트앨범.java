import java.util.*;

class Solution {
    class Genre implements Comparable<Genre> {
        String genre;
        List<int[]> songs = new ArrayList<>();
        
        Genre(String g) {
            this.genre = g;
        }
        
        int getTotalPlay() {
            return songs.stream()
                .mapToInt(i -> i[1])
                .sum();
        }
        
        @Override
        public int compareTo(Genre o) {
            return o.getTotalPlay() - this.getTotalPlay();
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> m = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            m.computeIfAbsent(g, k -> new Genre(g))
                .songs
                .add(new int[] {i, plays[i]});
        }
        
        List<Integer> result = new ArrayList<>();
        m.values().stream()
            .sorted()
            .map(g -> g.songs.stream()
                 .sorted((a, b) -> b[1] - a[1])
                 .limit(2)
                 .mapToInt(i -> i[0])
                 .toArray())
            .forEach(info -> {
                for (int i : info)
                    result.add(i);
            });
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}