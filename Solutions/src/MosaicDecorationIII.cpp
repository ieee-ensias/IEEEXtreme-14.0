/*
 IEEEXtreme 14.0 solutions
 Authors: team TLE - https://github.com/mhamedouadghiri - https://github.com/aaiit
 Verdict: 61.28 points (66.67%)
 */
#include <bits/stdc++.h>
#define min(a,b) (a<b)?a:b
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int w, h, a, b;
    cin >> w >> h >> a >> b ;

    int t[a][b];
    long long r = 0;
    for(int i = 0; i < a; i++)
        for(int j = 0; j < b; j++)
        {
            cin >> t[i][j];
            r += t[i][j];
        }

    int x = (w  / a), y = (h  / b) ;
    int ra = w - x * a, rb = h - y * b;
    long long r1 = 0, r2 = 0, r3 = 0, r4 = 0;
    long long sum;


    sum = 0;
    for(int i = 0; i < ra; i++)
        for(int j = 0; j < b; j++)
            sum += t[i][j];
    r1 = sum * w;

    sum = 0;
    for(int i = 0; i < a; i++)
        for(int j = 0; j < rb; j++)
            sum += t[i][j];
    r1 += sum * h;

    sum = 0;
    for(int i = 0; i < ra; i++)
        for(int j = 0; j < rb; j++)
            sum += t[i][j];
    r1 -= sum;



    sum = 0;
    for(int i = a - ra; i < a; i++)
        for(int j = 0; j < b; j++)
            sum += t[i][j];
    r2 = sum * w;

    sum = 0;
    for(int i = 0; i < a; i++)
        for(int j = b - rb; j < rb; j++)
            sum += t[i][j];
    r2 += sum * h;

    sum = 0;
    for(int i = a - ra; i < a; i++)
        for(int j = b - rb; j < b; j++)
            sum += t[i][j];
    r2 -= sum;


    sum = 0;
    for(int i = a - ra; i < a; i++)
        for(int j = 0; j < b; j++)
            sum += t[i][j];
    r3 = sum * w;

    sum = 0;
    for(int i = 0; i < a; i++)
        for(int j = 0; j < b; j++)
            sum += t[i][j];
    r3 += sum * h;

    sum = 0;
    for(int i = a - ra; i < a; i++)
        for(int j = 0; j < b; j++)
            sum += t[i][j];
    r3 -= sum;


    sum = 0;
    for(int i = 0; i < a; i++)
        for(int j = b - rb; j < b; j++)
            sum += t[i][j];
    r4 = sum * w;

    sum = 0;
    for(int i = 0; i < a; i++)
        for(int j = 0; j < b; j++)
            sum += t[i][j];
    r4 += sum * h;

    sum = 0;
    for(int i = 0; i < a; i++)
        for(int j = b - rb; j < b; j++)
            sum += t[i][j];
    r4 -= sum;

    cout << r *x *y + min(r1, min(r2, min(r3, r4)));
    return 0;
}
