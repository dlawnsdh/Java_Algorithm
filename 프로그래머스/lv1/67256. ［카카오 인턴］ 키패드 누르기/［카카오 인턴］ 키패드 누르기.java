class Solution {
    public String solution(int[] numbers, String hand) {
        int[] toZero = {0, 4, 3, 4, 3, 2, 3, 2, 1, 2, 1, 1};
        int[] toTwo = {3, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4, 4};
        int[] toFive = {2, 2, 1, 2, 1, 0, 1, 2, 1, 2, 3, 3};
        int[] toEight = {1, 3, 2, 3, 2, 1, 2, 1, 0, 1, 2, 2};
        String str = "";
        String l = "*";
        String r = "#";
        
        for (int i = 0; i < numbers.length; i++) {         
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                str += "L";
                l = Integer.toString(numbers[i]);
            }
            else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                str += "R";
                r = Integer.toString(numbers[i]);
            }
            else {
                int tmp1 = 0;
                int tmp2 = 0;
                switch (numbers[i]) {
                    case 2:
                        if (l.equals("*") && r.equals("#")) {
                            tmp1 = toTwo[10];
                            tmp2 = toTwo[11];
                        }
                        else if (l.equals("*")) {
                            tmp1 = toTwo[10];
                            tmp2 = toTwo[Integer.parseInt(r)];
                        }
                        else if (r.equals("#")) {
                            tmp1 = toTwo[Integer.parseInt(l)];
                            tmp2 = toTwo[11];
                        }
                        else {
                            tmp1 = toTwo[Integer.parseInt(l)];
                            tmp2 = toTwo[Integer.parseInt(r)];
                        }
                        break;
                    case 5:
                        if (l.equals("*") && r.equals("#")) {
                            tmp1 = toFive[10];
                            tmp2 = toFive[11];
                        }
                        else if (l.equals("*")) {
                            tmp1 = toFive[10];
                            tmp2 = toFive[Integer.parseInt(r)];
                        }
                        else if (r.equals("#")) {
                            tmp1 = toFive[Integer.parseInt(l)];
                            tmp2 = toFive[11];
                        }
                        else {
                            tmp1 = toFive[Integer.parseInt(l)];
                            tmp2 = toFive[Integer.parseInt(r)];
                        }
                        break;
                    case 8:
                        if (l.equals("*") && r.equals("#")) {
                            tmp1 = toEight[10];
                            tmp2 = toEight[11];
                        }
                        else if (l.equals("*")) {
                            tmp1 = toEight[10];
                            tmp2 = toEight[Integer.parseInt(r)];
                        }
                        else if (r.equals("#")) {
                            tmp1 = toEight[Integer.parseInt(l)];
                            tmp2 = toEight[11];
                        }
                        else {
                            tmp1 = toEight[Integer.parseInt(l)];
                            tmp2 = toEight[Integer.parseInt(r)];
                        }
                        break;
                    case 0:
                        if (l.equals("*") && r.equals("#")) {
                            tmp1 = toZero[10];
                            tmp2 = toZero[11];
                        }
                        else if (l.equals("*")) {
                            tmp1 = toZero[10];
                            tmp2 = toZero[Integer.parseInt(r)];
                        }
                        else if (r.equals("#")) {
                            tmp1 = toZero[Integer.parseInt(l)];
                            tmp2 = toZero[11];
                        }
                        else {
                            tmp1 = toZero[Integer.parseInt(l)];
                            tmp2 = toZero[Integer.parseInt(r)];
                        }
                        break;    
                }
                if (tmp1 > tmp2) { 
                    str += "R";
                    r = Integer.toString(numbers[i]);
                }
                else if (tmp1 < tmp2) { 
                    str += "L";
                    l = Integer.toString(numbers[i]);
                }
                else {
                    if (hand.equals("left")) {
                        str += "L";
                        l = Integer.toString(numbers[i]);
                    }
                    else {
                        str += "R";
                        r = Integer.toString(numbers[i]);
                    }
                }
            }
        }
        
        return str;
    }
}