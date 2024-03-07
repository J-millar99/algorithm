#include <string>
#include <vector>
#include <cstring>
using namespace std;

// c스타일
int solution(string str1, string str2) {
    return strstr(str2.c_str(), str1.c_str()) ? 1 : 0;
}

// c++스타일
int solution(string str1, string str2) {
    size_t found = str2.find(str1);
    return found != string::npos ? 1 : 0;
}