class Solution {
    public String solution(String[] seoul) {
        int i = 0;
        for (; i < seoul.length; i++)
            if (seoul[i].equals("Kim"))
                break;
        return String.format("김서방은 %d에 있다", i);
    }
}