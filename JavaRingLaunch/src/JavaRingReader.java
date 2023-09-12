import gnu.io.*;
import java.io.*;
import java.util.*;

public class JavaRingReader {
    public static void main(String[] args) {
        String portName = "COM1"; // Replace with your specific serial port name
        InputStream input = null;

        try {
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
            if (portIdentifier.isCurrentlyOwned()) {
                System.out.println("Port " + portName + " is currently in use.");
            } else {
                SerialPort serialPort = (SerialPort) portIdentifier.open("DeviceDataReader", 2000);

                // Configure serial port settings (baud rate, data bits, stop bits, parity, etc.)
                serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                // Get the input stream from the serial port for reading data
                input = serialPort.getInputStream();

                // Read and log binary data from the connected device (example reads up to 100 bytes)
                byte[] buffer = new byte[100];
                int bytesRead;
                // while ((bytesRead = input.read(buffer)) != -1) {
                //     // Log the received data as hexadecimal values
                //     for (int i = 0; i < bytesRead; i++) {
                //         System.out.printf("%02X ", buffer[i]);
                //     }
                //     System.out.println(); // Newline for formatting
                // }

                // Close the serial port when done
                serialPort.close();
            }
        } catch (Exception e) {
            System.out.println("Device is not connected to port " + portName);
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

