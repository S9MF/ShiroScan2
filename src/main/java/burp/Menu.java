package burp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Menu implements IContextMenuFactory {

    @Override
    public List<JMenuItem> createMenuItems(final IContextMenuInvocation invocation) {
        final List<JMenuItem> menuList = new ArrayList<>();

        JMenu shiroMenu  = new JMenu("Generate");
        final JMenuItem k1  = new JMenuItem("CommonsCollectionsK1");
        final JMenuItem k2  = new JMenuItem("CommonsCollectionsK2");
        final JMenuItem cb1  = new JMenuItem("CommonsBeanutils1");
        final JMenuItem cb2  = new JMenuItem("CommonsBeanutils2");
        final JMenuItem Jdk7u21  = new JMenuItem("Jdk7u21");
        final JMenuItem Jdk8u20  = new JMenuItem("Jdk8u20");
        final JMenuItem config = new JMenuItem("Config");

        k1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Utils.xrayGadgets("k1", invocation);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        k2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Utils.xrayGadgets("k2", invocation);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        cb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Utils.xrayGadgets("cb1", invocation);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        cb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Utils.xrayGadgets("cb2", invocation);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        Jdk7u21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Utils.xrayGadgets("Jdk7u21", invocation);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        Jdk8u20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Utils.xrayGadgets("Jdk8u20", invocation);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        config.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfigDlg dlg = new ConfigDlg();
                BurpExtender.callbacks.customizeUiComponent(dlg);
                dlg.setVisible(true);
            }
        });


        shiroMenu.add(k1);
        shiroMenu.add(k2);
        shiroMenu.add(cb1);
        shiroMenu.add(cb2);
        shiroMenu.add(Jdk7u21);
        shiroMenu.add(Jdk8u20);
        shiroMenu.add(config);

        menuList.add(shiroMenu);
        return menuList;
    }
}
