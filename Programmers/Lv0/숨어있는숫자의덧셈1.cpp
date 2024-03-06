#include <string>
#include <vector>

using namespace std;

int solution(string my_string) {
    int sum = 0;
    for (char ch : my_string)
        if (isdigit(ch))
            sum += ch - '0';
    return sum;
}