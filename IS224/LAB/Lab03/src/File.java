import java.io.*;
public class File {
	//public static int arr[];
	public static void main(String [] args)  {
		int arr[] = new int[5];
		int i = 0 ;
		String temp;
		try {
		FileReader fr= new FileReader("txt.txt");
		BufferedReader br = new BufferedReader(fr);
		
		while ((temp =br.readLine())!=null){
			int x=Integer.parseInt(temp);
			arr[i] = Integer.parseInt(temp);
			i++;
		}
		//fr.close();
		br.close();
		}	
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		 int g = 0 ;
		for(int j = 0 ; j<arr.length; j++) {
		 g = g + arr[j];
		}
		int sum = arr.length;
		int avg = g/ arr.length;
		System.out.println("there are = " + arr.length + " numbers and the average = " + avg);
	
	

}
}
