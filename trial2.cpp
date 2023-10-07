#include<iostream>
using namespace std;
int main(){
    int n,t;
    cin>>n;
    string a[n];
    
    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    
    int m;
    cin>>m;
    string b[m];
    
    for(int i=0;i<m;i++){
        cin>>b[i];
    }
    t=n*m;
    string c[t];
    
    int k=0;
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            c[k]=a[i]+b[j];
            k++;
        }
    }
    
    for(int s=0;s<t;s++){
        cout<<c[s]<<" ";
    }
    
}