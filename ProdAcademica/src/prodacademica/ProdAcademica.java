package prodacademica;

import java.util.ArrayList;
import java.util.Scanner;

public class ProdAcademica {
    
    
    
    
    public static void main(String[] args) {
        
        ArrayList<Colaboradores> col = new ArrayList <Colaboradores>();
        Colaboradores col_aux = new Colaboradores();
        Scanner scan = new Scanner(System.in);
        
        int pass=1;
        while(pass==1){
        System.out.println("------ MENU ------");
        System.out.println("1 - Colaborador");
        System.out.println("2 - Projeto");
        System.out.println("0 - Sair");
        
        int op;
        try{
            System.out.println("Selecione a opção desejada : ");
            op = scan.nextInt();
                if(op==1){ //1 Adicionar 2 Remover 3 Alterar 4 Listar
                    
                    int op_aux = col_aux.menuColaborador();
                    
                    if(op_aux==1){
                        col.add(col_aux.adicionarColaborador());
                        System.out.println("----------");
                    } else if (op_aux==2){
                        col_aux.removerColaborador(col);
                    } else if (op_aux==3){
                        col_aux.alterarColaborador(col);
                    } else if (op_aux==4){
                        col_aux.mostrarColaborador(col);
                    } else if(op==0){
                        break;
                    }
                
                } else if (op==0){
                    break;
                }  
            //1pass=0;
        } catch(Exception e){
            System.out.println("Por favor, tente novamente!");
        }
        
        
        
    }
    
    
        
    }
    
}


