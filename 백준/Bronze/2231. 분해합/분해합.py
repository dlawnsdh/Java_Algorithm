def bunhehab(k):
    s=str(k)
    for index in s:
        k+=int(index)
    return k

n=int(input())
min=0
for i in range(1,n+1):
    if bunhehab(i)==n:
        min=i
        break
print(min)