import sys
n = sys.stdin.readline().strip()
s = n
cnt = 0
if len(n) == 1:
    n, s = '0' + n, '0' + n
while True:
    cnt += 1
    a, b = int(n[0]), int(n[1])
    c = a + b
    c = str(c)
    n = n[1] + c[-1]
    if s == n:
        break
print(cnt)
