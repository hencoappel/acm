#include <fstream>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main () {
    int k;
    string division, line;
    int divp[2]; 
    cin >> k;

	while (k) {
        cin >> divp[0] >> divp[1];
        for (int i = 0; i < k; ++i) {
        	int xy[2];
        	cin >> xy[0] >> xy[1];
        	if (xy[0] == divp[0] || xy[1] == divp[1]) {
    			cout << "divisa\n";
        	} else if (xy[0] > divp[0] && xy[1] > divp[1]) {
    			cout << "NE\n";
        	} else if (xy[0] > divp[0] && xy[1] < divp[1]) {
    			cout << "SE\n";
        	} else if (xy[0] < divp[0] && xy[1] > divp[1]) {
    			cout << "NO\n";
        	} else if (xy[0] < divp[0] && xy[1] < divp[1]) {
    			cout << "SO\n";
        	}
        }
        cin >> k;
    }
}