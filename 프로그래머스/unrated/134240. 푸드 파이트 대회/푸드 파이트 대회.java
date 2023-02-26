class Solution {
    public String solution(int[] food) {
        StringBuffer bf = new StringBuffer();
        for (int i = 1; i < food.length; i++)
            bf.append(Integer.toString(i).repeat(food[i] / 2));
        return bf.toString() + "0" + bf.reverse().toString();
    }
}