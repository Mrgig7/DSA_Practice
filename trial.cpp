#include <iostream>
using namespace std;

void find_closest_elements(int arr[], int n, int target, int k) {
    // Initialize the variables
    int closestIndex = -1;
    int closestElements[k];

    // Find the index of the target or the nearest greater element
    int left = 0;
    int right = n - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            closestIndex = mid;
            break;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    // Update the closestElements array with the k closest elements to the target value
    int i = closestIndex;
    for (int j = n - 1; j >= 0 && k > 0; --j) {
        if (i >= 0 && j >= 0) {
            if (abs(arr[i] - target) <= abs(arr[j] - target)) {
                closestElements[--k] = arr[i--];
            } else {
                closestElements[--k] = arr[j];
            }
        } else if (i >= 0) {
            closestElements[--k] = arr[i--];
        } else {
            closestElements[--k] = arr[j];
        }
    }

    // Print the contents of the closestElements array
    for (int i = 0; i < k; ++i) {
        cout << closestElements[i] << " ";
    }
    cout << endl;
}

int main() {
    int n;
    cin >> n;

    int arr[n];
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    int target, k;
    cin >> target >> k;

    find_closest_elements(arr, n, target, k);

    return 0;
}
