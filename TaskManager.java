import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TaskManager extends JFrame {
    private ArrayList<Task> taskList = new ArrayList<>();
    private JTextField nameField, descriptionField;
    private JList<String> taskListView;
    private DefaultListModel<String> listModel;

    public TaskManager() {
        // Setup the frame 
        setTitle("Task Manager");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for task creation
        JPanel taskInputPanel = new JPanel();
        taskInputPanel.setLayout(new GridLayout(3, 2, 10, 10));
        taskInputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        taskInputPanel.add(new JLabel("Task Name:"));
        nameField = new JTextField();
        taskInputPanel.add(nameField);

        taskInputPanel.add(new JLabel("Task Description:"));
        descriptionField = new JTextField();
        taskInputPanel.add(descriptionField);

        // Buttons
        JButton createButton = new JButton("Create Task");
        JButton updateButton = new JButton("Update Task");
        JButton deleteButton = new JButton("Delete Task");

        // Action listeners
        createButton.addActionListener(e -> createTask());
        updateButton.addActionListener(e -> updateTask());
        deleteButton.addActionListener(e -> deleteTask());

        // Add buttons to the panel
        taskInputPanel.add(createButton);
        taskInputPanel.add(updateButton);
        taskInputPanel.add(deleteButton);

        // Task list display (JList)
        listModel = new DefaultListModel<>();
        taskListView = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(taskListView);
        taskListView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add components to the frame
        add(taskInputPanel, BorderLayout.NORTH);
        add(listScrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    // Task class with necessary attributes
    private static class Task {
        private String name;
        private String description;

        public Task(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return name + " - " + description;
        }
    }

    // Create task
    private void createTask() {
        String name = nameField.getText();
        String description = descriptionField.getText();

        if (!name.isEmpty() && !description.isEmpty()) {
            Task newTask = new Task(name, description);
            taskList.add(newTask);
            listModel.addElement(newTask.toString());
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please fill out both fields to create a task.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Update selected task
    private void updateTask() {
        int selectedIndex = taskListView.getSelectedIndex();

        if (selectedIndex != -1) {
            String newName = nameField.getText();
            String newDescription = descriptionField.getText();

            if (!newName.isEmpty() && !newDescription.isEmpty()) {
                Task updatedTask = new Task(newName, newDescription);
                taskList.set(selectedIndex, updatedTask);
                listModel.set(selectedIndex, updatedTask.toString());
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Please fill out both fields to update the task.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to update.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Delete selected task
    private void deleteTask() {
        int selectedIndex = taskListView.getSelectedIndex();

        if (selectedIndex != -1) {
            taskList.remove(selectedIndex);
            listModel.remove(selectedIndex);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Clear input fields after operation
    private void clearFields() {
        nameField.setText("");
        descriptionField.setText("");
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TaskManager::new);
    }
}
