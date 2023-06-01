n=int(input())
s=str(n)
l=[]
for i in s:
    l.append(int(i))
l.sort()
l.reverse()
s=""
for i in l:
   s+=str(i)
print(s)
