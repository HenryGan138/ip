import java.util.Scanner;

public class Ruby {
    public static void main(String[] args) {
        String userInput;
        Scanner in = new Scanner(System.in);
        String[] taskList = new String[100];
        int taskNo = 0;

        greet();
        userInput = in.nextLine();
        while (!userInput.toLowerCase().equals("bye")){

            if (userInput.toLowerCase().equals("list")){
                System.out.println("    " + "--------------");
                for (int i=0; i<taskNo;i++){
                    System.out.println("    " + (i+1) + ". "+ taskList[i]);
                }
                System.out.println("    " + "--------------");
            }else{
                taskList[taskNo] = userInput;
                print("added: "+userInput);
                taskNo++;
            }
            userInput = in.nextLine();
        }
        exit();
    }

    private static void greet(){
        print(new String[]{"Hi, I am here. Greets from Ruby.", "What can I do for you?"});
    }

    private static void exit(){
        print("Bye. Always feels good work with you.");
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
