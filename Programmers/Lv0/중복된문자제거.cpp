#include <string>
#include <vector>
#include <algorithm>
using namespace std;

string solution(string my_string) {
    std::vector<char> my_vector;
    for (char ch : my_string) {
        if (find(my_vector.begin(), my_vector.end(), ch) == my_vector.end()) {
            my_vector.push_back(ch);
        }
    }
    string answer(my_vector.begin(), my_vector.end());
    return answer;
}