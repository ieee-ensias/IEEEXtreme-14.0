'''
 IEEEXtreme 14.0 solutions
 Authors: team seaholic - https://github.com/adnaneaabbar
 Verdict: 20.78 points (25%)
'''

n, t = map(int, input().split())
l = list(map(int, input().split()))
x = 0
for i in l:
    x += 1 << (t-1-i)
xstr = format(x, "0"+str(t)+"b")

def findRotations(str): 
    tmp = str + str
    n = len(str) 
    for i in range(1, n + 1): 
        substring = tmp[i: i+n] 
        if (str == substring): 
            return i 
    return n

print(findRotations(xstr)-1)
