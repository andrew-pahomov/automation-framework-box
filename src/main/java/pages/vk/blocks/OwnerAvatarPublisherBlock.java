package pages.vk.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import pages.html_elements.Button;
import pages.html_elements.CheckBox;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title("Блок публикации фотографии")
public interface OwnerAvatarPublisherBlock extends AbstractBlockElement, Button.WithButton, CheckBox.WithCheckBox {

    @WithName("Кнопка продолжить")
    @FindBy(".//button")
    Button continueButton();

    @WithName("Чекбокс опубликовать запись")
    @FindBy(".//label[text()='Опубликовать запись']")
    CheckBox checkBoxPublishRecord();

    @WithName("Чекбокс опубликовать историю")
    @FindBy(".//label[text()='Опубликовать историю']")
    CheckBox checkBoxPublishStory();

    interface WithOwnerAvatarPublisherBlock extends AbstractBlockElement {
        @FindBy(".//div[@class='OwnerAvatarEditorPublisher__content']")
        OwnerAvatarPublisherBlock ownerAvatarPublisherBlock();
    }
}
