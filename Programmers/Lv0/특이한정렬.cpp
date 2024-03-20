#include <string>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

// 내 풀이

int CountMinValue(map<int, int> _map, int minValue)
{
    auto it = _map.begin();
    int cnt = 0;
    for (; it != _map.end(); ++it)
        if (it->second == minValue)
            ++cnt;
    return cnt;
}

int GetMinValue(map<int, int> _map)
{
    auto it = _map.begin();
    int minValue = it->second;
    for (; it != _map.end(); ++it)
        if (it->second < minValue)
            minValue = it->second;
    return minValue;
}

vector<int> solution(vector<int> numlist, int n) {
    map<int, int> _map;
    vector<int> answer;
    for (int num : numlist)
        _map[num] = abs(num - n);
    while (_map.size()) {
        int minValue = GetMinValue(_map);
        int maxKey = -10000;
        for (auto it = _map.begin(); it != _map.end(); ++it)
            if (it->second == minValue && it->first > maxKey)
                maxKey = it->first;
        answer.push_back(maxKey);
        _map.erase(maxKey);
    }
    return answer;
}

// 추가할 것
#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int num;

bool compare(int prev, int next) {
    if (abs(prev - num) == abs(next - num)) 
        return prev > next;
    return abs(prev - num) < abs(next - num);
}

vector<int> solution(vector<int> numlist, int n) {
    num = n;
    sort(numlist.begin(), numlist.end(), compare);
    return numlist;
}