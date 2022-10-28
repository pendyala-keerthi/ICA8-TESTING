import java.util.Scanner;

public class urinals {
    public static void main(String[] args) {
        String str= getString();
        boolean x=goodString(str);
        if(x==false)
        {
            System.out.println("invalid string, printing -1");
        }
        else {
            int y=urinalscount(str);
            System.out.println(y);
        }

    }
    public static boolean goodString(String str){
        for(int k=0;k<str.length();k++)
        {
            if(str.charAt(k)=='0' || str.charAt(k)=='1')
            {
                if(k>0 && str.charAt(k)=='1' && str.charAt(k-1)=='1')
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
        for(int k=0;k<a.length;k++)
        {
            a[k]=0;
        }
        for(int k=0;k<str.length();k++)
        {
            if(k==0)
            {
                if(str.charAt(k)=='0')
                {
                    if(k+1<str.length()) {
                        if (str.charAt(k + 1) == '1') {
                            a[k] = 0;
                        } else {
                            a[k] = 1;
                        }
                    }
                }
                else {
                    a[k]=0;
                }
            }
            else if(k==1)
            {
                if(str.charAt(k)=='1') {
                    a[k] = a[k - 1];
                }
                else
                {
                    if(str.charAt(k-1)=='1')
                    {
                        a[k]=a[k-1];
                    }
                    else if(k+1<str.length() && str.charAt(k+1)=='1')
                    {
                        a[k]=a[k-1];
                    }
                    else
                    {
                        a[k]=1;
                    }
                }
            }
            else {
                a[k]=a[k-1];
                if(str.charAt(k)=='1') {
                    a[k] = a[k - 1];
                }
                else
                {
                    if(str.charAt(k-1)=='1')
                    {
                        a[k]=a[k-1];
                    }
                    else if(k+1<str.length() && str.charAt(k+1)=='1')
                    {
                        a[k]=a[k-1];
                    }
                    else
                    {
                        a[k]=Math.max(a[k],1+a[k-2]);
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


