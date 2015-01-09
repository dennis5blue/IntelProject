package Client_gui;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class SimpleFileClient {
	public final static int SOCKET_PORT = 13267;
	public final static String SERVER1 = "192.168.21.222";
	public final static String SERVER2 = "192.168.137.1";
	public final static String
	FILE_TO_RECEIVED = "/Users/dennisyu/Desktop/photo.jpg";  // you may change this, I give a
                                                            // different name because i don't want to
                                                            // overwrite the one used by server...
	public final static String
	INPUT_FILE_NAME1 = "/Users/dennisyu/Documents/LAB/IntelProject/SimpleDemo/FileClient/src/Client_gui/output1.txt";
	public final static String
	INPUT_FILE_NAME2 = "/Users/dennisyu/Documents/LAB/IntelProject/SimpleDemo/FileClient/src/Client_gui/output2.txt";

	public final static int FILE_SIZE = 6022386; // file size temporary hard coded
                                                 // should bigger than the file to be downloaded

	public static void main (String [] args ) throws Exception {
		int bytesRead;
		int current = 0;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		Socket sock = null;
		String SERVER;
		int arr = 3;
		ImageDemo Imagecode = new ImageDemo();
		Check_file check_file = new Check_file();
		try {
			while(true){	
				//Thread.sleep(1000);
				File file1 = new File(INPUT_FILE_NAME1);
				File file2 = new File(INPUT_FILE_NAME2);
				int car_id = arr;
				if (file1.exists() && file2.exists()){
					car_id = check_file.Check(INPUT_FILE_NAME1,INPUT_FILE_NAME2);	
				}
				if (arr != car_id){
					System.out.println(car_id);
					if (car_id == 1 ){
						SERVER = SERVER1;
					}
					else SERVER = SERVER2;
					sock = new Socket(SERVER, SOCKET_PORT);
					System.out.println("Connecting...");

					// receive file
					byte [] mybytearray  = new byte [FILE_SIZE];
					InputStream is = sock.getInputStream();
					fos = new FileOutputStream(FILE_TO_RECEIVED);
					bos = new BufferedOutputStream(fos);
					bytesRead = is.read(mybytearray,0,mybytearray.length);
					current = bytesRead;

					do {
						bytesRead = is.read(mybytearray, current, (mybytearray.length-current));
						if(bytesRead >= 0) current += bytesRead;
					} while(bytesRead > -1);

					bos.write(mybytearray, 0 , current);
					bos.flush();
					System.out.println("File " + FILE_TO_RECEIVED + " downloaded (" + current + " bytes read)");
					Imagecode.exit();
					Imagecode.Image(FILE_TO_RECEIVED);
					arr = car_id;
					sock.close();
				}
      
			}
		}
		finally {
			if (fos != null) fos.close();
			if (bos != null) bos.close();
			if (sock != null) sock.close();
		}
	}
}