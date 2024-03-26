import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        int maxPlaytime = 0;
        String song = "(None)";
        m = replaceCode(m);
        
        List<MusicInfo> info = new ArrayList<>();
        for (String s : musicinfos) {
            String[] tmp = s.split(",");
            info.add(new MusicInfo(calculatePlayTime(tmp[0], tmp[1]), tmp[2], replaceCode(tmp[3])));
        }
        
        for (MusicInfo i : info) {
            String c = i.getCode().repeat(i.getPlayTime() / i.getCode().length())
                + i.getCode().substring(0, i.getPlayTime() % i.getCode().length());
            if (checkCode(c, m) && maxPlaytime < i.getPlayTime()) {
                song = i.getTitle();
                maxPlaytime = i.getPlayTime();
            }
        }
        return song;
    }
    
    class MusicInfo {
        int playTime;
        String title;
        String code;
        
        public MusicInfo(int p, String t, String c) {
            playTime = p;
            title = t;
            code = c;
        }
        
        public int getPlayTime() { return playTime; }
        public String getTitle() { return title; }
        public String getCode() { return code; }
    }
    
    public int calculatePlayTime(String st, String en) {
        int hour = (Integer.parseInt(en.substring(0, 2)) - Integer.parseInt(st.substring(0, 2))) * 60;
        int minute = Integer.parseInt(en.substring(3)) - Integer.parseInt(st.substring(3));
        return hour + minute;
    }
    
    public String replaceCode(String s) {
        return s.replaceAll("A#", "U")
            .replaceAll("B#", "V")
            .replaceAll("C#", "W")
            .replaceAll("D#", "X")
            .replaceAll("F#", "Y")
            .replaceAll("G#", "Z");
    }
    
    public boolean checkCode(String c, String m) {
        return (c.equals(m) || c.contains(m)) ? true : false;
    }
}