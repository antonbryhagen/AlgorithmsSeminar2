package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Task1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter name of file (example: valid1a.txt): ");
        String file = keyboard.nextLine();
        System.out.println("Enter which language the program is written in: ");
        String lang = keyboard.nextLine();

        if(lang.equals("c") || lang.equals("C")){
            verifyC("src/task1/"+file);
        }else if(lang.equals("c++") || lang.equals("C++")){
            verifyCPlusPlus("src/task1/"+file);
        }else{
            System.out.println("Invalid language, restart the program and try again");
        }

    }

    public static void verifyC(String file){
        Stack<String> stack = new Stack<>();
        int currentLine = 0;
        boolean compiled = true;
        try {
            Scanner input = new Scanner(new File(file));
            boolean inComment = false;
            while(input.hasNext()){
                String line = input.nextLine();
                currentLine++;
                for(int i = 0; i < line.length(); i++){  //check each char in line
                    if(!inComment){
                        //check if there was an attempt to start a comment (stack top element should be /)
                        if(!stack.isEmpty() && stack.peek().equals("/")){
                            if(line.charAt(i) ==  '/'){
                                // double slash comment found, remove the single slash and add the dual slash symbol to stack
                                stack.pop();
                                stack.push("//");
                                inComment = true;
                            } else if (line.charAt(i) == '*') {
                                // multi line comment found
                                stack.pop();
                                stack.push("/*");
                                inComment = true;
                            }else{
                                // no comment started, remove the single slash
                                stack.pop();
                            }
                        }else if(line.charAt(i) == '{' || line.charAt(i) == '[' || line.charAt(i) == '/'){
                            stack.push(""+line.charAt(i));  //push opening symbol to stack
                        } else if(line.charAt(i) == '}' || line.charAt(i) == ']' ){    //closing symbol ] or }
                            if(stack.isEmpty()){
                                System.out.println(line.charAt(i)+"Error: found closing symbol '"+line.charAt(i)+"' at line "+currentLine+" but there is no opening symbols");
                                compiled = false;
                            }else{
                                String closingSymbol = ""+line.charAt(i);
                                String topOfStack = stack.pop();
                                if(closingSymbol.equals("}") && !topOfStack.equals("{")){
                                    //incorrect closing symbol
                                    System.out.println("Error: found closing symbol '"+line.charAt(i)+"' at line "+currentLine+" but it does not match last opening symbol");
                                    compiled = false;
                                }else if(closingSymbol.equals("]") && !topOfStack.equals("[")){
                                    System.out.println("Error: found closing symbol '"+line.charAt(i)+"' at line "+currentLine+" but it does not match last opening symbol");
                                    compiled = false;
                                }
                            }

                        }
                    }else{
                        //in a comment (/**/)
                        if(stack.peek().equals("*")) {
                            if (line.charAt(i) == '/') {//found closing comment symbol
                                stack.pop(); //remove star
                                stack.pop(); //remove start of comment symbol
                                inComment = false;
                            }else{
                                //was no attempt to close the comment, remove star
                                stack.pop();
                            }
                        }
                        if(line.charAt(i) == '*'){
                            stack.push("*");
                        }
                    }
                }
                if(!stack.isEmpty() && stack.peek().equals("//")){
                    //new line, remove line comment
                    stack.pop();
                    inComment = false;
                }
                if (!inComment && !stack.isEmpty()) {
                    //symbols left from line
                    System.out.println("Error: all symbols were not closed at line "+currentLine);
                    compiled = false;
                    stack.clear();
                }
            }
            if(!stack.isEmpty()){
                System.out.println("Error: multiline comment started but reached end of file before it was closed");
                compiled = false;
            }

            if(compiled){
                System.out.println("No errors");
            }else{
                System.out.println("One or more errors");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void verifyCPlusPlus(String file){
        Stack<String> stack = new Stack<>();
        int currentLine = 0;
        boolean compiled = true;
        try {
            Scanner input = new Scanner(new File(file));
            boolean inComment = false;
            while(input.hasNext()){
                String line = input.nextLine();
                currentLine++;
                for(int i = 0; i < line.length(); i++){  //check each char in line
                    if(!inComment){
                        //check if there was an attempt to start a comment (stack top element should be /)
                        if(!stack.isEmpty() && stack.peek().equals("/")){
                            if(line.charAt(i) ==  '/'){
                                // double slash comment found, remove the single slash and add the dual slash symbol to stack
                                stack.pop();
                                stack.push("//");
                                inComment = true;
                            }else{
                                // no comment started, remove the single slash
                                stack.pop();
                            }
                        }else if(line.charAt(i) == '{' || line.charAt(i) == '[' || line.charAt(i) == '(' || line.charAt(i) == '/'){
                            stack.push(""+line.charAt(i));  //push opening symbol to stack
                        } else if(line.charAt(i) == '}' || line.charAt(i) == ']' || line.charAt(i) == ')'){    //closing symbol ], } or )

                            if(stack.isEmpty()){
                                System.out.println(line.charAt(i)+"Error: found closing symbol '"+line.charAt(i)+"' at line "+currentLine+" but there is no opening symbols");
                                compiled = false;
                            }else{
                                String closingSymbol = ""+line.charAt(i);
                                String topOfStack = stack.pop();
                                if(closingSymbol.equals("}") && !topOfStack.equals("{")){
                                    //incorrect closing symbol
                                    System.out.println("Error: found closing symbol '"+line.charAt(i)+"' at line "+currentLine+" but it does not match last opening symbol");
                                    compiled = false;
                                }else if(closingSymbol.equals("]") && !topOfStack.equals("[")){
                                    System.out.println("Error: found closing symbol '"+line.charAt(i)+"' at line "+currentLine+" but it does not match last opening symbol");
                                    compiled = false;
                                }else if(closingSymbol.equals(")") && !topOfStack.equals("(")){
                                    System.out.println("Error: found closing symbol '"+line.charAt(i)+"' at line "+currentLine+" but it does not match last opening symbol");
                                    compiled = false;
                                }
                            }
                        }
                    }
                }

                if(!stack.isEmpty() && stack.peek().equals("//")){
                    //new line, remove line comment
                    stack.pop();
                    inComment = false;
                }
                if (!inComment && !stack.isEmpty()) {
                    //symbols left from line
                    System.out.println("Error: all symbols were not closed at line "+currentLine);
                    compiled = false;
                    stack.clear();
                }
            }

            if(compiled){
                System.out.println("No errors");
            }else{
                System.out.println("One or more errors");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}




