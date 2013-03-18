#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

// http://acm.sgu.ru/problem.php?contest=0&problem=222

bool prime[(int) 1e6 + 1];

// calculate which numbers are prime using the Sieve of Eratosthenes
void calcprimes(){
    fill_n(prime, 1e6 + 1, true);
    prime[0] = false;
    prime[1] = false;
    int sqrt = 3163;
    for(int i = 2; i <= sqrt; i++) {
        if(prime[i]) {
            for(int j = i*i; j<=1e6; j+=i){
                prime[j] = false;
            }
        }
    }
}

int main() {
    int n;
    cin >> n;
    calcprimes();
    int total = 0;
    vector< pair<int, int> > pairs;
    // All primes which are sums of primes, one of thos primes must be 2, else you will not get an odd number
    int i = 2;
    for(int j = i; j < n - 1; j++){
        // collect all primes that added with 2 make another prime less than or equal to n.
        if(prime[j] && prime[i+j]){
            pairs.push_back(make_pair(i, j));
            total++;
        }
    }
    cout << total << endl;
    for(vector< pair<int, int> >::iterator it = pairs.begin(); it != pairs.end(); it++){
        pair<int, int> p = *it;
        cout << p.first << " " << p.second << endl;
    }
}
