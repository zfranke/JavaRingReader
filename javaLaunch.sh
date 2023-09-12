#!/bin/bash

# Prompt for project name and package name
read -p "Enter project name: " project_name
read -p "Enter package name (e.g., com.example): " package_name

# Create the project directory
mkdir "$project_name"
cd "$project_name"

# Create the source directory and package directories
src_dir="src/$(echo $package_name | tr . /)"
mkdir -p "$src_dir"

# Create the Main.java file
cat <<EOL > "$src_dir/Main.java"
package $package_name;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
EOL

# Create the bin directory for compiled classes
mkdir "bin"

# Create a README.md file
cat <<EOL > "README.md"
# $project_name

This is a Java project named $project_name.

## Usage

Compile and run the Main class to get started.

```bash
javac -d bin src/$package_name/Main.java
java -cp bin $package_name.Main
