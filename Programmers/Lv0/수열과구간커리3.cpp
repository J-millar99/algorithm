#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    for (vector<int> querie : queries)
        swap(arr[querie[0]], arr[querie[1]]);
    return arr;
}