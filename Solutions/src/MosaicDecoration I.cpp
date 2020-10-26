/*
 IEEEXtreme 14.0 solutions
 Authors: team The MenTaLisTs - https://github.com/choubari - https://github.com/TheMenTaLisT7
 Verdict: 43.32 points (100%)
*/

#include <iostream>

using namespace std;

int main() {
    int N, CB, CP;
    cin >> N >> CB >> CP;
    
    int b, p;
    
    int black(0), pink(0);
    
    int priceB(0), priceP(0);
    
    for (int i = 0; i < N; i++)
    {
        cin >> b >> p;
        black += b;
        pink += p;
    }
    
    while (black > 0)
    {
        black -= 10;
        priceB += CB;
    }
    
    while (pink > 0)
    {
        pink -= 10;
        priceP += CP;
    }
        
    cout << priceB + priceP;
    return 0;
}