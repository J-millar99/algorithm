#include <string>
#include <vector>
#include <map>
using namespace std;

map <int, string> m = { {1, "w"}, {-1, "s"}, {10, "d"}, {-10, "a"} };

int funcOp(int n1, int n2)
{
    return n1 - n2;
}

string solution(vector<int> numLog) {
    string answer = "";
    for (size_t idx = 0; idx < numLog.size() - 1; idx++)
    {
        if (funcOp(numLog[idx], numLog[idx + 1]) == -1)
            answer += "w";
        else if (funcOp(numLog[idx], numLog[idx + 1]) == 1)
            answer += "s";
        else if (funcOp(numLog[idx], numLog[idx + 1]) == -10)
            answer += "d";
        else if (funcOp(numLog[idx], numLog[idx + 1]) == +10)
            answer += "a";                        
    }
    return answer;
}

// 딕셔너리를 이용한 방식
string solution(vector<int> numLog) {
    string answer = "";
    for (int i = 1; i < numLog.size(); i++)
        answer += m[numLog[i] - numLog[i - 1]];
    return answer;
}