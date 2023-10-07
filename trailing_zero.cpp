// #include <iostream>
// using namespace std;

// int main(){
//    int fact = 1;
//    int n;
//    cin>>n;
//    for (int i=1;i<=n;i++){
//     fact=fact*i;
//    }
//     int count = 0;
//     while (fact % 10 == 0){
//         count++;
//         fact = fact / 10;
//     }
//     cout << count;
//     return 0;
// }

// without number overflow

#include<bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;
    int no_of_zero = 0, q=0;

    while(n!=0)
    {
        q = n/5;
        no_of_zero += q;
        n = q;
    }

cout<<no_of_zero<<endl;

    return 0;
}