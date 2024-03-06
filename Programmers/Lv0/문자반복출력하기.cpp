#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string my_string, int n) {
    string answer;
    for (char ch : my_string)
        for (size_t i = 0; i < n; i++)
            answer += ch;
    return answer;
}