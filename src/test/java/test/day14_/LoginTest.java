package test.day14_;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import test.TestBase;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginTest extends TestBase {

    @Ignore
    @Test(description = "")
    public  void  test1(){

        //read url value from the properties file
        String url = ConfigurationReader.getProperty("url");
        //Driver.get() --> will return webdriver object
        //and then we can call webdriver methods like get(), findElement()....
//        WebDriver driver = Driver.get();
        Driver.get().get(url);
        //print page title
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(3);
        Driver.close();
    }

    @Test
    public void test2(){
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
    }


}
