class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int x = 0; 
        int y = 0;
        int n = park.length - 1;
        int m = park[0].length() - 1;
        for (int i = 0; i < park.length; i++)
            for (int k = 0; k < park[i].length(); k++)
                if (park[i].charAt(k) == 'S') {
                    x = i;
                    y = k;
                }
        
        for (int j = 0; j < routes.length; j++) {
            int k = routes[j].charAt(2) - 48;
            int tmp = 0;
            switch (routes[j].charAt(0)) {
                case 'E':
                    if (y + k > m)
                        continue;
                    for (int i = 1; i <= k; i++)
                        if (park[x].charAt(y + i) != 'X')
                            tmp++;
                    if (k == tmp)
                        y += k;
                    break;
                case 'W':
                    if (y - k < 0)
                        continue;
                    for (int i = 1; i <= k; i++)
                        if (park[x].charAt(y - i) != 'X')
                            tmp++;
                    if (k == tmp)
                        y -= k;
                    break;
                case 'S':
                    if (x + k > n)
                        continue;
                    for (int i = 1; i <= k; i++)
                        if (park[x + i].charAt(y) != 'X')
                            tmp++;
                    if (k == tmp)
                        x += k;
                    break;
                case 'N':
                    if (x - k < 0)
                        continue;
                    for (int i = 1; i <= k; i++)
                        if (park[x - i].charAt(y) != 'X')
                            tmp++;
                    if (k == tmp)
                        x -= k;
                    break;
            }
        }
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}