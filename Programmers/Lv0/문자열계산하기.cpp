#include <string>
#include <vector>
#include <sstream>
using namespace std;

int solution(string my_string) {
    istringstream iss(my_string);
    string token;
    int sum = 0;

    iss >> token;
    sum = stoi(token); //첫 번째 숫자 저장
    while (iss >> token)
    {
        if (token[0] == '+') {
            iss >> token;
            sum += stoi(token);
        }
        else if (token[0] == '-') {
            iss >> token;
            sum -= stoi(token);
        }
    }
    return sum;
}