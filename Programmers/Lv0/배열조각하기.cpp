#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> arr, vector<int> query) {
    for (int i = 0; i < query.size(); i++) {
        if (i % 2 == 0)
            arr.resize(query[i] + 1);
        else if (i % 2 == 1)
            arr.erase(arr.begin(), arr.begin() + query[i]);
    }
    return arr;
}