'''
 IEEEXtreme 14.0 solutions
 Authors: team seaholic - https://github.com/adnaneaabbar
 Verdict: 22.08 points (24%)
'''

N = int(input())
S = list(map(int,input().split()))
D = int(input())
ans = 0
for i in range(D):
    l = list(map(int,input().split()))
    ans += l[2]
print(ans)
