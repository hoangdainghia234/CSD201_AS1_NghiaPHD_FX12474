package Main;

import java.util.Scanner;

//Lớp main_sort sẽ  chứa code menu thực hiện việc gọi tới các phương thức ở lớp Algorithm để thực hiện các chức năng theo yêu cầu
public class Main_sort {
	//Nội dung danh sách menu
	static void menuList() {
		System.out.println("+-------------------Menu--------+");
		System.out.println("|     1.Input              	|");
		System.out.println("|     2.Onput       		|");
		System.out.println("|     3.Bubble sort            	|");
		System.out.println("|     4.Selection sort     	|");
		System.out.println("|     5.Insertion sort          |");
		System.out.println("|     6.Search > value          |");
		System.out.println("|     7.Search = value       	|");
		System.out.println("|     0.Exit               	|");
		System.out.println("+----------------------------.+");
	}
	public static void main(String[] args) throws Exception {
	    //1.Thiết kế menu
			menuList();
			Scanner sc = new Scanner(System.in);
			int n = 0;
			//Tạo mảng có kích thước = 20
			float[] array = new float[20];

		//Tạo chức năng tương tác vs người dùng
			int choice = 0;

			Algorithm pc = new Algorithm();

		do {
			System.out.print("Mời bạn chọn chức năng: ");
			choice = sc.nextInt();
			switch (choice) {
				case 1: {
					menuList();
					//Nhập dữ liệu từ bàn phím:
					do {
						System.out.print("Nhập giá trị của n:  ");
						n = sc.nextInt();
					}
					while (n > 20);

					//Nhập giá trị của n số thực
					System.out.println("Nhập các giá trị của n số thực : ");
					array = new float[n];//cấp phát cho n số thực

					//Duyệt các số theo n số thực
					for (int i = 0; i < n; i++) {
						 System.out.print("Nhập giá trị " + i + " :");
						 array[i] = sc.nextFloat();
					}
					pc.writeFile("input.txt", array);
					break;
				}
				case 2: {
					menuList();
					pc.readFile("input.txt", array);
					break;
				}
				case 3: {
					menuList();
					pc.bubbleSort(array);
					break;
				}
				case 4: {
					menuList();
					pc.selectionSort(array);
					break;
				}
				case 5: {
					menuList();
					pc.insertionSort(array);
					break;
				}
				case 6: {
					menuList();
					pc.search(array, choice);
					break;
				}
				case 7: {
					menuList();
					 System.out.println("Binary Search ");
					 //Nhập một số thực lưu vào biến value
					 System.out.print("Input value: ");
					 float value = sc.nextFloat();

					 if (pc.binarySearch(array, 0, n, value) != -1) {
						 System.out.print("Indext of fist element: " + pc.binarySearch(array, 0, n, value));
					 } else {
						 System.out.print("Không tìm thấy " + pc.binarySearch(array, 0, n, value));
					 }

				}
			}
		}  while (choice != -1);
	}
}
