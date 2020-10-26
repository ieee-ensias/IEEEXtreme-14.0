/*
 IEEEXtreme 14.0 solutions
 Authors: team The MenTaLisTs - https://github.com/choubari - https://github.com/TheMenTaLisT7
 Verdict: 55.37 points (80.56%)
*/
#include <bits/stdc++.h> 

using namespace std;

int main() {
    int C, N, P, W;
    cin >> C >> N >> P >> W;
    
    if (C > W)
        cout << 0;
    else if (C == W)
        cout << 1;
    else
    {
        int T = 0;
        int a = W;
        vector<int> pockets;
        while (a >= P)
        {
            a-= P;
            pockets.push_back(P);
            if (a < P)
            {
                pockets.push_back(a);
                break;
            }
        }
        
        for (int i = pockets.size() - 1; i >= 0; i--)
        {
            if (pockets[i] == C)
            {
                T++;
                break;
            }
            else if (pockets[i] > C)
            {
                break;
            }
            else
            {
                if (i == 0)
                    break;
                if (pockets[i-1] >= C - pockets[i])
                {
                    pockets[i-1] -= C - pockets[i];
                    T++;
                }
                else
                    break;
            }
        }
        
        cout << T;

    } 
    return 0;
}