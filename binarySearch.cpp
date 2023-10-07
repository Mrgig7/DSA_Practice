 #include <iostream>
 using namespace std;

    int binarySearch(int arr[], int n, int key){
        int start = 0;
        int end = n;
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid] > key){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }


    int binarySearch(int a[], int first, int last, int search_num){
        int middle;
        if(last>=first){
            middle = (first+last)/2;
            if(a[middle] == search_num){
                return middle;
            }
            else if(a[middle] > search_num){
                return binarySearch(a, first, middle-1, search_num);
            }
            else{
                return binarySearch(a, middle+1, last, search_num);
            }
            return -1;
        }
    }