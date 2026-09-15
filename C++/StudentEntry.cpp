#include <iostream>

using namespace std;

int main (){
	
	int size;

	cout <<"Enter array size : "<<endl;
	cin >> size;

	string student[size];

	for(int i=0; i<size; i++){
		cout<<"enter student name : "<<endl;
		cin >> student[i];
		
	}
	
	for (int i= 0; i<size; i++){
	cout<<"student name :" <<student[i]<<endl;
	}
	
return 0;

}
