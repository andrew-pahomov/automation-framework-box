package pages.vk;

import pages.html_elements.Link;
import pages.vk.blocks.ProfileActionsBlock;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;

@Title("Главная страница Vk")
public interface MainPage extends AbstractPage, Link.WithLink, ProfileActionsBlock.WithProfileActionsBlock {
}
