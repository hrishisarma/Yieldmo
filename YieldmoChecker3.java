package logmein;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Hrishikesh
 */
public class YieldmoChecker3 {

    public static ArrayList<String> letterCombinations(String digits, Set arr2) {
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        hmap.put(0, "abc");
        hmap.put(1, "def");
        hmap.put(2, "ghij");
        hmap.put(3, "klm");
        hmap.put(4, "nop");
        hmap.put(5, "qrst");
        hmap.put(6, "uv");
        hmap.put(7, "w");
        hmap.put(8, "xy");
        hmap.put(9, "z");

        ArrayList<String> checker = new ArrayList<String>();

        if (digits == null || digits.length() == 0) {
            return checker;
        }

        ArrayList<Character> temp = new ArrayList<Character>();
        createString(digits, temp, checker, hmap,arr2);

        return checker;
    }

    public static void createString(String digits, ArrayList<Character> temp, ArrayList<String> result, HashMap<Integer, String> map, Set arr2) {
        if (digits.length() == 0) {
            char[] arr = new char[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                arr[i] = temp.get(i);
            }
            if(!arr2.add(String.valueOf(arr))) 
                result.add(String.valueOf(arr));
            return;
        }

        Integer curr = Integer.valueOf(digits.substring(0, 1));
        String letters = map.get(curr);
        for (int i = 0; i < letters.length(); i++) {
            temp.add(letters.charAt(i));
            createString(digits.substring(1), temp, result, map, arr2);
            temp.remove(temp.size() - 1);
        }
    }
    
    public static Set getFileWords(){
        String fileName = "C:\\Users\\Hrishikesh\\Documents\\NetBeansProjects\\Logmein\\src\\logmein\\check.txt";
        String line = null;
        
        Set<String> arr = new HashSet<>();
        
        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                arr.add(line.trim());
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
        }
        return arr;
    }

    public static void main(String args[]) {
        
        int n = 9012;
        
        String num = Integer.toString(n);
        
        Set<String> arr = getFileWords();
        ArrayList<String> arr2 = letterCombinations(num,arr);
        System.out.println("Dictionary Words : "+arr);
        System.out.println("Common words: "+arr2);

    }
}


