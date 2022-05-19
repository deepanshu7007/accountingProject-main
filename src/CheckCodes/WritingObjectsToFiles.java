package CheckCodes;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
 
public class WritingObjectsToFiles {
 
    private static final String filepath="file.dat";
 
    public static void main(String args[]) {
 
        WritingObjectsToFiles objectIO = new WritingObjectsToFiles();
 
        Student student = new Student("John","Frost",22);
        objectIO.WriteObjectToFile(student);
    }
 
    public void WriteObjectToFile(Object serObj) {
 
        try {
 
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public Object GetObjectFromFile()
    {
    	
    }
}
