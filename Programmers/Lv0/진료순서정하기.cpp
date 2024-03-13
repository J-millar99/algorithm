#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> emergency) {
    vector<int> answer;
    map<int, int> my_map;
    vector<int> sort_emergency = emergency;
    sort(sort_emergency.begin(), sort_emergency.end());
    for (int i = 0; i < sort_emergency.size(); i++)
        my_map[sort_emergency[i]] = emergency.size() - i;
    for (int i : emergency)
        answer.push_back(my_map[i]);
    return answer;
}