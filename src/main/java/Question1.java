public class Question1 {

    /*
      // palaindrome check
      // time and space : 0(n)
     */
    public static boolean checkPalaindrome(String s) {
        if (s == null) return false;
        String refinedString  = s.toLowerCase()
                .replaceAll(" ","")
                .replaceAll("[^a-z]", "");
        int i =0;
        int j = refinedString.length() -1;
        while (i < j) {
            if (refinedString.charAt(i) != refinedString.charAt(j)) {
                return false;
            }
            i++ ; j--;
        }
        return true;
    }
}

