import sys
input = sys.stdin.readline

N = int(input().strip())

arr =[]
for i in range(N):
    x, r = map(int, input().strip().split())
    arr.append([x-r,x+r])

arr.sort(key=lambda x : (x[0],x[1]))

flag, prev = True, [-1e9,-1e9]
for ar in arr:
    if prev[1] >= ar[0] and prev[1] <= ar[1]:
        flag = False
        break
    prev = ar

print("YES" if flag else "NO")