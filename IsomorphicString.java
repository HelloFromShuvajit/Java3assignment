import java.util.Scanner;

public class IsomorphicString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String s1 = sc.nextLine();
        System.out.println("Enter the second string: ");
        String s2 = sc.nextLine();
        sc.close();
        if(isIsomorphic(s1, s2)){
            System.out.println("The entered strings are isomorphic.");
        } else{
            System.out.println("The entered strings are not isomorphic.");
        }
    }
    public static boolean isIsomorphic(String s1, String s2){
        boolean result= true;
        int s1length = s1.length();
        int s2length = s2.length();
        if(s1length != s2length){
            result = false;
            System.out.println("length does not match.");
        }else{
            int mapS1tos2[] = new int[256];
            int mapS2tos1[] = new int[256];
            for(int i=0; i<256; i++){
                mapS1tos2[i] = -1;
                mapS2tos1[i] = -1;
            }
            for(int i=0; i<s1length; i++){
                char chars1 = s1.charAt(i);
                char chars2 = s2.charAt(i);
                 if(mapS1tos2[chars1] == -1 && mapS2tos1[chars2] == -1){
                    mapS1tos2[chars1] = chars2;
                    mapS2tos1[chars2] = chars1;
                    result = true;
                 } else{
                    if(mapS1tos2[chars1] !=chars2 && mapS2tos1[chars2] != chars1){
                        result =false;
                        break;
                    }
                 }
                 }
            }
             return result;   
            }

    }

