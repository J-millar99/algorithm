#include <string>
#include <vector>
using namespace std;

vector<int> solution(vector<int> arr) {
    int i = 0;
    vector<int> stk;
    while (i < arr.size()) {
        if (!stk.size())
            stk.push_back(arr[i++]);
        else if (stk.back() < arr[i])
            stk.push_back(arr[i++]);
        else if (stk.back() >= arr[i])
            stk.pop_back();
    }
    return stk;
}