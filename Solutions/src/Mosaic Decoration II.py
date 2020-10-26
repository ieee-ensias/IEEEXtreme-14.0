'''
 IEEEXtreme 14.0 solutions
 Authors: team seaholic - https://github.com/adnaneaabbar
 Verdict: 65.29 points (100%)
'''

w,h,a,b,m,c = list(map(int,input().split()))
from math import *
n_full_mosaic = ceil(w/a)*ceil(h/b);
n_piles = ceil(n_full_mosaic/10.0);
ans = n_piles*m;

if w != a*ceil(w/a):
    ans += h*c;
 
if h != b*ceil(h/b):
    ans += w*c;
 
print(ans)
