import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Task1 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String[] symbols = {"/*", "*/", "//", "{", "}", "[", "]"};
        try {
            Scanner input = new Scanner(new File("src/invalid1a.txt"));
            while(input.hasNext()){
                String line = input.nextLine();
                if (!stack.isEmpty() && stack.peek().equals("//")){
                    stack.pop();
                }
                String currentSymbol = "";
                for(int i = 0; i < line.length(); i++){
                    currentSymbol+=line.charAt(i);
                    for(String symbol : symbols){
                        if(currentSymbol.contains(symbol)){
                            switch(symbol){
                                case "/*":
                                    if(stack.isEmpty() || !stack.peek().equals(("//"))){
                                        stack.push(symbol);
                                    }
                                    break;
                                case "*/":
                                    if(!stack.isEmpty() && stack.peek().equals("/*")){
                                        stack.pop();
                                    }else if (stack.isEmpty() || !stack.peek().equals("//")){
                                        System.out.println("Error */");
                                    }
                                    break;
                                case "//":
                                    if(stack.isEmpty() || !stack.peek().equals("/*")){
                                        stack.push("//");
                                    }
                                    break;
                                case "[":
                                    if(stack.isEmpty() || (!stack.peek().equals("/*") && !stack.peek().equals("//"))){
                                        stack.push("[");

                                    }else{
                                        //System.out.println("Error [");
                                    }
                                    break;
                                case "]":
                                    if(!stack.isEmpty() && !stack.peek().equals("/*") && !stack.peek().equals("//")){
                                        if(stack.peek().equals("[")){
                                            stack.pop();
                                        }else{
                                            System.out.println("Error ]");
                                        }
                                    }
                                    break;
                                case "{":
                                    if(stack.isEmpty() || !stack.peek().equals("/*") && !stack.peek().equals("//")){
                                        stack.push("{");
                                    }else{
                                        //System.out.println("Error {");
                                    }
                                    break;
                                case "}":
                                    if(!stack.isEmpty() && !stack.peek().equals("/*") && !stack.peek().equals("//")){
                                        if(stack.peek().equals("{")){
                                            stack.pop();
                                        }else{
                                            System.out.println("Error }");
                                        }
                                    }
                                    break;


                            }
                            currentSymbol = "";
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
