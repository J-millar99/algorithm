#include <string>
#include <vector>
#include <algorithm>
#include <numeric>
using namespace std;

int solution(vector<int> sides) {
    auto max_value = max_element(sides.begin(), sides.end());
    return *max_value * 2 < accumulate(sides.begin(), sides.end(), 0) ? 1 : 2;
}