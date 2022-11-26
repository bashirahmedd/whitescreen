package com.futureschool;

import javax.swing.UIManager;

public class App {

   private static final long serialVersionUID = 1L;
   private static final String TITLE = "My First Media Player";
   private static final String VIDEO_PATH = "/home/naji/bashir-workspace/kids_corner/420p/usb1/math_0/How Many Fingers On My Hands _ Body Parts & Counting Song _ Fun Kids English_Fun Kids English_8ncPEiNgAQc-1.mp4";

   public static void main(String[] args) {
      try {
         UIManager.setLookAndFeel(
               UIManager.getSystemLookAndFeelClassName());
      } catch (Exception e) {
         System.out.println(e);
      }

      final MediaPlayerFrame mediaPlayerFrame = new MediaPlayerFrame(TITLE);

      mediaPlayerFrame.initialize();
      mediaPlayerFrame.setVisible(true);
      mediaPlayerFrame.loadVideo(VIDEO_PATH);

   }

}
