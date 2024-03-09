#include <string>
#include <vector>

using namespace std;

string solution(string n_str) {
    size_t start = n_str.find_first_not_of('0');
    return (start != std::string::npos) ? n_str.substr(start) : n_str;
}