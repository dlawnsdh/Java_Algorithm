import java.util.*;

class Solution {
    class Member {
        String parent;
        List<Integer> amount = new ArrayList<>();
        
        Member(String p) {
            this.parent = p;
        }
        
        void addAmount(int n) {
            amount.add(n);
        }
        
        void subAmount(int n) {
            if (!amount.isEmpty())
                amount.set(amount.size() - 1, amount.get(amount.size() - 1) - n);
        }
        
        int totalAmount() {
            return amount.stream()
                .mapToInt(Integer::intValue)
                .sum();
        }
    }
    
    void dfs(String name, int amount) {
        if (name.equals("-") || amount / 10 < 1) return;
        else {
            member.get(name).subAmount(amount / 10);
            member.get(member.get(name).parent).addAmount(amount / 10);
            dfs(member.get(name).parent, amount / 10);
        }
    }
    
    Map<String, Member> member = new LinkedHashMap<>() {{
        put("-", new Member("-"));
    }};
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (int i = 0; i < enroll.length; i++)
            member.put(enroll[i], new Member(referral[i]));
        for (int i = 0; i < seller.length; i++) {
            member.get(seller[i]).addAmount(amount[i] * 100);
            dfs(seller[i], amount[i] * 100);
        }
        
        member.remove("-");
        return member.values().stream()
            .mapToInt(m -> m.totalAmount())
            .toArray();
    }
}