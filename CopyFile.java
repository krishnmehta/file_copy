import java.util.*;
import java.io.*;

public class CopyFile {

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the InputPath of the file: ");
        String inputPath=sc.nextLine();
        System.out.println("Enter the OutputPath of the file: ");
        String outputPath=sc.nextLine();
        System.out.println("Enter File Name: ");
        String fileName=sc.nextLine();
        fileCopy(inputPath, outputPath, fileName);



    }
    static void fileCopy(String inputPath,String outputPath,String fileName) throws FileNotFoundException, IOException
    {

        File inputfile=new File(inputPath+"\\"+fileName);
        File outputfile=new File(outputPath+"\\"+fileName);
        File temp=null;
        FileReader readFile=null;
        FileWriter writeFile=null;

        readFile = new FileReader(inputPath+"\\"+fileName);

        if(inputfile.exists()){
            if(outputfile.exists()){

                temp = new File(outputPath+"\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy"+fileName.substring(fileName.indexOf("."),fileName.length()));

                if(temp.exists()){
                    int i=2;
                    int k;
                    while(true){
                        temp = new File(outputPath+"\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy ("+i+")"+fileName.substring(fileName.indexOf("."),fileName.length()));
                        if(!temp.exists()){
                            break;
                        }
                        i++;
                    }
                    writeFile = new FileWriter(outputPath+"\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy ("+i+")"+fileName.substring(fileName.indexOf("."),fileName.length()));
                    while((k=readFile.read())!=-1){
                        writeFile.write(k);
                    }
                    System.out.println("Success");
                }else{
                    int a;
                    writeFile = new FileWriter(outputPath+"\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy"+fileName.substring(fileName.indexOf("."),fileName.length()));
                    while((a=readFile.read())!=-1){
                        writeFile.write(a);
                    }
                    System.out.println("Success");
                }
            }else{
                int a;
                writeFile = new FileWriter(outputPath+"\\"+fileName);
                while((a=readFile.read())!=-1){
                    writeFile.write(a);
                }
                System.out.println("Success.");
            }
        }else{
            System.out.println("Not exist.");
        }

        readFile.close();
        writeFile.close();

    }
}