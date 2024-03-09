#include <string>
#include <vector>

using namespace std;

int solution(string myString, string pat) {
    for (char &ch : myString)
        ch == 'A' ? ch = 'B' : ch = 'A';
    if (myString.find(pat) != string::npos)
        return 1;
    return 0;
}