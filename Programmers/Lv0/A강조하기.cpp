#include <string>
#include <vector>
using namespace std;

string solution(string myString) {
    for (char &ch : myString)
        if (ch == 'a')
            ch = toupper(ch);
        else if (isupper(ch) && ch != 'A')
            ch = tolower(ch);
    return myString;
}