#include <string>
#include <vector>
#include <cstring>
using namespace std;


// c스타일
int solution(string my_string, string target) {
    if (strstr(my_string.c_str(), target.c_str()))
        return 1;
    return 0;
}

// c++스타일
int solution(string my_string, string target) {
    size_t found = my_string.find(target);

    if (found != string::npos)
        return 1;
    return 0;
}
