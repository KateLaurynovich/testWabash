package application.pageObject;

import application.enums.HelpFormItem;
import application.pageObject.forms.Breadcrumb;
import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Label;
import framework.elements.Selector;
import framework.utils.RandomGeneration;
import org.openqa.selenium.By;

public class FrequentlyAskedQuestionsPage extends BasePage {

    private static final String SELECT_FIRST_LOC = "//label[contains(text(), 'Select one...')]/..//select";
    private static final String SELECT_COUNTRY_LOC = "//label[contains(text(), 'Country')]/..//select";
    private static final String FIELD_INPUT_LOC = "//input[contains(@placeholder, '%s')]";
    private static final String COMMENTS_INPUT_LOC = "//textarea[contains(@placeholder, 'Comments')]";
    private static final String SUBMIT_BTN_LOC = " //div[@class='footer']//input[@type = 'submit']";
    private static final String SUCCESS_MSG_LOC = "//div[@class = 'sfSuccess']";
    private static final String SUCCESS_MSG = "Success! Thanks for filling out our form!";


    public Breadcrumb getBreadcrumb() {
        return new Breadcrumb();
    }

    private Selector getSelectOne() {
        return new Selector(By.xpath(SELECT_FIRST_LOC), "Select one");
    }

    private Selector getCountry() {
        return new Selector(By.xpath(SELECT_COUNTRY_LOC), "Select Country");
    }

    private Input getFieldInput(HelpFormItem helpFormItem) {
        return new Input(By.xpath(String.format(FIELD_INPUT_LOC, helpFormItem.getTitle())), helpFormItem.getTitle());
    }

    private Input getCommentInput() {
        return new Input(By.xpath(COMMENTS_INPUT_LOC), "Comment input");
    }

    private Button getSubmitBtn() {
        return new Button(By.xpath(SUBMIT_BTN_LOC), "Submit button");
    }

    private String getSuccessMsg() {
        return new Label(By.xpath(SUCCESS_MSG_LOC), "Success message").getText();
    }

    public void choiceRandomSelectOne() {
        getSelectOne().chooseSelector(getSelectOne().getCategory().get(RandomGeneration.randomGeneration(getSelectOne().getCategory().size())));
    }

    public void choiceRandomCountry() {
        getCountry().chooseSelector(getCountry().getCategory().get(RandomGeneration.randomGeneration(getSelectOne().getCategory().size())));
    }

    public void setFieldInput(HelpFormItem helpFormItem, String message) {
        getFieldInput(helpFormItem).submitInput(message);
    }

    public void setCommentInput(String message) {
        getCommentInput().submitInput(message);
    }

    public void clickSubmitBtn() {
        getSubmitBtn().clickElement();
    }

    public boolean  submittedFormSuccessfully() {
        return getSuccessMsg().contentEquals(SUCCESS_MSG);
    }
}
