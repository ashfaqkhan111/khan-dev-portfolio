#include <iostream>

using namespace std;

int main () {

double score;

cout << "Enter your score out 0 - 100 : " << endl;
cin >> score;

if (score >= 85){
	cout << "Grade A" << endl;

	}
else if (score >= 75 && score < 85) {
	cout << "Grade B" << endl;
	}
else if (score  >= 60 && score < 75) {
	cout << "Grade C" << endl;
	}
else if (score >= 50 && score < 60) {
	cout << "Grade D" << endl;
	}
else {
	cout << "Grade F fail" << endl;
	}

}
