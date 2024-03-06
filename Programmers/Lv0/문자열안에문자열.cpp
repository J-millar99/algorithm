#include <string>
#include <vector>
#include <cstring>
using namespace std;

//  c스타일
int solution(string str1, string str2) {
    if (strstr(str1.c_str(), str2.c_str()))
        return 1;
    return 2;
}
//  c++스타일
int solution(string str1, string str2) {    

    return (str1.find(str2) == string::npos)?2:1;
}