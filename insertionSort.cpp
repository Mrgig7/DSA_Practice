#include <iostream>
using namespace std;

void insertionSort (int arr[],int n){
    for (int i=1;i<n;i++){
        int current = arr[i];
        int j = i-1;
        while (arr[j]>current && j>=0){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = current;
    }
}

void insertionSort(int arr[], int n)
{
    int i,key,j;
    for (i=1;i<n;i++)
    {
        key = arr[i];
        j = i-1;
        while (j>=0 && arr[j]>key)
        {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;
    }
 }

int main(){
    int arr[] = {5,4,3,2,1};
    insertionSort(arr,5);
    for (int i=0;i<5;i++){
        cout<<arr[i]<<" ";
    }
    return 0;
}