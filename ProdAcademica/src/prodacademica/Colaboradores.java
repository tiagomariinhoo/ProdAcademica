package prodacademica;
public class Colaboradores {
    String nome;
    String endereco;
    String email;

    Projeto projeto_alocado[] = new Projeto [50]; //Array contendo os ids dos projetos alocados ao colaborador

    public Colaboradores(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    
    public void listarProjetos(){
        for(int i=0;i<projeto_alocado.length;i++){
            if(projeto_alocado[i]!=null){
                System.out.println("Projeto alocado ao colaborador " + getNome());
                projeto_alocado[i].mostrarProjeto();
                System.out.println("----------");
            }
        }
    }
}
