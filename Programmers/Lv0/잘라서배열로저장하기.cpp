#include <string>
#include <vector>

using namespace std;

vector<string> solution(string my_str, int n) {
    vector<string> answer;
    size_t start = 0;
    while (1) {
        if (my_str.length() <= start + n)
            break ;
        else {
            answer.push_back(my_str.substr(start, n));
            start += n;
        }
    }
    answer.push_back(my_str.substr(start, my_str.length() - start));
    return answer;
}