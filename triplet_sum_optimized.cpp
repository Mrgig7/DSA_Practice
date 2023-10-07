#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;

    int a[n];

    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    int sum;
    cin>>sum; 


    sort(a,a+n);
    int flag=0;

    for(int i=0;i<n-2 && flag==0;i++)
    {
        int l=i+1;
        int h=n-1;

        while(l<h)
        {
            if(a[i]+a[l]+a[h]<sum){
                l--;
            }else if(a[i]+a[l]+a[h]>sum){
                h--;
            }else{
                cout<<a[i]<<" "<<a[l]<<" "<<a[h]<<endl;
                flag=1;
                break;
            }
        }
    }

    if(flag == 0){
        cout<<"No triplet found"<<endl;
    }
    return 0;
}

