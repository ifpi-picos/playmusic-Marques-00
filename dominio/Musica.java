package dominio;

public class Musica {
    private String nome;
    private String genero;
    private String arquivoAudio;
    private int duracao;
    //construtor de msc
public Musica (String nome, String genero, String arquivoAudio, int duracao){
    this.nome=nome;
    this.genero=genero;
    this.arquivoAudio= arquivoAudio;
    this.duracao=duracao;
}    


// os métodos get e set eles permitem que outros objetos/leitores intejaram com os atributos
//get ler e set serve para alterar o valor de um atributo
    public String getnome (){
        return nome ;
    }
// ultilizo o void para dizer que ele não retorna nenhum valor
    public void setNome (String nome){
        this.nome = nome;
    }

    public String getgenero (){
        return genero ;
    }

    public void setGenero (String genero){
        this.genero = genero;
    }
    public String getArquivoAudio (){
        return arquivoAudio;
    }
    public void setArquivoAudio (String arquivoAudio){
        this.arquivoAudio = arquivoAudio;
    }
    public int getduracao(){
        return duracao;
}
    public void setDuracao (int duracao){
        this.duracao = duracao;
    }











}
