package pages.vk.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Button;
import pages.html_elements.Link;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title("Блок навигации")
public interface SideBarBlock extends AbstractBlockElement, Link.WithLink, Button.WithButton {

    @WithName("Кнопка Моя страница")
    @FindBy("//span[text()='Моя страница']")
    Button loginButton();

    interface WithSideBarBlock extends AbstractBlockElement {
        @FindBy("//nav[@class='side_bar_nav']")
        SideBarBlock sideBarBlock();
    }
}
