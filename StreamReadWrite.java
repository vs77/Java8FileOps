package fileOps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.sql.SQLException;

public class StreamReadWrite {
    public StreamReadWrite() {
       
    }
    private static final String FILE_NAME = "c://files//BritishBands.txt";
            
    public static void main (String[] argv){
        
        
        try{
            createNewFile(20,FILE_NAME);
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
        
        System.out.println("There are " + lineCount(FILE_NAME) + " lines in the file : " + FILE_NAME);
                
    }
    
    private static long lineCount(String fileName) throws IOException{
        long lineCount = 0;
        File f = new File(fileName);
        FileInputStream fis = new FileInputStream(f);
        BufferedReader  br  = new BufferedReader(new InputStreamReader(fis));
        
        return br.lines().count();
        
    }
    
    private static void createNewFileStream(long lineNum, String fileName) throws IOException{
        
    }
    
        
        }
