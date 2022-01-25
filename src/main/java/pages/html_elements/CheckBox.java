package pages.html_elements;

import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.By;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.element.UIElement;

@Title("Чекбокс")
public interface CheckBox extends UIElement {


    default boolean isChecked() {
        return this.isSelected();
    }

    default void setChecked(boolean checked) {
        if (checked) {
            if (!isChecked()) {
                this.click();
            }
        } else {
            if (isChecked()) {
                this.click();
            }
        }
    }

    default void setCheckedByName(boolean checked) {
        if (checked) {
            if (!this.findElement(By.xpath("./input")).isSelected()) {
                this.findElement(By.xpath("./span")).click();
            }
        } else {
            if (this.findElement(By.xpath("./input")).isSelected()) {
                this.findElement(By.xpath("./span")).click();
            }
        }
    }

    interface WithCheckBox extends UIElement {
        @FindBy(".//input[@type='checkbox']")
        CheckBox checkBox();
    }
}
