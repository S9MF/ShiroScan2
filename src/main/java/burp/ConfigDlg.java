package burp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigDlg extends JDialog {
    //定义组件
    private final JPanel mainPanel = new JPanel();
    private final JPanel toPanel = new JPanel();
    private final JPanel centerPanel = new JPanel();
    private final JPanel bottomPanel = new JPanel();;
    private final JComboBox mode= new JComboBox(new String[]{"AES-CBC", "AES-GCM"});
    private final JTextField key = new JTextField(18);
    private final JButton btSave = new JButton("保存");

    public ConfigDlg() {
        initGUI();
        initEvent();
        initValue();
        this.setTitle("设置");
    }

    private void initGUI() {
        toPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        toPanel.add(new JLabel("加密模式："));
        toPanel.add(mode);

        centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        centerPanel.add(new JLabel("key："));
        key.setFont(new Font(null, Font.PLAIN, 13));
        centerPanel.add(key);

        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(btSave);
        btSave.setToolTipText("Hey Bro!这是保存");

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(toPanel,BorderLayout.NORTH);
        mainPanel.add(centerPanel,BorderLayout.CENTER);
        mainPanel.add(bottomPanel,BorderLayout.SOUTH);

        this.setModal(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.add(mainPanel);
        //使配置窗口自动适应控件大小，防止部分控件无法显示
        this.pack();
        //居中显示配置窗口
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(screensize.width/2-this.getWidth()/2,screensize.height/2-this.getHeight()/2,this.getWidth(),this.getHeight());
    }
    //组件的事件响应
    private void initEvent() {
        //保存按钮
        btSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer modeSelect =  mode.getSelectedIndex();
                String keyValue = key.getText();

                //mode 0是CBC模式 1是GCM模式
                System.out.println("mode：" + modeSelect);
                System.out.println("key：" + keyValue);

                Config.setMode(modeSelect);
                Config.setKey(keyValue);
                ConfigDlg.this.dispose();
            }
        });
    }
    //为控件赋值
    public void initValue() {
        mode.setSelectedIndex(Config.getMode());
        key.setText(Config.getKey());
    }
}
