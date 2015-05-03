package src.main.java;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * <p>
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String s : strings) {
            if (!s.isEmpty()) {
                if(s.equals(".")) {
                    continue;
                }else if(s.equals("..")) {
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                }else {
                    stack.push(s);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Stack<String> reverseStack = new Stack<>();
        while(!stack.isEmpty()) {
            reverseStack.push(stack.pop());
        }
        while(!reverseStack.isEmpty()) {
            sb.append("/");
            sb.append(reverseStack.pop());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }


    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/home/"));
        System.out.println(simplifyPath.simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath.simplifyPath("/a/./b/c/d/c/"));


    }
}
