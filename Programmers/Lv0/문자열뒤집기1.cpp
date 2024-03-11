#include <string>
#include <vector>
#include <algorithm>
using namespace std;

string solution(string my_string) {
    reverse(my_string.begin(), my_string.end());
    return my_string;
}

// c++에서 reverse함수를 사용하여 반복자를 통해 문자열을 뒤집을 수 있다.