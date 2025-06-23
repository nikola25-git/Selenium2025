package sedmica10.ponedeljak;

import org.testng.annotations.*;

public class Selenium9 {

    @BeforeClass
    public void method() {
        System.out.println("------------");
        System.out.println("ISPIS IZ BEFORE CLASS");
        System.out.println("------------");
    }

    @BeforeMethod
    public void method2() {
        System.out.println("************");
        System.out.println("ISPIS IZ BEFORE METHOD");
        System.out.println("************");
    }

    @Test(priority = 10)
    public void test1() {
        System.out.println("/////////////");
        System.out.println("TEST 1");
        System.out.println("/////////////");
    }

    @Test(priority = 20)
    public void test2() {
        System.out.println("/////////////");
        System.out.println("TEST 2");
        System.out.println("/////////////");
    }

    @Test (priority = 30)
    public void test3() {
        System.out.println("/////////////");
        System.out.println("TEST 3");
        System.out.println("/////////////");
    }


    @AfterMethod
    public void method4() {
        System.out.println("!!!!!!!!!!!!!");
        System.out.println("ISPIS IZ AFTER METHOD");
        System.out.println("!!!!!!!!!!!!!");
    }

    @AfterClass
    public void method5() {
        System.out.println("@@@@@@@@@@@@@");
        System.out.println("ISPIS IZ AFTER CLASS");
        System.out.println("@@@@@@@@@@@@@");
    }

}
