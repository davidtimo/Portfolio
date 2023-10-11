#include <iostream>

using namespace std;

int main(){

    int N, P;

    scanf("%d %d", &N, &P); getchar();

    int temp1 = P;
    int temp2 = P;

    for(int i = 0; i < N; i++){

        char sybmol1, symbol2;
        int opt1, opt2;

        scanf("%c %d %c %d", &sybmol1, &opt1, &symbol2, &opt2);  getchar();

        if(sybmol1 == '+')
            temp1 = temp1 + opt1;

        else
            temp1 = temp1 * opt1;
        
        if(symbol2 == '+')
            temp2 = temp2 + opt2;

        else
            temp2 = temp2 * opt2;
        
        if(temp1 > temp2)
            temp1 = temp2 = temp1;
        
        else
            temp1 = temp2 = temp2;

    }

    printf("%d\n", temp1);


    return 0;
}