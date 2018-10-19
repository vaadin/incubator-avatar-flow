package com.vaadin.flow.component.incubator.vaadincom;

/*
 * #%L
 * Vaadin IncubatorAvatar Example for Vaadin 10
 * %%
 * Copyright (C) 2017 - 2018 Vaadin Ltd
 * %%
 * This program is available under Commercial Vaadin Add-On License 3.0
 * (CVALv3).
 *
 * See the file license.html distributed with this software for more
 * information about licensing.
 *
 * You should have received a copy of the CVALv3 along with this program.
 * If not, see <http://vaadin.com/license/cval-3>.
 * #L%
 */


import com.vaadin.flow.component.incubator.Avatar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;

/**
 * Server-side component Example for the <code>incubator-avatar</code> element.
 *
 * @author Vaadin Ltd
 */
@Route("avatar")
public class AvatarView extends DemoView {

    public final String IMAGE_PATH = "src/main/resources/images/user.png";

    @Override
    protected void initView() {
        exampleAvatarImageURL();
        exampleAvatarImagePath();
        exampleAvatarAbbreviationToolTip();
        exampleAvatarAbbreviationToolTipClickButton();
    }

    private void exampleAvatarImageURL(){
        Avatar avatar = new Avatar();
        avatar.setImage("https://banner2.kisspng.com/20171216/6c0/google-png-5a3554027e9924.3682726615134443545186.jpg");

        addCard("Avatar - Image (URL)", avatar);
    }

    private void exampleAvatarImagePath(){
        Avatar avatar = new Avatar();
        String path = IMAGE_PATH;
        avatar.setImage(path,"image/png");

        addCard("Avatar - Image (resources)", avatar);
    }

    private void exampleAvatarAbbreviationToolTip(){
        Avatar avatar = new Avatar("John Smith");
        avatar.setTooltipPosition(Avatar.Position.RIGHT);
        avatar.setTooltipAlignment(Avatar.Alignment.BOTTOM);
        addCard("Avatar - Abbreviations & tooltip", avatar);
    }

    private void exampleAvatarAbbreviationToolTipClickButton(){
        Avatar avatar = new Avatar();
        avatar.setName("Second Example abbreviation");
        avatar.setTooltipPosition(Avatar.Position.BOTTOM);
        avatar.setTooltipAlignment(Avatar.Alignment.RIGHT);

        avatar.addClickListener(clickEvent -> {
            Notification notification = new Notification(
                    "You clicked on the avatar", 3000);
            notification.open();
        });

        addCard("Avatar - Click listener", avatar);
    }
}
