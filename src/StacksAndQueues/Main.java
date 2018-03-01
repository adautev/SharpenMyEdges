package StacksAndQueues;

import SortingAlgorithms.InsertSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        StackLL<String> stack = new StackLL<String>();
        stack.Push("backwards!");
        stack.Push("forward");
        //Ooops!
        stack.Pop();
        stack.Push("spelled ");
        stack.Push("are");
        //Oops!
        stack.Pop();
        stack.Push("is ");
        stack.Push("sentence ");
        stack.Push("This ");

        StringBuilder stackLLresult = new StringBuilder();
        while (!stack.isEmpty()) {
            stackLLresult.append(stack.Pop());
        }
        if(!stackLLresult.toString().trim().equals("This sentence is spelled backwards!")) {
            throw new Exception("You couldn't manage ONE stack!");
        }

        System.out.println("Stacks and queues tests completed successfully.");
    }

}
