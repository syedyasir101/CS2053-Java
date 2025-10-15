import java.util.Scanner;
public class First{
	public static void main(String[] args){
		try(Scanner scanner = new Scanner(System.in)){
			Thread thread = new Thread(new One());
			Thread thread2 = new Thread(new Two());

			thread.start();
			thread2.start();
		
		}
	}
}

class One implements Runnable{
	@Override
	public void run(){
		for(int i=0;i<6;i++){
			System.out.println(i + " this is from first thread!!");
		}	
	}
}


class Two implements Runnable{
	@Override
	public void run(){
		for(int i=0; i<6;i++){
			System.out.println(i+ " this is from Second thread!!");
		}
	}

}

