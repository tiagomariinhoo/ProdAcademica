package prodacademica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class Colaboradores extends Pessoa {
    
    ArrayList <Publicacoes> pub = new ArrayList <Publicacoes> ();
    ArrayList <Projeto> proj = new ArrayList <Projeto>();
    ArrayList <Colaboradores> colab = new ArrayList<Colaboradores>();
    
    public void alocarColaborador(ArrayList <Colaboradores> col, ArrayList<Projeto> proj){ //Professor -> Aluno // Professor -> Projeto
        if(col.size()==0){
            System.out.println("Ainda não há colaboradores registrados!");
        }
        
        Scanner scan = new Scanner(System.in);
         
         System.out.println("Deseja alocar : ");
         System.out.println("1 - Professor para aluno");
         System.out.println("2 - Professor para projeto");
         System.out.println("3 - Aluno para projeto");
         System.out.println("4 - Mudar status do projeto");
         int op = scan.nextInt();
            if(op==1){
                
                int contador=0;
                for(int i=0;i<col.size();i++){
                    if(col.get(i).getCargo()==4){
                        System.out.println("----- PROFESSOR -----");
                        System.out.println("Nome : " + col.get(i).getNome());
                        System.out.println("Numero : " + i);
                        System.out.println("---------------------");
                        contador++;
                    }
                }

                if(contador==0){
                    System.out.println("Não há professores registrados!");
                    return ;
                }
                
                System.out.println("Escolha o professor por número : ");
                int numb = scan.nextInt();
                    if(col.get(numb).getCargo()==4){
                        
                        int contador2=0;    
                            for(int i=0;i<col.size();i++){
                                if(col.get(i).getCargo()!=4 && col.get(i).getCargo()!=5 && col.get(i).colab.size()==0){
                                    System.out.println("----- ALUNO -----");
                                    System.out.println("Aluno : " + col.get(i).getNome());
                                    System.out.println("Numero : " + i);
                                    System.out.println("-----------------");
                                    contador2++;
                                }
                            }
                            if(contador2==0){
                                System.out.println("Não há alunos disponíveis!");
                                return ;
                            }
                            
                        System.out.println("Escolha o aluno que receberá o professor como orientador : ");
                        int op3 = scan.nextInt();
                            if(col.get(op3).getCargo()!=5 && col.get(op3).getCargo()!=4 && col.get(op3).colab.size()==0){
                                col.get(op3).colab.add(col.get(numb)); //Professor a um aluno
                                col.get(numb).colab.add(col.get(op3)); //Aluno a profesor
                                System.out.println("Professor alocado com sucesso!");
                            } else {
                                System.out.println("Selecione uma opção válida!");
                                return ;
                            }

                    } else {
                        System.out.println("Por favor, selecione uma opção válida");
                        return ;
                    }
            } else if (op==2){
                
                int contador=0;
                for(int i=0;i<col.size();i++){
                    if(col.get(i).getCargo()==4){
                        System.out.println("----- PROFESSOR -----");
                        System.out.println("Nome : " + col.get(i).getNome());
                        System.out.println("Numero : " + i);
                        System.out.println("---------------------");
                        contador++;
                    }
                }

                if(contador==0){
                    System.out.println("Não há professores registrados!");
                    return ;
                }
                
                if(proj.size()==0){
                    System.out.println("Não há projetos registrados!");
                    return ;
                }
                
                boolean pode=false;
                if(proj.size()>0){
                    for(int i=0;i<proj.size();i++){
                        if(proj.get(i).getStatus().equals("Em elaboração")){
                            pode = true;
                        }
                    }
                    
                    if(!pode){
                        System.out.println("Não há projetos disponíveis!");
                        return ;
                    }
                }
                
                System.out.println("Escolha o professor por número : ");
                int numb = scan.nextInt();
                int count = proj.size();
                    if(col.get(numb).getCargo()==4){
                        for(int i=0;i<proj.size();i++){
                            if(proj.get(i).getStatus().equals("Em elaboração")){
                                boolean at = false;
                                
                                if(proj.get(i).colab.size()>0){
                                at=false;
                                    for(int m=0;m<proj.get(i).colab.size();m++){
                                        if(proj.get(i).colab.get(m).getNome().equals(col.get(numb).getNome())){
                                            at=true;
                                            count--;
                                            break;
                                        }
                                    }
                                }
                                if(!at){
                                System.out.println("----- PROJETO -----");
                                System.out.println("Projeto : " + proj.get(i).getTitulo());
                                System.out.println("Numero : " + i);
                                System.out.println("-------------------");
                                }
                            }
                            
                        }
                        if(count==0){
                            System.out.println("Não há projetos disponíveis!");
                            return;
                        }
                        System.out.println("Selecione o projeto por numero : ");
                        int op2 = scan.nextInt();
                        if(!pode){
                            System.out.println("Selecione um projeto válido!");
                            return; 
                        }
                        
                            col.get(numb).proj.add(proj.get(op2));
                            proj.get(op2).colab.add(col.get(numb));
                            System.out.println("Projeto alocado com sucesso!");
                    } else {
                        System.out.println("Selecione uma opção válida!");
                        return ;
                    }
                
            } else if (op==3){
                int contador2=0;
                for(int i=0;i<col.size();i++){
                    if(col.get(i).getCargo()!=4 && col.get(i).getCargo()!=5 && col.get(i).getAlocado()==false){
                        System.out.println("----- ALUNO -----");
                        System.out.println("Nome : " + col.get(i).getNome());
                        System.out.println("Numero : " + i);
                        System.out.println("-----------------");
                        contador2++;
                    }
                }
                
                
                
                if(contador2==0){
                    System.out.println("Não há alunos registrados!");
                    return ;
                }
                
                contador2=0;
                
                for(int i=0;i<proj.size();i++){
                    if(proj.get(i).getStatus().equals("Em elaboração")){
                        System.out.println("----- PROJETO ------");
                        System.out.println("Titulo : " + proj.get(i).getTitulo());
                        System.out.println("Numero : " + i);
                        System.out.println("-------------------");
                        contador2++;
                    }
                }
                
                if(contador2==0){
                    System.out.println("Não há projetos disponíveis!");
                    return ;
                }
                
                System.out.println("Selecione o aluno por numero : ");
                int op2 = scan.nextInt();
                
                System.out.println("Selecione o projeto por numero : ");
                int op3 = scan.nextInt();
                
                boolean at=false;
                    for(int i=0;i<col.get(op2).proj.size();i++){
                        if(col.get(op2).proj.get(i).getStatus().equals("Em andamento")){
                            at=true;
                        }
                    }
                    if(!at){
                        col.get(op2).proj.add(proj.get(op3));
                        proj.get(op3).colab.add(col.get(op2));
                        System.out.println("Aluno alocado com sucesso!");
                    } else {
                        System.out.println("O aluno " + col.get(op2).getNome() + " já faz parte de um projeto!");
                    }
                
            } else if (op==4){
                if(proj.size()==0){
                    System.out.println("Não há projetos disponíveis!");
                    return ;
                }
                
                for(int i=0;i<proj.size();i++){
                    System.out.println("----- PROJETO -----");
                    System.out.println("Titulo : " + proj.get(i).getTitulo());
                    System.out.println("Numero : " + i);
                    System.out.println("Status : " + proj.get(i).getStatus());
                    System.out.println("-------------------");
                }
            
                System.out.println("Selecione o projeto por numero : ");
                int op2 = scan.nextInt();
                    
                if(op2<0 || op2>proj.size()-1){
                        System.out.println("Selecione um projeto existente!");
                        return ;
                    }
            
                System.out.println("Digite o novo status do projeto : ");
                System.out.println("1 - Em elaboração");
                System.out.println("2 - Em andamento");
                System.out.println("3 - Concluído");
                
                int op3 = scan.nextInt();
                
                boolean pode = false;
                    if(op3==1){
                        proj.get(op2).setStatus("Em elaboração");
                        System.out.println("Status alterado com sucesso!");
                        return;
                    }
                    if(op3==2){ //Verificar se há professor no projeto para passar para andamento
                        System.out.println("Titulo : " + proj.get(op2).getTitulo());
                        System.out.println("Colaboradores : " + proj.get(op2).colab.size());
                        if(proj.get(op2).colab.size()>0){
                            for(int i=0;i<proj.get(op2).colab.size();i++){
                                if(proj.get(op2).colab.get(i).getCargo()==4){
                                    pode = true;
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Não há ninguém associado a esse projeto, não pode mudar os status.");
                            return ;
                        }
                        
                        if(pode){
                            proj.get(op2).setStatus("Em andamento");
                            System.out.println("Status alterado com sucesso!");
                        } else {
                            System.out.println("Para que o projeto seja alterado para essa opção, precisa ter um professor alocado no projeto.");
                            return ;
                        }
                    } else if (op3==3){
                        if(proj.get(op2).publicacoes.size()>0){
                            proj.get(op2).setStatus("Concluído");
                            System.out.println("Status alterado com sucesso!");
                        } else {
                            System.out.println("O projeto precisa ter alguma publicação para ser concluido.");
                            return ;
                        }
                    }
            
            }
            
            
    }
    
    @Override
    public void mostrarColaborador(ArrayList <Colaboradores> col){
        Scanner scan = new Scanner (System.in);
        if(col.size()==0){
            System.out.println("Ainda não há colaboradores registrados!");
            return ;
        }
        
        System.out.println("1 - Procurar colaborador");
        System.out.println("2 - Listar colaboradores");
        int op = scan.nextInt();
            String nome = null;
            int id=-1;
            if(op==1){
                
                for(int j=0;j<col.size();j++){
                    System.out.println("Nome : " + col.get(j).getNome());
                    System.out.println("Id : " + j);
                }
                
                System.out.println("Selecione o id do colaborador que deseja ser encontrado : ");
                scan.nextLine();
                id = scan.nextInt();
                if(id>col.size() || id<0){
                    System.out.println("Por favor, digite um id válido!");
                    return ;
                }
            }
                for(int i=0;i<col.size();i++){
                    if(op==1){
                        if(col.get(id)!=null){
                            System.out.println("Nome : " + col.get(i).getNome());
                            System.out.println("Idade : " + col.get(i).getIdade());
                            System.out.println("Endereco : " + col.get(i).getEndereco());
                            System.out.println("Email : " + col.get(i).getEmail());
                            if(col.get(i).getCargo()==1){
                                System.out.println("Cargo : Aluno de graduação");
                            } else if (col.get(i).getCargo()==2){
                                System.out.println("Cargo : Aluno de mestrado");
                            } else if (col.get(i).getCargo()==3){
                                System.out.println("Cargo : Aluno de doutorado");
                            } else if (col.get(i).getCargo()==4){
                                System.out.println("Cargo : Professor");
                            } else if (col.get(i).getCargo()==5){
                                System.out.println("Cargo : Pesquisador");
                            }
                            
                            if(col.get(i).proj.size()>0){
                                System.out.println("-------");
                                GregorianCalendar cal = new GregorianCalendar();
                                GregorianCalendar cal2 = new GregorianCalendar();
                                System.out.println("Projeto alocado : ");
                                
                                Projeto[] auxpro = new Projeto[50];
                                for(int j=0;j<col.get(i).proj.size();j++){
                                        auxpro[j] = col.get(i).proj.get(j);
                                    }
                                
                                if(col.get(i).proj.size()>1){
                                    
                                    Projeto aux = new Projeto();
                                    
                                    
                                    for(int j=0;j<col.get(i).proj.size();j++){ //Ordenação
                                        for(int k=0;k<col.get(i).proj.size()-1;k++){
                                            cal.setTime(auxpro[k].getDataTermino());
                                            cal2.setTime(auxpro[k+1].getDataTermino());
                                            
                                            if(cal.get(Calendar.YEAR)<cal2.get(Calendar.YEAR)){
                                                Projeto projaux = new Projeto();
                                                projaux = auxpro[k];
                                                auxpro[k] = auxpro[k+1];
                                                auxpro[k+1] = projaux;
                                                
                                            }
                                        }
                                    }
                                }
                                
                                for(int j=0;j<col.get(i).proj.size();j++){
                                        
                                        System.out.println("-------");
                                        System.out.println("Projeto : " + auxpro[j].getTitulo());
                                        System.out.println("Status : " + auxpro[j].getStatus());
                                        System.out.println("Ano : " + auxpro[j].getDataTermino());
                                        System.out.println("-------");
                                }
                            
                            }
                            
                            if(col.get(i).colab.size()>0){
                                System.out.println("Orientador : ");
                                Colaboradores colab = new Colaboradores();
                                colab.mostrarColaborador(col.get(i).colab);
                            }
                            
                            System.out.println("---------------");
                        
                                   if(col.get(i).pub.size()>0){
                                   Publicacoes[] pub = new Publicacoes[50];
                                   Publicacoes auxpub = new Publicacoes();
                                   
                                   for(int j=0;j<col.get(i).pub.size();j++){
                                       pub[j] = col.get(i).pub.get(j);
                                   }
                                   if(col.get(i).pub.size()>1){
                                        
                                        for(int m = 0 ; m<col.get(i).pub.size();m++){
                                            for(int n = 0 ; n < col.get(i).pub.size() -1 ; n++){
                                                if(pub[n].getAno()<pub[n+1].getAno()){
                                                    auxpub = pub[n];
                                                    pub[n] = pub[n+1];
                                                    pub[n+1] = auxpub;
                                                }
                                            }
                                        }
                                    }
                                   
                                   
                                   System.out.println("------- PUBLICAÇÕES --------");
                                    for(int j=0;j<col.get(i).pub.size();j++){
                                       //System.out.println("Publicacao : " + col.get(i).pub.get(j).getTitulo());
                                       //System.out.println("Ano : " + col.get(i).pub.get(j).getAno());
                                       System.out.println("Publicacao : " + pub[j].getTitulo());
                                       System.out.println("Ano : " + pub[j].getAno());
                                   
                                    }
                                   }
                            
                            return ;
                        }
                    
                    } else if (op==2){
                            System.out.println("Nome : " + col.get(i).getNome());
                            System.out.println("Idade : " + col.get(i).getIdade());
                            System.out.println("Endereco : " + col.get(i).getEndereco());
                            System.out.println("Email : " + col.get(i).getEmail());
                            if(col.get(i).getCargo()==1){
                                System.out.println("Cargo : Aluno de graduação");
                            } else if (col.get(i).getCargo()==2){
                                System.out.println("Cargo : Aluno de mestrado");
                            } else if (col.get(i).getCargo()==3){
                                System.out.println("Cargo : Aluno de doutorado");
                            } else if (col.get(i).getCargo()==4){
                                System.out.println("Cargo : Professor");
                            } else if (col.get(i).getCargo()==5){
                                System.out.println("Cargo : Pesquisador");
                            }
                            
                            if(col.get(i).proj.size()>0){
                                System.out.println("-------");
                                GregorianCalendar cal = new GregorianCalendar();
                                GregorianCalendar cal2 = new GregorianCalendar();
                                System.out.println("Projeto alocado : ");
                                
                                Projeto[] auxpro = new Projeto[50];
                                for(int j=0;j<col.get(i).proj.size();j++){
                                        auxpro[j] = col.get(i).proj.get(j);
                                    }
                                
                                if(col.get(i).proj.size()>1){
                                    
                                    Projeto aux = new Projeto();
                                    
                                    for(int j=0;j<col.get(i).proj.size();j++){ //Ordenação
                                        for(int k=0;k<col.get(i).proj.size()-1;k++){
                                            cal.setTime(auxpro[k].getDataTermino());
                                            cal2.setTime(auxpro[k+1].getDataTermino());
                                            
                                            if(cal.get(Calendar.YEAR)<cal2.get(Calendar.YEAR)){
                                                Projeto projaux = new Projeto();
                                                projaux = auxpro[k];
                                                auxpro[k] = auxpro[k+1];
                                                auxpro[k+1] = projaux;
                                                
                                            }
                                        }
                                    }
                                }
                                
                                for(int j=0;j<col.get(i).proj.size();j++){
                                        
                                        System.out.println("-------");
                                        System.out.println("Projeto : " + auxpro[j].getTitulo());
                                        System.out.println("Status : " + auxpro[j].getStatus());
                                        System.out.println("Ano : " + auxpro[j].getDataTermino());
                                        System.out.println("-------");
                                }
                            
                            }
                            
                               if(col.get(i).colab.size()>0){
                                   System.out.println("------- COLABORADORES LIGADOS -------");
                                    for(int j=0;j<col.get(i).colab.size();j++){
                                        System.out.println("Nome : " + col.get(i).colab.get(j).getNome());
                                        if(col.get(i).colab.get(j).getCargo()==4){
                                            System.out.println("Cargo : Orientador ");
                                        } else if (col.get(i).colab.get(j).getCargo()==1 || col.get(i).colab.get(j).getCargo()==2 || col.get(i).colab.get(j).getCargo()==3 ){
                                            System.out.println("Cargo : Orientando");
                                        }
                                        
                                    }
                                    System.out.println("------------------------------------");
                               }
                               
                               if(col.get(i).pub.size()>0){
                                   Publicacoes[] pub = new Publicacoes[50];
                                   Publicacoes auxpub = new Publicacoes();
                                   
                                   for(int j=0;j<col.get(i).pub.size();j++){
                                       pub[j] = col.get(i).pub.get(j);
                                   }
                                   if(col.get(i).pub.size()>1){
                                        
                                        for(int m = 0 ; m<col.get(i).pub.size();m++){
                                            for(int n = 0 ; n < col.get(i).pub.size() -1 ; n++){
                                                if(pub[n].getAno()<pub[n+1].getAno()){
                                                    auxpub = pub[n];
                                                    pub[n] = pub[n+1];
                                                    pub[n+1] = auxpub;
                                                }
                                            }
                                        }
                                    }
                                   
                                   
                                   System.out.println("------- PUBLICAÇÕES --------");
                                   for(int j=0;j<col.get(i).pub.size();j++){
                                       //System.out.println("Publicacao : " + col.get(i).pub.get(j).getTitulo());
                                       //System.out.println("Ano : " + col.get(i).pub.get(j).getAno());
                                       System.out.println("Publicacao : " + pub[j].getTitulo());
                                       System.out.println("Ano : " + pub[j].getAno());
                                   
                                   }
                               }
                            
                            System.out.println("---------------");
                    }
            }
        
        
    
    }
    
    public Colaboradores adicionarColaborador(){
        Colaboradores col = new Colaboradores();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite o nome do colaborador : ");
        String nome = scan.nextLine();
        col.setNome(nome);
        
        System.out.println("Digite a idade do colaborador : ");
        int idade = scan.nextInt();
        col.setIdade(idade);
        
        scan.nextLine();
        System.out.println("Digite o endereço do colaborador : ");
        String endereco = scan.nextLine();
        col.setEndereco(endereco);
        
        System.out.println("Digite o email do colaborador : ");
        String email = scan.nextLine();
        col.setEmail(email);
       
        System.out.println("Digite o cargo do colaborador : ");
        System.out.println("1 - Graduação");
        System.out.println("2 - Mestrado");
        System.out.println("3 - Doutorado");
        System.out.println("4 - Professor");
        //System.out.println("5 - Pesquisador");
        
        int flag=0;
        int op;
        do{
            op = scan.nextInt();
            if(op>0 && op<5) flag=1;
            else {
                System.out.println("Por favor, selecione uma opção válida!");
            }
        } while(flag==0);
        
        col.setCargo(op);
        col.setAlocado(false);
        
        System.out.println("Colaborador adicionado com sucesso!");
        return col;
    }
    
    public void prodAcademicaGrad(ArrayList <Colaboradores> col){
        if(col.size()==0){
            System.out.println("Ainda não há colaboradores registrados!");
        }
        int cont_grad=0, cont_mest=0,cont_dout=0,cont_pro=0;
        
        for(int i=0;i<col.size();i++){
            if(col.get(i).getCargo()==1){ //Graduação
                for(int j=0;j<col.get(i).proj.size();j++){
                    if(col.get(i).proj.get(j).getStatus().equals("Concluído")){
                        cont_grad++;
                    }
                }
            } else if (col.get(i).getCargo()==2){
                for(int j=0;j<col.get(i).proj.size();j++){
                    if(col.get(i).proj.get(j).getStatus().equals("Concluído")){
                        cont_mest++;
                    }
                }
                
            } else if (col.get(i).getCargo()==3){
                for(int j=0;j<col.get(i).proj.size();j++){
                    if(col.get(i).proj.get(j).getStatus().equals("Concluído")){
                        cont_dout++;
                    }
                }
                
            } else if (col.get(i).getCargo()==4){
                for(int j=0;j<col.get(i).proj.size();j++){
                    if(col.get(i).proj.get(j).getStatus().equals("Concluído")){
                        cont_pro++;
                    }
                }
                
            }
        }
        
        System.out.println("Produção academica de alunos da graduação : " + cont_grad );
        System.out.println("Produção academica de alunos do mestrado : " + cont_mest);
        System.out.println("Produção academica de alunos do doutorado : " + cont_dout);
        System.out.println("Produção academica de professores : " + cont_pro);
        
        int count=0;
        for(int i=0;i<col.size();i++){
            if(col.get(i).getCargo()==4){
                if(col.get(i).colab.size()>0){
                    count+=col.get(i).colab.size();
                }
            }
        }
        
        System.out.println("Numero de orientações : " + count);
    }
    
    
    public int menuColaborador(){
        Scanner scan = new Scanner(System.in);
        Colaboradores col_aux = new Colaboradores();
        
        System.out.println("--------------------");
        System.out.println("1 - Adicionar colaborador");
        System.out.println("2-  Remover colaborador");
        System.out.println("3 - Alterar colaborador");
        System.out.println("4 - Consultar colaboradores");
        System.out.println("5 - Alocação");
        System.out.println("0 - Sair");
        try{
            int op = scan.nextInt();
                return op;
            
        } catch(Exception e){
            System.out.println("Selecione uma opção válida!");
        }
        
        return -1;
    }
    
    public void removerColaborador(ArrayList <Colaboradores> col){
        if(col.size()==0){
            System.out.println("Ainda não há colaboradores registrados!");
            return ;
        }
        System.out.println("----- LISTA DE COLABORADORES -----");
        for(int i=0;i<col.size();i++){
            System.out.println("Colaborador : " + col.get(i).getNome());
            System.out.println("Id : " + i);
        }
        System.out.println("---------------");
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o id do colaborador que será removido : ");
        int id = scan.nextInt();
        
        if(id>col.size() || id<0){
            System.out.println("Por favor, digite um id válido!");
            return ;
        }
        
        for(int i=0;i<col.size();i++){
            if(col.get(id)!=null){
                System.out.println("Colaborador "+ col.get(i).getNome() + " removido com sucesso!");
                System.out.println("----------");
                col.remove(i);
                return ;
            }
        }
        System.out.println("Colaborador não encontrado.");
        System.out.println("----------");
    }
   
    public void alterarColaborador(ArrayList <Colaboradores> col){
        if(col.size()==0){
            System.out.println("Ainda não há colaborador registrado!");
            return;
        }
        Scanner scan = new Scanner(System.in);
        
        for(int i=0;i<col.size();i++){
            System.out.println("Colaborador : " + col.get(i).getNome());
            System.out.println("Id : " + i);
            System.out.println("----------");
        }
    
        System.out.println("Digite o id do colaborador que terá alteração : ");
        int id = scan.nextInt();
        
            if(id>col.size() || id<0){
            System.out.println("Por favor, digite um id válido!");
            return ;
            }
            
            for(int i=0;i<col.size();i++){
                if(col.get(id)!=null){
                    System.out.println("Selecione o que deseja alterar : ");
                    System.out.println("1 - Nome");
                    System.out.println("2 - Idade");
                    System.out.println("3 - Endereço");
                    System.out.println("4 - Email");
                    System.out.println("5 - Cargo");
                    System.out.println("0 - Sair");
                    int op = scan.nextInt();
                    String nome;
                        if(op==1){
                            scan.nextLine();
                            System.out.println("Digite o nome : ");
                            nome = scan.nextLine();
                            col.get(i).setNome(nome);
                        } else if(op==2){
                            System.out.println("Digite a idade : ");
                            int idade = scan.nextInt();
                            col.get(i).setIdade(idade);
                        } else if(op==3){
                            System.out.println("Digite o endereço : ");
                            scan.nextLine();
                            nome = scan.nextLine();
                            col.get(i).setEndereco(nome);
                        } else if(op==4){
                            System.out.println("Digite o email : ");
                            scan.nextLine();
                            nome = scan.nextLine();
                            col.get(i).setEmail(nome);
                        } else if(op==5){
                            System.out.println("Digite o novo cargo : ");
                            System.out.println("1 - Graduação");
                            System.out.println("2 - Mestrado");
                            System.out.println("3 - Doutorado");
                            System.out.println("4 - Professor");
                            System.out.println("5 - Pesquisador");
                            int cargo = scan.nextInt();
                            col.get(i).setCargo(cargo);
                        }
                } 
            }
        
        
    }
}
