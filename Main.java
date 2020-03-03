package com;

import java.util.HashMap;

public class Main {

    static HashMap<String, Integer> numbers= new HashMap<String, Integer>();
    static HashMap<String, Integer> hundredNumbers= new HashMap<String, Integer>();
    static HashMap<String, Integer> largeNumbers= new HashMap<String, Integer>();

    static {
        numbers.put("zero", 0);
        numbers.put("um", 1);
        numbers.put("dois", 2);
        numbers.put("tres", 3);
        numbers.put("quatro", 4);
        numbers.put("cinco", 5);
        numbers.put("seis", 6);
        numbers.put("sete", 7);
        numbers.put("oito", 8);
        numbers.put("nove", 9);
        numbers.put("dez", 10);
        numbers.put("onze", 11);
        numbers.put("doze", 12);
        numbers.put("treze", 13);
        numbers.put("quatorze", 14);
        numbers.put("quinze", 15);
        numbers.put("dezesseis  ", 16);
        numbers.put("dezessete", 17);
        numbers.put("dezoito", 18);
        numbers.put("dezenove", 19);

        hundredNumbers.put("vinte", 20);
        hundredNumbers.put("trinta", 30);
        hundredNumbers.put("quarenta", 40);
        hundredNumbers.put("cinquenta", 50);
        hundredNumbers.put("sessenta ", 60);
        hundredNumbers.put("setenta", 70);
        hundredNumbers.put("oitenta", 80);
        hundredNumbers.put("noventa", 90);

        largeNumbers.put("cem", 100);
        largeNumbers.put("duzentos", 200);
        largeNumbers.put("trezentos", 300);
        largeNumbers.put("quatrocentos", 400);
        largeNumbers.put("quinhentos", 500);
        largeNumbers.put("seiscentos ", 600);
        largeNumbers.put("setecentos", 700);
        largeNumbers.put("oitocentos", 800);
        largeNumbers.put("novecentos", 900);
        largeNumbers.put("mil", 1000);
        largeNumbers.put("milhão", 1000000);
        largeNumbers.put("milhões", 1000000);
    }

    public static void main(String[] args){
        String input1="cinquenta e cinco milhões, vinte e tres mil e noventa"; //55023090
        String input2="cinquenta e seis";
        String input3="novecentos e nove";

        wordToNumber(input1);
        wordToNumber(input2);
        wordToNumber(input3);
    }

    private static void wordToNumber(String input) {
        System.out.println("===========\nInput string = "+input);
        long sum=0;
        Integer temp=null;
        Integer previous=0;
        String [] splitted= input.toLowerCase().split(" e ");

        for(String split:splitted){
            if( numbers.get(split)!=null){
                temp= numbers.get(split);

                sum=sum+temp;

                previous=previous+temp;
            }
            else if(largeNumbers.get(split)!=null){
                if(sum!=0){
                    sum=sum-previous;
                }
                sum=sum+(long)previous*(long)largeNumbers.get(split);
                temp=null;
                previous=0;


            }
            else if(hundredNumbers.get(split)!=null){
                temp=hundredNumbers.get(split);
                sum=sum+temp;

                previous=temp;
            }
        }
        System.out.println(sum);
    }

}