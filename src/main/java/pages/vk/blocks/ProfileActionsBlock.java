package pages.vk.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Button;
import pages.html_elements.Link;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title("Блок перехода к профилю")
public interface ProfileActionsBlock extends AbstractBlockElement, Button.WithButton, Link.WithLink {

    @WithName("Кнопка перехода к профилю")
    @FindBy("//span[@class='FlatButton__content']")
    Button actionButton();

    interface WithProfileActionsBlock extends AbstractBlockElement {
        @FindBy("//div[@class='profile_actions']")
        ProfileActionsBlock profileActionsBlock();
    }
}
