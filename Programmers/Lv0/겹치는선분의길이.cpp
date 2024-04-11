#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

int solution(vector<vector<int>> lines) {
    vector<vector<int>> alline;
    int answer = 0;

    for (vector<int> line : lines)
    {
        for (int i = 0; i < line[1] - line[0]; i++) {
            vector<int> tmp;
            tmp.push_back(line[0] + i);
            tmp.push_back(line[0] + i + 1);
            alline.push_back(tmp);
        }
    }
    sort(alline.begin(), alline.end());
    map<vector<int>, int> _map;
    for (auto line : alline)
        _map[line]++;
    for (auto pair : _map)
        if (pair.second != 1)
            answer++;
    return answer;
}