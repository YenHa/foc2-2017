package array.simple;

import java.util.Scanner;

public class SimpleArray_Yen {

	public static void main(String[] args) throws Exception {
		int n, i;
		int a[] = new int[100];
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap so phan tu n: ");
		n = input.nextInt();
		for (i = 0; i < n; i++) {
			System.out.println("Nhap vao gia tri a[" + i + "]=");
			a[i] = input.nextInt();
		}
		System.out.print("So chia het cho 7 hoac chia het cho 2 la: ");
		for (i = 0; i < n; i++) {
			if (a[i] % 7 == 0 || a[i] % 2 == 0) {
				System.out.print(a[i] + ";");
			}
		}

		System.out.println("So chia het cho 5 va khong chia het cho 3 la: ");

		for (i = 0; i < n; i++) {
			if (a[i] % 5 == 0 && a[i] % 3 != 0) {
				System.out.print(a[i] + ";");
			}
		}

	}
}
