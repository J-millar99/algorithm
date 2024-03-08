#include <string>
#include <vector>

using namespace std;

void funcTolower(string &str)
{
    for (char &ch : str)
        ch = tolower(ch);
}

int solution(string myString, string pat) {
    int answer = 0;
    funcTolower(myString);
    funcTolower(pat);
    return myString.find(pat) != string::npos ? 1 : 0;
}