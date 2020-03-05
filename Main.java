public class Main {
    public static void main(String[] args){
        String input1="quinhentos e cinquenta e cinco milhões, vinte e tres mil e noventa reais e setenta e cinco centavos"; //55023090
        String input2="cinquenta e seis reais e sessenta e seis centavos";
        String input3="novecentos mil, novecentos e nove reais";

        wordToNumber(input1);
        wordToNumber(input2);
        wordToNumber(input3);
    }
    private static int smallNumbers(String input) {
        if(input.equalsIgnoreCase("zero")==true) {
            return 0;
        }
        if(input.equalsIgnoreCase("um")==true) {
            return 1;
        }
        if(input.equalsIgnoreCase("dois")==true) {
            return 2;
        }
        if(input.equalsIgnoreCase("tres")==true) {
            return 3;
        }
        if(input.equalsIgnoreCase("quatro")==true) {
            return 4;
        }
        if(input.equalsIgnoreCase("cinco")==true) {
            return 5;
        }
        if(input.equalsIgnoreCase("seis")==true) {
            return 6;
        }
        if(input.equalsIgnoreCase("sete")==true) {
            return 7;
        }
        if(input.equalsIgnoreCase("oito")==true) {
            return 8;
        }
        if(input.equalsIgnoreCase("nove")==true) {
            return 9;
        }
        if(input.equalsIgnoreCase("dez")==true) {
            return 10;
        }
        if(input.equalsIgnoreCase("onze")==true) {
            return 11;
        }
        if(input.equalsIgnoreCase("doze")==true) {
            return 12;
        }
        if(input.equalsIgnoreCase("treze")==true) {
            return 13;
        }
        if(input.equalsIgnoreCase("quatorze")==true) {
            return 14;
        }
        if(input.equalsIgnoreCase("quinze")==true) {
            return 15;
        }
        if(input.equalsIgnoreCase("dezesseis")==true) {
            return 16;
        }
        if(input.equalsIgnoreCase("dezessete")==true) {
            return 17;
        }
        if(input.equalsIgnoreCase("dezoito")==true) {
            return 18;
        }
        if(input.equalsIgnoreCase("dezenove")==true) {
            return 19;
        }
        return -1;
    }
    private static int mediumNumbers(String input) {
        if(input.equalsIgnoreCase("vinte")==true) {
            return 20;
        }
        if(input.equalsIgnoreCase("trinta")==true) {
            return 30;
        }
        if(input.equalsIgnoreCase("quarenta")==true) {
            return 40;
        }
        if(input.equalsIgnoreCase("cinquenta")==true) {
            return 50;
        }
        if(input.equalsIgnoreCase("sessenta")==true) {
            return 60;
        }
        if(input.equalsIgnoreCase("setenta")==true) {
            return 70;
        }
        if(input.equalsIgnoreCase("oitenta")==true) {
            return 80;
        }
        if(input.equalsIgnoreCase("noventa")==true) {
            return 90;
        }
        if(input.equalsIgnoreCase("cem")==true) {
            return 100;
        }
        if(input.equalsIgnoreCase("duzentos")==true) {
            return 200;
        }
        if(input.equalsIgnoreCase("trezentos")==true) {
            return 300;
        }
        if(input.equalsIgnoreCase("quatrocentos")==true) {
            return 400;
        }
        if(input.equalsIgnoreCase("quinhentos")==true) {
            return 500;
        }
        if(input.equalsIgnoreCase("seiscentos")==true) {
            return 600;
        }
        if(input.equalsIgnoreCase("setecentos")==true) {
            return 700;
        }
        if(input.equalsIgnoreCase("oitocentos")==true) {
            return 800;
        }
        if(input.equalsIgnoreCase("novecentos")==true) {
            return 900;
        }
        return -1;
    }
    private static long largeNumbers(String input) {
        if(input.equalsIgnoreCase("mil")==true) {
            return 1000;
        }
        if(input.equalsIgnoreCase("milhão")==true) {
            return 1000000;
        }
        if(input.equalsIgnoreCase("milhões")==true) {
            return 1000000;
        }
        return -1;
    }
    private static int mediumNumbersCent(String input) {
        if(input.equalsIgnoreCase("vinte")==true) {
            return 20;
        }
        if(input.equalsIgnoreCase("trinta")==true) {
            return 30;
        }
        if(input.equalsIgnoreCase("quarenta")==true) {
            return 40;
        }
        if(input.equalsIgnoreCase("cinquenta")==true) {
            return 50;
        }
        if(input.equalsIgnoreCase("sessenta")==true) {
            return 60;
        }
        if(input.equalsIgnoreCase("setenta")==true) {
            return 70;
        }
        if(input.equalsIgnoreCase("oitenta")==true) {
            return 80;
        }
        if(input.equalsIgnoreCase("noventa")==true) {
            return 90;
        }
        return -1;
    }
    private static void wordToNumber(String input) {
        System.out.println("===========\nInput string = "+input);
        long sum=0;
        long temp=0;
        long previous=0;
        long sum1=0;
        long temp1=0;
        long previous1=0;
        String [] splitted0= input.toLowerCase().split("reais e ");
        String e = splitted0[0].replaceAll(" e ", " ");
        String a = e.replaceAll(", ", " ");
        String [] splitted1= a.toLowerCase().split(" ");
        String [] splitted2=null;
        if(splitted0.length>1){
            e = splitted0[1].replaceAll(" e ", " ");
            a = e.replaceAll("centavos", "");
            splitted2= a.toLowerCase().split(" ");
        }
        for(String split:splitted1){
            if(smallNumbers(split)!=-1){
                temp=smallNumbers(split);
                sum=sum+temp;
                previous=previous+temp;
            }
            else if(mediumNumbers(split)!=-1){
                temp=mediumNumbers(split);
                sum=sum+temp;
                previous=previous+temp;
            }
            else if(largeNumbers(split)!=-1){
                if(sum!=0){
                    sum=sum-previous;
                }
                sum=sum+(long)previous*(long)largeNumbers(split);
                temp=0;
                previous=0;
            }
        }
        if(splitted2!=null){
            for(String split:splitted2){
                if(smallNumbers(split)!=-1){
                    temp1=smallNumbers(split);
                    sum1=sum1+temp1;
                    previous1=previous1+temp1;
                }
                else if(mediumNumbers(split)!=-1){
                    temp1=mediumNumbers(split);
                    sum1=sum1+temp1;
                    previous1=previous1+temp1;
                }
            }
        }
        if(sum1>=10){
            System.out.println(sum+"."+sum1);
        }else{
            System.out.println(sum+".0"+sum1);
        }
    }
}
