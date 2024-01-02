object Solution {
    def solution(n: Int): Int = {
        func(2, n - 1)
    }
    
    def func(k: Int, n: Int): Int = {
        if (n % k == 0) k
        else func(k + 1, n)
    }
}