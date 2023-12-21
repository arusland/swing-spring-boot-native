package com.example.swingnative;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class SwingNativeApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder().headless(false)
                .sources(SwingNativeApplication.class)
                .run(args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                SwingUtilities.invokeLater(() -> {
                    var table = new JTable(new Object[][]{{"Hello", "World"}}, new Object[]{"Column 1", "Column 2"});
                    var frame = new JFrame("Swing Native");
                    frame.add(new JScrollPane(table), BorderLayout.CENTER);
                    frame.pack();
                    frame.setVisible(true);
                });
            }
        };
    }
}
