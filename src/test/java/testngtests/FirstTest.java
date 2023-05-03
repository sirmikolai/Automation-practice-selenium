package testngtests;

import com.github.vatbub.randomusers.Generator;
import com.github.vatbub.randomusers.result.RandomUser;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.motreba.model.testngpages.MainPage;
import testngtests.abstractClasses.AbstractTest;

@Feature("First test")
public class FirstTest extends AbstractTest {

    private MainPage mainPage;

    @BeforeClass
    public void setup() {
        super.setup();
        mainPage = new MainPage(driver);
    }

    @Test
    public void pageTitleTest() {
        Assert.assertEquals(driver.getTitle(), "My Store");
        mainPage.clickSignInButton();
        Assert.assertEquals(driver.getTitle(), "Login - My Store");
    }
}
