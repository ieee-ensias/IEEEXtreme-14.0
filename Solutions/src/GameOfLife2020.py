# IEEEXtreme 14.0 solutions
# Authors: The MenTaLisTs - https://github.com/choubari - https://github.com/TheMenTaLisT7
# Verdict: 80.37 points (100%)

rules = input().split(";")
rule1, rule2 = rules[0] , rules[1]
n,m = map(int, input().split())
def neighbor(M,i,j):
    return int(M[(i+1)%n][j]) + int(M[(i-1)%n][j]) + int(M[i][(j-1)%n])+int( M[i][(j+1)%n])

R1 = []
R2 = []
for i in range(len(rule1)):
    if rule1[i] =='1':
        R1.append(i)
    if rule2[i] == '1':
        R2.append(i)
def rul1(M,i,j):
    count = neighbor(M,i,j)
    if count in R1:
        return '1' 
    else :
        return '0'
def rul2(M,i,j):
    count = neighbor(M,i,j)
    if count in R2:
        return '1' 
    else :
        return '0'

    
M = []
for i in range(n):
    M.append(list(input()))

    

def reset(M):
    N = []
    for i in range(len(M)):
        N.append(list(M[i]))
    return N

        

N = reset(M)
for _ in range(m):
    for i in range(n):
        for j in range(n):
            if N[i][j] =='1':
                M[i][j] = rul2(N,i,j)
            else:
                M[i][j] = rul1(N,i,j)
    N=reset(M)

for i in range(n):
    for j in range(n):
        print(M[i][j],end='')
    print()