#include <string>
#include <vector>

using namespace std;

string solution(string myString, string pat) {
    size_t found = myString.rfind(pat);
    return myString.substr(0, found + (pat.length()));
}