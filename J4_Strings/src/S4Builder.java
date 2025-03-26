package J4_Strings.src;

public class S4Builder {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            char ch=(char)('a'+i);
            sb.append(ch);
        }

        System.out.println(sb.toString());

        sb.deleteCharAt(0);//to delete at specified position

        sb.delete(0,5);//delete elts from 0 to 4 positions

        System.out.println(sb.toString());

        System.out.println(sb.indexOf("z"));//return position of z

        System.out.println(sb.charAt(18));//return char at position 18

        pattern1(4);
        pattern2(4);
        pattern3(4);
        System.out.println();
        pattern4(4);
    }

    static void pattern1(int totalrows){

        for(int row=0;row<2*totalrows;row++){
            int printableCol = (row > totalrows) ? 2*totalrows-row : row;

            for(int col=0;col<printableCol;col++){
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    static void pattern2(int totalrows){

        for(int row=0;row<2*totalrows;row++){
            int printableCol = (row > totalrows) ? 2*totalrows-row : row;

            int printablespace=totalrows-printableCol;
            for(int space=0;space<printablespace;space++){
                System.out.print(" ");
            }

            for(int col=0;col<printableCol;col++){
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    static void pattern3(int totalrows){
        int n=2*totalrows;
        for(int row=0;row<=n;row++){
            for(int col=0;col<=n;col++){
                //value at each cell/box = min_distance_from(right-end,left-end,up,down)
                int cellValue=Math.min(Math.min(row,col),Math.min(n-row,n-col));
                System.out.print(cellValue+" ");
            }
            System.out.println();
        }
    }

    static void pattern4(int totalrows){
        int n=2*totalrows;
        for(int row=0;row<=n;row++){
            for(int col=0;col<=n;col++){
                //value at each cell/box = min_distance_from(right-end,left-end,up,down)
                int cellValue = totalrows - Math.min(Math.min(row,col),Math.min(n-row,n-col));
                System.out.print(cellValue+" ");
            }
            System.out.println();
        }
    }
}
