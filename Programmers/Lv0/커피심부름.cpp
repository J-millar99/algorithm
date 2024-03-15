#include <string>
#include <vector>

using namespace std;

int solution(vector<string> orders) {
    int answer = 0;
    for (string order : orders) {
        if (order.find("americano") != string::npos || order.find("anything") != string::npos)
            answer += 4500;
        else
            answer += 5000;
    }
    return answer;
}