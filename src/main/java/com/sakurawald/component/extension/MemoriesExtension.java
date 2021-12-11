package com.sakurawald.component.extension;

import com.sakurawald.bean.Memory;
import com.sakurawald.event.EventCenter;
import com.sakurawald.event.Listener;
import com.sakurawald.event.events.MemoriesStoreEvent;
import com.sakurawald.event.events.MemoriesUpdateEvent;
import com.sakurawald.event.events.RequestChangeDisplayEvent;

import javax.swing.*;
import java.util.Optional;

public class MemoriesExtension extends JPanel {

    private final JLabel memoryLabel = new JLabel("Memories");
    private final JComboBox<Memory> memoryJComboBox = new JComboBox<>();
    private final JButton fillButton = new JButton("Fill") {
        {
            this.addActionListener(e -> Optional.ofNullable(memoryJComboBox.getSelectedItem())
                    .ifPresent(memory -> EventCenter.fire(new RequestChangeDisplayEvent(memory.toString()))));
        }
    };

    public MemoriesExtension() {
        /* Add Components */
        this.add(memoryLabel);
        memoryJComboBox.setPrototypeDisplayValue(new Memory(0));
        this.add(memoryJComboBox);
        this.add(fillButton);

        /* Register Events */
        EventCenter.register(new Listener<MemoriesUpdateEvent>() {
            @Override
            public void onEvent(MemoriesUpdateEvent event) {
                memoryJComboBox.removeAllItems();
                event.getMemories().forEach(memoryJComboBox::addItem);
            }
        });


    }
}
