#include <iostream>
#include <cmath>
using namespace std;

//尚未解决溢出问题 
int main() {
	int x;
	cin>>x;
		if(x/10 == 0) cout<< x;
		else
        {
            int count=-1, sum=0;
            int temp = (x<0)? -x:x;
            int temp1 = temp;
            while(temp1 != 0)
            {
                temp1 /= 10;
                count++;
            }
            while(temp != 0)
            {
                int num = temp%10;
                temp /= 10;
                sum += (num*pow(10,count));
                count--;
            }
            sum = (x<0)? -sum:sum;
            cout<< sum;
        }
        return 0;
    }
