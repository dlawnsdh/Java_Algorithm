import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Music> l = new ArrayList<>();
        Map<String, Integer> total = new HashMap<>();
        Map<String, Integer> including = new HashMap<>();
        for (int i = 0; i < genres.length; i++)
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
        for (int i = 0; i < genres.length; i++)
            l.add(new Music(genres[i], i, plays[i]));
        
        l.sort((m1, m2) -> {
            if (total.get(m1.getGenre()) == total.get(m2.getGenre()))
                return -Integer.compare(m1.getPlayed(), m2.getPlayed());
            return -Integer.compare(total.get(m1.getGenre()), total.get(m2.getGenre()));
        });
        
        List<Integer> result = new ArrayList<>();
        for (Music m : l)
            if (including.getOrDefault(m.getGenre(), 0) < 2) {
                result.add(m.getNumber());
                including.put(m.getGenre(), including.getOrDefault(m.getGenre(), 0) + 1);
            }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    class Music {
        String genre;
        int number;
        int played;
        
        public Music(String g, int n, int p) {
            genre = g;
            number = n;
            played = p;
        }
        
        public String getGenre() { return genre; }
        public int getNumber() { return number; }
        public int getPlayed() { return played; }
    }
}