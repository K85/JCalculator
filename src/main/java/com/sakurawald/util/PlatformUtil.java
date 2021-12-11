package com.sakurawald.util;

import lombok.experimental.UtilityClass;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

@UtilityClass
public class PlatformUtil {

    public static void copyToClipboard(String content) {
        StringSelection selection = new StringSelection(content);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    }

}
