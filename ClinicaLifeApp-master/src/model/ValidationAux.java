package model;

import java.util.Calendar;

import view.consulta.BuscarConsulta;

public class ValidationAux {
	public static boolean dateIsValid(String data){
        String[] vetor = data.split("/");
        int ano = Integer.parseInt(vetor[2]);
        if(ano < 1850 )
            return false;
        return true;
    }
	
	public static boolean CPFisValid(String cpf){
        int d1, d2, soma = 0, peso = 10, resto, dig2;
        
        dig2 = Integer.parseInt(cpf.substring(10,11));
        
        if (cpf.equals("11111111111") 
            || cpf.equals("22222222222")
            || cpf.equals("33333333333")
            || cpf.equals("44444444444")
            || cpf.equals("55555555555")
            || cpf.equals("66666666666")
            || cpf.equals("77777777777")
            || cpf.equals("88888888888")
            || cpf.equals("99999999999"))
                return false;
        
        for (int i = 0; i < cpf.length()-2; i++)
           soma += Integer.parseInt(cpf.substring(i, i + 1)) * peso--;
    
        resto = (soma % 11);
        d1 = resto < 2 ? 0 :  11 - resto;

        if(d1 != Integer.parseInt(cpf.substring(9,10)))
            return false;
        
        soma = 0;
        peso = 11;

        cpf = cpf.substring(0, 9);
        cpf = cpf + Integer.toString(d1);
        for (int i = 0; i < cpf.length(); i++)
               soma += Integer.parseInt(cpf.substring(i, i + 1)) * peso--;

        resto = (soma % 11);
        d2 = resto < 2 ? 0 :  11 - resto;
        return d2 == dig2;
    }
    
	
}
