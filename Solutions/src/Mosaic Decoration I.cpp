/*
 IEEEXtreme 14.0 solutions
 Authors: team seaholic - https://github.com/adnaneaabbar
 Verdict: 43.31 points (100%)
*/

#include <bits/stdc++.h>

using namespace std;

int main() {
    int n, cb, cp;
    cin >> n >> cb >> cp;
    int sb = 0, sp = 0;
    int cost = 0;
    while(n--){
        int b, p;
        cin >> b >> p;
        sb += b; sp += p;
    }
    if(sb % 10 == 0) cost += sb/10 * cb;
    else if(sb % 10 != 0) cost += (sb/10 + 1) * cb;
    if(sp % 10 == 0) cost += sp/10 * cp;
    else if(sp % 10 != 0) cost += (sp/10 + 1) * cp;
    cout << cost << endl;
}
