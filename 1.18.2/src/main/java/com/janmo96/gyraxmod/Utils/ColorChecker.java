package com.janmo96.gyraxmod.Utils;


import java.util.ArrayList;
import java.util.List;

import static com.janmo96.gyraxmod.GyraxMod.McColors;

public class ColorChecker
{
    public static String TextColorChecker(String text)    {
    List<String> colorsFound = new ArrayList<>();
    List<String> convertedColors = new ArrayList<>();
    String foundColor;
    String finalText = null;

    if(text == null){
        return null;
    }
    //Checking Amount Of Colors and adding them to a list
        for (int i = 0; i < McColors.size(); i++){
            if(text.contains(McColors.get(i))){
             colorsFound.add(McColors.get(i));
            }
        }

        //Converts Colors to Color Code
        if(colorsFound.size() != 0) {

        for (int i = 0; i < colorsFound.size(); i++){
            foundColor = colorsFound.get(i);
            foundColor = ColorCheck(foundColor);
            convertedColors.add(foundColor);
        }



        for (int i = 0; i < convertedColors.size(); i++){
            text = ReplaceText.ColorText(convertedColors.get(i), colorsFound.get(i), text);
        }
        colorsFound.clear();
        convertedColors.clear();
        
        return text;
        }else {
            return text;
        }
    }

    public static List<String> getMcColors() {
        List<String> McColors = new ArrayList<>();

        McColors.add("&0");
        McColors.add("&1");
        McColors.add("&2");
        McColors.add("&3");
        McColors.add("&4");
        McColors.add("&5");
        McColors.add("&6");
        McColors.add("&7");
        McColors.add("&8");
        McColors.add("&9");
        McColors.add("&a");
        McColors.add("&b");
        McColors.add("&c");
        McColors.add("&d");
        McColors.add("&e");
        McColors.add("&f");
        McColors.add("&k");
        McColors.add("&l");

        return McColors;
    }
    public static String ColorCheck(String text) {

        switch (text) {
            case "&0":
                text = "\u00A70";
                break;
            case "&1":
                text = "\u00A71";
                break;
            case "&2":
                text = "\u00A72";
                break;
            case "&3":
                text = "\u00A73";
                break;
            case "&4":
                text = "\u00A74";
                break;
            case "&5":
                text = "\u00A75";
                break;
            case "&6":
                text = "\u00A76";
                break;
            case "&7":
                text = "\u00A77";
                break;
            case "&8":
                text = "\u00A78";
                break;
            case "&9":
                text = "\u00A79";
                break;
            case "&a":
                text = "\u00A7a";
                break;
            case "&b":
                text = "\u00A7b";
                break;
            case "&c":
                text = "\u00A7c";
                break;
            case "&d":
                text = "\u00A7d";
                break;
            case "&e":
                text = "\u00A7e";
                break;
            case "&f":
                text = "\u00A7f";
                break;
            case "&k":
                text = "\u00A7k";
                break;
            case "&l":
                text = "\u00A7l";
                break;
        }
        return text;
    }

}
