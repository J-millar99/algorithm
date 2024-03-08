#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(string my_string, string is_suffix) {
    size_t suffix_position = my_string.rfind(is_suffix);
    
    if (suffix_position != string::npos && suffix_position == my_string.length() - is_suffix.length()) {
        return 1;
    } else {
        return 0;
    }
}
