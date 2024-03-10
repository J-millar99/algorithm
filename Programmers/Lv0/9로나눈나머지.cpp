#include <string>
#include <vector>

using namespace std;

int solution(string number) {
    int num = 0;
    for (char ch : number)
        num += ch - '0';
    return num % 9;
}