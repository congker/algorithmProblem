package main.java;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcmTest {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> result = new ArrayList<>();
        String[] sensitiveWord = scan.nextLine().split(" ");
        while(true)
        {
            String sinput = scan.nextLine();
            if (!sinput.equals("0"))
            {
                String out = dealSpeak(sinput);
                if (!out.equals(sinput))
                {
                    result.add(sensitive(out, sensitiveWord));
                }
            }
            else
            { break; }
        }
        scan.close();
        for (String out : result)
        {
            System.out.println(out);
        }
    }

    public static String dealSpeak(String origin)
    {
        String p = "(\"([^\"]*)\")" + "|(?<=say that | says that | said that).*?(?=[.!])";
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(origin);
        if (matcher.find())
        {
            return matcher.group(0);
        }
        return origin;
    }

    public static String sensitive(String origin, String[] sensitiveWord)
    {
        String [] originWord = origin.split(" ");
        int length = originWord.length;
        for(String word : sensitiveWord)
        {
            StringBuilder p = new StringBuilder();
            for(int i=0;i< word.length();i++)
            {
                p.append(word.charAt(i)).append("+");
            }
            System.out.println(p);
            for (int i=0; i<length; i++)
            {
                Pattern pattern = Pattern.compile(p.toString().toLowerCase());
                Matcher matcher = pattern.matcher(originWord[i].toLowerCase());
                if (matcher.find())
                {
                    originWord[i] = "***";
                }
            }
        }
        return String.join(" ",originWord);
    }
}
