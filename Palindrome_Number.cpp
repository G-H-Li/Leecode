#include <iostream>
#include <math.h>
using namespace std; 

int getLength(int x){
    int count = 0;
    while(x != 0)
    {
        x /= 10;
        count += 1;
    }
    return count;
}

int main() {
	int x = 121;
    if(x < 0) cout<<"0";
    else if(x/10 == 0) cout<<"1";
    else{
    	int x0 = x;
            int n0 = getLength(x) -1;
            int n1 = 1;
            if(getLength(x)%2 == 0){
                while(n1 != n0)
                {
                    if(x/pow(10,n0) == x0 % 10){

                    x = x % (int)pow(10 ,n0);
                    x0 /= 10;
                    n1 += 1;
                    n0 -= 1;
                }
                    else {
					cout<<"0";
                    break;}
                }
                cout<<"1";
            }
            else{
                while(n0 != n1-1)
                {
                    if(x/pow(10,n0) == x0 % 10){

                    x = x % (int)pow(10 ,n0);
                    x0 /= 10;
                    n1 += 1;
                    n0 -= 1;
                }
                    else 
					{
						cout<<"0";
						break;
					}
                }
                cout<<"1";
            }
    }
    return 0;
}
    
    
