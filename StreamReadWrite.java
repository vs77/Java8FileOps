package fileOps;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStreamWriter;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.sql.SQLException;

public class StreamReadWrite {
    public StreamReadWrite() {
       
    }
    
    public static void main (String[] argv){
        try{
            createNewFile(20,"c://files//BritishBands.txt");
        }
        catch(IOException|NullPointerException ex){
            ex.printStackTrace();
        }
        
    }
    
    private static void createNewFile(long lineNum, String fileName) throws IOException{
        Path path = Paths.get(fileName);
        
        try( FileOutputStream fos = new FileOutputStream(path.toFile());
             BufferedWriter br    = new BufferedWriter(new OutputStreamWriter(fos)); ) {
        
            while(lineNum >= 0){
                br.write("Beatles : Lennon, Starr, McCartney, Harrison : Liverpool\n");
                br.write("Queen   : Mercury, Taylor, May, Deacon: London\n");
                br.write("\n");
                lineNum--;
            }
            
            br.flush();
        }
        catch(IOException|NullPointerException ex){
            ex.printStackTrace();
            throw ex;
        }
                
    }
}
