#include <string>
#include <vector>
using namespace std;

string solution(string a, string b) {
    int carry = 0;
    string result;
    
    int i = a.size() - 1;
    int j = b.size() - 1;
    
    while (i >= 0 || j >= 0 || carry != 0) {
        int digit1 = (i >= 0) ? a[i--] - '0' : 0;
        int digit2 = (j >= 0) ? b[j--] - '0' : 0;
        
        int sum = digit1 + digit2 + carry;
        carry = sum / 10;
        sum %= 10;
        
        result.insert(result.begin(), sum + '0');
    }    
    return result;
}
