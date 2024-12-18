

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import dominio.Musica;

public class AudioPlayer {
  public Clip audioClip;
  public boolean isPlaying = false;
  private List<Musica> listaDeReproducao = new ArrayList<>();
  private int index = 0;


/* Pegando o caminho do arquivo da 
musica e carregando ele passando para atributo audioClip*/
  public void loadAudio(String filePath) {
    System.out.println("loadAudio: " + filePath);
    try {
      // Carrega o arquivo de áudio
      File audioFile = new File(filePath);
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

      // Configura o Clip
      AudioFormat format = audioStream.getFormat();

      DataLine.Info info = new DataLine.Info(Clip.class, format);
      audioClip = (Clip)
       AudioSystem.getLine(info);

      audioClip.open(audioStream);
    } catch (UnsupportedAudioFileException e) {
      System.out.println("O formato do arquivo de áudio não é suportado.");
      e.printStackTrace();
    } catch (LineUnavailableException e) {
      System.out.println("A linha de áudio não está disponível.");
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("Erro ao ler o arquivo de áudio.");
      e.printStackTrace();
    }
  }
//carregando a lista de reprodução
  public void carregarListaReproducao (List<Musica> musicas){
    this.listaDeReproducao = musicas;
    this.index=0;
    loadAudio (musicas.get(index).getArquivoAudio());

  }
  //criando o botão de avançar
//size retornar o tam de um Array
public void nextButton (){
  if (listaDeReproducao != null){
    stopAudio();
    if ( index <(listaDeReproducao.size() -1)){
      index ++;
      loadAudio(listaDeReproducao.get(index).getArquivoAudio());
      playAudio();
    } else if (index >= (listaDeReproducao.size()-1)){
      index = 0; 
      loadAudio(listaDeReproducao.get(index).getArquivoAudio());
      playAudio();
    }

  }
  else{ System.out.println("lista de reprodução está vazio");

  }
}

public void previousButton (){
  if (listaDeReproducao != null){
    stopAudio();
    //esta verificando se o nosso indice é maior que 0 e se ele é menor ou igual o tanto de msc que a gente tem.
    if (index >0 && index <= (listaDeReproducao.size()-1)){
      index--;
      loadAudio(listaDeReproducao.get(index).getArquivoAudio());
      playAudio();
    } else if (index == 0){
      index = listaDeReproducao.size()-1; 
      loadAudio(listaDeReproducao.get(index).getArquivoAudio());
      playAudio();
    }

  }
  else{ System.out.println("lista de reprodução está vazio");

  }
}


/*Primeiro vamos verificar se o atributo audioClip
 * nao está vazio e se não está tocando.
 */ 
/*definindo a msc para o começo e dando o start ou comecar no atributo
 * audioClip e depois definindo o atributo isPlaying.
 */
  public void playAudio() {
    System.out.println("playAudio");
    if (audioClip != null && !isPlaying) {
      audioClip.setFramePosition(0); // Reinicia o áudio do começo
      System.out.println("playAudio start");
      audioClip.start();
      isPlaying = true;
    }
  }
/*verificar se o atributo não está vazio e se tem algo tocando ou seja isplaying está como verdadeiro (true)  definie o atributo
 * isplaying como falso.
*/
  public void stopAudio() {
    System.out.println("stopAudio");
    if (audioClip != null && isPlaying) {
      System.out.println("stopAudio stop");
      audioClip.stop();
      // isPlaying é a mesma coisa que está tocando e pode ser verdadeiro ou falso.
      isPlaying = false;
    }
  }
}
 
//criar uma lista de msc. (lista de reproduçao)