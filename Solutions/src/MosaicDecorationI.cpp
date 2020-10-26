/*
 IEEEXtreme 14.0 solutions
 Authors: team TLE - https://github.com/mhamedouadghiri - https://github.com/aaiit
*/
 
#include <bits/stdc++.h>
using namespace std;

int main(int argc, char const *argv[])
{
	ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n,cb,cp;
    cin>>n>>cb>>cp;
    int sp=0,sb=0,p,b;
    while(n--)
    {
    	cin>>b>>p;
    	sp+=p;
    	sb+=b;
    }
    int r=((sp+9)/10)*cp+((sb+9)/10)*cb;
    cout<<r;
	return 0;
}
