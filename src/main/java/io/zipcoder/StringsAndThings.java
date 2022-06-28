package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     * countYZ("day fez"); // Should return 2
     * countYZ("day fyyyz"); // Should return 2
     */
    //count the number of words ending in 'y' or 'z'
    //don't count the words that begin with 'y'
    //can use Character.isLetter(char) to test if a char is an alphabetic letter
    public Integer countYZ(String str) {
        int length = str.length();
        int count = 0;
        str = str.toLowerCase();

        for (int i = 0; i < length; i++) {

            if (str.charAt(i) == 'y' || str.charAt(i) == 'z') {
                if (i < length - 1 && !Character.isLetter(str.charAt(i + 1))) count++;
                else if (i == length - 1) count++;
            }
        }
        return count;
    }


    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * <p>
     * example : removeString("Hello there", "llo") // Should return "He there"
     * removeString("Hello there", "e") //  Should return "Hllo thr"
     * removeString("Hello there", "x") // Should return "Hello there"
     */

    //two string --> base & remove
    //return a version of the base string --> all instances of the remove string are removed (not case-sensitive)
    //assume remove string is length 1 or more
    //remove only non-overlapping instances --> xxx removing xx = x
    public String removeString(String base, String remove) {
        String result = "";
        for (int i = 0; i < base.length(); i += 1) {
            if ((i <= base.length() - remove.length()) && base.substring(i, i + remove.length()).equalsIgnoreCase(remove)) {
                i += remove.length() - 1;
            } else {
                result += base.charAt(i);
            }
        }

        return result;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     * <p>
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     * containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     * containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */

    //boolean true or false
    //true if # of appearances of "is" anywhere in the string = # of appearances of "not" anywhere in the string
    public Boolean containsEqualNumberOfIsAndNot(String str) {
        int length = str.length();
        int not = 0;
        int is = 0;

        for (int i = 0; i < length; i++) {
            if (i < length - 2) {
                String tmp = str.substring(i, i + 3);
                if (tmp.equals("not")) not++;
            }
            if (i < length - 1) {
                String tmp2 = str.substring(i, i + 2);
                if (tmp2.equals("is")) is++;
            }
        }
        if (not == is)
            return true;
        else {
        }
        return false;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     * gHappy("xxgxx") // Should return  false
     * gHappy("xxggyygxx") // Should return  false
     */

    //lowercase 'g' in a string is "happy" if there is another 'g' to its left or right
    //return true (boolean) if all the g's in the string are happy.
    //return false (boolean) if all the g's in the string are not happy
    public Boolean gIsHappy(String str) {
        int length = str.length();
        boolean happy = true;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == 'g') {
                if (i > 0 && str.charAt(i - 1) == 'g')
                    happy = true;
                else if (i < length - 1 && str.charAt(i + 1) == 'g')
                    happy = true;
                else
                    happy = false;
            }
        }
        return happy;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     * countTriple("xxxabyyyycd") // Should return 3
     * countTriple("a") // Should return 0
     */

    //triple --> char appearing 3 times in a row
    //return # of triples in a string (may overlap)
    //return an integer (int)

    public Integer countTriple(String str) {
        int count = 0;

        for (int i = 0; i <= str.length() - 3; i++) {
            if(str.charAt(i) == str.charAt(i + 1) &&
                    str.charAt(i) == str.charAt(i + 2))
                count++;
        }
        return count;
    }
}
