# IEEEXtreme 14.0 solutions
# Authors: The MenTaLisTs - https://github.com/choubari - https://github.com/TheMenTaLisT7
# Verdict: 57.75 points (100%)

n=int(input())
for i in range (n):
    T = list(map(int, input().rstrip().split()))
    J=[]
    sum=0
    for j in range (T[0]):
        m=int(input())
        sum+=m
        J.append(m)

    J.sort()
    for k in range (T[2]):
        sum+=T[1]-2*J[k]
    print (sum)  