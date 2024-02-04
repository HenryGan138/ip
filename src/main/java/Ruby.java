import java.util.ArrayList;
import java.util.Scanner;

public class Ruby {
    private static final Scanner in  = new Scanner(System.in);
    private static ArrayList<Task> taskList= new ArrayList<Task>();
    private static int taskNo = 0;
    private static String userInput;


    public static void main(String[] args) {
        greet();
        processor();
        exit();
    }

    private static void greet(){
        print(new String[]{"Hi, I am here. Greets from Ruby.", "What can I do for you?"});
    }

    private static void exit(){
        print("Bye. Always feels good work with you.");
    }

    private static void processor(){
        String [] userInputs = inputCatcher();

        while (checkout(userInputs)) {
            switch (userInputs[0].toLowerCase()){
            case "list":
                showTaskList();
                break;
            case "mark":
                if (userInputs.length==1){
                    print("Incorrect order.");
                    break;
                }
                int n = Integer.parseInt(userInputs[1])-1;
                if (n >= taskNo){
                    print("Sorry, task unfound.");
                }else{
                    taskList.get(n).markedTask();
                }
                break;
            case "unmark":
                if (userInputs.length==1){
                    print("Incorrect order.");
                    break;
                }
                int m = Integer.parseInt(userInputs[1])-1;
                if (m >= taskNo){
                    print("Sorry, task unfound.");
                }else{
                    taskList.get(m).unmarkedTask();
                }
                break;
            default:
                taskNo++;
                taskList.add(new Task(userInput,taskNo));
                print("added: " + userInput);
            }

            userInputs = inputCatcher();
        }
    }

    private static String[] inputCatcher(){
        userInput = in.nextLine();
        return userInput.split(" ");
    }

    private static boolean checkout(String[] userInputs){
        return !userInputs[0].equalsIgnoreCase("bye");
    }

    private static void showTaskList() {
        System.out.println("    " + "--------------");
        System.out.println("    " + "Here are the tasks in your list:");
        for (Task task:taskList){
            task.printTask();
        }
        System.out.println("    " + "--------------");
    }

    private static void print(String thingToPrint){
        System.out.println("    " + "--------------");
        System.out.println("    " + thingToPrint);
        System.out.println("    " + "--------------");
    }

    private static void print(String[] thingsToPrint){
        System.out.println("    " + "--------------");
        for (String thing: thingsToPrint){
            System.out.println("    " + thing);
        }
        System.out.println("    " + "--------------");
    }
}
