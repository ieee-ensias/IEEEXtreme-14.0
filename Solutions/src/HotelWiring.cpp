/*
 IEEEXtreme 14.0 solutions
 Authors: team TLE - https://github.com/mhamedouadghiri - https://github.com/aaiit
 Verdict: 57.75 points (100%)
*/

#include <bits/stdc++.h>
using namespace std;

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int q;
    cin >> q;
    while(q--)
    {
        int m, n, k;
        cin >> m >> n >> k;
        vector<int> f(m);
        for(int i = 0; i < m; i++)cin >> f[i];
        sort(f.begin(), f.end());
        long sum = 0;
        for(int i = 0; i < m; i++)
        {
            if(i < k)
            {
                sum += n - f[i];
            }
            else
            {
                sum += f[i];
            }
        }
        cout << sum << "\n";
    }
    return 0;
}
