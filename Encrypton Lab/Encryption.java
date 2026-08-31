import java.util.Scanner;
// Using this package in java, the scanner class is able to take input values from user inputs, files, strings, and other input streams


public class Encryption {


    public static void Encrypt() {
        Scanner input = new Scanner(System.in); // System.in allows for what the user types to be what the input is that
                                                // the class Scanner will read
        System.out.println("Type the Encryption key: ");
        int key = input.nextInt(); // This integer variable holds the encrypion key
        input.nextLine(); // This takes in the white space after clicking enter to the previous prompt
        System.out.println("Type the text you would like to Encrypt: ");
        String line = input.nextLine(); // This String variable holds the text that the user wants to be encrypted
        String newLine = ""; // This String varibale will be built in the next for loop, eventually creating
                             // the encrypted text
        for (int i = 0; i < line.length(); i++) { // This for loop goes through each character of the text the user
                                                  // enters
            if (line.charAt(i) < 65) {
                newLine += line.charAt(i);
            } else if ((line.charAt(i) > 90) && (line.charAt(i) < 97)) {
                newLine += line.charAt(i);
            } else if (line.charAt(i) > 122) {
                newLine += line.charAt(i);
            }
            /*
             * These first three conditional statements check if there are characters in the
             * text the user entered that are special characters, by checking their ascii
             * values.
             * If the character being checked is a special character, it is simply added to
             * the new
             * encryted text as is, which is shown through "newLine += line.charAt(i);".
             */
            else // When the character's ascii value is just a regualr letter(upper case or lower
                 // case)
            {
                char newChar = (char) (line.charAt(i) + key); // Encrypts the chracter by increasing it's ascii value by
                                                              // the encryption key
                if ((line.charAt(i) < 91) && (newChar > 96)) {
                    newChar -= key;
                    for (int j = 0; j < key; j++) {
                        newChar += 1;
                        if (newChar == 91) {
                            newChar = 65;
                        }
                    }
                    newLine += (char) (newChar);
                    /*
                     * This first conditional makes sure the case of the letter stays the same
                     * (if entered lowercase, output is lowercase). The reason this is important is
                     * because,
                     * if you have an output that comes out a different case, when you try to
                     * decrypt it
                     * with the same key, the output will not be correct.
                     * The way this works is by increasing the ascii value of the new char by 1,
                     * and then if it is equal to one past the ascii value of Z(uppercase) or
                     * z(lowercase),
                     * starting back at A or a respectively, and then incrementing again by 1 until
                     * it has been increased
                     * to the desired key
                     */
                } else if (newChar < 65) {
                    newChar = (char) (newChar - 26);
                    newLine += newChar;
                } else if ((newChar > 90) && (newChar < 97)) {
                    newChar = (char) (newChar - 26);
                    newLine += newChar;
                } else if (newChar > 122) {
                    newChar = (char) (newChar - 26);
                    newLine += newChar;
                }
                /*
                 * These 3 conditionals check to see that after encyrpting the character, if it
                 * becomes a special character. If it does, like conditional statment 1 in this
                 * part,
                 * it will start back at A or a by subtracting 26 from the ascii value.
                 */
                else {
                    newLine += newChar;
                }
                // This conditional is when the encrypted character is a character, and doesn't
                // need any changes.
            }
        }
        System.out.println("Encrypted Text: " + newLine); // Prints out the encrypted text
    }


    public static void Decrypt()
    /*
     * This function wors the same as encrypt, however there are a few differences,
     * which will
     * be commented. If there are no comments, assume it is the same as the Encrypt
     * function.
     */
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Type the Decryption key: ");
        int key = input.nextInt();
        input.nextLine();
        System.out.println("Type the text you would like to Decrypt: ");
        String line = input.nextLine();
        String newLine2 = "";
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) < 65) {
                newLine2 += line.charAt(i);
            } else if ((line.charAt(i) > 90) && (line.charAt(i) < 97)) {
                newLine2 += line.charAt(i);
            } else if (line.charAt(i) > 122) {
                newLine2 += line.charAt(i);
            } else {
                char newChar2 = (char) (line.charAt(i) - key);
                if ((line.charAt(i) > 96) && (newChar2 < 91)) {
                    newChar2 += key;
                    for (int j = 0; j < key; j++) {
                        newChar2 -= 1;
                        if (newChar2 == 96) {
                            newChar2 = 122;
                        }
                    }
                    newLine2 += (char) (newChar2);
                }
                /*
                 * This first conditional makes sure the case of the letter stays the same
                 * (if entered lowercase, output is lowercase) just like in the Ecrypt function.
                 * The way this works is by decreasing the ascii value of the new char by 1,
                 * and then if it is equal to one before the ascii value of A(uppercase) or
                 * a(lowercase),
                 * starting back at Z or z respectively, and then decreasing again by 1 until it
                 * has been decreased
                 * to the desired key
                 */
                else if (newChar2 < 65) {
                    newChar2 = (char) (newChar2 + 26);
                    newLine2 += newChar2;
                } else if ((newChar2 > 90) && (newChar2 < 97)) {
                    newChar2 = (char) (newChar2 + 26);
                    newLine2 += newChar2;
                } else if (newChar2 > 122) {
                    newChar2 = (char) (newChar2 + 26);
                    newLine2 += newChar2;
                }
                /*
                 * These 3 conditionals check to see that after decyrpting the character, if it
                 * becomes a special character. If it does, like conditional statment 1 in this
                 * part,
                 * it will start back at A or a by adding 26 to the ascii value.
                 */
                else {
                    newLine2 += newChar2;
                }
                // This conditional is when the encrypted character is a character, and doesn't
                // need any changes.
            }
        }
        System.out.println("Decrypted Text: " + newLine2); // Prints out the decrypted text
    }


    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("1.Encrypt\n2.Decrypt\nChoice: ");
        int choice = input.nextInt(); // This integer variable takes in the choice the user makes
        // 1 being encryption, and 2 being decryption


        if (choice == 1) // Checking if the user chose encryption
        {
            Encrypt(); // Runs the encryption method
        }


        else if (choice == 2) // Checking if the user chose decryption
        {


            Decrypt(); // Runs the decryption method
        }


    }
}
