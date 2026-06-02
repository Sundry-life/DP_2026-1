package ch15.Sample.pagemaker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database() {
    }

    // 데이터베이스 이름에서 Properties를 얻는다 
    public static Properties getProperties(String dbname) throws IOException { //String db이름 인자로 받음.
        String filename = dbname + ".txt";  //db이름으로 txt 이름
        Properties prop = new Properties();
        prop.load(new FileReader(filename)); //프러퍼티 파일에서 모든 데이터(키-값)을 읽어옴. 
        return prop;//읽은거 리턴
    }
}
