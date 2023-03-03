package com.janmo96.gyraxmod.rules;


import com.janmo96.gyraxmod.GyraxMod;
import com.janmo96.gyraxmod.Utils.ColorChecker;
import net.minecraftforge.fml.loading.FMLPaths;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class LoadRules {

    public static void Init() {

      try{
        Path p = Paths.get(FMLPaths.CONFIGDIR.get() + "/Gyrax");

            Path fileP = Path.of(p + "/rules.txt");

            if (!Files.exists(fileP)) {
                Files.createFile(fileP);

                File f = Paths.get(fileP.toUri()).toFile();

                FileWriter w = new FileWriter(f);
                BufferedWriter rules = new BufferedWriter(w);
                rules.write("---Rules--");
                for (String s : Arrays.asList("1. Example Rule 1.", "2. Example Rule 2.", "3. Example Rule 3.")) {
                    rules.newLine();
                    rules.write(s);
                }

                rules.close();


            //System.out.println("Rules Text File Created");
        } else {
            //System.out.println("Rules Text File Exists: " + Files.exists(Paths.get(FMLPaths.CONFIGDIR.get() + "/Gyrax/rules.txt")));
            ReadRules();
        }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public static boolean SymbolChecker(String text){
        return text.contains("&");
    }
        public static void ReadRules(){
        try {
            File f = new File(FMLPaths.CONFIGDIR.get() + "/Gyrax/rules.txt");
            Scanner scanner = new Scanner(f);
            ArrayList<String> rulesList = new ArrayList<>();
            while (scanner.hasNextLine()){
                String data = scanner.nextLine();
                if(SymbolChecker(data)) {
                  data = ColorChecker.TextColorChecker(data);
                }


              //  System.out.println(data);
                rulesList.add(data);




            GyraxMod.RulesText = rulesList;
         //   System.out.println("Final Rules Text:");
            for (int i = 0; i < GyraxMod.RulesText.size(); i++){
              System.out.println(GyraxMod.RulesText.get(i));


            }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error Occurred");
            e.printStackTrace();
        }
        }
        }





