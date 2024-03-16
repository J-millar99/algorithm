#include <string>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

int solution(vector<int> sides) {
    set<int> _set;
    auto _max = max_element(sides.begin(), sides.end());
    auto _min = min_element(sides.begin(), sides.end());
    for (int i = *_max - *_min + 1; i < *_max + 1; i++)
        _set.insert(i);
    for (int j = *_max + 1; j < *_max + *_min; j++)
        _set.insert(j);
    return _set.size();
}