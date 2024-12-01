Arkanoid Game- OOP project in java

Overview
=========
This is an Arkanoid-style game built in Java. The game features a paddle that can move horizontally to bounce a ball, break blocks, and advance through different levels. The game allows you to face progressively challenging levels with different block configurations.

Features
=========
- Classic Arkanoid Gameplay: Control a paddle to bounce a ball and break blocks.
- Multiple Levels: The game features different levels with increasing difficulty.
- Graphics and Animation: Smooth game animations and visuals.
- Keyboard Controls: Use the keyboard to control the paddle and interact with the game.
- Game Flow: Includes a simple game flow that handles level progression and game over states.

Prerequisites
===============
Before running the game, make sure you have the following installed:

- Java 11 or later: Ensure you are using at least Java 11 for compatibility.
- Apache Ant: The build and management tool used for compiling and running the project.

Installation
=============
1. Clone the Repository: Download or clone the project to your local machine.
   git clone https://github.com/SimonFraiberg/Arkanoid.git
   cd arkanoid-game

2. Install Apache Ant: If you don't have Apache Ant installed, download it from Apache Ant's official site (https://ant.apache.org/), and follow the installation instructions for your operating system.

3. Set Up Java: Ensure you have Java 11 (or later) installed. You can download it from AdoptOpenJDK (https://adoptium.net/) or Oracle (https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).

Running the Game
================
1. Compile the Project:
   Use Apache Ant to compile the project:
   ant compile

2. Run the Game:
   After compiling, you can run the game using:
   ant run

   This will compile the project (if it hasn't been compiled already) and launch the game.


Controls
=========
- Left Arrow: Move the paddle left.
- Right Arrow: Move the paddle right.
- P: Pause
- Space: Resume the game

Project Structure
=================
Here is a brief overview of the project structure:

- src/: Contains all the source code for the game.
  - Ass6Game.java: Main class to run the game and manage the flow.
  - Animations/: Contains classes related to animations (e.g., AnimationRunner).
  - Levels/: Contains level designs and classes for different levels (e.g., Invasion, Asteroids).
  - Mechanics/: Contains classes that handle game mechanics, such as GameFlow.

- bin/: Directory where the compiled .class files are placed (created by Ant).

- biuoop-1.4.jar: An external JAR file used by the project (e.g., for GUI or other utilities).

- build.xml: The Apache Ant build file that manages the compilation, cleaning, and running tasks.

