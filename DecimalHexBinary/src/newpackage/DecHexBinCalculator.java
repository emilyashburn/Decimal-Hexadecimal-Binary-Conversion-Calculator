/**
 * Emily Ashburn
 * 1/9/19
 *
 * This program is designed to convert:
 *   ✓  decimal -> hexadecimal or binary
 *   ✓  binary -> decimal or hexadecimal
 *      hexadecimal -> decimal or binary
 */
package newpackage;

public class DecHexBinCalculator {

    static StringBuilder sb = new StringBuilder();
    static int remainder, whole, power = 0;
    static double total;

    public static void main(String[] args) {

        decToBin(50);
        System.out.println();
        decToBin(99);
        System.out.println();
        decToBin(1234);
        System.out.println();
        System.out.println();
//
//        decToHex(24);
//        System.out.println();
//        decToHex(12);
//        System.out.println();
//        decToHex(111);
//        System.out.println();
//        decToHex(3333);

//        binToDec(1010);
//        System.out.println(binToDec(1111));
//        total = power = 0;
//        System.out.println(binToDec(11001010));         
//        total = power = 0;
//        System.out.println(binToDec(1111111111));

        binToHex(11000);
        sb.append(hexConversion((int) total));
        reverse(sb);
        System.out.println(sb);

//        power = 0;
//        System.out.println();
//        binToHex(1101111);
//        sb.append(hexConversion((int) total));
//        reverse(sb);
    }

    //Recursive decimal to binary conversion
    public static void decToBin(int dec) {
        remainder = dec % 2;
        whole = dec / 2;

        if (whole == 0) {
            sb.append(remainder);
            reverse(sb);
        } else {
            sb.append(remainder);
            decToBin(whole);
        }
    }

    //Reverses digits to correct order
    //Resets StringBuilder value for reuse
    public static void reverse(StringBuilder sb) {
        for (int i = sb.length() - 1; i > -1; i--) {
            System.out.print(sb.charAt(i));
        }
        sb.delete(0, sb.length());
    }

    //Recursive decimal to hexadecimal 
    public static void decToHex(int dec) {
        remainder = dec % 16;
        whole = dec / 16;

        if (whole == 0) {
            switch (remainder) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    sb.append(remainder);
                    break;
                case 10:
                    sb.append("A");
                    break;
                case 11:
                    sb.append("B");
                    break;
                case 12:
                    sb.append("C");
                    break;
                case 13:
                    sb.append("D");
                    break;
                case 14:
                    sb.append("E");
                    break;
                case 15:
                    sb.append("F");
            }
            reverse(sb);
        } else {
            switch (remainder) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    sb.append(remainder);
                    break;
                case 10:
                    sb.append("A");
                    break;
                case 11:
                    sb.append("B");
                    break;
                case 12:
                    sb.append("C");
                    break;
                case 13:
                    sb.append("D");
                    break;
                case 14:
                    sb.append("E");
                    break;
                case 15:
                    sb.append("F");
                    break;
            }
            decToHex(whole);
        }
    }

    //Recursive binary to decimal (UP TO 0011 1111 1111)
    public static int binToDec(int bin) {
        remainder = (bin % 10);
        whole = (bin / 10);

        if (whole != 0 || remainder != 0) {
            if (remainder == 0) {
                ++power;
            } else {
                total += Math.pow(2, power);
//                System.out.println("total: " + total + ".. power: " + power);
                ++power;
            }
            binToDec(whole);
        }
        return (int) total;
    }

    public static StringBuilder binToHex(int bin) {

        remainder = bin % 10;
        whole = bin / 10;

        if (whole != 0 || remainder != 0) {
            if (remainder == 0) {
                ++power;
            } else {
                //@param total: value of first 4 binary digits
                total += Math.pow(2, power);
                ++power;
            }
            //Total resets after 4 binary digits
            if (power > 3) {
                sb.append(hexConversion((int) total));
                System.out.println(sb);
                total = power = 0;
            }
            binToHex(whole);
        }
        return sb;
    }

    public static String hexConversion(int dec) {
        switch (dec) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return Integer.toString(dec);
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            }
        return "";
    }

    public static void test(int dec) {

    }
}
