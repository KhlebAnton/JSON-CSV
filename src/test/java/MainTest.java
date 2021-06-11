import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class MainTest {
    @Test
    void testParseXML() throws ParserConfigurationException, IOException, SAXException {
        String fileNameTest = "Test.xml";
        Employee testEmp = new Employee(1,"Test","Test","Test",1);
        List<Employee> expected = Main.parseXML(fileNameTest);
        List<Employee> actual = new ArrayList<>();
        actual.add(testEmp);
        Assert.assertEquals(expected.toString(),actual.toString());
    }
    @Test
    void testParseCSV() {
        String[] testColumnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileNameTest = "Test.csv";
        Employee testEmp = new Employee(1,"Test","Test","Test",1);
        List<Employee> expected = Main.parseCSV(testColumnMapping,fileNameTest);
        List<Employee> actual = new ArrayList<>();
        actual.add(testEmp);
        Assert.assertEquals(expected.toString(),actual.toString());
    }
    @Test
    void testListToJson() {
        Employee testEmp = new Employee(1,"Test","Test","Test",1);
        List<Employee> testList = new ArrayList<>();
        testList.add(testEmp);
        String expected = Main.listToJson(testList);
        String actual = "[{\"id\":1,\"firstName\":\"Test\"," +
                "\"lastName\":\"Test\",\"country\":\"Test\",\"age\":1}]";
        Assert.assertEquals(expected,actual);
    }

}