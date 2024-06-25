# Base Converter

This Java program converts numbers between different numerical bases ranging from 2 to 16. 
The user can input a number, specify its base, and the base to which it should be converted. 
The program also includes automated tests to ensure correct functionality.

## Features

- Converts numbers between bases 2 to 16.
- Validates input numbers for the specified base.
- Provides a simple terminal-based user interface.
- Includes automated tests for normal and edge cases.

## Requirements

- Java Development Kit (JDK) 8 or higher

## Usage

1. **Compile the program**:
    ```
    javac BaseConverter.java
    ```

2. **Run the program**:
    ```
    java BaseConverter
    ```

3. **Follow the prompts**:
    - Enter the number to be converted.
    - Enter the base of the number to be converted (between 2 and 16).
    - Enter the base to which the number should be converted (between 2 and 16).

4. **View the result**:
    - The program will display the converted number.


## Automated Tests

The program includes a series of automated tests that run each time the program is executed. 
These tests ensure the correctness of the conversion logic across various inputs.

## Test Cases

### Normal Cases:
- Binary `1010` to Decimal `10`
- Hexadecimal `A` to Binary `1010`
- Decimal `25` to Octal `31`

### Edge Cases:
- Binary `0` to Hexadecimal `0`
- Binary `1` to Hexadecimal `1`
- Hexadecimal `F` to Binary `1111`

### Additional Cases:
- Binary `11111111` to Hexadecimal `FF`
- Hexadecimal `FF` to Binary `11111111`
- Octal `777` to Decimal `511`

## Notes

- The program validates the input number for the specified base and will throw an error if the number is invalid.
- Bases must be between 2 and 16, inclusive.
