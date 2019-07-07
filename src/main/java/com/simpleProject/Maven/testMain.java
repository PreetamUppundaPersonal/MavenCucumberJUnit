package com.simpleProject.Maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;

public class testMain {
    public static void main(String[] Args) throws Throwable {
        File srcFolder = new File("D:\\AutomationProj\\darwin-automation_JavaCopyPaste");

        //Get list of records(TC IDs) from Policy.xlsx
        File fp = new File("D:\\AutomationProj\\Policy.xlsx");
        FileInputStream fpis = new FileInputStream(fp);
        Workbook workbook = WorkbookFactory.create(fpis);

        //open sheet "Business_Flow"
        Sheet sheet = workbook.getSheet("Business_Flow");

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        //To gather the list of TC IDs
        List<String> tcID = new ArrayList<String>();

        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            String cellValue = dataFormatter.formatCellValue(sheet.getRow(i).getCell(0));
            System.out.println();
            tcID.add(cellValue);
        }

        //Create the folder if it does not exist
        for (String folderName : tcID) {
            //make sure source exists
            if (!srcFolder.exists()) {
                System.out.println("Directory does not exist.");
                //just exit
                System.exit(0);
            } else {
                try {
                    copyFolder(srcFolder, new File("D:\\AutomationProj\\CopiedFolders\\" + folderName));
                } catch (IOException e) {
                    e.printStackTrace();
                    //error, just exit
                    System.exit(0);
                }
            }
        }
        System.out.println("Done");
    }

    public static void copyFolder(File src, File dest)
            throws IOException {
        if (src.isDirectory()) {
            //if directory not exists, create it
            if (!dest.exists()) {
                dest.mkdir();
                System.out.println("Directory copied from "
                        + src + "  to " + dest);
            }
            //list all the directory contents
            String files[] = src.list();

            for (String file : files) {
                //construct the src and dest file structure
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                //recursive copy
                copyFolder(srcFile, destFile);
            }
        } else {
            //if file, then copy it
            //Use bytes stream to support all file types
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
            System.out.println("File copied from " + src + " to " + dest);
        }
    }
}
//        //For Method Overriding (so runtime polymorphism can be achieved)
//        //For Code Reusability
//        //Single, Multi level, Heirarchical
//        Programmer inheritance = new Programmer();
//        System.out.println("Programmer salary is:" + inheritance.salary);
//        System.out.println("Bonus of Programmer is:" + inheritance.bonus);
//
//    }
//}
