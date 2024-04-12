#include <string>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int solution(vector<string> babbling) {
    vector<string> words = {"aya", "ye", "woo", "ma"};
    for (int i = 0; i < babbling.size(); i++) {
        for (string word : words)
            if (babbling[i].find(word) != string::npos)
                babbling[i].replace(babbling[i].find(word), word.length(), " ");
        if (babbling[i].find(" ") != string::npos)
            babbling[i].replace(babbling[i].find(" "), 1, "");
    }
    return count(babbling.begin(), babbling.end(), "");
}