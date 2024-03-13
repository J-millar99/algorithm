#include <string>
#include <vector>
#include <map>
#include <sstream>
using namespace std;

string solution(string letter) {
    map<string, string> morse = {
        {".-", "a"}, {"-...", "b"}, {"-.-.", "c"}, {"-..", "d"},
        {".", "e"}, {"..-.", "f"}, {"--.", "g"}, {"....", "h"},
        {"..", "i"}, {".---", "j"}, {"-.-", "k"}, {".-..", "l"},
        {"--", "m"}, {"-.", "n"}, {"---", "o"}, {".--.", "p"},
        {"--.-", "q"}, {".-.", "r"}, {"...", "s"}, {"-", "t"},
        {"..-", "u"}, {"...-", "v"}, {".--", "w"}, {"-..-", "x"},
        {"-.--", "y"}, {"--..", "z"}
    };
    istringstream iss(letter);
    string answers;
    string answer;
    while (iss >> answer)
        answers += morse[answer];
    return answers;
}