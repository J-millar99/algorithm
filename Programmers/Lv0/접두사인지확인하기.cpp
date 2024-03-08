#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(string my_string, string is_suffix) {
    size_t suffix_position = my_string.find(is_suffix);
    
    if (suffix_position == 0) {
        return 1;
    } else {
        return 0;
    }
}
