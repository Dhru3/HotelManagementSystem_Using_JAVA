package Mini;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelManagementSystem {
    public static void main(String[] args) {
        Room[] rooms = new Room[15];
        String name = "";
        String phoneNumber = "";
        String roomType = "";
        int numberOfNights = 0;
        int numberOfGuests = 0; // Initialize numberOfGuests

        for (int i = 0; i < 5; i++) {
            rooms[i] = new StandardRoom();
            rooms[i + 5] = new SuiteRoom();
            rooms[i + 10] = new DeluxeRoom();
        }

        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~HOTEL MANAGEMENT SYSTEM:~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("1. Explore our Rooms:");
                System.out.println("2. Book a room:");
                System.out.println("3. View Invoice:");
                System.out.println("4. Exit.");
                System.out.print("Enter your choice (1-4): ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.println("\nRoom Types:");
                        System.out.println("1. Standard:\nOur standard rooms are the most basic and affordable rooms offered by our hotel. They typically have the necessary amenities for a comfortable stay, such as a bed, a bathroom, and a TV.");
                        System.out.println("\n2. Deluxe:\nRooms are furnished with high-quality materials and stylish decor accompanying additional amenities such as a separate seating area, a king-size bed, and a balcony.");
                        System.out.println("\n3. Grand Suite:\nOur suites are the most spacious and luxurious rooms offered by our hotel. They have two or more bedrooms, a living area, and a kitchen. Suites are a great option for families or groups of friends who are looking for a spacious and comfortable place to stay.");
                        break;
                        
                    case 2:
                        System.out.println("\nBook Room:");
                        System.out.print("Enter your name: ");
                        name = scanner.nextLine();

                        // Validate the phone number
                        boolean validPhoneNumber = false;
                        while (!validPhoneNumber) {
                            System.out.print("Enter your phone number (10 digits): ");
                            phoneNumber = scanner.nextLine();
                            try {
                                Long.parseLong(phoneNumber); // Check if it's a valid long (numeric input)
                                if (phoneNumber.matches("\\d{10}")) {
                                    validPhoneNumber = true;
                                } else {
                                    System.out.println("Invalid phone number. Please enter a 10-digit number.");
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("Invalid phone number. Please enter a numeric value.");
                            }
                        }

                        // Allow entering room type as a number or text
                        System.out.print("Enter the room type (1 for Standard, 2 for Deluxe, 3 for Grand Suite): ");
                        int roomTypeChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        switch (roomTypeChoice) {
                            case 1:
                                roomType = "standard";
                                break;
                            case 2:
                                roomType = "deluxe";
                                break;
                            case 3:
                                roomType = "suite";
                                break;
                            default:
                                System.out.println("Invalid room type. Please enter a valid number.");
                                continue; // Restart the loop
                        }

                        // Validate the number of guests
                        boolean validNumberOfGuests = false;
                        while (!validNumberOfGuests) {
                            try {
                                System.out.print("Enter the number of guests: ");
                                numberOfGuests = scanner.nextInt();

                                if (numberOfGuests == 0) {
                                    System.out.println("Invalid number of guests. Please enter a number greater than 0.");
                                } else if (numberOfGuests > 10) {
                                    System.out.println("BOOK more than 1 room.");
                                } else if (numberOfGuests > 4) {
                                    System.out.println("Choosing Grand Suite as the default room due to a large number of guests. Book again if you want separate rooms.");
                                    roomType = "suite"; // Set the default room type to Deluxe
                                    validNumberOfGuests = true; // Skip the prompt for number of guests again
                                } else {
                                    validNumberOfGuests = true;
                                }
                            } catch (InputMismatchException ex) {
                                System.out.println("Invalid input. Please enter a valid number.");
                                scanner.nextLine(); // Consume the invalid input
                            }
                            
                        }

                        System.out.print("Enter the number of nights: ");
                        numberOfNights = scanner.nextInt();
                        break;

                    case 3:
                        System.out.println("\nView Invoice:");
                        if (name.isEmpty() || phoneNumber.isEmpty() || roomType.isEmpty() || numberOfNights == 0) {
                            System.out.println("No booking information available. Please book a room first.");
                        } 
                        else if (numberOfGuests==1){
                            printInvoice(name,phoneNumber,roomType,numberOfNights); //Method Overloading2
                            }
                        else{
                            printInvoice(name, phoneNumber, roomType, numberOfNights, numberOfGuests);  //Method Overloading1
                        }
                        break;

                    case 4:
                        System.out.println("Thank you for visiting our hotel! Hope to see you again soon :)");
                        return; // Exit the program

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input. Please enter a valid number.");
        } finally {
            // Close the scanner in the finally block
            scanner.close();
        }
    }

    private static void printInvoice(String name, String phoneNumber, String roomType, int numberOfNights) {
        float pricePerNight = getPricePerNight(roomType);
        float totalPrice = pricePerNight * numberOfNights;
    
        System.out.println("\nInvoice Details (Single Guest):");
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Number of Nights: " + numberOfNights);
        System.out.println("Total Price: " + totalPrice + " rupees");
    }
    
    // Overloaded method to print invoice for multiple guests
    private static void printInvoice(String name, String phoneNumber, String roomType, int numberOfNights, int numberOfGuests) {
        float pricePerNight = getPricePerNight(roomType);
        float totalPrice = pricePerNight * numberOfNights * numberOfGuests;
    
        System.out.println("\nInvoice Details (Multiple Guests):");
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Number of Guests: " + numberOfGuests);
        System.out.println("Number of Nights: " + numberOfNights);
        System.out.println("Total Price: " + totalPrice + " rupees");
    }

    

    private static float getPricePerNight(String roomType) {
        switch (roomType) {
            case "standard":
                return 5000.0f; // Use float
            case "suite":
                return 10000.0f; // Use float
            case "deluxe":
                return 8500.0f; // Use float
            default:
                return 0.0f; // Use float
        }
    }
}
