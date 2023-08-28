package soundboard;

import com.formdev.flatlaf.FlatDarkLaf;
import soundboard.panels.CatalogueSelectorPanel;
import soundboard.panels.ChannelSelectorPanel;
import soundboard.panels.MusicPlayerPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        Icons icons = new Icons();
        Client client = Client.getClient();
        API api = new API(client);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        CatalogueSelectorPanel catalogueSelector = new CatalogueSelectorPanel(api);
        catalogueSelector.loadUI("src/main/resources/sample_catalogue.json");
        panel.add(catalogueSelector);

        JPanel mediaPanel = new JPanel();

        MusicPlayerPanel miniPlayer = new MusicPlayerPanel(api, icons);
        mediaPanel.add(miniPlayer);

        ChannelSelectorPanel channelSelector = new ChannelSelectorPanel(api, icons);
        channelSelector.populateChannelList(new String[]{"0", "1"});
        mediaPanel.add(channelSelector);

        panel.add(mediaPanel);

        //Create and set up the window.
        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
