import sys
a = []
n = int(sys.stdin.readline())
s = ""
for _ in range(n):
    s = sys.stdin.readline()
    a.append(s[0])
    for i in range(1, len(s)):
        a.append(s[i])
        if a[len(a) - 2] == '(' and a[len(a) - 1] == ')':
            a.pop()
            a.pop()
    a.pop()
    if len(a) == 0:
        print('YES')
    else:
        print('NO')
    a = []