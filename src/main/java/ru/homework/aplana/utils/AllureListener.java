package ru.homework.aplana.utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.homework.aplana.steps.Hooks;

public class AllureListener extends AllureJunit4 {

    @Override
    public void testFailure(Failure failure) throws Exception {
        takeScreenshot();
        super.testFailure(failure);
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
