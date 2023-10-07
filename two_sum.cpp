#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, sum;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    cin >> sum;
    sort(arr, arr + n);
    int i = 0, j = n - 1;
    while (i < j) {
        if (arr[i] + arr[j] == sum) {
            cout << arr[i] << " " << arr[j] << endl;
            i++;
            j--;
        } else if (arr[i] + arr[j] < sum) {
            i++;
        } else {
            j--;
        }
    }
    return 0;
}
