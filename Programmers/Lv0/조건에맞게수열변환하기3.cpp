#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, int k) {
    for (int &num : arr)
        k % 2 == 0 ? num += k : num *= k;
    return arr;
}