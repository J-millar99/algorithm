#include <string>
#include <vector>
#include <algorithm>
using namespace std;

string solution(string my_string, string alp) {

    for (char &ch : my_string)
        if (ch == alp[0])
            ch = toupper(ch);
    return my_string;
}