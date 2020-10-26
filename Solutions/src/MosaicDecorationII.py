# IEEEXtreme 14.0 solutions
# Authors: The MenTaLisTs - https://github.com/choubari - https://github.com/TheMenTaLisT7
# Verdict: 65.3 points (100%)

import math
L = list(map(int, input().rstrip().split())) 
W=L[0]
H=L[1]
A=L[2]
B=L[3]
M=L[4]
C=L[5]
rowtiles=math.ceil(W/A)
coltiles=math.ceil(H/B)
ntiles = rowtiles*coltiles
rowplus=rowtiles*A-W
colplus=coltiles*B-H
cuttinginch=0
if (rowplus!=0):
    cuttinginch+=H

if (colplus!=0):
    cuttinginch+=W    
    
price = math.ceil(ntiles/10)*M+cuttinginch*C  
print(price) 