# Incubator avatar for Flow

# incubator-avatar;

[Live Demo ↗](https://incubator.app.fi/incubator-avatar-demo/index.html)

[&lt;incubator-avatar&gt;](https://vaadin.com/directory/component/vaadinincubator-avatar) is a Web Component displaying user's avatar, his name or a placeholder icon.

# What does the component do?

It displays an image or abbreviations that represents the user's avatar.

# How is it used?

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

## Avatar - Abbreviations & tooltip

```java
Avatar avatar = new Avatar("John Smith");
avatar.setTooltipPosition(Avatar.Position.RIGHT);
avatar.setTooltipAlignment(Avatar.Alignment.BOTTOM);
```

## Avatar - Click listener
```java
Avatar avatar = new Avatar();
avatar.setName("Second Example abbreviation");
avatar.setTooltipPosition(Avatar.Position.BOTTOM);
avatar.setTooltipAlignment(Avatar.Alignment.RIGHT);

avatar.addClickListener(clickEvent -> {
    Notification notification = new Notification(
            "You clicked on the avatar", 3000);
});
```

# How to run the demo?

The Demo can be run going to the project incubator-avatar-flow-vaadincom-demo and executing the maven goal:

```mvn jetty:run```


## License & Author

This Add-on is distributed under [Commercial Vaadin Add-on License version 3](http://vaadin.com/license/cval-3) (CVALv3). For license terms, see LICENSE.txt.

Incubator avatar is written by Vaadin Ltd.


## Setting up for development:

Clone the project in GitHub (or fork it if you plan on contributing)

```
git clone git@github.com/vaadin/incubator-avatar-flow.git
```

To build and install the project into the local repository run 

```mvn install -DskipITs```

in the root directory. `-DskipITs` will skip the integration tests, which require a TestBench license. If you want to run all tests as part of the build, run

```mvn install```