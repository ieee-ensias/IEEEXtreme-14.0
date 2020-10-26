'''
 IEEEXtreme 14.0 solutions
 Authors: team seaholic - https://github.com/adnaneaabbar
 Verdict: 36.88 points (38%)
'''

t = int(input())
from math import *
def closest_power(c):
    a = int(log2(c))
    if(abs(c-(1<<a)) > abs(c-(1<<(a+1)))):
        return a+1
    else:
        return a
while(t > 0):
    t -= 1
    c = int(input())
    ans = ['END']
    count = 0
    m = c
    while (m): 
        if (m % 2 == 1): 
            print("ADD R1, R1, R0, LSL #"+str(count))
        count += 1
        m = int(m/2)
    print("MOV R0, R1, LSL #0")
    print("END")
    
    
