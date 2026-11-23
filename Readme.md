# Bubble Burst Game 🎮

## Overview

Bubble Burst is a desktop-based interactive game developed using **Java and Java Swing**. The game provides an engaging graphical interface where players interact with bubbles by clicking different positions within a game panel.

Players can select a difficulty level, place bubbles, progress through multiple rounds, and complete the game within a 60-second time limit.

## Features

- **Graphical User Interface:** Built using Java Swing.
- **Start Game:** Launch the game using the Start button.
- **Difficulty Selection:** Choose from three difficulty levels.
- **Interactive Gameplay:** Click inside the game panel to place bubbles.
- **Bubble Validation:** Prevents bubbles from being placed outside the valid game area.
- **Multiple Rounds:** Supports up to 10 rounds.
- **Random Bubble Generation:** Generates bubble positions automatically.
- **Countdown Timer:** Includes a 60-second game timer.
- **Restart Functionality:** Restart the game and reset the gameplay.

## Technologies Used

- Java
- Java Swing
- Java AWT
- Java Event Handling
- ArrayList
- Random Class
- Timer

```

## Requirements

Before running the application, ensure you have:

- Java Development Kit (JDK) 8 or later.
- Java-compatible IDE (IntelliJ IDEA, Eclipse, or NetBeans), or a terminal.
- A desktop environment that supports Java Swing.

## Installation and Setup

### 1. Clone the Repository

```bash
git clone https://github.com/brywilczak/Bubble-Burst-game.git
```

### 2. Navigate to the Project Directory

```bash
cd BubbleBurstGame
```

### 3. Compile the Application

```bash
javac BubbleBurstGame.java
```

### 4. Run the Application

```bash
java BubbleBurstGame
```

## How to Play

1. Launch the application.
2. Select your preferred difficulty level.
3. Click the **Start** button.
4. Click inside the game panel to place bubbles.
5. Complete the initial bubble placement to progress through the rounds.
6. Continue playing until all rounds are completed or the timer expires.
7. Use the **Restart** button to reset the game.

## Difficulty Levels

The game provides three difficulty settings:

| Level | Difficulty Slider | Number of Bubbles |
|---|---:|---:|
| Easy | 0 | 4 |
| Medium | 1 | 5 |
| Hard | 2 | 6 |

## Game Rules

- Players have 60 seconds to play.
- Bubbles must be placed within the valid game panel.
- Invalid positions are rejected.
- The game supports up to 10 rounds.
- The game ends when all rounds are completed or time runs out.
- Players can restart the game at any time.

## Learning Objectives

This project demonstrates practical Java programming concepts, including:

- Object-oriented programming.
- GUI development using Java Swing.
- Event-driven programming.
- Mouse event handling.
- Action listeners.
- Timer implementation.
- Collections using ArrayList.
- Random number generation.
- Graphics rendering and customization.

## Future Improvements

Potential enhancements include:

- Add a scoring system.
- Introduce animated bubbles.
- Add sound effects.
- Implement a leaderboard.
- Improve difficulty progression.
- Add pause and resume functionality.
- Track the player's highest score.
- Improve the countdown timer display.
