package com.futureschool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import java.util.logging.Level;
import java.util.logging.Logger;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class VideoControlsPanel extends JPanel {

    private static final Logger logger = Logger.getLogger(VideoControlsPanel.class.getName());
    private JButton playButton;
    private JButton pauseButton;
    private JButton rewindButton;
    private JButton skipButton;
    private JToggleButton toggleButton;

    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

    public VideoControlsPanel(EmbeddedMediaPlayerComponent mpComponent) {

        this.mediaPlayerComponent = mpComponent;

        // Create a video border
        Border videoBorder = BorderFactory.createTitledBorder("Video Controls");
        setBorder(videoBorder);
        // Create buttons
        playButton = new JButton("Play");
        add(playButton);
        pauseButton = new JButton("Pause");
        add(pauseButton);
        rewindButton = new JButton("Rewind");
        add(rewindButton);
        skipButton = new JButton("Skip");
        add(skipButton);
        toggleButton = new JToggleButton("Toggle Full Screen");
        add(toggleButton);

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.mediaPlayer().controls().play();
            }
        });
        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.mediaPlayer().controls().pause();
            }
        });
        rewindButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.mediaPlayer().controls().skipTime(-14000);
            }
        });
        skipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.mediaPlayer().controls().skipTime(4000);
            }
        });

        toggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.mediaPlayer().fullScreen().toggle();

            }

        });

    }
}
