package classes;


import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;

public class KarateRunTest {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));

        Results results = Runner.builder()
                .path("classpath:features")
                .outputCucumberJson(true)
                .outputJunitXml(true)
                .parallel(1);
        System.out.println(results.getReportDir());
        generateReport("target/karate-reports");

    }

    public static void generateReport(String karateOutputPath){
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[]{"json"}, true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "dual-control-karate");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();

    }

    @Karate.Test
    public Karate preapprovedTest() {
        return Karate.run("classpath:features").relativeTo(getClass());
    }

}
