'''
 IEEEXtreme 14.0 solutions
 Authors: team seaholic - https://github.com/adnaneaabbar
 Verdict: 57.75 points (100%)
'''
for _ in range(int(input())):
    M = []
    l = list(map(int,input().split()))
    for _ in range(l[0]):
        M.append(int(input()))
    M.sort()
    for k in range(l[2]):

        M[k] = l[1] - M[k]

    print(sum(M))
