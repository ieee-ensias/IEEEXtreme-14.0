# IEEEXtreme 14.0 solutions
# Authors: The MenTaLisTs - https://github.com/choubari - https://github.com/TheMenTaLisT7
# Verdict: 50.06 points (60%)

def Sorting(lst): 
    lst2 = sorted(lst, key=len) 
    return lst2 

def find_all(a_str, sub):
    start = 0
    while True:
        start = a_str.find(sub, start)
        if start == -1: return
        yield start
        start += len(sub) 
            
def nonoverlapping(s,s1,s2):
    p=s.find(s1)    
    for i in (list(find_all(s, s2))):
        if (i<p and (len(s2)+i-1)<p)or(p<i and i>(len(s1)+p-1)):
            return True
    return False        
    

      
# Function to print all distinct palindrome sub-strings of s 
def palindromeSubStrs(s): 
    TT=[]  
    m = dict() 
    n = len(s) 
    # table for storing results (2 rows for odd- 
    # and even-length palindromes 
    R = [[0 for x in range(n+1)] for x in range(2)] 
  
    # Find all sub-string palindromes from the given input 
    # string insert 'guards' to iterate easily over s 
    s = "@" + s + "#"
  
    for j in range(2): 
        rp = 0    # length of 'palindrome radius' 
        R[j][0] = 0
  
        i = 1
        while i <= n: 
            while s[i - rp - 1] == s[i + j + rp]: 
                rp += 1 
            R[j][i] = rp 
            k = 1
            while (R[j][i - k] != rp - k) and (k < rp): 
                R[j][i+k] = min(R[j][i-k], rp - k) 
                k += 1
            rp = max(rp - k, 0) 
            i += k 
  
    # remove guards 
    s = s[1:len(s)-1] 
  
    m[s[0]] = 1
    for i in range(1,n): 
        for j in range(2): 
            for rp in range(R[j][i],0,-1): 
                m[s[i - rp - 1 : i - rp - 1 + 2 * rp + j]] = 1
        m[s[i]] = 1
    for i in m: 
        TT.append(i)
        
    return Sorting(TT)
   
def printing(string):
    Length=[] 
    Pal= palindromeSubStrs(string) 
    #print("palynd", Pal)
    for i in range (len(Pal)-1,0,-1):
        br=0
        if (Pal[i]==string):
            pass
        for j in range (i-1,-1,-1):
            if br==1:
                break
            if nonoverlapping(string,Pal[i], Pal[j]) :
                #print((Pal[i]),(Pal[j]))
                
                Length.append(len(Pal[i])+len(Pal[j]))
                br=1
                break
    return Length            
    
     
# Driver program 
n=int(input())
for test in range (n):
    string = input()
    listt=printing(string)
    print(max(listt))
    
    