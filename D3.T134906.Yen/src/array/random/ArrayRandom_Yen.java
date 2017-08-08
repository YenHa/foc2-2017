package array.random;

import java.util.Random;
import java.util.Scanner;

public class ArrayRandom_Yen {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rd = new Random();
		int n = 0, max = 0, min = 1000, count = 0;
		double tongTB = 0;
		long tong = 0;
		boolean result;
		try {
			System.out.println("Nhap so phan tu mang: ");
			n = input.nextInt();
		} catch (Exception e) {
			System.out.println("Nhap so nguyen duong !");
		}
		int[] arr = new int[n];
		System.out.println("Cac so nguyen duong la: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(1000);

			System.out.format("%4d", arr[i], " ");
			tong += arr[i];
			tongTB = (tong * 1.0) / n;
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		System.out.println();
		System.out.println("Tong cac so trong danh sach la: " + tong);
		System.out.println("Gia tri trung binh cua cac so trong danh sach la: " + tongTB);
		System.out.println("Gia tri cua phan lon nhat la: " + max);
		System.out.println("Gia tri cua phan tu nho nhat la: " + min);
		System.out.println("Cac so nguyen to trong danh sach la: ");
		for (int i = 0; i < arr.length; i++) {
			result = checkPrimeNumber(arr[i]);
			if (result) {
				System.out.print(arr[i] + " ");
			}
		}
	}

	public static boolean checkPrimeNumber(int number) {

		if (number < 2) {
			return false;
		}
		for (int i = 2; i < number / 2; i++) {
			if (number % i == 0) {
				return false;

			}
		}
		return true;
		

	}
}