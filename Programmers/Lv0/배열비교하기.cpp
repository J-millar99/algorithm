#include <string>
#include <vector>

using namespace std;

int sumVector(const vector<int> &vec) {
    int sum = 0;
    for (const int& element : vec) {
        sum += element;
    }
    return sum;
}

int solution(vector<int> arr1, vector<int> arr2) {
    if (arr1.size() > arr2.size())
        return 1;
    else if (arr1.size() < arr2.size())
        return -1;
    if (sumVector(arr1) > sumVector(arr2))
        return 1;
    else if (sumVector(arr1) < sumVector(arr2))
        return -1;
    return 0;
}