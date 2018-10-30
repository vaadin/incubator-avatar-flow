# Incubator Avatar for Flow

[Live Demo ↗](https://incubator.app.fi/incubator-avatar-demo/index.html)

[&lt;incubator-avatar&gt;](https://vaadin.com/directory/component/vaadinincubator-avatar) is a Web Component displaying user's avatar, his name or a placeholder icon.

# What does the component do?

Incubator Avatar displays an image or abbreviations that represents the user's avatar.

# How is it used?

Incubator Avatar can be used in an easy way. Avatar represents a character or user giving him a
name an abbr or image as a visual identifier. A tooltip (enable by default) can be enable or disable
to display the name of the avatar when hover on it.

The abbr is generated from the Avatar's name initials. E.g. John Smith - JS.

## Avatar - Image (URL)
```java
Avatar avatar = new Avatar();
avatar.setImage("https://banner2.kisspng.com/20171216/6c0/google-png-5a3554027e9924.3682726615134443545186.jpg");
```

## Avatar - Image (resources)

```java
Avatar avatar = new Avatar();
String path = IMAGE_PATH;
avatar.setImage(path,"image/png");
```

## Avatar - Name and tooltip

```java
Avatar avatar = new Avatar("John Smith");
avatar.setTooltipPosition(TooltipPosition.RIGHT);
avatar.setTooltipAlignment(TooltipAlignment.BOTTOM);
```

or

```java
Avatar avatar = new Avatar("John Smith", TooltipPosition.RIGHT, TooltipAlignment.BOTTOM);
```

## Avatar - Click listener
```java
Avatar avatar = new Avatar();
avatar.setName("Second Example abbreviation");
avatar.setTooltipPosition(TooltipPosition.BOTTOM);
avatar.setTooltipAlignment(TooltipAlignment.RIGHT);

avatar.addClickListener(clickEvent -> {
    Notification notification = new Notification(
            "You clicked on the avatar", 3000);
    notification.open();
});
```

## Avatar - Enabling and Disabling tooltip
```java
Avatar avatar = new Avatar("Sophia Wilson");

Button actionButton = new Button("enable/disable", event -> {
    avatar.setToolTipEnabled(!avatar.isToolTipEnabled());
});

```

# How to run the demo?

The Demo can be run going to the project incubator-avatar-flow-vaadincom-demo and executing the maven goal:

```mvn jetty:run```

After server startup, you'll be able find the demo at[http://localhost:8080/avatar](http://localhost:8080/avatar)


## License & Author

This Add-on is distributed under [Commercial Vaadin Add-on License version 3](http://vaadin.com/license/cval-3) (CVALv3). For license terms, see LICENSE.txt.

Incubator avatar is written by Vaadin Ltd.


## Setting up for development:

Clone the project in GitHub (or fork it if you plan on contributing)

```
git clone git@github.com/vaadin/incubator-avatar-flow.git
```

in the root directory. `-DskipITs` will skip the integration tests, which require a TestBench license. If you want to run all tests as part of the build, run

```mvn install```