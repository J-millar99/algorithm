#include <string>
#include <vector>
#include <sstream>
#include <algorithm>
using namespace std;

vector<string> solution(string myString) {
    vector<string> tokens;
    istringstream iss(myString);
    string token;
    
    while (getline(iss, token, 'x')) {
        tokens.push_back(token);
    }
    sort(tokens.begin(), tokens.end());
    tokens.erase(remove(tokens.begin(), tokens.end(), ""), tokens.end());
    return tokens;
}