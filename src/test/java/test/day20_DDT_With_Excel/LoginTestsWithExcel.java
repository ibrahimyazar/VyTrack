package test.day20_DDT_With_Excel;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import test.TestBase;
import utils.BrowserUtils;
import utils.Driver;
import utils.ExcelUtil;

import java.util.Map;

public class LoginTestsWithExcel extends TestBase {

    @Test(dataProvider = "credentials", description = "login with different credentials")
    public void loginTest(String username, String password, String firstname, String lastname, String result){
        //is must because we will ge null pointer exception
        extentTest = extentReports.createTest("Login as" + username);   // we are creating report
         if(username.equals("username")){
            //will make test skipped
            //it will not fail
            //because first row is dedicated to column names
            throw new SkipException("Test was skipped because it's first row!");
        }else{
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
            //put here wait for title to be "Dashboard"
            BrowserUtils.waitForPageTitle("Dashboard");
            Assert.assertEquals(Driver.get().getTitle(), "Dashboard");
            extentTest.pass("Login test passed for user "+username);   //*****
        }
//        LoginPage loginPage = new LoginPage();
//        loginPage.login(username, password);

//        if(Driver.get().getTitle().equalsIgnoreCase("Dashboard")){
//            System.out.println("Test passed");
//        }else{
//            System.out.println("Test is not passed ");
//        }
//
//       // Assert.assertEquals(Driver.get().getTitle(), "Dashboard");
    }




    //is a test data supplier
    //as many sets of data it returns
    //as many times exactly same test will run
    @DataProvider(name = "credentials")
   public static Object[][] credentials(){
        ExcelUtil qa2 = new ExcelUtil("vytrack_testusers.xlsx", "QA2-short");
        return qa2.getDataArray();

   }











//   public static void main(String[] args) {
////
//                                //  file name path               sheet name
//       ExcelUtil qa2 = new ExcelUtil("vytrack_testusers.xlsx", "QA2-short");
//       System.out.println("Row count: " + qa2.rowCount());
//       System.out.println(qa2.getColumnsNames());
////
////         //map is a data structure
//////        //in map, every value is referenced by key
//////        //when we retrieve data from map, we don't specify index, we specify key name
//////        //keys must be unique
//////        //keys are represented by column names
//////        //like in properties file key=value
//        for(Map<String, String> map: qa2.getDataList()){
//            System.out.println(map);
//
//        }
//
//       for(Map<String, String> map: qa2.getDataList()){  //when you get something from map .get
//           System.out.println(map.get("username"));   // you can get all user name
//
//       }
//
//       for(Map<String, String> map: qa2.getDataList()){  //when you get something from map .get
//                                //   key=value
//           System.out.println(map.get("password"));   // you can get all user name
//
//       }
//
//       for(Map<String, String> map: qa2.getDataList()){  //when you get something from map .get
//           System.out.println(map.get("firstname"));   // you can get all user name
//
//       }
//
//       for(Map<String, String> map: qa2.getDataList()){  //when you get something from map .get
//           System.out.println(map.get("lastname"));   // you can get all user name
//
//       }
//
//   }


}
