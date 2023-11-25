import java.util.Scanner;

public class PathBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bot's initial position
        int x = 0;
        int y = 0;

        // Bot's initial direction (0: North, 1: East, 2: South, 3: West)
        int direction = 0;

        System.out.print("Enter commands for the bot: ");
        String commands = scanner.nextLine();

        // Process each command
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);

            // Check the type of command
            switch (command) {
                case 'R':
                    direction = (direction + 1) % 4;
                    break;
                case 'L':
                    direction = (direction + 3) % 4;
                    break;
                case 'M':
                    // Move the bot in the current direction
                    System.out.print("Enter the number of steps: ");
                    int steps = scanner.nextInt();

                    switch (direction) {
                        case 0:
                            y += steps;
                            break;
                        case 1:
                            x += steps;
                            break;
                        case 2:
                            y -= steps;
                            break;
                        case 3:
                            x -= steps;
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid command: " + command);
            }
        }

        // Output the final position
        String finalDirection = getDirectionName(direction);
        System.out.println("Final Position: " + finalDirection + " (" + x + "," + y + ")");
    }
    private static String getDirectionName(int direction) {
        switch (direction) {
            case 0:
                return "North";
            case 1:
                return "East";
            case 2:
                return "South";
            case 3:
                return "West";
            default:
                return "Unknown";
        }
    }
}
