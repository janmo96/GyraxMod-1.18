package com.janmo96.gyraxmod.Utils;

public class ReplaceText
{
    public static String ColorText(String converted, String original, String rulesText)
    {
        String replacedText;

        replacedText = rulesText.replace(original, converted);
        //System.out.println("Original Text replaced With: " + replacedText);
        return replacedText;
    }





}
