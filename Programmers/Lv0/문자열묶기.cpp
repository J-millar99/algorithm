#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<string> strArr) {
    vector<int> data(31, 0);
    for (size_t idx = 0; idx < 31; idx++)
        data[idx] = 0;
    for (string str : strArr)
        data[str.length()] += 1;
    auto max_it = max_element(data.begin(), data.end());
    return *max_it;
}