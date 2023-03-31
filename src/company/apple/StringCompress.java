package company.apple;

public class StringCompress {

    public int sizeOfCompressedString(char[] input) {
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            while (i < input.length && input[i] == input[i+1]) {
                count++;
                i++;
            }

            if (count == 1) {
                sb.append(input[i]);
            } else {
                sb.append(input[i]);
                sb.append(count);
            }
        }
        return sb.length();
    }
}
