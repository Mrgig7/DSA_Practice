#include <iostream>
using namespace std;

void bubbleSort (int arr[],int n){
    for (int i=0;i<n-1;i++){
        for (int j=0;j<n-i-1;j++){
            if (arr[j]>arr[j+1]){
                swap(arr[j],arr[j+1]);
            }
        }
    }
}



// optimised approch

// void bubbleSort(int arr[], int n)
// {
//     int i,j;
//     bool swap;
//     for (i=0;i<n-1;i++)
//     {
//         swap = false;
//         for (j=0;j<n-i-1;j++)
//         {
//             if (arr[j]>arr[j+1])
//             {
//                 swap(arr[j],arr[j+1]);
//                 swap = true;
//             }
//         }
//         if (swap == false)
//         {
//             break;
//         }
//     }
//     }


int main(){
    int arr[] = {2,4,6,3,5};
    bubbleSort(arr,5);
    for (int i=0;i<5;i++){
        cout<<arr[i]<<" ";
    }
    return 0;
}