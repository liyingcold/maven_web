import org.junit.Test;


import javax.servlet.Filter;
import java.net.URL;

public class test {

    @Test
    public void get(){
//        找到冲突的jar包
        URL url= Filter.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println("path:"+url.getPath()+" name:"+url.getFile());
    }
}
