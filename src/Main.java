import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите текст для шифрования");
        String text = scan.nextLine();
        System.out.println("выберите действие (1 - шифрование, 2 - дешифрование): ");
        int choice = scan.nextInt();
        String [] deAphabet = {"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я"};
        int [] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33};

            switch (choice) {
                case 1:
                    String encodedText = encodeText(text, deAphabet, numbers);
                    System.out.println("Зашифрованный текст: " + encodedText);
                    break;
                case 2:
                    String decodedText = decodeText(text, deAphabet, numbers);
                    System.out.println("Расшифрованный текст " + decodedText);
                    break;
                default:
                    System.out.println("Неверное выбор действий");
                    break;
            }



    }
    public static String encodeText(String text, String[] deAplhabet, int[] numbers) {
        StringBuilder encodedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = Character.toUpperCase(text.charAt(i));
            if (Character.isLetter(c)) {
                int index = -1;
                for (int j = 0; j < deAplhabet.length; j++) {
                    if (deAplhabet[j].equals(String.valueOf(c))) {
                        index = j;
                        break;
                    }
                }
                if (index != -1) {
                    encodedText.append(numbers[index]).append(", ");
                } else {
                    encodedText.append(c);
                }
            } else {
                encodedText.append(c);
            }
        }
        return encodedText.toString().trim();
    }
    public static String decodeText(String text, String[] deAplhabet, int[] numbers) {
        StringBuilder decodedText = new StringBuilder();
        String[] parts = text.split(" ");
        for (String part : parts) {
            if (isNumeric(part)) {
                int index = Integer.parseInt(part) - 1;
                if (index >= 0 && index < deAplhabet.length) {
                    decodedText.append(deAplhabet[index]);
                } else {
                    decodedText.append(part);
                }
            } else {
                decodedText.append(part);
            }
        }
        return decodedText.toString();
    }
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

