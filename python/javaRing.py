import serial

# Define the serial port and its settings
serial_port = "COM1"  # Replace with the actual serial port name
baud_rate = 9600  # Adjust the baud rate to match your iButton's settings
timeout = 1  # Set a timeout for reading from the serial port (in seconds)

# Initialize the serial connection
ser = serial.Serial(serial_port, baud_rate, timeout=timeout)

try:
    # Send a command to the Java Ring with iButton
    command = b"your_command_here"  # Replace with the actual command
    ser.write(command)

    # Read data from the iButton
    response = ser.read(64)  # Adjust the number of bytes to read as needed
    print("Response:", response)
    
    # Print the hexadecimal representation of each byte and save it to a variable to be used later
    hex_response = ""
    for byte in response:
        hex_response += hex(byte) + " "
    print("Hexadecimal:", hex_response)
    
    # Print the decimal representation of each byte and save it to a variable to be used later
    dec_response = ""
    for byte in response:
        dec_response += str(byte) + " "
    print("Decimal:", dec_response)
    
    

except serial.SerialException as e:
    print("Serial communication error:", str(e))

finally:
    # Close the serial port when done
    ser.close()
