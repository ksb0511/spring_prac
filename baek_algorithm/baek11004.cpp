#include <cstdio>
#include <iostream>
using namespace std;

void swap(int* a, int* b) {
	int t = *a;
	*a = *b;
	*b = t;
}

void quickSort(int left, int right, int* data) {
	int pivot = left;
	int j = pivot;
	int i = left + 1;

	if (left < right) {
		for (; i <= right; i++) {
			if (data[i] < data[pivot]) {
				j++;
				swap(&data[j], &data[i]);
			}
		}
		swap(&data[left], &data[j]);
		pivot = j;

		quickSort(left, pivot - 1, data);
		quickSort(pivot + 1, right, data);

	}
}

int main() {
	int i,n;
	cin >> i>>n;

	//int arr[i];
	// C++이니 new 키워드로 동적할당 하시면 런타임에 변수로 크기를 지정받는 배열 생성은 가능함.
	int* arr = new int[i];
	
	for (int x = 0; x < i; x++) {
		cin >> arr[x];
	}

	quickSort(0, i-1, arr);

	cout << arr[1]<<endl;


	return 0;
}