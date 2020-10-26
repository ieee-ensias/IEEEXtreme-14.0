/*
 IEEEXtreme 14.0 solutions
 Authors: team seaholic - https://github.com/adnaneaabbar
 Verdict: 43.9 points (50%)
*/

#include <cstdlib>
#include<iostream>
#include<string.h>
#include<stdio.h>
using namespace std;
int main(int argc, char** argv) {
    int N;
    cin >> N;
    string codes[N];  
    int count;
    int ans = 0;
    for(int i=0; i<N; i++){
        cin >> codes[i];
    }
    for(int i=0; i<N-1; i++){
        for(int k=i+1; k<N; k++){
            count = 0;
            for(int j=0; j<codes[i].length(); j++){
                if(codes[i][j] != codes[k][j]){
                    count++;
                }
            }
            if(count == 1) ans++;
        }
    }
    cout<<ans;
    return 0;
}
