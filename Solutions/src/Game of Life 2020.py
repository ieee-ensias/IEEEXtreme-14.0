'''
 IEEEXtreme 14.0 solutions
 Authors: team seaholic - https://github.com/adnaneaabbar
 Verdict: 80.36 points (100%)
'''

dead_rule, live_rule = input().split(';')
n, m = input().split()
n = int(n)
m = int(m)
grid = []
for i in range(n):
    row = input()
    grid.append(list(row))
def check_neighbors(i, j, expected, n):
    l = 0
    if(grid[(i+1)  % n][j] == '1'):
        l+= 1
    if(grid[i][(j+1) % n] == '1'):
        l+= 1
    if(grid[i][(j-1) % n] == '1'):
        l+= 1
    if(grid[(i-1) % n][j] == '1'):
        l+= 1
    return expected == l
from copy import copy, deepcopy
for g in range(m):
    _grid = deepcopy(grid)
    for i in range(n):
        for j in range(n):
            if(grid[i][j] == '0'):
                for ith in range(5):
                    if(dead_rule[ith] == '1'):
                        if(check_neighbors(i, j, ith, n) == True):
                            _grid[i][j] = '1'
            else:
                _grid[i][j] = '0'
                for ith in range(5):
                    if(live_rule[ith] == '1'):
                        if(check_neighbors(i, j, ith, n) == True):
                            _grid[i][j] = '1'
    grid = deepcopy(_grid)
for row in _grid:
    for i in row:
        print(i, end='')
    print()
