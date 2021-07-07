public class Main {

    public static void main(String[] args) {
        String word = "string";
        twist(word);
    }

    //Программа для чтения справа налево.
    public static void twist(String word){
        MyStack stack = new MyStack();
        char[] strToArray = word.toCharArray();

        for (int i = 0; i < strToArray.length; i++) {
            stack.push(strToArray[i]);
        }

        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.pop());
        }
    }
}
