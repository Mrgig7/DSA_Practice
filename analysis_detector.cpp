// You are using GCC
#include <iostream>
using namespace std;

int main(){
    int a;
    cin>>a;
    
    double b[100];
    for (int i = 0; i<a;i++){
        cin>>b[i];
    }
    
    int c=0;
    for (int i = 0; i<a;++i){
        if(b[i]>=0){
            c++;
        }
    }
    
    double d[c];
    int j = 0;
    for (int i = 0; i<a;++i){
        if(b[i]>=0){
            d[j] = b[i];
            j++;
        }
    }
    
    cout<<"Updated Array With Positive Closing Prices: ";
    for (int i = 0; i<c; ++i){
        cout<<d[i]<<" ";
    }
    cout << endl;
    
    return 0;
}