package com.decodejava.dsa.arrays.patterns;

public class Patterns {

//            *
//            * *
//            * * *
    public static void nForest(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

//            1
//            1 2
//            1 2 3
    public static void nTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

//        1
//        2 2
//        3 3 3
    public static void nTriangle2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

//            * * *
//            * *
//            *
    public static void seeding(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n - i + 1; j >= 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    //    *
    //   ***
    //  *****
    public static void nStarTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i ; j++) {
                System.out.print("*");
            }
            for(int j = 1; j<i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

//       *****
//        ***
//         *
    public static void nStarTriangle2(int n) {
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j<i; j++)
                System.out.print(" ");
            for (int j = 1; j <= n-i+1 ; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

//               *
//              ***
//             *****
//             *****
//              ***
//               *
    public static void nStarDiamond(int n) {
        nStarTriangle(n);
        nStarTriangle2(n);
    }



    //      *
    //      **
    //      ***
    //      **
    //      *
    public static void nStarTriangle3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j >= 1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

//              4444444
//              4333334
//              4322234
//              4321234
//              4322234
//              4333334
//              4444444
    public static void getNumberPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(n - j + 1);
            }
            for (int j = 1; j < n; j++) {
                System.out.print(n - i + 1);
            }
        }
    }
}
