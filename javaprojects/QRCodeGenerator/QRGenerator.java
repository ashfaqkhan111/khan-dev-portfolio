import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class QRGenerator {
    public static void main(String[] args) {

        java.util.Scanner in = new Scanner(System.in);

        System.out.print("Enter text or url : ");
        String text = in.nextLine();

        System.out.print("Enter filename : ");
        String filename = in.nextLine();

        int width = 300;
        int height = 300;

        Path path = Paths.get("output/"+filename+".png");

        try {
            BitMatrix matrix = new MultiFormatWriter().encode(text,BarcodeFormat.QR_CODE,width,height);

            System.out.println();
            System.out.println("QR Code generated successfully!");
            MatrixToImageWriter.writeToPath(matrix, "PNG", path);
            System.out.println("Saved to :" +path);
        }catch (Exception e){
            System.out.println("something went wrong.");
            e.printStackTrace();
        }
        in.close(); 
    }
}
