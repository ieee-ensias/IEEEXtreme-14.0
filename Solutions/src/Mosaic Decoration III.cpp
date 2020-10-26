/*
 IEEEXtreme 14.0 solutions
 Authors: team seaholic - https://github.com/adnaneaabbar
 Verdict: 36.77 points (40%)
*/

#include <bits/stdc++.h>

using namespace std;

int main() {
    int n, m, r, c;
    cin >> n >> m >> r >> c;
    int colors[r][c];
    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            cin >> colors[i][j];
        }
    }
    int cost = 0;
    if(n%r == 0){
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    cost += n/r * m/c * colors[i][j];
                }
            }
            int a = m%c;
            for(int i=0; i<r; i++){
                for(int j=0; j<a; j++){
                    cost += n/r * colors[i][j];
                }
            }
        
    } else {
        if(m%c != 0){
            int a = n%r;
            int b = m%c;
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    cost += n/r *  m/c * colors[i][j];
                }
            }
            for(int i=0; i<a; i++){
                for(int j=0; j<c; j++){
                    cost += m/c * colors[i][j];
                }
            }
            for(int i=0; i<r; i++){
                for(int j=0; j<b; j++){
                    cost += n/r * colors[i][j];
                }
            }
        } else {
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    cost += n/r * m/c * colors[i][j];
                }
            }
            int a = n%r;
            for(int i=0; i<a; i++){
                for(int j=0; j<c; j++){
                    cost += m/c * colors[i][j];
                }
            }
        }
    }
    cout << cost << endl;
    return 0;
}
