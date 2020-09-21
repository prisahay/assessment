package Assignment_3.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ObjectDataReader {
    Properties p = new Properties();
    public Properties getObjectRepository() throws IOException{
        //Read object repository file
    	System.out.println("Reading properties from " + System.getProperty("user.dir")+"\\src\\test\\java\\Assignment_3\\objects\\Objects.properties");
        InputStream stream = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\java\\Assignment_3\\objects\\Objects.properties"));
        //load all objects
        p.load(stream);
         return p;
    }
    
}
