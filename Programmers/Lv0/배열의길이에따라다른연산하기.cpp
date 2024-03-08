#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, int n) {
    if (arr.size() % 2 == 0)
        for (size_t idx = 1; idx < arr.size(); idx += 2)
            arr[idx] += n;
    else
        for (size_t idx = 0; idx < arr.size(); idx += 2)
            arr[idx] += n;
    return arr;
}