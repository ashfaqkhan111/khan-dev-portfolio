#include <iostream>
using namespace std;

int main() {

double a, b;
char op;

cout << "Enter first number : ";
cin >> a;

cout << "Enter oprator (+, - , *, /) : ";
cin >> op;

cout << "Enter second number : ";
cin >> b;

switch (op) {

	case '+':
		cout <<"Result : " << a+b << endl;
		break;

	case '-': 
		cout <<"Result : " << a-b << endl;
		break;
	case '*':
		cout <<"Result : " << a*b << endl;
		break;
	case '/':
		if (b != 0)
		cout << "Result : " << a/b << endl;
		else
		cout << "cannont divide by 0" << endl;
		break;
	default :
		cout << "Invalid oprator!";
	}
return 0;

}
