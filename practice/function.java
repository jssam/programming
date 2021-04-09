public class function {
    //////////////// normal stack
    public static class CustomStack {
        int[] data;
        int tos;

        public CustomStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        int size() {
            return tos + 1;
        }

        void display() {
            for (int i = tos; i >= 0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        void push(int val) {
            if (size() < data.length) {
                tos++;
                data[tos] = val;
            } else {
                System.out.println("Stack overflow");
                return;
            }
        }

        int pop() {
            if (tos != -1) {
                tos--;
                return data[tos + 1];
            } else {
                System.out.println("Stack underflow");
                return -1;
            }
        }

        int top() {
            if (tos != -1) {
                return data[tos];
            } else {
                System.out.println("Stack underflow");
                return -1;
            }
        }

        /////// dynamic stack
        void pushdynamic(int val) {
            if (tos == data.length - 1) {
                int s = size() * 2;
                int arr[] = new int[s];
                for (int i = 0; i < data.length; i++) {
                    arr[i] = data[i];
                }
                data = arr;
            }
            tos++;
            data[tos] = val;
        }

        //////////// Normal queue////
public CustomQueue(int cap) {
    data = new int[cap];
    front = 0;
    size = 0;
  }

        int size() {
            return this.size;
        }

        void display() {
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % data.length;
                System.out.print(data[idx] + " ");
            }
            System.out.println();
        }

        void add(int val) {
            if (size == data.length) {
                System.out.println("Queue overflow");
                return;
            }
            int idx = (front + size) % data.length;
            data[idx] = val;
            size++;

        }

        int remove() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            }
            int val = data[front];
            data[front] = 0;
            front = (front + 1) % data.length;
            size--;
            return val;
        }

        int peek() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            }
            return data[front];
        }

        ////////////// dynamic queue
        void add_dynamic(int val) {
            // write ur code here
            if (size == data.length) {
                int arr[] = new int[data.length * 2];
                for (int i = 0; i < data.length; i++) {
                    arr[i] = data[(front + i) % data.length];
                }
                front = 0;
                arr[size] = val;
                data = arr;
                size++;
            } else {
                int idx = (front + size) % data.length;
                data[idx] = val;
                size++;
            }
        }

        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            String exp = scn.nextLine();

            System.out.println(isDuplicate(exp));

        }

        ///////////// stack dublicates bracket /////
        public static boolean isDuplicate(String exp) {
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < exp.length(); i++) {
                if (exp.charAt(i) != ')') {
                    st.push(exp.charAt(i));
                } else if (exp.charAt(i) == ')') {
                    if (st.peek() == '(') {
                        return true;
                    } else {
                        while (st.peek() != '(') {
                            st.pop();
                        }
                        st.pop();
                    }
                }
            }
            return false;
        }

        /////// Balanced brackets
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            String exp = scn.nextLine();
            System.out.println(isBalance(exp));
        }

        public static boolean isBalance(String exp) {
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < exp.length(); i++) {
                if (exp.charAt(i) == '(' || exp.charAt(i) == '[' || exp.charAt(i) == '{') {
                    st.push(exp.charAt(i));
                } else if (exp.charAt(i) == ')' || exp.charAt(i) == '}' || exp.charAt(i) == ']') {
                    if (st.size() == 0) {
                        return false;
                    }
                    if ((exp.charAt(i) == ')' && st.peek() != '(') || (exp.charAt(i) == ']' && st.peek() != '[')
                            || (exp.charAt(i) == '}' && st.peek() != '{')) {
                        return false;
                    } else {
                        st.pop();
                    }
                }
            }
            if (st.size() != 0) {
                return false;
            }
            return true;
        }

        //////////// next greator element official
        public static int[] solve(int[] arr) {
            int n = arr.length - 1;
            int data[] = new int[n + 1];
            data[n] = -1;
            Stack<Integer> st = new Stack<>();
            st.push(arr[n]);
            for (int i = n - 1; i >= 0; i--) {
                while (st.size() != 0 && arr[i] >= st.peek()) {
                    st.pop();
                }
                if (st.size() == 0) {
                    data[i] = -1;
                } else {
                    data[i] = st.peek();
                }
                st.push(arr[i]);
            }
            return data;
        }

        ///////// stock span
        public static int[] solve(int[] arr) {
            int data[] = new int[arr.length];
            Stack<Integer> sr = new Stack<>();
            data[0] = 1;
            sr.push(0);
            for (int i = 1; i < arr.length; i++) {
                while (sr.size() != 0 && arr[i] >= arr[sr.peek()]) {
                    sr.pop();
                }
                if (sr.size() == 0) {
                    data[i] = i + 1;
                } else {
                    data[i] = i - sr.peek();
                }
                sr.push(i);
            }
            return data;
        }

        //////////// postfix evolution
        public static void main(String[] args) throws Exception {
            Scanner scn = new Scanner(System.in);
            String exp = scn.nextLine();
            solve(exp);
        }

        public static void solve(String exp) {
            Stack<Integer> eval = new Stack<>();
            Stack<String> pre = new Stack<>();
            Stack<String> in = new Stack<>();
            for (int i = 0; i < exp.length(); i++) {
                char c = exp.charAt(i);
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    evalfun(eval, c);
                    prefun(pre, c);
                    infun(in, c);

                } else {
                    eval.push(Integer.parseInt(c + ""));
                    pre.push(c + "");
                    in.push(c + "");
                }
            }
            System.out.println(eval.pop());
            System.out.println(in.pop());
            System.out.println(pre.pop());
        }

        public static void evalfun(Stack<Integer> eval, char c) {
            int v2 = eval.pop();
            int v1 = eval.pop();
            if (c == '+') {
                eval.push(v1 + v2);
            } else if (c == '-') {
                eval.push(v1 - v2);
            } else if (c == '*') {
                eval.push(v1 * v2);
            } else if (c == '/') {
                eval.push(v1 / v2);
            }
        }

        public static void prefun(Stack<String> eval, char c) {
            String v2 = eval.pop();
            String v1 = eval.pop();
            eval.push(c + v1 + v2);

        }

        public static void infun(Stack<String> eval, char c) {
            String v2 = eval.pop();
            String v1 = eval.pop();
            eval.push("(" + v1 + c + v2 + ")");
        }
    }

    /////////////// prefix evolution
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        solve(exp);
    }

    public static void solve(String exp) {
        Stack<Integer> eval = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<String> in = new Stack<>();
        int j = exp.length();
        for (int i = j - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                evalfun(eval, c);
                prefun(pre, c);
                infun(in, c);

            } else {
                eval.push(Integer.parseInt(c + ""));
                pre.push(c + "");
                in.push(c + "");
            }
        }
        System.out.println(eval.pop());
        System.out.println(in.pop());
        System.out.println(pre.pop());
    }

    public static void evalfun(Stack<Integer> eval, char c) {
        int v1 = eval.pop();
        int v2 = eval.pop();
        if (c == '+') {
            eval.push(v1 + v2);
        } else if (c == '-') {
            eval.push(v1 - v2);
        } else if (c == '*') {
            eval.push(v1 * v2);
        } else if (c == '/') {
            eval.push(v1 / v2);
        }
    }

    public static void prefun(Stack<String> eval, char c) {
        String v1 = eval.pop();
        String v2 = eval.pop();
        eval.push(v1 + v2 + c);

    }

    public static void infun(Stack<String> eval, char c) {
        String v1 = eval.pop();
        String v2 = eval.pop();
        eval.push("(" + v1 + c + v2 + ")");
    }

}

    /////////////// infix
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();

        System.out.println(evaluate(exp));
    }

    public static int evaluate(String exp) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int idx = 0; idx < exp.length(); idx++) {
            char ch = exp.charAt(idx);

            if (ch == '(') {
                operators.push(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '('
                        && precedence(operators.peek()) >= precedence(ch)) {
                    char op = operators.pop();
                    int v2 = operands.pop(), v1 = operands.pop();

                    if (op == '+')
                        operands.push(v1 + v2);
                    else if (op == '-')
                        operands.push(v1 - v2);
                    else if (op == '/')
                        operands.push(v1 / v2);
                    else if (op == '*')
                        operands.push(v1 * v2);
                }

                operators.push(ch);

            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    char op = operators.pop();
                    int v2 = operands.pop(), v1 = operands.pop();

                    if (op == '+')
                        operands.push(v1 + v2);
                    else if (op == '-')
                        operands.push(v1 - v2);
                    else if (op == '/')
                        operands.push(v1 / v2);
                    else if (op == '*')
                        operands.push(v1 * v2);
                }

                operators.pop(); // opening bracket

            } else if (ch >= '0' && ch <= '9') {
                operands.push(Integer.parseInt(ch + ""));
            }
        }

        while (operators.size() > 0) {
            char op = operators.pop();
            int v2 = operands.pop(), v1 = operands.pop();

            if (op == '+')
                operands.push(v1 + v2);
            else if (op == '-')
                operands.push(v1 - v2);
            else if (op == '/')
                operands.push(v1 / v2);
            else if (op == '*')
                operands.push(v1 * v2);
        }

        return operands.pop();
    }

    public static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 2;
        } else {
            // if(op == '*' || op == '/')
            return 4;
        }
    }
}}}
