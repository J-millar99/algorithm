#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<string> spell, vector<string> dic) {
    string temp;
    for (string ch : spell)
        temp += ch;
    sort(temp.begin(), temp.end());
    for (string str : dic) {
        sort(str.begin(), str.end());
        if (str == temp)
            return 1;
    }
    return 2;
}