## Tech stack
* Java 11
* Maven 3.6.3
* JUnit 5

## Running the application
```shell script
   mvn clean compile
   java -cp target/classes drawing_vector.main.Main
```

## Features

## User Interface (UI Layer)
* Color Panel: Allows users to select colors via RGB and Alpha sliders.
* Shape Selection Panel: Buttons for choosing Lines, Rectangles, or Ellipses.
* Drawing Canvas: White panel where users draw selected shapes.
* Undo/Redo Controls: Buttons or shortcuts for undoing/redoing actions.

## Core Functionality (Application Layer)
* Drawing Module: Handles rendering of shapes (Lines, Rectangles, Ellipses).
* Undo/Redo System: Stores history of actions to enable reversing/redoing operations.
* Color Manager: Updates the selected color and applies it to drawn shapes.

## Data Management (Storage Layer)
* Shape Object Storage: Maintains a list of drawn shapes with properties (type, color, position).
* Undo/Redo Stack: Tracks user actions for undo/redo functionality.

## Testing & Reliability
* Unit Testing: Ensures core functionalities (drawing, undo/redo, color selection) work as expected.