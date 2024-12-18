package dominio;

import java.util.ArrayList;
import java.util.List;
//get serve para acessar  e set para alterar
//void = vazio
    //public significa que class pode ser acessado em qualquer lugar do programa. //private atributo em que somente o dono pode acessar
    public class Album {
        private String nome; 
        private int ano; 
        private List<Musica> musicas = new ArrayList <>();
        
    public Album (String nome, int ano, List<Musica> musicas)  {
      this.nome = nome;
      this.ano = ano;
      this.musicas = musicas;
    }  

        public String getNome() {
        return nome;
      }
    
      public void setNome(String nome) {
        this.nome = nome;
      }
    
      public int getAno() {
        return ano;
      }
    
      public void setAno(int ano) {
        this.ano = ano;
      }
    
      public List<Musica> getMusicas() {
        return musicas;
      }
    //add musica na lista
      public void addMusica(Musica musica) {
        musicas.add(musica);
      }
    //add musicas adiciona várias msc a lista
      public void addMusicas(List<Musica> musicas) {
        this.musicas.addAll(musicas);
      }
    
        
    }
    
    

