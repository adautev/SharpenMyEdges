package StacksAndQueues;

import SortingAlgorithms.InsertSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        StackLL<String> stackLL = new StackLL<String>();
        stackLL.Push("backwards!");
        stackLL.Push("forward");
        //Ooops!
        stackLL.Pop();
        stackLL.Push("spelled ");
        stackLL.Push("are");
        //Oops!
        stackLL.Pop();
        stackLL.Push("is ");
        stackLL.Push("sentence ");
        stackLL.Push("This ");

        StringBuilder stackLLresult = new StringBuilder();
        for(String s : stackLL) {
            stackLLresult.append(s);
        }
        if(!stackLLresult.toString().trim().equals("This sentence is spelled backwards!")) {
            throw new Exception("You couldn't manage ONE stack!");
        }
        StackAR<String> stackAR = new StackAR<String>();
        stackAR.Push("backwards!");
        stackAR.Push("forward");
        //Ooops!
        stackAR.Pop();
        stackAR.Push("spelled ");
        stackAR.Push("are");
        //Oops!
        stackAR.Pop();
        stackAR.Push("is ");
        stackAR.Push("sentence ");
        stackAR.Push("This ");
        StringBuilder stackARresult = new StringBuilder();
        for (String s : stackAR) {
            stackARresult.append(s);
        }
        if(!stackARresult.toString().trim().equals("This sentence is spelled backwards!")) {
            throw new Exception("You couldn't manage ONE stack!");
        }
        System.out.println("Stacks and queues tests completed successfully.");
    }

}
