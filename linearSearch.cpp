#include <iostream>
using namespace std;

int main(){
    int arr[] = {1, 2, 3, 4, 5};
    int n = sizeof(arr)/sizeof(arr[0]);

    int key = 3;
    int i;
    for(i = 0; i < n; i++){
        if(arr[i] == key){
            cout << "Found at index: " << i << endl;
            break;
        }
    }
    if(i == n){
        cout << "Not found" << endl;
    }
    return 0;
}