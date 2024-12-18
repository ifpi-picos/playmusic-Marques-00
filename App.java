
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


import dominio.Album;
import dominio.Artista;
import dominio.Musica;
import dominio.Playlist;

public class App {
    public static void main(String[] args) {
        // Criando músicas
        Musica musica1 = new Musica("In the End", "Rock", "./assets/In-The-End-Linkin-Park.wav", 329);
        Musica musica2 = new Musica("Californication", "Rock", "./assets/Red-Hot-Chili-Peppers-Californication.wav", 345);

        // Criando lista de músicas
        List<Musica> musicas1 = new ArrayList<>();
        musicas1.add(musica1);
        musicas1.add(musica2);

        // Criando álbum
        Album album = new Album("PrimeiroAlbum", 2016, musicas1);
        List<Album> albuns = new ArrayList<>();
        albuns.add(album);

        // Criando artista
        Artista artista = new Artista("Link Park", albuns);
        artista.addAlbum(album);

        // Criando playlist
        Playlist playlist = new Playlist("Favoritas", musicas1);

        // Instância de player de áudio
        AudioPlayer player = new AudioPlayer();
        player.carregarListaReproducao(artista.getAlbuns().get(0).getMusicas());


        // Criando os botões
        JButton playStopButton = new JButton("Play");
        JButton nextButton = new JButton("Próxima");
        JButton previousButton = new JButton("Anterior");

        // Configuração do botão Play/Stop
        playStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!player.isPlaying) {
                    player.playAudio();
                    playStopButton.setText("Stop");
                } else {
                    player.stopAudio();
                    playStopButton.setText("Play");
                }
            }
        });

        // Botão Próxima Música
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.nextButton();
                playStopButton.setText("Stop");
            }
        });

        // Botão Música Anterior
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.previousButton();
                playStopButton.setText("Stop");
            }
        });

        

        ImageIcon icon = new ImageIcon("./assets/music.png");

        // Exibe um JOptionPane com o botão Play/Stop
        JOptionPane.showOptionDialog(
                null,
                "Tocando música",
                "PlayMusic",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                icon,
                new Object[] {  previousButton, playStopButton, nextButton},playStopButton
                );

        // Fecha o clip de áudio ao encerrar o programa
        if (player.audioClip != null) {
            player.audioClip.close();
        }
    }
}