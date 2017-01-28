package prodacademica;

import java.util.ArrayList;
import java.util.Scanner;

public class ProdAcademica {
    
    
    
    
    public static void main(String[] args) {
        
        ArrayList<Colaboradores> col = new ArrayList <Colaboradores>();
        ArrayList<Projeto> proj = new ArrayList <Projeto>();
        ArrayList<Publicacoes> pub = new ArrayList <Publicacoes>();
        
        Colaboradores col_aux = new Colaboradores();
        Projeto proj_aux = new Projeto();
        Publicacoes pub_aux = new Publicacoes();
        
        Scanner scan = new Scanner(System.in);
        
        int pass=1;
        while(pass==1){
        System.out.println("------ MENU ------");
        System.out.println("1 - Colaborador");
        System.out.println("2 - Projeto");
        System.out.println("3 - Publicacoes");
        System.out.println("0 - Sair");
        
        int op;
        try{
            System.out.println("Selecione a opção desejada : ");
            op = scan.nextInt();
                if(op==1){ //1 Adicionar 2 Remover 3 Alterar 4 Listar 5 Alocar
                    
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
                    } else if (op_aux==5){
                        col_aux.alocarColaborador(col,proj);
                    } else if(op==0){
                        break;
                    }
                
                } else if (op==2){
                    int op_aux = proj_aux.menuProjeto();
                        
                        if(op_aux==1){
                            proj.add(proj_aux.adicionarProjeto());
                            proj_aux.mostrarProjeto(proj);
                        } else if (op_aux==2){
                            proj_aux.removerProjeto(proj);
                        } else if (op_aux==3){
                            proj_aux.alterarProjeto(proj);
                        } else if (op_aux==4){
                            proj_aux.mostrarProjeto(proj);
                        }
                    
                    
                } else if (op==3){
                    int op_aux = pub_aux.menuPublicacoes();
                        
                    if(op_aux==1){
                        pub.add(pub_aux.lancarPublicacao());
                    } else if (op_aux==2){
                        pub_aux.removerPublicacao(pub);
                    } else if (op_aux==3){
                        pub_aux.alocarPublicacao(proj, pub);
                    }
                    
                }else if (op==0){
                    break;
                }  
            //1pass=0;
        } catch(Exception e){
            System.out.println("Por favor, tente novamente!");
        }
        
        
        
    }
    
    
        
    }
    
}


