package company.google;

public class LicenseKeyFormatting {
        public String licenseKeyFormatting(String s, int k) {
            // first clean string (remove -), string.replace('')
            // get string length / k = m
            // get string length % k = r

            if(s.length() < 1 || s.length() > 100000 || k < 1 || k > 100000) {
                return null;
            }

            s = s.replace("-", "").toUpperCase();

            // handle exception
            for(int i = 0 ; i < s.length(); i++) {
                if(!Character.isLetterOrDigit(s.charAt(i))) {
                    return null;
                }
            }
            if (s.length() <= k) {
                return s;
            }
            int n = s.length();
            int r = n % k;

            StringBuilder sb = new StringBuilder();

            if(r > 0) {
                sb.append(s, 0, r);
                sb.append("-");
            }

            for (int i = r; i < n;) {
                sb.append(s, i, i + k);
                i = i + k;
                if(i < n) {
                    sb.append("-");
                }
            }
           return sb.toString();
        }


        public static void main(String[] args) {
            LicenseKeyFormatting lkf = new LicenseKeyFormatting();
            System.out.println(lkf.licenseKeyFormatting("5F3Z-2e-9-w", 4));
            System.out.println(lkf.licenseKeyFormatting("2-5g-3-J", 2));
            System.out.println(lkf.licenseKeyFormatting("2-4A0r7-4k", 3));
        }
}


