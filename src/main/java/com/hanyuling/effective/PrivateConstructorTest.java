package com.hanyuling.effective;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.EnumSet;

public class PrivateConstructorTest {

    private PrivateConstructorTest(){

    }
    public PrivateConstructorTest(String s) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("", "", "");
    }

}
class PrivateConstructorSubset extends PrivateConstructorTest{

    public PrivateConstructorSubset() throws Exception {
        super("");
    }
}