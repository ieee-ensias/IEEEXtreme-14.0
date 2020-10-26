'''
 IEEEXtreme 14.0 solutions
 Authors: team seaholic - https://github.com/adnaneaabbar
 Verdict: 68.73 points (100%)
'''

c, n, p, w = list(map(int, input().split()))
if(w < c):
    print(0)
else:
    i = w//c;
    while(True):
        if(w - i*c <= p*(n-i)):
            break
        i-=1

    if(w//c <= n - 1/p and w - (w/c)*c > p*(n-w/c)):
        print(w//c)
    else:
        print(i)
