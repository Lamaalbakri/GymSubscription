package gymsubscription;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
  Programmer: Lama Albakri 
  Gym Subscription System
*/
public class dataFromFile {
    public static dataFromFile d;

    private String fileID;
    private String filename;
    private String fileNum;
    private String fileGen;
    private String fileStype;
    private String fileClasses;
    private String filePrice;
    private File f;
    private boolean have_account = false;
    private boolean have_sub = false;

    public dataFromFile() {

    }
    public void fill(){
        d=new dataFromFile();
        d.setFileID(fileID);
        d.setFilename(filename);
        d.setFileNum(fileNum);
        d.setFileGen(fileGen);
        d.setFileStype(fileStype);
        d.setFileClasses(fileClasses);
        d.setFilePrice(filePrice);
        d.sethave_sub(have_sub);
    }
  
    public void setFileID(String fileID) {
        this.fileID = fileID;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setFileNum(String fileNum) {
        this.fileNum = fileNum;
    }

    public void setFileGen(String fileGen) {
        this.fileGen = fileGen;
    }

    public void setFileStype(String fileStype) {
        this.fileStype = fileStype;
    }

    public void setFileClasses(String fileClasses) {
        this.fileClasses = fileClasses;
    }

    public void setFilePrice(String filePrice) {
        this.filePrice = filePrice;
    }
     public void sethave_sub(boolean have_sub) {
        this.have_sub = have_sub;
    }

    public String getFileID() {
        return fileID;
    }

    public String getFilename() {
        return filename;
    }

    public String getFileNum() {
        return fileNum;
    }

    public String getFileGen() {
        return fileGen;
    }

    public String getFileStype() {
        return fileStype;
    }

    public String getFileClasses() {
        return fileClasses;
    }

    public String getFilePrice() {
        return filePrice;
    }

    public boolean gethave_account() {
        return have_account;
    }
    public boolean getsub_account() {
        return have_sub;
    }

    public boolean check(String text2) throws FileNotFoundException {
        String id = text2;
        f = new File("account.txt");
        Scanner output = new Scanner(f);
        boolean flag = false;
        String input = null;

        while (output.hasNext() && flag == false) {
            input = output.nextLine();
            if (!input.startsWith("*")) {
                continue;
            }
            input = input.substring(1);
            if (id.equals(input)) {
                flag = true;
                have_account = true;
            }
        }
            return have_account;
        }
    
    public void validation(String text2) throws FileNotFoundException, IOException, Exception {

        String id = text2;
        f = new File("account.txt");
        Scanner output = new Scanner(f);
        boolean flag = false;
        String input = null;

        while (output.hasNext() && flag == false) {
            input = output.nextLine();
            if (!input.startsWith("*")) {
                continue;
            }
            input = input.substring(1);
            if (id.equals(input)) {
                flag = true;
            }
        }
        if (flag) {
            setFileID(input);
            setFilename(output.nextLine().replace("Name:", ""));
            setFileNum(output.nextLine().replace("Phone number:", ""));
            setFileGen(output.nextLine().replace("Gender:", ""));
            if (output.hasNext()) {
                input=output.nextLine();
                if(!input.startsWith("*")){
                setFileStype(input.replace("Subscription Type:", ""));
                setFileClasses(output.nextLine().replace("Classes:", ""));
                setFilePrice(output.nextLine().replace("Price:", ""));
                }            
            }
            have_account = true;
        } else {
            JOptionPane.showMessageDialog(null, "you dont have an account!", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
    }
 public void editSub(String sub ,String classes , String price) throws FileNotFoundException, IOException 
    {
        List<String> lines = Files.readAllLines(Paths.get("account.txt"));  
        for (int i = 0 ; i < lines.size();i++)
        {
            if (lines.get(i).startsWith("*"))
            {
                if(dataFromFile.d.fileID.equals(lines.get(i).substring(1)))
                {    
                    //add the updet guests number
                    lines.add (i + 4 , ("Subscription Type:" + sub));
                    lines.add (i + 5 , ("Classes:" + classes));
                    lines.add (i + 6 , ("Price:" + price));

                   d.setFileStype(sub);
                   d.setFileClasses(classes);
                   d.setFilePrice(price);
                    break;
                }
            }
        }
        PrintWriter inputFile = new PrintWriter("account.txt");
        for (String element : lines)
            inputFile.println(element);
        inputFile.close();
    }
}