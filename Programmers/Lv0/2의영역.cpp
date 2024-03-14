#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> result;
    if (find(arr.begin(), arr.end(), 2) == arr.end()) {
        result.push_back(-1);
    }
    else if (count(arr.begin(), arr.end(), 2) == 1) {
        result.push_back(2);
    }
    else {
        vector<int>::iterator front_it = find(arr.begin(), arr.end(), 2);
        vector<int>::iterator back_it = find(arr.rbegin(), arr.rend(), 2).base();
        result.assign(front_it, back_it);
    }
    return result;
}