package com.wxq.apsv.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.wxq.apsv.interfaces.*;
import com.wxq.apsv.model.*;

import javax.swing.*;
import java.awt.*;

public class TaskDetailPane extends JPanel implements Observer {
    private JComboBox taskSelector;

    @Override
    public void Update(ObservableSubject s) {
        if (s instanceof TaskListModel) {
            TaskListModel taskListModel = (TaskListModel)s;
            DefaultComboBoxModel model = new DefaultComboBoxModel(taskListModel.getTasks().stream().map(t -> t.name).toArray());
            this.taskSelector.setModel(model);
        }
    }

    public JComboBox getTaskSelector() {
        return taskSelector;
    }

    public TaskDetailPane() {
        InitComponents();
    }

    private void InitComponents() {
        this.setLayout(new GridLayoutManager(5, 12, new Insets(5, 10, 20, 5), -1, 5));

        // Task selector
        // TODO selector item id and display text
        add(new JLabel("选择任务"), new GridConstraints(0, 0, 1, 1, 8, 0, 0, 0, null, new Dimension(80, 36), new Dimension(-1, 36), 0, false));

        taskSelector = new JComboBox();
        add(taskSelector, new GridConstraints(0, 1, 1, 3, 8, 0, 2, 0, new Dimension(100, -1), null, null, 0, false));

        add(new JLabel(""), new GridConstraints(4, 0, 1, 12, 0, 0, 1|2, 1|2, null, null, null, 0, false));
    }
}
