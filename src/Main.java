import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private SortedList sortedList = new SortedList();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    public Main() {
        JFrame frame = new JFrame("Sorted List GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        JTextField addField = new JTextField();
        JButton addButton = new JButton("Add");
        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Search");

        inputPanel.add(new JLabel("Add Element:"));
        inputPanel.add(addField);
        inputPanel.add(new JLabel("Search Element:"));
        inputPanel.add(searchField);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = addField.getText();
                if (!input.isEmpty()) {
                    sortedList.add(input);
                    addField.setText("");
                    textArea.setText("Updated List: \n" + sortedList.getList());
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = searchField.getText();
                if (!input.isEmpty()) {
                    String result = sortedList.search(input);
                    searchField.setText("");
                    textArea.setText("Search Result: \n" + result + "\n\nUpdated List: \n" + sortedList.getList());
                }
            }
        });

        frame.setVisible(true);
    }
}
