# Villafranca-Tour
Android for beginners Final Project

To build this project in Android Studio follow these steps:

- Clone this repository: git clone https://github.com/grisoni77/Villafranca-Tour.git <your_project_directory>
- Open Android Studio
- Choose "Import project (Eclipse ADT, Gradle, etc.)" and select the directory in which you cloned this repository at the first step
- Select "Run 'app'" from Run menu to deploy the App to a connected device or emulator

## App concept
Idea definition and target user population are described in file [idea.md](idea.md) under this repository

## App design
Some sketches describing the graphical layout of the app have been included in 'design' folder:
- **menu_page**: this sketch describes a page with a logo and a menu, wrapped by a RelativeLayout. The menu is composed by a vertical-oriented LinearLayout that contains 5 buttons, each of them letting the user access the 5 content pages
- **content_page**: this sketch describes how each of the content page is composed: each page has a Textview for the title, a Scrollview that contains the main content and a secondary menu at the bottom of the screen to go back to the menu_page. These 3 views are inserted into a vertical-oriented LinearLayout (ScrollView has weight=1 because the content has to occupy as much space as possible). The secondary menu at the bottom is made up by a horizontal-oriented LinearLayout that contains the buttons (at least the button to go back to menu)
