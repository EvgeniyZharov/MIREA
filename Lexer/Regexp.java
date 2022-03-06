package com.company.tasks;

import java.util.*;
import java.util.regex.*;


public class Regexp {

    private static Map<String, Pattern> lexems = new HashMap<>();

    static {

        lexems.put("VAR", Pattern.compile("^[a-z][a-z0-9]{0,}$"));
        lexems.put("DIGIT", Pattern.compile("^0|([1-9][0-9]*)$"));
        lexems.put("ASSIGN_OP", Pattern.compile("[=]"));
        lexems.put("PLUS_SIGN", Pattern.compile("[+]"));
        lexems.put("MINUS_SIGN", Pattern.compile("[-]"));
        lexems.put("MULTIPLY_SIGN", Pattern.compile("[*]"));
        lexems.put("DIVIDE_SIGN", Pattern.compile("[/]"));
        lexems.put("QUESTION_SIGN", Pattern.compile("[?]"));
        lexems.put("EXCLAMATION_SIGN", Pattern.compile("[!]"));

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> strings = new LinkedList<>();

        int ii = 0;
        while (true){
            System.out.println("Введите строку: ");
            strings.add(ii, scan.nextLine());
            if (strings.get(ii).isEmpty()){
                strings.remove(ii);
                break;
            }
            ii++;
        }

        System.out.println("Количество строк введено: "+strings.size());

        List<Token> tokens = new LinkedList<>();

        for (String str : strings){
            for (String lexemName: lexems.keySet()) {
                Matcher m = lexems.get(lexemName).matcher(str);
                if (m.find()) {
                    tokens.add(new Token(lexemName, str));
                }
            }
        }

        for (Token token: tokens) {
            System.out.println(token);
        }

    }

}

class Token {

    private String type;
    private String value;

    public Token(String type, String value){
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString(){
        return "TOKEN[type=\"" + this.type + "\", value=\"" + this.value + "\"]";
    }

}