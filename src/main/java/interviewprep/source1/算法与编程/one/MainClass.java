package interviewprep.source1.算法与编程.one;

import java.io.FileWriter;

/**
 * Created by jianshen on 1/16/17.
 */
public class MainClass {
    public static void main(String[] args) throws Exception{
        FileManager a= new FileManager("a.txt",new char[]{'\n'});
        FileManager b= new FileManager("b.txt",new char[]{'\n',' '});
        FileWriter c= new FileWriter("c.txt");
        String aWord= null;

        String bWord= null;
        while((aWord= a.nextWord()) !=null ){
            c.write(aWord+ "\n");
            bWord= b.nextWord();
            if(bWord!= null)
                c.write(bWord+ "\n");
        }

        while((bWord= b.nextWord()) != null){
            c.write(bWord+ "\n");
        }
        c.close(); }
}
