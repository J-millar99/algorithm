#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    string num1 = to_string(a) + to_string(b);
    int num2 = a * b * 2;
    return stoi(num1) >= num2 ? stoi(num1) : num2;
}