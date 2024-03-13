#include <string>
#include <vector>
#include <map>
using namespace std;

string solution(string s) {
    string answer = "";
    map <char, int> _map;
    for (char ch : s)
        _map[ch] += 1;
    for (auto data : _map)
        if (data.second == 1)
            answer += data.first;
    return answer;
}