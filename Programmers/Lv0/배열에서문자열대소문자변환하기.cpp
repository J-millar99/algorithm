#include <string>
#include <vector>
#include <cctype>
using namespace std;

void transUpper(string &str)
{
    for (char &ch : str)
        ch = toupper(ch);
}

void transLower(string &str)
{
    for (char &ch : str)
        ch = tolower(ch);
}

vector<string> solution(vector<string> strArr) {
    for (size_t idx = 0; idx < strArr.size(); idx++)
    {
        if (idx % 2 == 1)
            transUpper(strArr[idx]);
        else
            transLower(strArr[idx]);
    }
    return strArr;
}