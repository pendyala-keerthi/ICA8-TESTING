import java.util.Scanner;

public class urinals {
    public static void main(String[] args) {

    }
    public static boolean goodString(String str){
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='0' || str.charAt(i)=='1')
            {
                if(i>0 && str.charAt(i)=='1' && str.charAt(i-1)=='1')
                {
                    return false;

                }
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static int urinalscount(String str)
    {
        int[]a=new int[str.length()];
        for(int i=0;i<a.length;i++)
        {
            a[i]=0;
        }
        for(int i=0;i<str.length();i++)
        {
            if(i==0)
            {
                if(str.charAt(i)=='0')
                {
                    if(i+1<str.length()) {
                        if (str.charAt(i + 1) == '1') {
                            a[i] = 0;
                        } else {
                            a[i] = 1;
                        }
                    }
                }
                else {
                    a[i]=0;
                }
            }
            else if(i==1)
            {
                if(str.charAt(i)=='1') {
                    a[i] = a[i - 1];
                }
                else
                {
                    if(str.charAt(i-1)=='1')
                    {
                        a[i]=a[i-1];
                    }
                    else if(i+1<str.length() && str.charAt(i+1)=='1')
                    {
                        a[i]=a[i-1];
                    }
                    else
                    {
                        a[i]=1;
                    }
                }
            }
            else {
                a[i]=a[i-1];
                if(str.charAt(i)=='1') {
                    a[i] = a[i - 1];
                }
                else
                {
                    if(str.charAt(i-1)=='1')
                    {
                        a[i]=a[i-1];
                    }
                    else if(i+1<str.length() && str.charAt(i+1)=='1')
                    {
                        a[i]=a[i-1];
                    }
                    else
                    {
                        a[i]=Math.max(a[i],1+a[i-2]);
                    }
                }
            }
        }
        return a[str.length()-1];
    }
    public static String getString(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String str=sc.next();
        return str;
    }

}


