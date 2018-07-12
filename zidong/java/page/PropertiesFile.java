package page;

import java.io.*;
import java.util.Properties;


public class PropertiesFile {
    private String filepath;
    private Properties pro;
    private Properties properties;

    public PropertiesFile(String filepath) throws IOException {
        this.filepath = filepath;
        this.pro = readFile();
    }

    public Properties readFile() throws IOException {
        properties = new Properties();
        try {
            InputStream in = new FileInputStream(filepath);
            BufferedInputStream action = new BufferedInputStream(in);
            properties.load(action);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String getFile(String key) {
        if (pro.containsKey(key)) {
            String username = pro.getProperty(key);
            return username;
        } else {
            System.out.println("你输入的key值不对");
            return "";
        }
    }

    public void WritePro(String key, String value) throws IOException {
        if (pro.containsKey(key)) {
            FileOutputStream fos=new FileOutputStream(filepath,true);
            pro.setProperty(key,value);
            pro.store(fos, "The New properties file");
            fos.close();

        } else {
            System.out.println("你输入的key值不对");

        }
    }
}
