package com.sakurawald.component.extension;

import com.sakurawald.bean.History;
import com.sakurawald.event.EventCenter;
import com.sakurawald.event.Listener;
import com.sakurawald.event.events.HistorySpawnEvent;
import com.sakurawald.event.events.RequestChangeDisplayEvent;
import com.sakurawald.util.PlatformUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HistoryExtension extends JPanel {
    private final JLabel historiesJLabel = new JLabel("Histories");
    private final JList<History> historiesJList = new JList<>();
    private final JScrollPane jScrollPane = new JScrollPane();
    private final DefaultListModel<History> histories = new DefaultListModel<>();

    public HistoryExtension() {

        /* Add Components */
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        historiesJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(historiesJLabel);
        historiesJList.setModel(histories);
        historiesJList.setLayoutOrientation(JList.VERTICAL);
        historiesJList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && historiesJList.getSelectedValue() != null) {
                    // Fire Event to notify the Calculator.
                    EventCenter.fire(new RequestChangeDisplayEvent(String.valueOf(historiesJList.getSelectedValue().getValue())));
                }
            }
        });
        this.add(historiesJList);

        jScrollPane.setViewportView(historiesJList);
//        jScrollPane.setPreferredSize(new Dimension(200, 150));
        this.add(jScrollPane);

        // Use the anonymous JPanel to wrap the buttons
        this.add(new JPanel() {
            {
                this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

                this.add(new JButton("Clear") {{
                    this.addActionListener(e -> histories.clear());
                }});
                this.add(new JButton("Copy") {
                    {
                        this.addActionListener(e -> {
                                    if (historiesJList.getSelectedValue() != null)
                                        PlatformUtil.copyToClipboard(historiesJList.getSelectedValue().toString());
                                }
                        );
                    }
                });
            }
        });


        /* Register Event */
        EventCenter.register(new Listener<HistorySpawnEvent>() {
            @Override
            public void onEvent(HistorySpawnEvent event) {
                histories.addElement(event.getSpawnedHistory());
                historiesJList.ensureIndexIsVisible(histories.getSize() - 1);
                historiesJList.setSelectedIndex(histories.getSize() - 1);
            }
        });
    }
}
