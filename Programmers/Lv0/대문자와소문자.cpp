#include <string>
#include <vector>

using namespace std;

string solution(string my_string) {
    for (char &ch : my_string)
        islower(ch) ? ch = toupper(ch) : ch = tolower(ch);
    return my_string;
}