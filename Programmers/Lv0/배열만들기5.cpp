#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> intStrs, int k, int s, int l) {
    vector<int> answer;
    for (int i = 0; i < intStrs.size(); i++) {
        int num = 0;
        for (int j = s; j < s + l; j++) {
            num *= 10;
            num += intStrs[i][j] - '0';
        }
        if (num > k)
            answer.push_back(num);
    }
    return answer;
}