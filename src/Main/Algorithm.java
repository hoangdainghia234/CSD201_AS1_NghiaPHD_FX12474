package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

//Lớp Algorithm sẽ chứa các code liên quan tới thuật toán, nhập, in, đọc/ghi dữ liệu từ/vào file
public class Algorithm {
	 /**

	  * Writing the array read from input array arr to file

	  *

	  * @param fileName The file name of file to write value

	  * @param arr      The input float array

	  *

	  */
	//Nhập giá trị của n số thực, lưu vào tệp INPUT.TXT.
	 public void writeFile(String fileName, float arr[]) {
	        try {
	        	//mở File
	            FileWriter fw = new FileWriter(fileName);
	            //Duyệt mảng ghi từng phần tử vào file
	            for (float element : arr) {
	            	//Chuyển float của các số thực thành kiểu chuổi bên trong Fie
	            	fw.write(String.valueOf(element) + " ");
	            }
	            fw.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        System.out.println("Success...");
	 }
	 /**

	  * Reading the file then input to the array arr

	  *

	  * @param fileName The file name of file to read

	  * @param arr      The output float array that will contain value read from file

	  *

	  */
	 //Đọc dữ liệu từ tệp lưu vào mảng a và hiển thị dữ liệu ra màn hình
	 public void readFile(String fileName, float arr[]) throws Exception {
	        FileReader fr = new FileReader(fileName);
	        BufferedReader br = new BufferedReader(fr);

	        String str = br.readLine();
	        //tách các xâu ra thành từng từ lưu vào từng p tử của mảng
	        String[] p = str.split(" ");

	        //cấp phát cho mảng
	        arr = new float[p.length];

	        //duyệt duyệt từng p tử trong p
	        for (int i = 0; i < arr.length; i++) {
	        	//gán từng phần tử của p vào mảng arr
	        	arr[i] = Float.parseFloat(p[i]);
	        	System.out.print(arr[i] + " ");
	        }
	        fr.close();
	 }

	 /**

	  * Sorting the input array arr using Bubble Sort algorithm.

	  *

	  * @param arr Input array using for sorting

	  * @return Returning a sorted array by using the Bubble Sort algorithm

	  *

	  */
	  void display(float[] arr)
	   {int i;
	    for(i=0;i<arr.length;i++)
	      System.out.print("  " + arr[i]);
	    System.out.println();
	   }


	 //Sắp xếp theo thuật toán Bubble Sort
	 public float[] bubbleSort(float arr[]) {
		 //Lưu dữ liệu của mảng a sang một mảng b
		 float[] b = new float[arr.length];
		 //duyệt tất cả phần tử của mảng arr  gán mảng b mới vừa tạo
		 for (int i = 0; i < arr.length; i++) {
			 b[i] = arr[i];
		 }
		 //Sắp xếp theo Bubble sort
		 for (int i = 0; i < b.length - 1; i++) {
			 for (int j = 0; j < b.length - i - 1; j++) {
				 if (b[j] > b[j + 1]) {
					 float temp = b[j];//khởi tạo biến temp
					 b[j] = b[j + 1];
					 b[j + 1] = temp;
				 }
				//hiển thị lần lượt các bước thuật toán
				 display(b);
			 }
		 }
		 //lưu vào file
		 writeFile("output1.txt", b);

		 return b;
	 }

	 /**

	  * Sorting the input array arr using Selection Sort algorithm.

	  *

	  * @param arr Input array using for sorting

	  * @return Returning a sorted array by using the Selection Sort algorithm

	  *

	  */

	 public float[] insertionSort(float arr[]) {
		 //Lưu dữ liệu của mảng a sang một mảng b
		 float[] b = new float[arr.length];
		 //duyệt tất cả phần tử của mảng arr  gán mảng b mới vừa tạo
		 for (int k = 0; k < arr.length; k++) {
			 b[k] = arr[k];
		 }
		 //sắp xếp mảng chèn
		 int i,j;
		 float temp = 0;
		 for (i = 0; i < b.length; i++) {
			 temp = b[i];
			 j = i - 1;

			 while (j >= 0 && temp < b[j]) {
				 b[j + 1] = b [j];
				 j--;//dịch chuyển bên chuyển phải tạo khoảng trống để chèn ptu
			 }
			 b[j + 1] = temp;
			 //hiển thị lần lượt các bước thuật toán
			 display(b);
		 }
		 //lưu vào file
		 writeFile("output2.txt", b);

		//duyệt mảng để in ra kết quả mảng đã sắp xếp
		 for (i = 0; i < b.length; i++) {
			 System.out.print(b[i] + " ");
		 }
		 return b;
	 }
	 /**

	  * Sorting the input array arr using Insertion Sort algorithm.

	  *

	  * @param arr Input array using for searching

	  * @return Returning a sorted array by using the Insertion Sort algorithm

	  *

	  */

	 public float[] selectionSort(float arr[]) {
		 //Lưu dữ liệu của mảng a sang một mảng b
		 float[] b = new float[arr.length];
		 //duyệt tất cả phần tử của mảng arr  gán mảng b mới vừa tạo
		 for (int k = 0; k < arr.length; k++) {
			 b[k] = arr[k];
		 }

		//sắp xếp mảng chọn
		int i,j;
		int min = 0;
		for (i = 0 ; i < b.length - 1; i++) {
			min = i;
			for (j = i + 1; j < b.length; j++) {
				if (b[min] > b[j]) {
					min = j;
				}
			}
			float temp = b[min];
			b[min] = b[i];
			b[i] = temp;
			display(b);//hiển thị lần lượt các bước thuật toán
		}
		 //lưu vào file
		 writeFile("output3.txt", b);

		//duyệt mảng để in ra kết quả mảng đã sắp xếp
		 for (i = 0; i < b.length; i++) {
			 System.out.print(b[i] + " ");
		 }
		return b;
	 }



	 /**

	  * Searching the indices of elements in array [arr] greater than value. Printing

	  * and writing all indices to the console screen and file OUTPUT4.TXT separated by space.

	  *

	  * @param arr   Input array using for searching

	  * @param value The value for searching

	  *

	  */
	 //Tìm kiếm theo thuật toán Tìm Kiếm Tuyến Tính (Linear Search)
	 public void search(float arr[], float value) {
		//tạo biến string
		 String f = "";
		 //Nhập một số thực lưu vào biến value
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Mời bạn nhập số: ");
		 value = sc.nextFloat();

		 //Tìm kiếm vị trí (chỉ số) của các phần tử có giá trị lớn hơn biến value được nhập vào.
		 for (int i = 0; i < arr.length; i++) {
			 if (value == arr[i]) {
				 f += i + " ";
				 System.out.println(i);
			 }
		 }

		 //lưu vào file
	        try {
	        	//mở File
	            FileWriter fw = new FileWriter("output4.txt");
	            fw.write(f);
	            fw.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	 }
	 /**

	  * Searching by using the Binary Search algorithm. Returning the first index of

	  * value if it is present in array arr, otherwise, return -1. The index also

	  * written to file OUTPUT5.TXT and shown on the console screen.

	  *

	  * @param arr   Input array using for searching

	  * @param left  The left index

	  * @param right The right index

	  * @param value The value for searching

	  * @return The index of the element if found, otherwise, return -1

	  *

	  */

	 public int binarySearch(float arr[], int left, int right, float value) {
		 //Sắp xếp mảng b bằng 1 trong 3 thuật toán Bubble Sort, Selection Sort, Insertion Sort được cài đặt ở bước 3, 4, 5;
		 float[] b = bubbleSort(arr);
		 right = b.length - 1;
		 String f = "";
		 int middle;
		 //điều kiện vòng lặp khởi đông khi vị trí bên trái luôn hơn bên phải tức mảng đã sắp xếp
		 while(left <= right) {
		     // Lấy vị trí ở giữa left và right
		     middle = (left + right) / 2;
		        // Nếu phần từ ở giữa bằng x thì trả về
		        // vị trí
		        if (b[middle] == value) {
			        try {
			        	//mở File
			            FileWriter fw = new FileWriter("output5.txt");
			            fw.write(Integer.toString(middle));
			            fw.close();
			        } catch (Exception e) {
			            System.out.println(e);
			        }
		            return middle;
		        }

		        // Nếu x lớn hơn phần tử ở giữa thì
		        // chắc chắn nó nằm bên phải.
		        // Chỉ định left phần từ ở giữa + 1
		        if (value > arr[middle])
		        	left = middle + 1;
		        else
		            //Ngược lại
		        	right = middle - 1;
		 }
	     //Trả về -1 nếu không tìm thấy gía trị trong mảng.
	     return -1;
	 }
}
