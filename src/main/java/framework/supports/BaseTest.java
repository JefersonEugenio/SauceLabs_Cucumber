package framework.supports;

import com.aventstack.extentreports.Status;
import framework.tools.Report;
import framework.utils.FileOperationsAndProperties;
import framework.webDrivers.DriverFactory;
import framework.webDrivers.DriverManager;
import framework.webDrivers.Drivers;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static framework.tools.Report.extentTest;

public class BaseTest extends DriverFactory {

    @Before
    public void browserSetup() {
        Report.configurarExtentReport();
        Report.createTest("Sauce Labs com cucumber");
        extentTest.log(Status.INFO, "Iniciado de teste");
        DriverManager.setDriver(createInstance(Drivers.CHROME));
        DriverManager.getDriver().get(FileOperationsAndProperties.getPropertiesData("url", "SauceLabs"));
        if (DriverManager.getDriver() == null) {
            throw new IllegalStateException("Driver não foi inicializado corretamente!");
        }
    }

    @After
    public void tearDown() {
        extentTest.log(Status.INFO, "Finalizado de teste");
        Report.closeReport();
        DriverManager.quit();
    }

}