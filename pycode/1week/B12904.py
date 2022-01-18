import sys
input = sys.stdin.readline

s = list(input().strip())
t = list(input().strip())

switch = False

while t:
    if t[-1] == 'A':
        t.pop()
    elif t[-1] == 'B':
        t.pop()
        t.reverse()
    if s == t:
        switch = True
        break

if switch:
    print(1)
else:
    print(0)

import sys
input = sys.stdin.readline

s = list(input().strip())
t = list(input().strip())

def dfs(s,t):
    if len(t) == len(s):
        if t == s:
            return 1
        return 0

    # 경우의수 4가지 A_A B_A B_B A_B는 절대 안됨
    # 하나씩 줄여가면서 확인하기...
    if t[-1] == 'A' and dfs(s,t[:-1]) == 1:
        return 1
    if t[0] == 'B' and dfs(s,t[::-1][:-1]) == 1:
        return 1
    return 0
print(dfs(s,t))