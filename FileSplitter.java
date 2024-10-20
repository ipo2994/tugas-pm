import java.io.*;
import java.util.*;

public class FileSplitter {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan nama file: ");
        String fileName = scanner.nextLine();
        
        System.out.print("Masukkan jumlah bagian yang diinginkan: ");
        int numParts = scanner.nextInt();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            Queue<String> queue = new LinkedList<>();
            StringBuilder currentPart = new StringBuilder();
            int linesPerPart = getLineCount(fileName) / numParts;
            int lineCount = 0;
            
            while ((line = reader.readLine()) != null) {
                currentPart.append(line).append("\n");
                lineCount++;
                
                if (lineCount >= linesPerPart) {
                    queue.offer(currentPart.toString());
                    currentPart = new StringBuilder();
                    lineCount = 0;
                }
            }
            
            if (currentPart.length() > 0) {
                queue.offer(currentPart.toString());
            }
            
            reader.close();
            
            System.out.println("\nBagian-bagian file yang telah dipotong:");
            int partNumber = 1;
            while (!queue.isEmpty()) {
                System.out.println("\nBagian " + partNumber + ":");
                System.out.println(queue.poll());
                partNumber++;
            }
            
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }
    }
    
    public static int getLineCount(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int lineCount = 0;
        while (reader.readLine() != null) {
            lineCount++;
        }
        reader.close();
        return lineCount;
    }
}
