package utilities;

import hooks.CucumberHooks;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StatusDetails;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.util.ResultsUtils;
import org.openqa.selenium.WebDriver;

public class AllureCucumberListener implements ConcurrentEventListener {

    StatusDetails statusDetails = null;
    private ThreadLocal<String> currentTestStep = new ThreadLocal<>();

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepStarted.class, this::handleTestStepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
    }

    private void handleTestStepStarted(TestStepStarted event) {
        TestStep testStep = event.getTestStep();
        if (!(testStep instanceof HookTestStep)) {
            String stepName = getStepName(testStep);
            currentTestStep.set(stepName);
            Allure.getLifecycle().startStep(stepName, new StepResult().setName(stepName));
        }
    }

    private void handleTestStepFinished(TestStepFinished event) {
        if (!(event.getTestStep() instanceof HookTestStep)) {
            String stepUUID = currentTestStep.get();
            Status allureStatus = getAllureStatus(event.getResult().getStatus());

            if (event.getResult().getError() != null) {
                statusDetails = ResultsUtils.getStatusDetails(event.getResult().getError()).orElse(null);

                // Capture screenshot if step failed
                WebDriver driver = CucumberHooks.getDriver();
                if (driver != null) {
                    ScreenshotUtil.takeScreenshot(driver, "FailedStep_" + System.currentTimeMillis());
                }
            }

            Allure.getLifecycle().updateStep(stepUUID, step -> {
                step.setStatus(allureStatus);
                if (statusDetails != null) {
                    step.setStatusDetails(statusDetails);
                }
            });

            Allure.getLifecycle().stopStep(stepUUID);
        }
    }

    private String getStepName(TestStep testStep) {
        if (testStep instanceof PickleStepTestStep) {
            PickleStepTestStep pickleStepTestStep = (PickleStepTestStep) testStep;
            return pickleStepTestStep.getStep().getText();
        } else if (testStep instanceof HookTestStep) {
            HookTestStep hookTestStep = (HookTestStep) testStep;
            return hookTestStep.getHookType().toString();
        }
        return "Unknown Step";
    }

    private Status getAllureStatus(io.cucumber.plugin.event.Status status) {
        switch (status) {
            case PASSED:
                return Status.PASSED;
            case FAILED:
                return Status.FAILED;
            case SKIPPED:
                return Status.SKIPPED;
            default:
                return Status.BROKEN;
        }
    }
}
