package com.futureschool;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Window;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.fullscreen.adaptive.AdaptiveFullScreenStrategy;

public class MediaPlayerFrame extends JFrame {

    private EmbeddedMediaPlayerComponent mediaPlayerComponent;
    private MonitorScreenController monitorScreenController;
    private static final Logger logger = Logger.getLogger(MediaPlayerFrame.class.getName());

    public MediaPlayerFrame(String title) {
        super(title);
        monitorScreenController = new MonitorScreenController();
    }

    public void initialize() {

        Window w = monitorScreenController.getTargetMonitor();
        if(w==null){
            logger.log(Level.INFO, "Secondary display not found, primary display used instead.");
            w=this;
        }

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent(  null,
        null,
        new AdaptiveFullScreenStrategy(w),
        null,
        null) {
            @Override
            public void playing(MediaPlayer mediaPlayer) {
                super.playing(mediaPlayer);
                System.out.println("Media Playback started.");
            }

            @Override
            public void finished(MediaPlayer mediaPlayer) {
                super.playing(mediaPlayer);
                System.out.println("Media Playback finished.");
            }
        };
        this.setBounds(100, 100, 600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediaPlayerComponent.release();
                System.exit(0);
            }
        });
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);

        VideoControlsPanel videoControlsPanel = new VideoControlsPanel(mediaPlayerComponent);
        contentPane.add(videoControlsPanel, BorderLayout.SOUTH);

        this.setContentPane(contentPane);
        this.setVisible(true);
    }

    public void loadVideo(String path) {
        mediaPlayerComponent.mediaPlayer().media().startPaused(path);
    }
}
