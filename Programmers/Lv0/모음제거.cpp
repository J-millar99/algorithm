#include <string>
#include <vector>

using namespace std;

string solution(string my_string) {
    string answer = "";

    for (auto ch : my_string)
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            continue;
        else
            answer += ch;
    return answer;
}

// erase를 사용하는 방법
string solution(string my_string) {
    for (char vowel : {'a', 'e', 'i', 'o', 'u'}) {
        size_t found = my_string.find(vowel);
        while (found != std::string::npos) {
            my_string.erase(found, 1);
            found = my_string.find(vowel);
        }
    }
    return my_string;
}