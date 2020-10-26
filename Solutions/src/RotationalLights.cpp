 /*
 IEEEXtreme 14.0 solutions
 Authors: team TLE - https://github.com/mhamedouadghiri - https://github.com/aaiit
 Verdict: 62.33 points (75%)
*/
#include <bits/stdc++.h>
using namespace std;
void updatex(vector<long> &x, long step, long T)
{
    for (auto &t : x)
        t = (t + step) % T;
    unsigned long i = x.size() - 1;
    while (x[i] < x[i - 1])
        i--;
    if (i == x.size() - 1)
        return;
    vector<long> tmp(x.begin() + i + 1, x.end());
    x.insert(x.begin(), tmp.begin(), tmp.end());
    x.erase(x.begin() + i + 1 + tmp.size(), x.end());
}
void updated(vector<long> &x, vector<long> &table, long t, long n)
{
    table[0] = t + x[0] - x[n - 1];
    for(int i = 1; i < n; i++)table[i] = x[i] - x[i - 1];
}
int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    long n, t;
    cin >> n >> t;
    vector<long> x(n);
    vector<long> xx;
    for (auto &tmp : x)
    {
        cin >> tmp;
        xx.push_back(tmp);
    }
    vector<long> table(n);
    updated(x, table, t, n);
    long offset = 0;
    updatex(x, table[offset], t);
    long sum = table[offset];
    offset = n - 1;
    while (xx != x)
    {
        sum += table[offset];
        updatex(x, table[offset], t);
        offset--;
        offset %= n;
    }
    cout << --sum << endl;
    return 0;
}
