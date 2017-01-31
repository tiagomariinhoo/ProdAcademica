package prodacademica;

import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private int idade;
    private String endereco;
    private String email;
    private int cargo;
    private boolean alocado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public boolean getAlocado() {
        return alocado;
    }

    public void setAlocado(boolean alocado) {
        this.alocado = alocado;
    }
    
    public void mostrarColaborador(ArrayList <Colaboradores> col){
        
        for(int i=0;i<col.size();i++){
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
                            
        }
        
    }
    
}
