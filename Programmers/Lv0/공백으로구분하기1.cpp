#include <string>
#include <vector>
#include <sstream>
using namespace std;

vector<string> solution(string my_string) {
    std::istringstream iss(my_string);

    std::vector<string> words;
    std::string word;
    while (iss >> word)
        words.push_back(word);
    return words;
}