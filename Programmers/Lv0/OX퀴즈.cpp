#include <string>
#include <vector>
#include <sstream>
using namespace std;

vector<string> solution(vector<string> quizs) {
    vector<string> answer;
    for (string quiz : quizs) {
        istringstream iss(quiz);
        string num1, num2, op, equl, ret;

        iss >> num1 >> op >> num2 >> equl >> ret;
        int n1 = stoi(num1), n2 = stoi(num2);
        if (op == "+") n1 += n2;
        else if (op == "-") n1 -= n2;
        n1 == stoi(ret) ? answer.push_back("O") : answer.push_back("X");
    }
    return answer;
}