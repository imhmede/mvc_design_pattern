# Model View Controller Implementation for android mobile apps

This is a simple Paasive Model View Controller (MVC) design pattern implemntation for mobile app.

## Project Structure

The project is structured as follows:

- **`passive_mvc'**
- ***'/app/src/main/java/com/example/simplemvc/*`***: The java source code.
- **`passive_mvc/gradle/*`**: QuickSort algorithm implementation.
- **`src/main/sorting/BinarySearch.java`**: BinarySearch algorithm implementation.
- **`src/main/mvc/Model.java`**: Represents the data, including sorting algorithms and input array.
- **`src/main/mvc/View.java`**: Displays the original and sorted arrays.
- **`src/main/mvc/Controller.java`**: Manages the interaction between the Model and View.
- **`lib`**: Contains any necessary libraries.
- **`build.xml`**: Ant build script for compiling, running, and cleaning the project.
- **`README.md`**: This file, containing instructions and additional information.

## Requirements

- **Java JDK**: The program requires Java JDK to compile and run. Make sure you have it installed on your machine.
- **Apache Ant**: The program is automated using an Ant script, so you need to have Apache Ant installed.

## Usage

### Compiling

To compile all the Java files, run the following command:

```bash
ant compile
ant run
