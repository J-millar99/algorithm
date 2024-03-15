#include <string>
#include <vector>
#include <sstream>
using namespace std;

int solution(string s) {
    int answer = 0, temp = 0;
    istringstream iss(s);
    string numStr;
    while (iss >> numStr)
        if (numStr == "Z")
            answer -= temp;
        else {
            temp = stoi(numStr);
            answer += temp;
        }
    return answer;
}