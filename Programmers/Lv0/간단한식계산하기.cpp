#include <string>
#include <vector>
#include <sstream>
using namespace std;
int solution(string binomial) {
    int num1, num2;
    char op;
    istringstream iss(binomial);
    iss >> num1;
    iss >> op;
    iss >> num2;

    if (op == '+')
        return num1 + num2;
    else if (op == '-')
        return (num1 + num2 * -1);
    else if (op == '*')
        return (num1 * num2);
}