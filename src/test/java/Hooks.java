import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;

public class Hooks {

    @Before
    public void preCondition() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        Configuration.timeout = 20000;
        Configuration.startMaximized = true;
        Configuration.fastSetValue = true;
        Configuration.browser = "chrome";
        capabilities.setAcceptInsecureCerts(true);

        open("http://google.com");

    }
}
