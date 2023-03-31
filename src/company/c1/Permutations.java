package company.c1;

import java.util.HashSet;

public class Permutations {

    // Function to print all the permutations of str
    static void getAllPermutn(String str, String ans, HashSet<String> set)
    {

        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            set.add(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recursive call
            getAllPermutn(ros, ans + ch, set);
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        String s = "abb";
        getAllPermutn(s, "", new HashSet<>());
    }
}
