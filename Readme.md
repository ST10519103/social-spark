# Social Spark App

## Overview

The Social Spark App is a native Android application developed using Kotlin in Android Studio. It was built to help users stay socially connected during busy days by suggesting small, simple actions (called “social sparks”) based on the time of day.

The idea is to make staying in touch feel quick and easy. The user just enters a time of day (like morning or evening), and the app suggests something small they can do to connect with someone.

## Objective

The goal of this project was to:

* Build a working Android app using Kotlin
* Use conditional logic (`if` statements) to generate suggestions
* Create a simple and easy-to-use interface
* Use GitHub for version control
* Set up GitHub Actions for automated builds
* Use logging to show understanding of debugging and program flow

## Prerequisites

Before running this project, make sure you have:

* Android Studio
* Git
* A GitHub account

## Project Creation Process

The project was created in Android Studio using the **Empty Views Activity** template so I could design the UI using XML.

Steps I followed:

1. Created a new project in Android Studio
2. Selected Kotlin as the programming language
3. Designed the layout in `activity_main.xml`
4. Added UI components
5. Linked everything in Kotlin using `findViewById`
6. Used `if` statements to control the logic and generate suggestions

## User Interface

The interface is simple and mostly uses default styling, since I focused more on understanding and implementing the logic rather than spending too much time on UI design.

The interface includes:

* A text input field for entering the time of day
* A button to generate suggestions
* A reset button to clear input and results
* A display area for showing the suggestion

### UI Layout
<img width="350" height="699" alt="Screenshot 2026-03-30 222833" src="https://github.com/user-attachments/assets/51352028-36a2-48b5-82d5-4d726ad558b5" />

### Example Output
<img width="453" height="807" alt="Screenshot 2026-03-30 210235" src="https://github.com/user-attachments/assets/d081feae-7e7b-4893-b370-f01df242e2ad" />
<img width="457" height="821" alt="Screenshot 2026-03-30 210039" src="https://github.com/user-attachments/assets/1455b2d0-cad0-4955-bb75-9c3f6459b4b5" />


## Functionality

The application works like this:

1. The user enters a time of day (e.g., morning, afternoon, evening)
2. The app processes the input using `if` statements
3. A suggestion is selected based on the input
4. The result is displayed on the screen

Initially, each time of day only had a single fixed suggestion. For example:

```
if (userInput == "morning") {
    suggestion = "Send a good morning text"
}
```

I then decided to go a bit further and make the app more dynamic by allowing multiple suggestions for a given time of day. Instead of always showing the same message, the app now randomly selects from a list of suggestions.

```
val morningSuggestions = listOf(
    "Send a good morning text to a family member",
    "Share a positive quote with a friend",
    "Say good morning to a neighbor"
)

if (userInput == "morning") {
    suggestion = morningSuggestions.random()
}
```

This makes the app feel less repetitive and a bit more engaging for the user.

### Example Suggestions

* Morning → Send a good morning text
* Mid-morning → Thank a colleague 
* Afternoon → Check in on a friend 
* Evening → Call someone 
* Night → Send a kind message 

### Error Handling

If the user enters something invalid, the app shows a helpful message asking for a correct time input.

## GitHub Usage

GitHub was used to manage and track the project.

* Created a repository for the project
* Made regular commits with meaningful messages
* Pushed updates after completing parts of the app
* Used version control to keep track of changes and progress

## GitHub Actions (CI/CD)

GitHub Actions was set up to automatically build the project.

### GitHub Actions Workflow
<img width="1439" height="783" alt="Screenshot 2026-03-30 222925" src="https://github.com/user-attachments/assets/d237a5f0-22c9-4443-b0ba-d7ec1ebb70ce" />

The workflow:

* Runs automatically on every push to the main branch
* Builds the project using Gradle
* Helps catch errors early
* Keeps the project stable

## Logging & Debugging

Logging was implemented using Android’s `Log` class to track what’s happening in the app.

Things I logged:

* User input
* When buttons are clicked
* When invalid input is entered
* The suggestion that gets generated

Logcat in Android Studio was used to view these logs, which helped me:

* Debug issues
* Understand how the app flows
* Make sure everything was working correctly
  
<img width="1872" height="864" alt="Screenshot 2026-03-30 203359" src="https://github.com/user-attachments/assets/453809f0-c40a-4422-a900-03d9bcd24a53" />

## Demo Video

A demonstration of the application can be viewed here:

[https://drive.google.com/file/d/1koj4qE97KOy1fq1OPyzflDktX3Pf6u0u/view?usp=sharing]

The video shows:

* The app interface
* Entering different inputs
* Suggestions being generated
* Reset functionality

## References
